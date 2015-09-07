package listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import land.GetHousePicturel;
import land.House;
import random.Dice;
import user.CurrentPlayer;
import user.Player;
import user.SetPlayers;
import windows.DaojuHouse;
import windows.PlayGame;
import windows.Victory;

public class DiceListener implements ActionListener{
	private PlayGame game;
	private JLabel dice;
	private int point;//骰子的点数
	private CurrentPlayer currentPlayer;
	private House toHouse;//到达的房子
	private Player current;//当前玩家
	public DiceListener(JLabel dice,PlayGame game){
		this.dice=dice;
		this.game=game;
		currentPlayer=new CurrentPlayer(game.getPlayers());
		current=currentPlayer.getCurrentPlayer();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(game.getReminder().getLineCount()>=6){
			game.getReminder().setText("");
		}
		
		point =Dice.getNum(dice);
		
		//擦除旧位置的名字
		game.getHost().get(current.getPosition()).setText(new StringBuffer(game.getHost().get(current.getPosition()).getText()).delete(0, 1).toString());
		//当前位置
		
		System.out.println(current.getPosition()+"---------");
		int location=current.getPosition()+point;
		System.out.println(location+"+++====");
		if(location>37){
			boolean flag=false;
			for(int i=current.getPosition()+1;i<=37;i++){//37之前路段
				if(flag){
					break;
				}
				House nextHouse=game.getMapHouses().get(i);
				if(nextHouse.isFence()){//前面的路上有路障
					location=i;
					current.setPosition(location);//设置玩家投掷骰子后的位置
					nextHouse.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(nextHouse.getLever())));
					nextHouse.setFence(false);
					game.getReminder().append(current.getName()+"踩到了路障\r\n");
					flag=true;//找到了路障
					
				}
				
			}
			if(!flag){
				location-=38;
				for(int i=0;i<=location;i++){//0和后面的路段
					if(flag){
						break;
					}
					House nextHouse=game.getMapHouses().get(i);
					if(nextHouse.isFence()){//前面的路上有路障
						location=i;//设置新location
						current.setPosition(location);//设置玩家投掷骰子后的位置
						nextHouse.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(nextHouse.getLever())));
						nextHouse.setFence(false);
						game.getReminder().append(current.getName()+"踩到了路障\r\n");
						flag=true;//找到了路障
						break;
					}
				}
			}
		}
		else{
			boolean flag=false;
			for(int i=current.getPosition()+1;i<=location;i++){//0和后面的路段
				if(flag){
					break;
				}
				House nextHouse=game.getMapHouses().get(i);
				if(nextHouse.isFence()){//前面的路上有路障
					location=i;//设置新location
					current.setPosition(location);//设置玩家投掷骰子后的位置
					nextHouse.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(nextHouse.getLever())));
					nextHouse.setFence(false);
					game.getReminder().append(current.getName()+"踩到了路障\r\n");
					flag=true;//找到了路障
					break;
				}
			}
			
			
		}
		
		
		//判断当前位置房子的类型
		House current_house=game.getMapHouses().get(location);
		current.setPosition(location);
		//是监狱
		if(current_house.isPrison())
		{
			current.setStayRound(3);
			current.setToPrison(true);//关进监狱
			game.getReminder().append(current.getName()+"在监狱停留三天\r\n");
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
			
			
		}
		//设置有炸弹道具
		else if(current_house.isBomb())
		{
			current.setStayRound(2);
			current.setPosition(29);
			current.setToHospotal(true);//住进医院
			current_house.setBomb(false);
			game.getReminder().append(current.getName()+"踩到炸弹，住院2天\r\n");
			current_house.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(current_house.getLever())));//改变图片
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		}
		//是道具屋
		else if (current_house.isDaoju()) {
			new DaojuHouse(current,game);
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		}
		//是能提供点券的矿地
		else if(current_house.isTicket())
		{
			current.setTicket(current_house.getTicket()+current.getTicket());
			game.getReminder().append(current.getName()+"获得了"+current_house.getTicket()+"点劵\r\n");
			game.flushPlayeInfo(current);
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		}
		else if(current_house.isHospital()){//医院
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		}
		else if(current_house.isStart()){//	起点			
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		}
		//普通房屋，
		else{
			game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
			if(current_house.getBelongTo()==null){//空地				
			int select=JOptionPane.showConfirmDialog(null, "是否花费"+current_house.getPrice()+"购买房子", "房地产", JOptionPane.YES_NO_OPTION);
				//0:是，1:否
			if(select==0){//购买此地
				if(current.getMoney()<current_house.getPrice()){//资金不够
					String[] options={"确定"};
					JOptionPane.showOptionDialog(null, "你的资金不足!", "Warning", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[0]);
				}
				else{//购买成功 0级
					current.setMoney(current.getMoney()-current_house.getPrice());//付款
					current.getMyHouses().add(current_house);
					current_house.setLever(current_house.getLever()+1);
					current_house.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(current_house.getLever())));//设置地的级数图片
					
					current_house.setBelongTo(current);
					game.getHost().get(current_house.getPosition()).setBackground(SetPlayers.getColor().get(current.getName()));
					game.flushPlayeInfo(current);
					game.getReminder().append(current.getName()+"成功购买一块空地，花费"+current_house.getPrice()+"\r\n");
				}
			}
			}
			else{//地盘有所属人
				if(current_house.getBelongTo().equals(current)){//属于自己的地盘
					if(current_house.getLever()<3)//房子最大级别为3
					{
						int select=JOptionPane.showConfirmDialog(null, "是否花费"+current_house.getPrice()+"升级房子", "房地产", JOptionPane.YES_NO_OPTION);
						if(select==0){//升级此地
							if(current.getMoney()<current_house.getPrice()){//资金不够
								String[] options={"确定"};
								JOptionPane.showOptionDialog(null, "你的资金不足!", "Warning", 
										JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
										null, options, options[0]);
							}
							else{//升级成功 
								current.setMoney(current.getMoney()-(current_house.getPrice()));//付款
								current_house.setLever(current_house.getLever()+1);//升级
								current_house.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(current_house.getLever())));//设置地的级数图片
								game.getHost().get(current_house.getPosition()).setBackground(SetPlayers.getColor().get(current.getName()));
								game.flushPlayeInfo(current);//刷新财富榜
								game.getReminder().append(current.getName()+"成功升级房子，花费"+current_house.getPrice()+"\r\n");//公告
							}
						}
					}
					else{
						game.getReminder().append(current.getName()+"的房子已达顶级!!!不可以在升级\r\n");
					}
				}
				else{//踩在别人的地盘上
					if(current_house.getBelongTo().getStayRound()==0)//如果地主人没被关进监狱或者住进医院
					{
					int pay=(current_house.getLever()+1)*current_house.getPrice()/2;
					if(current.getMoney()<pay)//付钱给别人但不够，退出游戏
					{
						String[] options={"确定"};
						JOptionPane.showOptionDialog(null, "很遗憾，"+current.getName()+"玩家资金不足!退出游戏", "Warning", 
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
								null, options, options[0]);
						for(House house:current.getMyHouses())
						{
							//把当前该玩家的所有房产设置成不属于任何玩家的空地状态
							house.setLever(-1);
							house.setBelongTo(null);
							house.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(house.getLever())));
							game.getHost().get(house.getPosition()).setBackground(Color.WHITE);//所属者颜色为白色
							
						}
						StringBuffer sb=new StringBuffer(game.getHost().get(current.getPosition()).getText());
						game.getHost().get(current.getPosition()).setText(sb.delete(sb.length()-1, sb.length()).toString());
						game.deletePlayer(current);
						int which=currentPlayer.getPlayerLocation();
						game.getPlayers().remove(current);
						//game.getPlayerMoney().remove(which);
						//game.getPlayerTicket().remove(which);
						System.out.println(game.getPlayers().size()+"haahhahh");
						currentPlayer=new CurrentPlayer(game.getPlayers());//重新设置当前玩家人数
						currentPlayer.setWhich(which-1);
				
					//	current=currentPlayer.getCurrentPlayer();
						if(game.getPlayers().size()<2)
						{
							new Victory(game.getPlayers().get(0),game);
						
						}
						
						
						
					}
					else//付钱给别人钱够，就付款
					{
					current.setMoney(current.getMoney()-pay);//付款给对方
					current_house.getBelongTo().setMoney(current_house.getBelongTo().getMoney()+pay);//收钱
					game.getReminder().append(current.getName()+"向"+current_house.getBelongTo().getName()+"支付过路费"+pay+"\r\n");//通知
					game.flushPlayeInfo(current);//刷新显示栏
					System.out.println(current.getName()+"付款人");
					game.flushPlayeInfo(current_house.getBelongTo());
					System.out.println(current_house.getBelongTo().getName()+"收款人");
					}
					}
					else{//地主人住进监狱或者医院
						game.getReminder().append(current.getName()+"真幸运,房子主人不在家,免除过路费\r\n");
					}
							
				}
				
			}
			
			
			
			
			
		}		
		current=currentPlayer.getCurrentPlayer();//当前玩家
		while(true){
		if(current.getStayRound()>0){
			ok:
			if(current.isToHospotal()){
				
				current.setStayRound(current.getStayRound()-1);
				
				if(current.getStayRound()==0){
					current.setToHospotal(false);
					game.getReminder().append("玩家"+current.getName()+"出院了\r\n");
					break ok;
				}
				game.getReminder().append("玩家"+current.getName()+"因炸伤住院还剩"+current.getStayRound()+"回合\r\n");
				
			}
		out:
		if(current.isToPrison()){
			
			current.setStayRound(current.getStayRound()-1);
			
			if(current.getStayRound()==0){
				current.setToPrison(false);
				game.getReminder().append("玩家"+current.getName()+"出狱了\r\n");
				break out;
			}
			game.getReminder().append("玩家"+current.getName()+"被关进监狱,剩余释放回合："+current.getStayRound()+"天\r\n");
			
		}
			current=currentPlayer.getCurrentPlayer();//玩家停留，下一个玩家
			
		}
		
			
			
			if(current.getStayRound()==0)
				break;
			
		}
		game.getRound().setText("当前回合："+current.getName());
		game.getUseProp().setText("("+SetPlayers.getNames().get(current.getName())+")道具");
		System.out.println("which"+CurrentPlayer.getPlayerLocation());
		}
		
	}
	


