package com.civilization.model;

import java.awt.Point;

//用于加载岛屿和岛屿的点击事件
public class Island {
	
	//岛屿种类
	private String Island_Kinds;
	//岛屿每回合所能提供的金钱
	private int Island_Gold;
	//岛屿上初始中立敌对单位的种类
	private int Enemy_Kinds;
	//岛屿上初始中立敌对单位的数量
	private int Enemy_Num;
	//岛屿的X坐标
	private Point Island_X;
	//岛屿的Y坐标
	private Point Island_Y;
	//岛屿的占领者:player1,player2,中立 三种
	private String HostOfIsland;
	//岛屿上玩家军队的种类:1,2,3三种
	private int Player_Army_Kind;
	//岛屿上玩家军队的数量
	private int Player_Army_Num;
	public String getHostOfIsland() {
		return HostOfIsland;
	}
	public void setHostOfIsland(String hostOfIsland) {
		HostOfIsland = hostOfIsland;
	}
	public int getPlayer_Army_Kind() {
		return Player_Army_Kind;
	}
	public void setPlayer_Army_Kind(int player_Army_Kind) {
		Player_Army_Kind = player_Army_Kind;
	}
	public int getPlayer_Army_Num() {
		return Player_Army_Num;
	}
	public void setPlayer_Army_Num(int player_Army_Num) {
		Player_Army_Num = player_Army_Num;
	}
	
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
	public int getEnemy_Kinds() {
		return Enemy_Kinds;
	}
	public void setEnemy_Kinds(int enemy_Kinds) {
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
	//尚未设定每种岛的具体收入，所以用123代替，我觉得大概是主岛最高，大岛次之，小岛最少
	public int IslandMoneyPerRound(String IslandKind) {
		int gettedMoney = 0;
		switch(IslandKind)
		{
		case "Main":gettedMoney=1;break;
		case "Big":gettedMoney=2;break;
		case "Small":gettedMoney=3;break;
		}
		return gettedMoney;
	}
	//T 判断两个岛之间距离
	
}
