package com.civilization.mainstript;

import java.awt.EventQueue;

import com.civilization.View.StartView;
import com.civilization.control.MainController;
import com.civilization.control.Music;

//放置主函数
public class MainStript {
	
	//主控制器
	private static MainController mainController=new MainController();
	private static Music musicPlay=new Music();
	public static void main(String[] args) {

		//初始化游戏
		//mainController.initGame();
		//musicPlay.musicPlayer_Begin(true);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartView frame = new StartView();
					frame.repaint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
