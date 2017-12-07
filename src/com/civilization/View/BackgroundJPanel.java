package com.civilization.View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	// 背景图片缩放比例
	private float backgroundScale = 1;
	//
	private int mapSizeX = 2;
	//
	private int mapSizeY = 2;
	//
	
	public BackgroundJPanel() {

	}

	protected void paintComponent(Graphics g) {

		drawBackground(g);
	}

	// 画图背景图片

	private void drawBackground(Graphics graphics) {
		if (backgroundImage != null) {
			
			System.out.println(drawX);
			System.out.println(drawY);

			
			int width=  getWidth() * mapSizeX;	
			int height=  getHeight() * mapSizeX;  
			graphics.drawImage(backgroundImage, drawX, drawY,width, height, null);
			System.out.println("repaint");
			
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
		//System.out.println(initDrawX);
	}

	public void setBackgroundScale(float backgroundScale) {
		this.backgroundScale = backgroundScale;
	}

	public void setBackgroundImage(String backgroundURL) {
		this.backgroundImage = new ImageIcon(backgroundURL).getImage();
	}

	public void initData() {
		initDrawX = -getWidth() / mapSizeX;
		//initDrawX=0;
		intiDrawY = -getHeight() / mapSizeY;
		//intiDrawY=0;
		drawX = initDrawX;
		drawY = intiDrawY;
		System.out.println(getWidth());
	}

}
