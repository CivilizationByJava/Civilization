package com.civilization.control;

import com.civilization.model.Island;

public class Battle {
	private int Atk_Army_Num;
	private int Def_Army_Num;

	public void Player_Atk_Army(Island I_atk,Island I_def,int Army_Num)//最后一个参数最大为5
	{
		//攻击方决定进攻地点并派出军队
		//根据Island类中判断距离的函数判断距离，只有距离最近的两个岛才能互相伤害，函数还没写
		if(I_atk.getPlayer_Army_Num()>=Army_Num)
		{Atk_Army_Num=Army_Num;}
		else {Atk_Army_Num=I_atk.getPlayer_Army_Num();}		
	}
	
	public void Player_Def_Army()
	{
		//防御方派出军队（自动五个，少于五个有几个派几个）
	}
	public void Attack()
	{
		//双方roll点决定攻击伤害值
		//按伤害从高到低依次排列
		//最高对最高，第二对第二，以此类推，数值小的一方GG
		//一轮攻击后战斗结束，GG的单位减少
	}
	public void BattleStart()
	{
		//Player_Atk_Army();
		//Player_Def_Army();
		//Attack();
		
	}
	public void setAtk_Army_Num(int atk_Army_Num) {
		Atk_Army_Num = atk_Army_Num;
	}
	public void setDef_Army_Num(int def_Army_Num) {
		Def_Army_Num = def_Army_Num;
	}
	
}
