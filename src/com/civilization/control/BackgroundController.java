package com.civilization.control;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.LayoutStyle;

import com.civilization.View.BackgroundJPanel;
import com.civilization.View.MapView;
import com.civilization.model.Island;

//控制背景图片
public class BackgroundController {

	private Battle battle = new Battle();
	//
	MapView mapView = new MapView();
	BackgroundJPanel backgroundJPanel = new BackgroundJPanel();
	//
	String backgroundURL = "source/images/background.jpg";

	private int backgroundX;
	private int backgroundY;

	// 前一个位置
	private int beginX = 0;

	private int value;
	//

	private int beginY = 0;

	boolean inBackground = false;

	boolean isAttack = false;

	//
	private Island clickedIsland;
	//
	private Island lastClickIsland;
	//
	private int attackShipType;

	public void initBackGroundDraw() {

		mapView.showAttackPanel(-5000, -5000);
		// backgroundX = (int) ((mapView.getWidth() -
		// mapView.getBackgroundJPanel().getWidth()) / 2);
		// backgroundY = (int) ((mapView.getHeight() -
		// mapView.getBackgroundJPanel().getHeight()) / 2);
		mapView.getBackgroundJPanel().initData();

		mapView.getBackgroundJPanel().setLocation(backgroundX - 10, backgroundY - 24); // 定位

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
			public void componentResized(ComponentEvent e) {
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
						for (JButton island : mapView.getIsland()) {
							Point position = island.getLocation();
							island.setLocation(new Point(position.x - changeX, position.y - chanegY));
							//
						}
						
						mapView.showAttackPanel(mapView.getAttackPanel().getLocation().x - changeX,
								mapView.getAttackPanel().getLocation().y - chanegY);
						mapView.getBackgroundJPanel().repaint();

					} else {
						backgroundX += changeX;
						backgroundY += chanegY;
						mapView.getBackgroundJPanel().moveDrawPoint(-backgroundX, -backgroundY);
					}
				}

			}
		});

		// 岛屿Button按钮监听事件
		for (JButton island : mapView.getIsland()) {
			island.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// 点击岛屿\
					if (isAttack) {
						mapView.getShopButton().setVisible(false);
						clickedIsland = mapView.getIslandsMode().get(getIslandByName(arg0.getSource()));
						// 数据
						battle.BattleStart(lastClickIsland, clickedIsland, lastClickIsland.getPlayer_Army_Kind(),
								clickedIsland.getPlayer_Army_Kind(), value);
						isAttack = false;
						// 图像

					} else {
						mapView.getShopButton().setVisible(true);
						lastClickIsland = mapView.getIslandsMode().get(getIslandByName(arg0.getSource()));
						mapView.setClickedIsland(clickedIsland);
						mapView.showAttackPanel(island.getLocation().x, island.getLocation().y + 200);
					}
				}
			});
		}

		mapView.getAttackbutton().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int value = (int) (mapView.getSpinner().getValue());
				if (value <= lastClickIsland.getPlayer_Army_Num() && value <= 5) {
					attackShipType = lastClickIsland.getEnemy_Kinds();
					isAttack = true;
				}
			}

		});
		
		addShopListener();

	}

	//
	private void addShopListener() {
		mapView.getShip1().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//购买
			}

		});
		mapView.getShip2().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//购买
			}
		});
		mapView.getShip3().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//购买
			}
		});
	}

	private int getIslandByName(Object object) {
		for (JButton island : mapView.getIsland()) {
			if (island.equals(object)) {
				return mapView.getIsland().indexOf(island);
			}
		}

		return 0;
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
		// mapView.setButton();
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
