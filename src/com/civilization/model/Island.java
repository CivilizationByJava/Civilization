package com.civilization.model;

import java.awt.Point;

//用于加载岛屿和岛屿的点击事件
public class Island {
	
	//岛屿种类
	private String Island_Kinds;
	//岛屿每回合所能提供的金钱
	private int Island_Gold;
	//岛屿上初始中立敌对单位的种类
	private String Enemy_Kinds;
	//岛屿上初始中立敌对单位的数量
	private int Enemy_Num;
	//岛屿的X坐标
	private Point Island_X;
	//岛屿的Y坐标
	private Point Island_Y;
	public String getIsland_Kinds() {
		return Island_Kinds;
	}
	public void setIsland_Kinds(String island_Kinds) {
		Island_Kinds = island_Kinds;
	}
	public int getIsland_Gold() {
		return Island_Gold;
	}
	public void setIsland_Gold(int island_Gold) {
		Island_Gold = island_Gold;
	}
	public String getEnemy_Kinds() {
		return Enemy_Kinds;
	}
	public void setEnemy_Kinds(String enemy_Kinds) {
		Enemy_Kinds = enemy_Kinds;
	}
	public int getEnemy_Num() {
		return Enemy_Num;
	}
	public void setEnemy_Num(int enemy_Num) {
		Enemy_Num = enemy_Num;
	}
	public Point getIsland_X() {
		return Island_X;
	}
	public void setIsland_X(Point island_X) {
		Island_X = island_X;
	}
	public Point getIsland_Y() {
		return Island_Y;
	}
	public void setIsland_Y(Point island_Y) {
		Island_Y = island_Y;
	}
	
}
