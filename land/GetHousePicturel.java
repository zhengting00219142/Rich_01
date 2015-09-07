package land;

import java.util.HashMap;
import java.util.Map;

public class GetHousePicturel {

	private static Map<Integer, String> picture;
	
	private static Map<Integer, String> bomb;
	
	private static  Map<Integer,String> fence;
	public static Map<Integer, String>  getPicture()
	
	{
		picture=new HashMap<Integer, String>();
		picture.put(-1,"picture/house_1.jpg" );
		picture.put(0,"picture/house.jpg" );
		picture.put(1,"picture/house1.jpg" );
		picture.put(2,"picture/house2.jpg" );
		picture.put(3,"picture/house3.jpg" );
		return picture;
		
	}
public static Map<Integer, String>  getBomb()
	
	{
		bomb=new HashMap<Integer, String>();
		bomb.put(-1,"picture/bomb_1.jpg" );
		bomb.put(0,"picture/bomb0.jpg" );
		bomb.put(1,"picture/bomb.jpg" );
		bomb.put(2,"picture/bomb1.jpg" );
		bomb.put(3,"picture/bomb2.jpg" );
		return bomb;
		
	}
public static Map<Integer, String>  getFence()

{
	fence=new HashMap<Integer, String>();
	fence.put(-1,"picture/fence_1.jpg" );
	fence.put(0,"picture/fence0.jpg" );
	fence.put(1,"picture/fence.jpg" );
	fence.put(2,"picture/fence1.jpg" );
	fence.put(3,"picture/fence2.jpg" );
	return fence;
	
}
	
	
	
	
	
	
}
