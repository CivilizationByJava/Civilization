package com.civilization.View;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.prism.Graphics;
import com.sun.prism.Image;

import sun.security.x509.PrivateKeyUsageExtension;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private int islandNum=6;
	//
	private BackgroundJPanel backgroundJPanel;

	private List<JButton> island=new ArrayList<>();
	
	public int getIslandNum(){
		return islandNum;
	}
	
	public List<JButton> getIsland(){
		return this.island;
	}
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
	private JLabel lblNewLabel;
	private JButton ship1;
	private JButton ship2;
	private JButton ship3;
	private JLabel ship1Price;
	private JLabel ship2Price;
	private JLabel ship3Price;
	private JButton bomb;
	private JLabel label;
	private JPanel panel;
	
	public void setShopView(){
		panel.setVisible(false);
		panel.setOpaque(false);
		
		ship1.setContentAreaFilled(false);
		ship1.setBackground(Color.WHITE);
		setIcon("source/images/ship1.jpg",ship1);
		panel.add(ship1);
		ship2.setContentAreaFilled(false);
		ship2.setBackground(Color.WHITE);
		setIcon("source/images/ship2.jpg",ship2);
		panel.add(ship2);
		ship3.setContentAreaFilled(false);
		ship3.setBackground(Color.WHITE);
		setIcon("source/images/ship3.jpg",ship3);
		System.out.println(ship3);
		panel.add(ship3);
		bomb.setContentAreaFilled(false);
		bomb.setBackground(Color.WHITE);
		setIcon("source/images/bomb.jpg",bomb);
		System.out.println(bomb);
		panel.add(bomb);
	}
	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		setBounds(100, 100, 966, 568);
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

		player1Area = new JPanel();
		player1Area.setVisible(false);

		player2Area = new JPanel();
		player2Area.setVisible(false);

		battleArea = new JPanel();
		battleArea.setVisible(false);
		
		panel = new JPanel();
		GroupLayout gl_backgroundJPanel = new GroupLayout(backgroundJPanel);
		gl_backgroundJPanel.setHorizontalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(player1Area, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(battleArea, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(player2Area, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(playerInfo, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
		);
		gl_backgroundJPanel.setVerticalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_backgroundJPanel.createSequentialGroup()
							.addGap(159)
							.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_backgroundJPanel.createSequentialGroup()
									.addGap(50)
									.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(battleArea, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
										.addComponent(player2Area, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
								.addComponent(player1Area, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)))
						.addGroup(gl_backgroundJPanel.createSequentialGroup()
							.addComponent(playerInfo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		lblNewLabel = new JLabel("shop");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			boolean bool=true;
			public void mouseClicked(MouseEvent arg0) {
				if(bool){
					panel.setVisible(true);
				}else{
					panel.setVisible(false);
				}
				bool=!bool;
			}
		});
		GroupLayout gl_playerInfo = new GroupLayout(playerInfo);
		gl_playerInfo.setHorizontalGroup(
			gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(14)
					.addComponent(player1Name, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(33)
					.addComponent(player1Money, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(70)
					.addComponent(player1Islands, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(108)
					.addComponent(player2Name, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(91)
					.addComponent(player2Money, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addGap(95)
					.addComponent(player2Islands, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(107)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(23))
		);
		gl_playerInfo.setVerticalGroup(
			gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(13)
					.addComponent(player1Name, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(22)
					.addComponent(player1Money))
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(22)
					.addComponent(player1Islands))
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(22)
					.addComponent(player2Name))
				.addGroup(gl_playerInfo.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_playerInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(player2Money)
						.addComponent(player2Islands)
						.addComponent(lblNewLabel)))
		);
		playerInfo.setLayout(gl_playerInfo);
		
		ship1 = new JButton("ship1");
		ship1.setBounds(0, 0, 131, 67);
		
		ship2 = new JButton("ship2");
		ship2.setBounds(0, 106, 131, 75);
		
		ship3 = new JButton("ship3");
		ship3.setBounds(0, 225, 131, 75);
		
		ship3Price = new JLabel("50$/5");
		ship3Price.setBounds(58, 308, 31, 18);
		
		ship2Price = new JLabel("40$/5");
		ship2Price.setBounds(48, 194, 41, 18);
		
		ship1Price = new JLabel("50$/5");
		ship1Price.setBounds(58, 75, 31, 18);
		panel.setLayout(null);
		panel.add(ship3Price);
		panel.add(ship2Price);
		panel.add(ship1Price);
		
		bomb = new JButton("bomb");
		bomb.setBounds(34, 339, 70, 49);
	
		label = new JLabel("50$/1");
		label.setBounds(58, 404, 31, 18);
		panel.add(label);
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
		setShopView();
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


	public void setButton(){
		for(int i=0;i<islandNum;i++){
			
			JButton button = new JButton("island"+(i+1));
			button.setBorderPainted(false);
			button.setBackground(Color.WHITE);
			
			button.setBounds(-200+200*i, -100+100*i,200, 200);
			
			button.setContentAreaFilled(false);
			
			setIcon("source/images/island"+(i+1)+".jpg",button);
			island.add(button);
			backgroundJPanel.add(button);
		}
	}
	
	public void setIcon(String Url,JButton button ){
		ImageIcon icon=new ImageIcon(Url);	
		java.awt.Image temp=icon.getImage().getScaledInstance(button.getWidth(),button.getHeight() , icon.getImage().SCALE_DEFAULT);
		icon=new ImageIcon(temp);
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
