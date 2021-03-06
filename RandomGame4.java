//package Game.Random3;
//第三版
import java.util.Random;
import java.util.Scanner;
//4.0版   介绍 ： 
//	在原有基础上加上滚动条
//	猜随机数的小游戏：
//猜一个1-100之间的随机数,玩家和机器人一起猜系统给出的随机数字，看谁先猜到。

public class RandomGame4 {
	
	public static void main(String[] args) {
		//调用滚动字符串方法方法
		RandomGame4.RollSyso();
	}
	//改方法是滚动输出字符串
	public static void RollSyso(){
		String s ="欢迎来到《 安安陪你玩游戏系列之另类猜数字 》！          @author:不 追 马";
		char[] c = s.toCharArray();
		int count = 0;
		int end = c.length- 1;
		int start ;
			while(true){
				//String temp = "";
				count++;
		 		start  = c.length - count;
		 		if(start >=0){
		 			for(int i = start;i<=end;i++){
		 				System.out.print(c[i]);
		 			}
		 		}else{
		 			
		 			for(int i = 0;i<=count -c.length ;i++){
		 			System.out.print(" ");
		 		}
		 			for(int i = 0;i<=end;i++){
		 				System.out.print(c[i]);
		 			}
		 		}
		 		
				System.out.print("\r");
				
				if(count >= 50){
					System.out.println();
					RandomGame4.SysoString();
					
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
	}
	//该方法是一个字一个字的输出字符串
	public static void SysoString(){
		String s1  ="》》》》》》》》》》》》》》》》》》》正>>在>>加>>载>>游>>戏>>请>>稍>>候》》》》》》》》》》》》》》》》》》》\n";
		String  s2 = "\t这是一款老少皆宜，休闲益智的游戏，只有手气和实力兼备才能更快猜出数字！规则介绍：\n";
		String  s3 = "\t系统会产生一个0到99之间的随机数，你会和内置的机器人安安一起PK，\n\t系统只会提示谁猜的数字更接近目标值，看谁能先猜到随机数。\n";
		String s4 = "\t根据猜中随机数的次数获得如下称号：\n";
		String s5 = "\t\t2次以内:\t最强王者，sao气冲天\n";
		String s6 = "\t\t3次-5次:\t超凡大师，sao气凌人\n";
		String s7 = "\t\t6次-8次:\t璀璨钻石，sao气外漏\n";
		String s8 = "\t\t9次-11次:\t闪耀黄金，sao气内敛\n";
		String s9 = "\t\t12次以上:\t励志青铜，单纯似水\n";
		String s10 = "\n";
		
		String  s =s1+s2+s3+s4+s5+s6+s7+s8+s9;
		char[] c = s.toCharArray();
		int count = 0;
		while(count <c.length){
			
			System.out.print(c[count]);
			count++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println();
		Guess.guessNum();
	}

}

//该类封装了玩猜数字游戏的所有规则。
class Guess{
	
	//定义机器人与目标数之间距离
	static int rebortLen = 0;
	static int personLen = 0;//定义玩家猜的数字和目标数之间的距离
	static int  cha = personLen - rebortLen;//正数代表人猜的更远离目标数
	//系统产生的随机数
	static int   random = (int)((Math.random() * 100)+1);
	//产生机器人安安的初始值。
	static int jiqiNum  = (int)((Math.random() * 100 )+1);
	
	//创建Random对象，
	static Random rn  =new Random();
	//创建计数器
	static int count ;
	//定义游戏复杂程度（即机器人的智能程度）；
	static int  diffculty = 3;
	
	//提供玩家选择游戏难度的方法
	public static void switchDif(){
		System.out.println("请选择游戏难度（即机器人安安的智能程度）：【1】简单   【2】一般  【3】困难");
		Scanner sc = new Scanner(System.in);
		try{
			int  dif = sc.nextInt();
			switch(dif){
				case  1 :
					diffculty =1;
					System.out.println("安安已经开启傻瓜模式，小学一年级水平");
					break;
				case  2 :
					diffculty = 2;
					System.out.println("安安已经开启普通人模式。初中一年级水平");
					break;
				case  3 :
					System.out.println("安安已经开启幸运女神模式。高中一年级水平");
					diffculty = 3;
					break;
				default :
					System.out.println("你的输入有误，系统默认为简单难度");
					break;
			}
		}catch(Exception e){
			
			System.out.println("输入非法！请在数字1，2，3中输入。 ");
			switchDif();
		}
		
	}
	 
	//该方法是动态改变机器人猜的数字
	public static void  getJiqiNum(int jiqiNum1 ,int random1 ){
		

		//设置游戏难度规则：
		if(rebortLen < diffculty * 2){
			jiqiNum = random;

		}else{
			
			if(jiqiNum1 > random1){			
				jiqiNum = jiqiNum1 - (rn.nextInt(rebortLen)+1) - rn.nextInt(15 * diffculty);
			 //System.out.println(jiqiNum1);
			}else if(jiqiNum1 < random1){
				jiqiNum = jiqiNum1 + (rn.nextInt(rebortLen)+1) + rn.nextInt(15 * diffculty);
				//System.out.println(jiqiNum1);
			}
		}

		
		//让机器人猜的数字不能超多1- 100之间。
		if(jiqiNum >= 100 ){
			 jiqiNum = 99-(int)(Math.random()* 10);
		}else if( jiqiNum <0 ){
			 jiqiNum = (int)(Math.random()* 10);
		}
	}
	
	//开始猜数字游戏
	public  static void guessNum(){
		
		//System.out.println("");
		count = 0;
		//调用选择游戏难度方法
		switchDif();
		Scanner sc = new Scanner(System.in);
		while(true){
			
			count ++;
			
			System.out.println();
			System.out.println("********-我-是-华-丽-的-分-割-线********");
			System.out.println();
			if(count == 6){
				System.out.println("系统检测到你猜起来比较困难，给你点小提示：要猜的数字各位数之和是"+(random /10 + random % 10));
				
			}
			System.out.println("机器人安安猜：		"+jiqiNum);
			System.out.print("输入你猜的数字：	");
			
			//捕获用户可能输入的错误信息
			 try{
				 int  num = sc.nextInt();//记录玩家猜的数字,先把输入信息当成字符串来处理}
				 personLen = Math.abs(num - random);//记录玩家和目标数之间的距离
				//System.out.println("wanjia和目标数之间距离："+personLen);
					rebortLen = Math.abs(jiqiNum - random);//记录机器人和目标数之间的距离
					//System.out.println("机器人和目标数之间距离"+rebortLen);
					cha = personLen - rebortLen;
					//玩家猜中了
					if(personLen == 0){
						System.out.println("恭喜你猜对了！");
						System.out.println("本次游戏统计：玩家总共猜了"+count+"次机会胜出！！");
						//判定玩家什么段位
						if(count<=2){
							System.out.println("已获得最强王者称号,骚气冲天！");
						}else if(count <= 5){
							System.out.println("已获得超凡大师称号，骚气凌人！");
						}else if(count <= 8 ){
							System.out.println("已获得璀璨钻石称号，骚气外漏！");
						}else if(count <= 11){
							System.out.println("已获得闪耀黄金称号，骚气内敛！");
						}else{
							System.out.println("已获得青铜渣渣称号，单纯似水！");
						}
						//玩家决定是否要玩下去
						System.out.println("机器人安安：哇，$_$,好厉害哦 ！再玩一次吧！请输入 :【1】 选择继续玩下去，其他任意数字:退出游戏 ");
						int  c  = sc.nextInt();
						//System.out.println("你输入："+c);
						if(c == 1 ){
							//重新设定计数器
							//count=0;
							//重新设定目标随机值
							random = (int)((Math.random() * 100)+1);
							jiqiNum  = (int)((Math.random() * 100 )+1);
							guessNum();
						}else{
							System.out.println("机器人安安：下次记得再来玩啊！安安等着和你PK哦！");
							//System.out.println("本次游戏统计：玩家总共猜了"+count+"次机会胜出！！");
							//break;
							System.exit(0);
						 
						}
					}
					//机器人猜中了
					if(rebortLen ==0){
						System.out.println("恭喜机器人安安猜对了！");
						System.out.println("本次游戏统计：安安总共猜了"+count+"次机会胜出！！");
						System.out.println("安安：哼！我是集美貌与智慧于一身的机器人！输给我很正常，大不了再来一局嘛 ~~\n请输入 :【1】选择继续玩下去，输入其他任意数字:退出游戏 ");
						int  c  = sc.nextInt();
						//System.out.println("你输入："+c);
						if(c == 1 ){
							//重新设定count值
							//count = 0;
							//重新设定目标随机值
							random = (int)((Math.random() * 100)+1);
							//从新设定安安猜的数字
							jiqiNum  = (int)((Math.random() * 100 )+1);
							guessNum();
						}else{
							System.out.println("下次记得再来玩啊！安安等着和你PK哦！");
							System.exit(0);
							//System.out.println("本次游戏统计：玩家总共猜了"+count+"次机会胜出！！");
							//break;
						}
					}
					//都没猜对，看谁的数字更加接近。
					if(cha > 0){
							System.out.println("安安猜得更近！");
					} else if(cha < 0 ){
							System.out.println("你猜得更近！就差一点了！");
					}else{
						System.out.println("你和安安猜的一样近！棒棒哒~~");
					}	
					//调用方法将静态的机器人猜的值改变。
					getJiqiNum(jiqiNum, random);
			 }
			 catch(Exception e){
				 System.out.println("你输入的数据有误，重新开始你的表演！！");
				 guessNum();
			 }
		}
	}
}
	

