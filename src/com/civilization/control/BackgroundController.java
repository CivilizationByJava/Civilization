package com.civilization.control;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.civilization.View.MapView;

//控制背景图片
public class BackgroundController {

	//
	MapView mapView = new MapView();
	//
	String backgroundURL = "source/images/background.jpg";

	private int backgroundX;
	private int backgroundY;

	// 前一个位置
	int beginX = 0;
	int beginY = 0;

	boolean inBackground = false;

	public void initBackGroundDraw() {
		backgroundX = (int) ((mapView.getWidth() - mapView.getBackgroundJPanel().getWidth()) / 2);
		backgroundY = (int) ((mapView.getHeight() - mapView.getBackgroundJPanel().getHeight()) / 2);

		mapView.getBackgroundJPanel().setLocation(backgroundX, backgroundY); // 定位

		// 鼠标动作 监听器 注册
		mapView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 检测 落点 是否在图片上,只有落点在图片上时 才起作
				if (inPicBounds(e.getX(), e.getY())) {
					beginX = e.getX();
					beginY = e.getY();
					inBackground = true;
				}
				// 记录当前坐标
			}

			// 释放
			public void mouseReleased(MouseEvent e) {
				inBackground = false;
			}
		});

		// 鼠标移动 监听器 注册
		mapView.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (inBackground && checkPoint(e.getX(), e.getY())) {
					// 边界 检查
					backgroundX = backgroundX - (beginX - e.getX());
					backgroundY = backgroundY - (beginY - e.getY());
					// System.out.println("pic_x=" + pic_x);
					beginX = e.getX();
					beginY = e.getY();
					mapView.getBackgroundJPanel().setLocation(backgroundX, backgroundY);
				}
			}
		});
	}

	// 检测 点(px,py) 是否在图片上
	private boolean inPicBounds(int px, int py) {
		if (px >= backgroundX && px <= backgroundX + mapView.getBackgroundJPanel().getWidth() && py >= backgroundY
				&& py <= backgroundY + mapView.getBackgroundJPanel().getHeight())
			return true;
		else
			return false;
	}

	// 越界 检查
	private boolean checkPoint(int px, int py) {
		if (px < 0 || py < 0)
			return false;
		if (px > mapView.getWidth() || py > mapView.getHeight())
			return false;
		return true;
	}

	public void initBackGroundControler() {
		initMapView();
		mapView.getBackgroundJPanel().setBackgroundImage(backgroundURL);
		initBackGroundDraw();
	}

	// 初始化地图
	private void initMapView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mapView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
