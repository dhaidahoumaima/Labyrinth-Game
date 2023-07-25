import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Labyrinth {
	public int[][] cells = new int[13][23];
	public int ligne = 0;
	public int column = 0;
	public int nbrLigne = 13;
	public int nbrColumn = 23;
	public int cellWidth = 40;
	public int cellHeight = 40;
	public Image dragonPic;
	private Image wall, prize;

	public void paint(Graphics graph) throws IOException {
		wall = ImageIO.read(getClass().getResource("ressources/wall.png"));
		prize = ImageIO.read(getClass().getResource("ressources/prize.png"));
		int cells[][] = getCells();

		for (ligne = 0; ligne < nbrLigne; ligne++) {
			for (column = 0; column < nbrColumn; column++) {
				if (cells[ligne][column] == 1) {

					if (LabyrinthGameGUI.getLevel() == 1) {
						graph.setColor(Color.darkGray);
					}
					graph.drawImage(wall, column * 40, ligne * 40, cellWidth, cellHeight, null);
					graph.setColor(Color.black);
					graph.drawRect(column * 40, ligne * 40, cellWidth, cellHeight);
				}
			}
		}
		graph.drawString("start", 5, 502);
		graph.drawImage(prize, 22 * 40, 0 * 40, cellWidth, cellHeight, null);
	}



	public int[][] getCells() {
		int cells[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1 },
				{ 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		return cells;
	}

	public ArrayList<Point> getEmptycells() {
		int [][]cell=getCells();
		ArrayList<Point> list=new ArrayList<Point>();
		for (ligne = 0; ligne < nbrLigne; ligne++) {
			for (column = 0; column < nbrColumn; column++) {
				if (cell[ligne][column] == 0) {
					list.add(new Point(ligne, column));
					}
				}
		}
		return list;
	}
}
