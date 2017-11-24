package com.civilization.model;

public class Ship_3 extends Ship{

	private int Ship3_Def;
	private int Ship3_Atk_min;
	private int Ship3_Atk_max;
	private int Ship3_HP;
	private int Ship3_Money;

	public Ship_3() {
		//暂未设定船只具体的防御，攻击下限/上限，生命值，花费，以12345代替
		super(1,2,3,4,5);
		Ship3_Def=super.getShip_Def();
		Ship3_Atk_min=super.getShip_Atk_min();
		Ship3_Atk_max=super.getShip_Atk_max();
		Ship3_HP=super.getShip_HP();
		Ship3_Money=super.getShip_Money();
	}

	public int getShip3_Def() {
		return Ship3_Def;
	}

	public int getShip3_Atk_min() {
		return Ship3_Atk_min;
	}

	public int getShip3_Atk_max() {
		return Ship3_Atk_max;
	}

	public int getShip3_HP() {
		return Ship3_HP;
	}

	public int getShip3_Money() {
		return Ship3_Money;
	}

}
