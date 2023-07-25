import java.io.IOException;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LabyrinthGameGUI extends JPanel {
	Labyrinth labyrinth = new Labyrinth();
	public static int level = 1;
	private Image playerPic, dragonPic, wall;
	Player player;
	Dragon dragon;

	public LabyrinthGameGUI() throws IOException {
		playerPic = ImageIO.read(getClass().getResource("ressources/player.png"));
		dragonPic = ImageIO.read(getClass().getResource("ressources/dragon.png"));
		wall = ImageIO.read(getClass().getResource("ressources/wall.png"));
		player = new Player(0, 480, 40, 40, 40, playerPic);
		Point p=startRandomPosition();
		dragon = new Dragon((p.y)*40, (p.x)*40, 40, 40, 40, dragonPic);

		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				player.keyPressed(arg0);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		setFocusable(true);
	}

	public Point startRandomPosition() {
		System.out.println("size : "+labyrinth.getEmptycells().size());
		int random= new Random().nextInt(labyrinth.getEmptycells().size());
		System.out.println(random);
		return labyrinth.getEmptycells().get(random);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		try {
			labyrinth.paint(grphcs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.paint(grphcs);
		dragon.paint(grphcs);
		dragon.move();
		//if(labyrinth.cells[dragon.getX()/40][dragon.getY()/40+1]==labyrinth. )

		repaint();
	}

	public static int compteLevel() {
		return level++;
	}

	public static int getLevel() {
		return level;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		JFrame frame = new JFrame("Labyrinth Game");
		LabyrinthGameGUI game = new LabyrinthGameGUI();
		frame.add(game);
		frame.setSize(940, 560);
		frame.setLocation(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException bug) {
				Thread.currentThread().interrupt();
				System.out.println(bug);
			}
		}
	}
}
