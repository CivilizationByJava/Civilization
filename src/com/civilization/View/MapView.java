package com.civilization.View;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import com.civilization.control.Game;
import com.civilization.model.Island;
import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class MapView extends JFrame {

	private static final long serialVersionUID = 1L;
	private int islandNum = 6;
	//
	private BackgroundJPanel backgroundJPanel;

	private List<JButton> island = new ArrayList<>();

	public int getIslandNum() {
		return islandNum;
	}

	public List<JButton> getIsland() {
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
	private List<Island> islandsMode = new ArrayList<>();
	private JLabel shopButton;
	private JButton ship1;
	private JButton ship2;
	private JButton ship3;
	private JLabel ship1Price;
	private JLabel ship2Price;
	private JLabel ship3Price;
	private JButton bomb;
	private JLabel label;
	private JPanel panel;
	private JPanel attackPanel;
	private JButton cancelbutton;
	private JButton attackbutton;
	private JButton ship1Icon;
	private JButton ship3Icon;
	private JButton ship2Icon;
	private JLabel ship1Num;
	private JLabel ship3Num;
	private JLabel ship2Num;
	private JSpinner spinner;

	private Game game;

	//
	private Island clickedIsland;

	public void showAttackPanel(int x, int y, Island island) {
		if (island.getPlayer_Army_Kind() == 1) {
			ship1Num.setText(Integer.toString(island.getPlayer_Army_Num()));
			ship2Num.setText("0");
			ship3Num.setText("0");
		} else if (island.getPlayer_Army_Kind() == 2) {
			ship2Num.setText(Integer.toString(island.getPlayer_Army_Num()));
			ship1Num.setText("0");
			ship3Num.setText("0");
		} else if (island.getPlayer_Army_Kind() == 3) {
			ship3Num.setText(Integer.toString(island.getPlayer_Army_Num()));
			ship2Num.setText("0");
			ship1Num.setText("0");
		}

		//attackPanel.setLocation(x, y);

	}

	public void setAttackPanelView() {
		ship1Icon.setContentAreaFilled(false);
		ship1Icon.setBackground(Color.WHITE);
		setIcon("source/images/ship1.png", ship1Icon);
		attackPanel.add(ship1Icon);
		ship2Icon.setContentAreaFilled(false);
		ship2Icon.setBackground(Color.WHITE);
		setIcon("source/images/ship2.png", ship2Icon);
		attackPanel.add(ship2Icon);
		ship3Icon.setContentAreaFilled(false);
		ship3Icon.setBackground(Color.WHITE);
		setIcon("source/images/ship3.png", ship3Icon);
		attackPanel.add(ship3Icon);
		cancelbutton.setContentAreaFilled(false);
		attackbutton.setContentAreaFilled(false);
		attackPanel.add(spinner);
	}

	public void setShopView() {
		panel.setVisible(false);
		panel.setOpaque(false);

		ship1.setContentAreaFilled(false);
		ship1.setBackground(Color.WHITE);
		setIcon("source/images/ship1.png", ship1);
		panel.add(ship1);
		ship2.setContentAreaFilled(false);
		ship2.setBackground(Color.WHITE);
		setIcon("source/images/ship2.png", ship2);
		panel.add(ship2);
		ship3.setContentAreaFilled(false);
		ship3.setBackground(Color.WHITE);
		setIcon("source/images/ship3.png", ship3);
		panel.add(ship3);
		bomb.setContentAreaFilled(false);
		bomb.setBackground(Color.WHITE);
		setIcon("source/images/bomb.jpg", bomb);
		panel.add(bomb);
	}

	public MapView(Game game) {

		this.game = game;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());

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

		panel = new JPanel();

		attackPanel = new JPanel();
		attackPanel.setOpaque(false);
		GroupLayout gl_backgroundJPanel = new GroupLayout(backgroundJPanel);
		gl_backgroundJPanel.setHorizontalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(attackPanel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(playerInfo, GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
		);
		gl_backgroundJPanel.setVerticalGroup(
			gl_backgroundJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_backgroundJPanel.createSequentialGroup()
					.addComponent(playerInfo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_backgroundJPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_backgroundJPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(attackPanel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_backgroundJPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)))
					.addContainerGap())
		);

		cancelbutton = new JButton("cancel");
		cancelbutton.setBounds(14, 157, 81, 27);
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attackPanel.setLocation(-5000, -5000);
			}
		});
		attackPanel.setLayout(null);
		attackPanel.add(cancelbutton);

		attackbutton = new JButton("attack");
		attackbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		attackbutton.setBounds(117, 157, 81, 27);
		attackPanel.add(attackbutton);

		ship1Icon = new JButton("New button");
		ship1Icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ship1Icon.setBounds(0, 13, 58, 44);

		ship3Icon = new JButton("New button");
		ship3Icon.setBounds(143, 13, 55, 44);

		ship2Icon = new JButton("New button");
		ship2Icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		ship2Icon.setBounds(72, 13, 57, 44);

		ship1Num = new JLabel("0");
		ship1Num.setBounds(14, 70, 28, 18);
		attackPanel.add(ship1Num);

		ship2Num = new JLabel("0");
		ship2Num.setBounds(88, 70, 24, 18);
		attackPanel.add(ship2Num);

		ship3Num = new JLabel("0");
		ship3Num.setBounds(158, 70, 29, 18);
		attackPanel.add(ship3Num);

		spinner = new JSpinner();
		spinner.setBounds(84, 95, 46, 24);
		spinner.setModel(new SpinnerNumberModel(2, 1, 5, 1));
		// attackPanel.add(spinner);

		shopButton = new JLabel("shop");
		shopButton.setVisible(false);
		shopButton.addMouseListener(new MouseAdapter() {
			boolean bool = true;

			public void mouseClicked(MouseEvent arg0) {
				if (bool) {
					panel.setVisible(true);
				} else {
					panel.setVisible(false);
				}
				bool = !bool;
			}
		});
		GroupLayout gl_playerInfo = new GroupLayout(playerInfo);
		gl_playerInfo.setHorizontalGroup(gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(14)
						.addComponent(player1Name, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE).addGap(33)
						.addComponent(player1Money, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE).addGap(70)
						.addComponent(player1Islands, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE).addGap(108)
						.addComponent(player2Name, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).addGap(91)
						.addComponent(player2Money, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE).addGap(95)
						.addComponent(player2Islands, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE).addGap(107)
						.addComponent(shopButton, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE).addGap(23)));
		gl_playerInfo.setVerticalGroup(gl_playerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(13).addComponent(player1Name,
						GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(22).addComponent(player1Money))
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(22).addComponent(player1Islands))
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(22).addComponent(player2Name))
				.addGroup(gl_playerInfo.createSequentialGroup().addGap(22)
						.addGroup(gl_playerInfo.createParallelGroup(Alignment.BASELINE).addComponent(player2Money)
								.addComponent(player2Islands).addComponent(shopButton))));
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
		backgroundJPanel.setLayout(gl_backgroundJPanel);
		setShopView();
		setAttackPanelView();
	}

	public void setButton() {
		addIsland(new Point(-900, 450), new Point(300, 300), 4);
		Island island_1 = new Island("main", 0);
		island_1.setHostOfIsland(game.getPlayer1());
		islandsMode.add(island_1);
		addIsland(new Point(-560, -200), new Point(150, 150), 2);
		Island island_2 = new Island("small", 1);
		island_2.setPlayer_Army_Kind(1);
		island_2.setPlayer_Army_Num(2);
		islandsMode.add(island_2);
		addIsland(new Point(-500, 400), new Point(150, 150), 3);
		Island island_3 = new Island("small", 1);
		island_3.setPlayer_Army_Kind(2);
		island_3.setPlayer_Army_Num(4);
		islandsMode.add(island_3);
		addIsland(new Point(-560, 900), new Point(150, 150), 3);
		Island island_4 = new Island("small", 1);
		island_4.setPlayer_Army_Kind(1);
		island_4.setPlayer_Army_Num(3);
		islandsMode.add(island_4);
		addIsland(new Point(-100, 400), new Point(150, 150), 5);
		Island island_5 = new Island("small", 2);
		island_5.setPlayer_Army_Kind(5);
		island_5.setPlayer_Army_Num(4);
		islandsMode.add(island_5);
		addIsland(new Point(-100, 900), new Point(150, 150), 6);
		Island island_6 = new Island("small", 2);
		island_6.setPlayer_Army_Kind(1);
		island_6.setPlayer_Army_Num(1);
		islandsMode.add(island_6);
		addIsland(new Point(300, 450), new Point(200, 200), 7);
		Island island_7 = new Island("big", 3);
		island_7.setPlayer_Army_Kind(3);
		island_7.setPlayer_Army_Num(4);
		islandsMode.add(island_7);
		addIsland(new Point(900, 450), new Point(300, 300), 5);
		Island island_8 = new Island("main", 4);
		island_8.setPlayer_Army_Kind(1);
		island_8.setPlayer_Army_Num(2);
		islandsMode.add(island_8);
		addIsland(new Point(1500, 450), new Point(200, 200), 2);
		Island island_9 = new Island("big", 5);
		island_9.setPlayer_Army_Kind(1);
		island_9.setPlayer_Army_Num(1);
		islandsMode.add(island_9);
		addIsland(new Point(1900, 400), new Point(150, 150), 3);
		Island island_10 = new Island("small", 6);
		island_10.setPlayer_Army_Kind(2);
		island_10.setPlayer_Army_Num(2);
		islandsMode.add(island_10);
		addIsland(new Point(1900, 900), new Point(150, 150), 6);
		Island island_11 = new Island("small", 6);
		island_11.setPlayer_Army_Kind(3);
		island_11.setPlayer_Army_Num(3);
		islandsMode.add(island_11);
		addIsland(new Point(2240, -200), new Point(150, 150), 6);
		Island island_12 = new Island("small", 7);
		island_12.setPlayer_Army_Kind(2);
		island_12.setPlayer_Army_Num(1);
		islandsMode.add(island_12);
		addIsland(new Point(2300, 450), new Point(150, 150), 5);
		Island island_13 = new Island("small", 7);
		island_13.setPlayer_Army_Kind(1);
		island_13.setPlayer_Army_Num(4);
		islandsMode.add(island_13);
		addIsland(new Point(2240, 900), new Point(150, 150), 7);
		Island island_14 = new Island("small", 7);
		island_14.setPlayer_Army_Kind(1);
		island_14.setPlayer_Army_Num(4);
		islandsMode.add(island_14);
		addIsland(new Point(2500, 450), new Point(300, 300), 4);
		Island island_15 = new Island("main", 8);
		island_15.setHostOfIsland(game.getPlayer2());
		islandsMode.add(island_15);

	}


	private void addIsland(Point position, Point size, int tag) {
		JButton button = new JButton();
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);

		button.setBounds(position.x, position.y, size.x, size.y);

		button.setContentAreaFilled(false);
		setIcon("source/images/islands/island" + tag + ".png", button);
		island.add(button);
		backgroundJPanel.add(button);
	}

	public void setIcon(String Url, JButton button) {
		ImageIcon icon = new ImageIcon(Url);
		icon.getImage();
		java.awt.Image temp = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(),
				Image.SCALE_DEFAULT);
		icon = new ImageIcon(temp);
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

	public JPanel getAttackPanel() {
		return attackPanel;
	}

	public JButton getAttackbutton() {
		return attackbutton;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setClickedIsland(Island clickedIsland) {
		this.clickedIsland = clickedIsland;
	}

	public List<Island> getIslandsMode() {
		return islandsMode;
	}

	public JButton getShip1() {
		return ship1;
	}

	public JButton getShip2() {
		return ship2;
	}

	public JButton getShip3() {
		return ship3;
	}

	public JLabel getShopButton() {
		return shopButton;
	}

}
