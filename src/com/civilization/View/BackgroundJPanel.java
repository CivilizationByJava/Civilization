package com.civilization.View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.civilization.control.BackgroundController;

/**
 * @author Administrator
 *
 */
public class BackgroundJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// 背静图片
	private Image backgroundImage;
	//
	private int initDrawX;
	//
	private int intiDrawY;
	// 绘制起点的X坐标
	private int drawX = 0;
	// 绘制起点的Y坐标
	private int drawY = 0;
	//
	private float mapSizeX = 2f;
	//
	private float mapSizeY = 2f;
	//

	public BackgroundJPanel() {

	}

	protected void paintComponent(Graphics g) {

		drawBackground(g);
	}

	// 画图背景图片

	private void drawBackground(Graphics graphics) {
		if (backgroundImage != null) {

			int width = (int) (getWidth() * mapSizeX);
			int height = (int) (getHeight() * mapSizeX);
			graphics.drawImage(backgroundImage, drawX, drawY, width, height, null);

		}
	}

	public int getDrawX() {
		return drawX;
	}

	public int getDrawY() {
		return drawY;
	}

	public void moveDrawPoint(int x, int y) {
		drawX = initDrawX + x;
		drawY = intiDrawY + y;
	}

	public void setBackgroundImage(String backgroundURL) {
		this.backgroundImage = new ImageIcon(backgroundURL).getImage();
	}

	public void initData() {
		initDrawX = -(int) (getWidth() / mapSizeX);
		intiDrawY = -(int) (getHeight() / mapSizeY);
		drawX = initDrawX;
		drawY = intiDrawY;
	}

}
