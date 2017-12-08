package com.civilization.View;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private int islandNum = 6;
	//
	private BackgroundJPanel backgroundJPanel;

	private List<JButton> island = new ArrayList<>();

	public int getIslandNum() {
		return islandNum;
	}

	public List<JButton> getIsland() {
		return this.island;
	}

	private JLabel player1Name;
	private JLabel player1Money;
	private JLabel player1Islands;
	//
	private JLabel player2Name;
	private JLabel player2Money;
	private JLabel player2Islands;

	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

		backgroundJPanel = new BackgroundJPanel();
		backgroundJPanel.setBackground(Color.BLUE);
		backgroundJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(backgroundJPanel);
		backgroundJPanel.setLayout(null);
		this.backgroundJPanel.initData();
		setButton();

		JPanel playerInfo = new JPanel();
		playerInfo.setOpaque(false);

		player1Name = new JLabel("Name1");

		player1Money = new JLabel("Money1");

		player1Islands = new JLabel("islands1");

		player2Name = new JLabel("Name2");

		player2Money = new JLabel("Money2");

		player2Islands = new JLabel("islands2");
		GroupLayout gl_playerInfo = new GroupLayout(playerInfo);
		gl_playerInfo.setHorizontalGroup(gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup().addContainerGap()
						.addComponent(player1Name, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE).addGap(33)
						.addComponent(player1Money, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE).addGap(70)
						.addComponent(player1Islands, GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE).addGap(108)
						.addComponent(player2Name, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE).addGap(91)
						.addComponent(player2Money, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE).addGap(77)
						.addComponent(player2Islands, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE).addGap(69)));
		gl_playerInfo.setVerticalGroup(gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup().addContainerGap()
						.addGroup(gl_playerInfo.createParallelGroup(Alignment.BASELINE)
								.addComponent(player1Name, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(player1Money).addComponent(player1Islands).addComponent(player2Name)
								.addComponent(player2Money).addComponent(player2Islands))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		playerInfo.setLayout(gl_playerInfo);
		GroupLayout gl_backgroundJPanel = new GroupLayout(backgroundJPanel);
		gl_backgroundJPanel.setHorizontalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addComponent(playerInfo, GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
					.addGap(87))
		);
		gl_backgroundJPanel.setVerticalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addComponent(playerInfo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(504, Short.MAX_VALUE))
		);
		backgroundJPanel.setLayout(gl_backgroundJPanel);
	}


	public void setButton() {
		for (int i = 0; i < islandNum; i++) {

			JButton button = new JButton("island" + (i + 1));
			button.setBorderPainted(false);
			button.setBackground(Color.WHITE);

			button.setBounds(2700,1300,200, 200);

			button.setContentAreaFilled(false);

			setIcon("source/images/island" + (i + 1) + ".jpg", button);
			island.add(button);
			backgroundJPanel.add(button);
		}
	}

	public void setIcon(String Url, JButton button) {
		ImageIcon icon = new ImageIcon(Url);
		icon.getImage();
		java.awt.Image temp = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(),
				Image.SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		button.setIcon(icon);

	}

	public BackgroundJPanel getBackgroundJPanel() {
		return backgroundJPanel;
	}

	public JLabel getPlayer1Name() {
		return player1Name;
	}

	public JLabel getPlayer1Money() {
		return player1Money;
	}

	public JLabel getPlayer1Islands() {
		return player1Islands;
	}

	public JLabel getPlayer2Name() {
		return player2Name;
	}

	public JLabel getPlayer2Money() {
		return player2Money;
	}

	public JLabel getPlayer2Islands() {
		return player2Islands;
	}
}
