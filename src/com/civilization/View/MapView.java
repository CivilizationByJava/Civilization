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

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	//
	private BackgroundJPanel backgroundJPanel;

	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 369);
		backgroundJPanel = new BackgroundJPanel();
		//backgroundJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundJPanel);
		backgroundJPanel.setLayout(null);
	}

	public BackgroundJPanel getBackgroundJPanel() {
		return backgroundJPanel;
	}
}
