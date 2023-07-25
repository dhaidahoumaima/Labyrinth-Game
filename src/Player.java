
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 *
 * @author bli
 */
public class Player extends Sprite {
	Labyrinth lab=new Labyrinth();
	public Player(int x, int y, int width, int height, int mouvement, Image image) {
		super(x, y, width, height, mouvement, image);
	}

	public void paint(Graphics g) {
		g.drawImage(image, x, y, width, height, null);	
	}


	public void keyPressed(KeyEvent e) {
		int [][]labyrinth = lab.getCells();
		if (e.getKeyCode() == 37) {
			if (labyrinth[y / 40][(x / 40) - 1] != 1) {
				x = x - mouvement;
			}
		}
		if (e.getKeyCode() == 39) {
			if (labyrinth[y / 40][(x / 40)+1] != 1) {
				x = x + mouvement;
			}
		}
		if (e.getKeyCode() == 40) {
			if (labyrinth[(y / 40) + 1][x / 40] != 1) {
				y = y + mouvement;
			}
		}
		if (e.getKeyCode() == 38) {
			if (labyrinth[(y / 40) - 1][x / 40] != 1) {
				y = y - mouvement;
			}
		}
		
		if(x==880 && y==440) {
			LabyrinthGameGUI.compteLevel();
			x=0;
			y=40;
		}
	}
}
