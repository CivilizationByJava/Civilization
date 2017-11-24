package com.civilization.control;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

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
	private int beginX = 0;


	private int beginY = 0;
	private float v = 1;

	boolean inBackground = false;

	public void initBackGroundDraw() {

		mapView.getBackgroundJPanel().initData();

		backgroundX = (int) ((mapView.getWidth() - mapView.getBackgroundJPanel().getWidth()) / 2);
		backgroundY = (int) ((mapView.getHeight() - mapView.getBackgroundJPanel().getHeight()) / 2);

		mapView.getBackgroundJPanel().setLocation(backgroundX, backgroundY); // 定位

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
		mapView.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				if(e.getWheelRotation()==-1){
					v+=0.1;
					mapView.getBackgroundJPanel().setValue(v);
					//System.out.println(v);
				}
				if(e.getWheelRotation()==1&&v>0.5){
					v-=0.1;
					mapView.getBackgroundJPanel().setValue(v);
				}
				mapView.getBackgroundJPanel().repaint();
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
	