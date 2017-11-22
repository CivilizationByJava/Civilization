package com.civilization.View;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	//
	private BackgroundJPanel backgroundJPanel;

	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 369);
		backgroundJPanel = new BackgroundJPanel();
		backgroundJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundJPanel);
		GroupLayout gl_contentPane = new GroupLayout(backgroundJPanel);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 863, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 543, Short.MAX_VALUE)
		);
		backgroundJPanel.setLayout(gl_contentPane);

	}

	public BackgroundJPanel getBackgroundJPanel() {
		return backgroundJPanel;
	}
}
