package com.civilization.control;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import com.civilization.View.MapView;

//控制背景图片
public class BackgroundController {

	//
	MapView mapView = new MapView();
	//
	String backgroundURL = "source/images/background.jpg";

	private int backgroundX=0;
	private int backgroundY=0;

	// 前一个位置
	private int beginX = 0;


	private int beginY = 0;

	boolean inBackground = false;

	public void initBackGroundDraw() {

		backgroundX = (int) ((mapView.getWidth() - mapView.getBackgroundJPanel().getWidth()) / 2);
		backgroundY = (int) ((mapView.getHeight() - mapView.getBackgroundJPanel().getHeight()) / 2);

		mapView.getBackgroundJPanel().setLocation(backgroundX-10, backgroundY-24); // 定位

		// 鼠标动作 监听器 注册
		mapView.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				beginX = e.getX();
				beginY = e.getY();
				inBackground = true;
			}

			// 释放
			public void mouseReleased(MouseEvent e) {
				inBackground = false;
			}
		});
		
		//
		mapView.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e){
				backgroundX = (int) ((mapView.getWidth() - mapView.getBackgroundJPanel().getWidth()) / 2);
				backgroundY = (int) ((mapView.getHeight() - mapView.getBackgroundJPanel().getHeight()) / 2);
				mapView.getBackgroundJPanel().initData();
				
			}

		});

		// 鼠标移动 监听器 注册
		mapView.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {

				int changeX = beginX - e.getX();
				int chanegY = beginY - e.getY();
				if (inBackground) {
					backgroundX -= changeX;
					backgroundY -= chanegY;
					beginX = e.getX();
					beginY = e.getY();

					mapView.getBackgroundJPanel().moveDrawPoint(backgroundX, backgroundY);
					if (isInBounds()) {
						mapView.getBackgroundJPanel().repaint();
					} else {
						backgroundX += changeX;
						backgroundY += chanegY;
						mapView.getBackgroundJPanel().moveDrawPoint(-backgroundX, -backgroundY);
					}
				}

			}
		});
		
	}
	
	// 检测 点(x,y) 是否在图片上
	private boolean isInBounds() {
		
		if (mapView.getBackgroundJPanel().getDrawX() > -mapView.getBackgroundJPanel().getWidth()
				&& mapView.getBackgroundJPanel().getDrawX() < 0
				&& mapView.getBackgroundJPanel().getDrawY() > -mapView.getBackgroundJPanel().getHeight()
				&& mapView.getBackgroundJPanel().getDrawY() < 0) {

			return true;

		} else
			return false;
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
	