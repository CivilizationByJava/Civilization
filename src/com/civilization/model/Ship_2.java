package com.civilization.model;

public class Ship_2 extends Ship {

	private int Ship2_Def;
	private int Ship2_Atk_min;
	private int Ship2_Atk_max;
	private int Ship2_HP;
	private int Ship2_Money;

	public Ship_2() {
		//暂未设定船只具体的防御，攻击下限/上限，生命值，花费，以12345代替
		super(1,2,3,4,5);
		Ship2_Def=super.getShip_Def();
		Ship2_Atk_min=super.getShip_Atk_min();
		Ship2_Atk_max=super.getShip_Atk_max();
		Ship2_HP=super.getShip_HP();
		Ship2_Money=super.getShip_Money();
	}

	public int getShip2_Def() {
		return Ship2_Def;
	}

	public int getShip2_Atk_min() {
		return Ship2_Atk_min;
	}

	public int getShip2_Atk_max() {
		return Ship2_Atk_max;
	}

	public int getShip2_HP() {
		return Ship2_HP;
	}

	public int getShip2_Money() {
		return Ship2_Money;
	}

}
