package com.civilization.View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import javafx.embed.swing.JFXPanel;

public class BegamePanel extends JFXPanel {

	private Image startBackgroundImage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void paintComponent(Graphics g) {

		drawBackground(g);
	}


	// 画背景图
	private void drawBackground(Graphics graphics) {
		ImageIcon ima = new ImageIcon("source/images/startbg.png");

		if (startBackgroundImage == null) {
			startBackgroundImage=ima.getImage();
		}
		graphics.drawImage(	startBackgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
	}

}
