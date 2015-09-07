package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bgm.Bgm;

public class BgmListener implements  ActionListener
{
	private static boolean flag=true;
	private   Bgm bgm;
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
		if(flag){
			bgm=new Bgm();
			bgm.start();
			flag=false;
		}
		else{
			bgm.getAudioClip().stop();
			flag=true;
		}
		
	}
	

}
