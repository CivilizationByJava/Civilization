package com.civilization.control;

import com.civilization.model.Island;

public class Move {

	//如果岛上没有任何敌人，就可以移动到那然后直接占领
	public void shipMove(Island i1,Island i2,int army_Num)
	{
		//判断距离，最近的岛才能去
		//起点岛派军队到目的地
		if(army_Num<=i1.getPlayer_Army_Num())		
		{i1.setPlayer_Army_Num(i1.getPlayer_Army_Num()-army_Num);
		i2.setPlayer_Army_Num(army_Num);}else {
			i1.setPlayer_Army_Num(0);
			i2.setPlayer_Army_Num(i1.getPlayer_Army_Num());
		}
		//更换岛屿控制权
		i2.setHostOfIsland(i1.getHostOfIsland());
	}
}
