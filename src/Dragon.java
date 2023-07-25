import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Random;
import java.math.*;

public class Dragon extends Sprite {
	Labyrinth lab = new Labyrinth();

	public Dragon(int x, int y, int width, int height, int mouvement, Image image) {
		super(x, y, width, height, mouvement, image);
	}

	public void paint(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void move() {
		int[][] labyrinth = lab.getCells();
		int newX = y + (stepRandom() * 40);
		int newY = x + (stepRandom() * 40);
		if (labyrinth[newX / 40][newY / 40] != 1) {
			y = newX;
			x = newY;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		;
	}

	private int stepRandom() {
		int r = new Random().nextInt(3);
		return r - 1;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}

	public Point getPosition() {
		return new Point(x, y);
	}

	@Override
	public String toString() {
		return "Dragon []";
	}

}
