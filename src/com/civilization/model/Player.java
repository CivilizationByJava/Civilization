package com.civilization.model;

//玩家类
public class Player {

	// 玩家ID
	private String Playerid;
	// 玩家拥有的金钱数目
	private int money=1000;
	// 玩家拥有的岛屿数量(主要，大型，小型)
	private int islandsCount_Main = 1;
	private int islandsCount_Big = 0;
	private int islandsCount_Small = 0;
	// 每回合所能获得的总金钱数（随玩家持有的岛屿种类和数量而变化）
	private int MoneyPerRound;
	// 玩家拥有的兵种1数量
	private int Ship1_Num;
	// 玩家拥有的兵种2数量
	private int Ship2_Num;
	// 玩家拥有的兵种3数量
	private int Ship3_Num;
	// 玩家主基地剩余生命值
	private int Base_HP;

	public String getPlayerID() {
		return this.Playerid;
	}

	public void setPlayerID(String Playerid) {
		this.Playerid = Playerid;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getIslandsCount_Main() {
		return islandsCount_Main;
	}

	public void setIslandsCount_Main(int islandsCount_Main) {
		this.islandsCount_Main = islandsCount_Main;
	}

	public int getIslandsCount_Big() {
		return islandsCount_Big;
	}

	public void setIslandsCount_Big(int islandsCount_Big) {
		this.islandsCount_Big = islandsCount_Big;
	}

	public int getIslandsCount_Small() {
		return islandsCount_Small;
	}

	public void setIslandsCount_Small(int islandsCount_Small) {
		this.islandsCount_Small = islandsCount_Small;
	}

	public int getMoneyPerRound() {
		return this.MoneyPerRound;
	}

	public void setMoneyPerRound(int MoneyPerRound) {
		this.MoneyPerRound = MoneyPerRound;
	}

	public int getShip1_Num() {
		return this.Ship1_Num;
	}

	public void setShip1_Num(int Ship1_Num) {
		this.Ship1_Num = Ship1_Num;
	}

	public int getShip2_Num() {
		return this.Ship2_Num;
	}

	public void setShip2_Num(int Ship2_Num) {
		this.Ship2_Num = Ship2_Num;
	}

	public int getShip3_Num() {
		return this.Ship3_Num;
	}

	public void setShip3_Num(int Ship3_Num) {
		this.Ship3_Num = Ship3_Num;
	}

	public int getBase_HP() {
		return this.Base_HP;
	}

	public void setBase_HP(int Base_HP) {
		this.Base_HP = Base_HP;
	}

}
