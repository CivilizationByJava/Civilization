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
	public MapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 552, 369);
		//setBounds(0,0,);
		this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		backgroundJPanel = new BackgroundJPanel();
		backgroundJPanel.setBackground(Color.BLUE);
		//backgroundJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundJPanel);
		backgroundJPanel.setLayout(null);
		this.backgroundJPanel.initData();
		setButton();
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
}
