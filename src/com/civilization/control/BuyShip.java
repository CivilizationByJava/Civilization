package com.civilization.control;

import com.civilization.model.Player;
import com.civilization.model.Ship_1;
import com.civilization.model.Ship_2;
import com.civilization.model.Ship_3;
import com.civilization.model.Island;
public class BuyShip {

	public void Buy(Player p, Island island,int Shipkind, Ship_1 s1, Ship_2 s2, Ship_3 s3, int BuyShipNum) {

		switch (Shipkind) {
		case 1:
			if (p.getMoney() >= s1.getShip_Money()&&island.getPlayer_Army_Kind()!=2&&island.getPlayer_Army_Kind()!=3) {
				island.setPlayer_Army_Num(island.getPlayer_Army_Num()+BuyShipNum);
				p.setMoney(p.getMoney() - s1.getShip_Money());
			} else {
				/* T 告诉玩家买不了 */}
			break;
		case 2:
			if (p.getMoney() >= s2.getShip_Money()&&island.getPlayer_Army_Kind()!=1&&island.getPlayer_Army_Kind()!=3) {
				island.setPlayer_Army_Num(island.getPlayer_Army_Num()+BuyShipNum);
				p.setMoney(p.getMoney() - s2.getShip_Money());
			} else {
				/* T 告诉玩家买不了 */}
			break;
		case 3:
			if (p.getMoney() >= s3.getShip_Money()&&island.getPlayer_Army_Kind()!=1&&island.getPlayer_Army_Kind()!=2) {
				island.setPlayer_Army_Num(island.getPlayer_Army_Num()+BuyShipNum);
				p.setMoney(p.getMoney() - s3.getShip_Money());
			} else {
				/* T 告诉玩家买不了 */}
			break;
		}
	}

}
