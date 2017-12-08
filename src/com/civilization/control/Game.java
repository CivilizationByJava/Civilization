package com.civilization.control;

import com.civilization.model.Player;

public class Game {

	//胜负判断
	public String winOrLose(Player p1,Player p2)
	{
		
		if(p1.getIslandsCount_Big()+p1.getIslandsCount_Main()+p1.getIslandsCount_Small()==0) {
			return p1.getPlayerID();
		}
		if(p2.getIslandsCount_Big()+p2.getIslandsCount_Main()+p2.getIslandsCount_Small()==0) {
			return p2.getPlayerID();
		}
		return null;
	
		
	}
}
