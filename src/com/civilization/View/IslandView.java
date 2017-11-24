package com.civilization.View;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IslandView {

	//岛屿
	private JButton island = new JButton("");
	//岛屿大小
	private int islandSize = 10;

	public IslandView(String url) {
		island.setIcon(new ImageIcon(url));
	}

	// 但背景图片拖动时，改变岛屿图标的位置
	public void changePosition(int x, int y) {
		Point position = island.getLocation();
		island.setLocation(new Point(position.x + x, position.y + y));
	}

}
