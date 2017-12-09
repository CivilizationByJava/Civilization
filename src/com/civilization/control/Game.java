package com.civilization.control;

import com.civilization.model.Player;

public class Game {
	//
	private Player player1 = new Player();
	private Player player2 = new Player();

	//
	private Player curPlayer = player1;

	private GetMoney getMoney = new GetMoney();

	// 胜负判断
	public String winOrLose(Player p1, Player p2) {

		if (p1.getIslandsCount_Big() + p1.getIslandsCount_Main() + p1.getIslandsCount_Small() == 0) {
			return p1.getPlayerID();
		}
		if (p2.getIslandsCount_Big() + p2.getIslandsCount_Main() + p2.getIslandsCount_Small() == 0) {
			return p2.getPlayerID();
		}
		return null;
	}

	// 切换游戏玩家
	public void switchPlayer() {
		getMoney.moneyGet(curPlayer);
		if (curPlayer == player1) {
			curPlayer = player2;
		} else {
			curPlayer = player1;
		}
		
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Player getCurPlayer() {
		return curPlayer;
	}
}