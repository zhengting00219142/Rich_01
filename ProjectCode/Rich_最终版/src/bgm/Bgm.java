package bgm;

import java.applet.AudioClip;

import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

public class Bgm extends Thread{	
	private  AudioClip aau;
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		try{
			URL cb;
			File f = new File("bgm/Bgm1.wav"); // 引号里面的是音乐文件所在的绝对路径
			cb = f.toURL();
			//AudioClip aau;
			aau = Applet.newAudioClip(cb);
//			aau.play();
			aau.loop();
			// 循环播放 aau.play() 单曲 aau.stop()停止播放
		} catch (MalformedURLException e)	{
			e.printStackTrace();
		}
	}
	public AudioClip getAudioClip(){
		return aau;
	}

}
