package com.civilization.control;

import com.civilization.model.Island;
import com.civilization.model.Ship_1;
import com.civilization.model.Ship_2;
import com.civilization.model.Ship_3;

import java.util.Random;

public class Battle {
	private int Atk_Army_Num = 0;
	private int Def_Army_Num = 0;
	Ship_1 s1 = new Ship_1();
	Ship_2 s2 = new Ship_2();
	Ship_3 s3 = new Ship_3();

	// 参数： 攻击方岛屿 防御方岛屿 派出军队数量
	public int Player_Atk_Army(Island I_atk, Island I_def)// 最后一个参数最大为5
	{
		// 攻击方决定进攻地点并派出军队
		// 根据Island类中判断距离的函数判断距离，只有距离最近的两个岛才能互相伤害，函数还没写
		if (islandBattle(I_atk.getIsland_Level(), I_def.getIsland_Level())) {
			if (I_atk.getPlayer_Army_Num() >= 5) {
				Atk_Army_Num = 5;
			} else {
				Atk_Army_Num = I_atk.getPlayer_Army_Num();
			}
			return I_atk.getPlayer_Army_Kind();
		}
		// 距离太远时返回0，不能发动进攻
		return 0;
	}

	// 参数： 防守方岛屿
	public int Player_Def_Army(Island I_def) {
		// 防御方派出军队（自动五个，少于五个有几个派几个）
		// 判断岛屿的主人是玩家还是中立敌对

		if (I_def.getPlayer_Army_Num() >= 5) {
			Def_Army_Num = 5;
		} else {
			Def_Army_Num = I_def.getPlayer_Army_Num();
		}

		return I_def.getPlayer_Army_Kind();
	}

	// 参数： 攻击方岛屿 防御方岛屿 攻击方兵种 防御方兵种
	public void Attack(Island I_atk, Island I_def, int atk_Kind, int def_Kind) {

		// 双方roll点决定攻击伤害值
		Random random = new Random();
		int atk_atkMax = 0;
		int atk_atkMin = 0;
		int def_atkMax = 0;
		int def_atkMin = 0;
		switch (atk_Kind) {
		case 1:
			atk_atkMax = s1.getShip_Atk_max();
			atk_atkMin = s1.getShip_Atk_min();
			break;
		case 2:
			atk_atkMax = s2.getShip_Atk_max();
			atk_atkMin = s2.getShip_Atk_min();
			break;
		case 3:
			atk_atkMax = s3.getShip_Atk_max();
			atk_atkMin = s3.getShip_Atk_min();
			break;
		}
		switch (def_Kind) {
		case 1:
			def_atkMax = s1.getShip_Atk_max();
			def_atkMin = s1.getShip_Atk_min();
			break;
		case 2:
			def_atkMax = s2.getShip_Atk_max();
			def_atkMin = s2.getShip_Atk_min();
			break;
		case 3:
			def_atkMax = s3.getShip_Atk_max();
			def_atkMin = s3.getShip_Atk_min();
			break;
		}
		int[] atk_Dam = { 0, 0, 0, 0, 0 };
		int[] def_Dam = { 0, 0, 0, 0, 0 };
		System.out.println(Atk_Army_Num);
		for (int i = 0; i < Atk_Army_Num; i++) {
			atk_Dam[i] = random.nextInt(atk_atkMax) % (atk_atkMax - atk_atkMin + 1) + atk_atkMin;

		}
		for (int i = 0; i < Def_Army_Num; i++) {
			def_Dam[i] = random.nextInt(def_atkMax) % (def_atkMax - def_atkMin + 1) + def_atkMin;
		}

		// T 按伤害从高到低依次排列,假装已经排完序了
		// 最高对最高，第二对第二，以此类推，数值小的一方GG
		int atk_GG_Num = 0;
		int def_GG_Num = 0;
		for (int i = 0; i <= Player_Atk_Army(I_atk, I_def) && i <= Player_Def_Army(I_def); i++) {
			if (atk_Dam[i] > def_Dam[i]) {
				def_GG_Num++;
			}
			if (atk_Dam[i] > def_Dam[i]) {
				atk_GG_Num++;
			}
		}
		// 一轮攻击后战斗结束，GG的单位减少
		I_atk.setPlayer_Army_Num(I_atk.getPlayer_Army_Num() - atk_GG_Num);

		I_def.setPlayer_Army_Num(I_def.getPlayer_Army_Num() - def_GG_Num);
	}

	// 参数： 攻击方岛屿 防御方岛屿 攻击方兵种 防御方兵种 派出军队数量 这个函数是上面三个的整合，所以参数也比较多
	public void BattleStart(Island I_atk, Island I_def, int atk_Kind, int def_Kind, int Army_Num) {
		Player_Atk_Army(I_atk, I_def);
		Player_Def_Army(I_def);
		Attack(I_atk, I_def, atk_Kind, def_Kind);

	}

	public void setAtk_Army_Num(int atk_Army_Num) {
		Atk_Army_Num = atk_Army_Num;
	}

	public void setDef_Army_Num(int def_Army_Num) {
		Def_Army_Num = def_Army_Num;
	}

	public boolean islandBattle(int islandLevel_1, int islandLevel_2) {
		if (islandLevel_1 - islandLevel_2 <= 1 || islandLevel_2 - islandLevel_1 <= 1) {
			return true;
		}
		return false;
	}

}
