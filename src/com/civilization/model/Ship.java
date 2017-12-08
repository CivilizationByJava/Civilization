package com.civilization.model;

public class Ship {

	private int Ship_Def;
	private int Ship_Atk_min;
	private int Ship_Atk_max;
	private int Ship_HP;
	private int Ship_Money;
	public Ship(int Def,int Atk_min,int Atk_max,int HP,int Money) {
		 Ship_Def=Def;
		 Ship_Atk_min=Atk_min;
		 Ship_Atk_max=Atk_max;
		 Ship_HP=HP;
		 Ship_Money=Money;
		 
		
	}
	public int getShip_Def() {
		return Ship_Def;
	}
	public void setShip_Def(int ship_Def) {
		Ship_Def = ship_Def;
	}
	public int getShip_Atk_min() {
		return Ship_Atk_min;
	}
	public void setShip_Atk_min(int ship_Atk_min) {
		Ship_Atk_min = ship_Atk_min;
	}
	public int getShip_Atk_max() {
		return Ship_Atk_max;
	}
	public void setShip_Atk_max(int ship_Atk_max) {
		Ship_Atk_max = ship_Atk_max;
	}
	public int getShip_HP() {
		return Ship_HP;
	}
	public void setShip_HP(int ship_HP) {
		Ship_HP = ship_HP;
	}
	public int getShip_Money() {
		return Ship_Money;
	}
	public void setShip_Money(int ship_Money) {
		Ship_Money = ship_Money;
	}
	
	
}
