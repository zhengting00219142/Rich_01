package daoju;

public class PropFactory {

	public static Prop getProp(String propName){
		if("".equals(propName.trim())){
			return null;
		}
		else if(propName.contains("Õ¨µ¯")){
			return new Bomb();
		}
		else if(propName.contains("Â·ÕÏ")){
			return new Fence();
		}
		else if(propName.contains("»úÆ÷ÍÞÍÞ")){
			return new Robot();
		}
		else{
			return null;
		}
	}
}
