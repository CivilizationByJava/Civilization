package com.civilization.control;

import com.civilization.model.Island;
import com.civilization.model.Player;

public class getMoney {

	// 该函数每回合运行一次
	public void moneyGet(Player p) {
		int moneyMain;
		int moneyBig;
		int moneySmall;
		// 计算每种岛一回合能给玩家带来多少收入
		moneyMain = 800 * p.getIslandsCount_Main();
		moneyBig = 500 * p.getIslandsCount_Big();
		moneySmall = 200 * p.getIslandsCount_Small();
		// 加在一起就是玩家的总金币
		p.setMoney(p.getMoney() + moneyMain + moneyBig + moneySmall);
	}

	
}
