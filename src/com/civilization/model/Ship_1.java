package com.civilization.model;

public class Ship_1 extends Ship {
	
	
	private int Ship1_Def;
	private int Ship1_Atk_min;
	private int Ship1_Atk_max;
	private int Ship1_HP;
	private int Ship1_Money;

	public Ship_1() {
		//暂未设定船只具体的防御，攻击下限/上限，生命值，花费，以12345代替
		super(1,2,3,4,5);
		Ship1_Def=super.getShip_Def();
		Ship1_Atk_min=super.getShip_Atk_min();
		Ship1_Atk_max=super.getShip_Atk_max();
		Ship1_HP=super.getShip_HP();
		Ship1_Money=super.getShip_Money();
	}

	public int getShip1_Def() {
		return Ship1_Def;
	}

	public int getShip1_Atk_min() {
		return Ship1_Atk_min;
	}

	public int getShip1_Atk_max() {
		return Ship1_Atk_max;
	}

	public int getShip1_HP() {
		return Ship1_HP;
	}

	public int getShip1_Money() {
		return Ship1_Money;
	}

}
