package com.civilization.control;

//主控制器，用于控制其他的控制器
public class MainController {

	BackgroundController backgroundController;

	//初始化游戏
	public void initGame() {
		backgroundController=new BackgroundController();
		backgroundController.initBackGroundControler();
	}
	
}
