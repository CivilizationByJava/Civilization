package com.civilization.control;

import com.civilization.model.Player;
import com.civilization.model.Ship_1;
import com.civilization.model.Ship_2;
import com.civilization.model.Ship_3;

public class BuyShip {

	public void Player1buyShip1(Player p, int Shipkind, Ship_1 s1, Ship_2 s2, Ship_3 s3, int BuyShipNum) {

		switch (Shipkind) {
		case 1:
			if (p.getMoney() >= s1.getShip_Money()) {
				p.setShip1_Num(p.getShip1_Num() + BuyShipNum);
				p.setMoney(p.getMoney()-s1.getShip_Money());
			} else {
				/*T 告诉玩家钱不够买不了 */}
			break;
		case 2:
			if (p.getMoney() >= s2.getShip_Money()) {
				p.setShip2_Num(p.getShip2_Num() + BuyShipNum);
				p.setMoney(p.getMoney()-s2.getShip_Money());
			} else {
				/*T 告诉玩家钱不够买不了 */}
			break;
		case 3:
			if (p.getMoney() >= s3.getShip_Money()) {
				p.setShip3_Num(p.getShip3_Num() + BuyShipNum);
				p.setMoney(p.getMoney()-s3.getShip_Money());} else {
				/*T 告诉玩家钱不够买不了 */}
			break;
		}
	}

}
