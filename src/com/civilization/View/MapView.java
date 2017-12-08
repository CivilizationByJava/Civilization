package com.civilization.View;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	//
	private BackgroundJPanel backgroundJPanel;
	//
	private JLabel player1Name;
	private JLabel player1Money;
	private JLabel player1Islands;
	//
	private JLabel player2Name;
	private JLabel player2Money;
	private JLabel player2Islands;
	//
	private JPanel player2Area;
	//
	private JPanel player1Area;
	private JPanel battleArea;

	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 568);
		backgroundJPanel = new BackgroundJPanel();
		backgroundJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundJPanel);

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

		player1Area = new JPanel();

		player2Area = new JPanel();

		battleArea = new JPanel();
		GroupLayout gl_backgroundJPanel = new GroupLayout(backgroundJPanel);
		gl_backgroundJPanel.setHorizontalGroup(gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_backgroundJPanel.createSequentialGroup()
								.addComponent(player1Area, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(battleArea, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(player2Area, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
						.addComponent(playerInfo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 938,
								GroupLayout.PREFERRED_SIZE)));
		gl_backgroundJPanel.setVerticalGroup(gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
						.addComponent(playerInfo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(battleArea, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
								.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(player2Area, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
										.addComponent(player1Area, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)))
						.addGap(0)));
		GroupLayout gl_player1Area = new GroupLayout(player1Area);
		gl_player1Area.setHorizontalGroup(
				gl_player1Area.createParallelGroup(Alignment.LEADING).addGap(0, 404, Short.MAX_VALUE));
		gl_player1Area.setVerticalGroup(
				gl_player1Area.createParallelGroup(Alignment.LEADING).addGap(0, 451, Short.MAX_VALUE));
		player1Area.setLayout(gl_player1Area);
		GroupLayout gl_player2Area = new GroupLayout(player2Area);
		gl_player2Area.setHorizontalGroup(
				gl_player2Area.createParallelGroup(Alignment.LEADING).addGap(0, 438, Short.MAX_VALUE));
		gl_player2Area.setVerticalGroup(
				gl_player2Area.createParallelGroup(Alignment.LEADING).addGap(0, 451, Short.MAX_VALUE));
		player2Area.setLayout(gl_player2Area);
		backgroundJPanel.setLayout(gl_backgroundJPanel);
	}

	public JPanel getPlayer2Area() {
		return player2Area;
	}

	public JPanel getPlayer1Area() {
		return player1Area;
	}

	public JPanel getBattleArea() {
		return battleArea;
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
