package com.civilization.control;

import java.applet.*;
import java.net.URL;

public class Music {

	public void musicPlayer_Begin(boolean IsBegin) {

		// 游戏开始界面的bgm：lost in the nowhere
		java.net.URL music_Begin = getClass().getResource("../lostInTheNowhere.wav");
		AudioClip sound = java.applet.Applet.newAudioClip(music_Begin);
		// sound.play();
		sound.loop();
		//切换界面时停止播放音乐
		while(IsBegin==false) {
			sound.stop();
		}

	}

	public void musicPlayer_Battle(boolean IsBattle) {

		// 游戏战斗界面的bgm：Parodia Sonatina Var.2
		java.net.URL music_Battle = getClass().getResource("../ParodiaSonatinaVar2.wav");

		AudioClip sound = java.applet.Applet.newAudioClip(music_Battle);
		// sound.play();
		sound.loop();
		// sound.stop();
		//切换界面时停止播放音乐
				while(IsBattle==false) {
					sound.stop();
				}

	}

	public void musicPlayer_Map(boolean IsMap) {

		// 游戏地图界面的bgm：NoEl
		java.net.URL music_Map = getClass().getResource("../NoEl.wav");

		AudioClip sound = java.applet.Applet.newAudioClip(music_Map);
		// sound.play();
		sound.loop();
		// sound.stop();
		//切换界面时停止播放音乐
				while(IsMap==false) {
					sound.stop();
				}

	}

	public void musicPlayer_Shop(boolean IsShop) {

		// 游戏商店界面的bgm：赎罪（arrange）
		java.net.URL music_Shop = getClass().getResource("../save.wav");

		AudioClip sound = java.applet.Applet.newAudioClip(music_Shop);
		// sound.play();
		sound.loop();
		// sound.stop();
		//切换界面时停止播放音乐
				while(IsShop==false) {
					sound.stop();
				}

	}

	public void musicMove() {
		// 音效尚未添加
		java.net.URL music_Move = getClass().getResource("/save.wav");

		AudioClip sound = java.applet.Applet.newAudioClip(music_Move);
		sound.play();
		// sound.loop();
		// sound.stop();
	}
	public void musicAttack() {
		// 音效尚未添加
		java.net.URL music_Attack = getClass().getResource("/save.wav");

		AudioClip sound = java.applet.Applet.newAudioClip(music_Attack);
		sound.play();
		// sound.loop();
		// sound.stop();
	}

}
