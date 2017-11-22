package com.civilization.View;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
public class BackgroundJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	// 背静图片
	private Image backgroundImage;
	// 背景图片的X坐标
	private int backgroundX;
	// 背景图片的Y坐标
	private int backgroundY;
	// 背景图片缩放比例
	private float backgroundScale = 1;

	protected void paintComponent(Graphics g) {

		drawBackground(g);
	}

	// 画图背景图片
	private void drawBackground(Graphics graphics) {
		if (backgroundImage != null) {
			graphics.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
			/*graphics.drawImage(backgroundImage, (getWidth() - backgroundImage.getWidth(null)) / 2,
					(getHeight() - backgroundImage.getHeight(null)) / 2, null);*/
		}
	}

	public void setBackgroundX(int backgroundX) {
		this.backgroundX = backgroundX;
	}

	public void setBackgroundY(int backgroundY) {
		this.backgroundY = backgroundY;
	}

	public void setBackgroundScale(float backgroundScale) {
		this.backgroundScale = backgroundScale;
	}

	public void setBackgroundImage(String backgroundURL) {
		this.backgroundImage = new ImageIcon(backgroundURL).getImage();
	}

}
