package randomgme5;

//import java.util.Random;
import java.util.Random;
import java.util.Scanner;
//5.0��   ���� �� 
//	 ��ԭ�л������Ż����룬���ٴ��룬ɾ������Ҫ���쳣�����ڼ���¼������ʱ�򻯴����Լ��������Ż���
//	���������С��Ϸ��
//��һ��1-100֮��������,��Һͻ�����һ���ϵͳ������������֣���˭�Ȳµ���

public class RandomGame5{
	
	public static void main(String[] args) {
		//���ù����ַ�������
		 RollSyso();
	}
	//��������ַ���
	public static void RollSyso(){
		String s ="��ӭ������ ������������� ����          @author:�� ׷ ��";
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
				
				if(count >= 55){
					System.out.println();
					 SysoString();
					
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
	//�÷�����һ����һ���ֵ�����ַ���
	public static void SysoString(){
		String s1  ="����������������������������������������>>��>>��>>��>>��>>Ϸ>>��>>��>>�򡷡�����������������������������������\n";
		String  s2 = "\t����һ�����ٽ��ˣ��������ǵ���Ϸ��ֻ��������ʵ���汸���ܸ���³����֣�������ܣ�\n";
		String  s3 = "\tϵͳ�����һ��0��99֮�����������������õĻ����˰���һ��PK��\n\tϵͳֻ����ʾ˭�µ����ָ��ӽ�Ŀ��ֵ����˭���Ȳµ��������\n";
		String s4 = "\t���ݲ���������Ĵ���������³ƺţ�\n";
		String s5 = "\t\t2������:\t��ǿ���ߣ�sao������\n";
		String s6 = "\t\t3��-5��:\t������ʦ��sao������\n";
		String s7 = "\t\t6��-8��:\t����ʯ��sao����©\n";
		String s8 = "\t\t9��-11��:\t��ҫ�ƽ�sao������\n";
		String s9 = "\t\t12������:\t��־��ͭ��������ˮ\n";
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
				 
				e.printStackTrace();
			}
			
		}
		System.out.println();
		Guess.guessNum();
	}

}

//�����װ�����������Ϸ�����й���
class Guess{
	
	//�����������Ŀ����֮�����
	static int rebortLen  ;
	static int personLen  ;//������Ҳµ����ֺ�Ŀ����֮��ľ���
	static int  cha = personLen - rebortLen;//���������˲µĸ�Զ��Ŀ����
	//ϵͳ�����������
	static int   random  ;
	//���������˰����ĳ�ʼֵ��
	static int jiqiNum   ;
	
	//����Random����
	static Random rn  =new Random();
	//����������
	static int count ;
	//������Ϸ���ӳ̶ȣ��������˵����̶ܳȣ���
	static int  diffculty = 1;
	
	//�ṩ���ѡ����Ϸ�Ѷȵķ���
	public static void switchDif(){
		outer: while(true){
			System.out.println("��ѡ����Ϸ�Ѷȣ��������˰��������̶ܳȣ�����1����   ��2��һ��  ��3������");
			Scanner sc = new Scanner(System.in);
				String  dif = sc.next();
				switch(dif){
					case  "1" :
						diffculty =1;
						System.out.println("�����Ѿ�����ɵ��ģʽ��Сѧһ�꼶ˮƽ");
						break outer;
					case  "2" :
						diffculty = 2;
						System.out.println("�����Ѿ�������ͨ��ģʽ������һ�꼶ˮƽ");
						break outer;
					case  "3" :
						System.out.println("�����Ѿ���������Ů��ģʽ������һ�꼶ˮƽ");
						diffculty = 3;
						break outer;
					default :
						System.out.println("�����������ϵͳĬ��Ϊ���Ѷ�");
						break outer;
				}
			 
		}
		
		
	}
	 
	//�÷����Ƕ�̬�ı�����˲µ�����
	public static void  getJiqiNum(int jiqiNum1 ,int random1 ){
		

		//������Ϸ�Ѷȹ���
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

		
		//�û����˲µ����ֲ��ܳ���1- 100֮�䡣
		if(jiqiNum >= 100 ){
			 jiqiNum = 99-(int)(Math.random()* 10);
		}else if( jiqiNum <0 ){
			 jiqiNum = (int)(Math.random()* 10);
		}
	}
	
	//��ʼ��������Ϸ
	public  static void guessNum(){
		//��ʼ���������
		random = (int)((Math.random() * 100)+1);//��ʼ�������
		jiqiNum  = 50;//��ʼ�������˲µ�����
		count = 0;
		switchDif();//����ѡ����Ϸ�Ѷȷ���
		Scanner sc = new Scanner(System.in);
		while(true){
			
			count ++;
			System.out.println("\r\n********-��-��-��-��-��-��-��-��********\r\n");
			if(count == 6){
				System.out.println("ϵͳ��⵽��������Ƚ����ѣ������С��ʾ��Ҫ�µ����ָ�λ��֮����"+(random /10 + random % 10));
				
			}
			System.out.println("�����˰����£�		"+jiqiNum);
			System.out.print("������µ����֣�	");
			int num;//����һ��������¼��Ҳµ�����
			//�����û���������Ĵ�����Ϣ
			 try{
				 String  numStr = sc.next();//��¼��Ҳµ�����,�Ȱ�������Ϣ�����ַ���������}
				  num= Integer.parseInt(numStr);//��¼������ת����int����
				 personLen = Math.abs(num - random);//��¼��Һ�Ŀ����֮��ľ���
					rebortLen = Math.abs(jiqiNum - random);//��¼�����˺�Ŀ����֮��ľ���
					//System.out.println("�����˺�Ŀ����֮�����"+rebortLen);
					cha = personLen - rebortLen;
					//��Ҳ�����
					if(personLen == 0){
						System.out.println("��ϲ��¶��ˣ�");
						System.out.println("������Ϸͳ�ƣ�����ܹ�����"+count+"�λ���ʤ������");
						//�ж����ʲô��λ
						if(count<=2){
							System.out.println("�ѻ����ǿ���߳ƺ�,ɧ�����죡");
						}else if(count <= 5){
							System.out.println("�ѻ�ó�����ʦ�ƺţ�ɧ�����ˣ�");
						}else if(count <= 8 ){
							System.out.println("�ѻ������ʯ�ƺţ�ɧ����©��");
						}else if(count <= 11){
							System.out.println("�ѻ����ҫ�ƽ�ƺţ�ɧ��������");
						}else{
							System.out.println("�ѻ����ͭ�����ƺţ�������ˮ��");
						}
						//��Ҿ����Ƿ�Ҫ����ȥ
						System.out.println("������������Ŷ ������һ�ΰɣ������� :��1�� ѡ���������ȥ���������ⰴ��:�˳���Ϸ ");
						String  c  = sc.next();
						 
						if(c.equals("1") ){
							guessNum();
						}else{
							System.out.println("��������ѡ���˽�����Ϸ��");
							System.exit(0);
						}
					}
					//�����˲�����
					if(rebortLen ==0){
						System.out.println("��ϲ�����˰����¶��ˣ�");
						System.out.println("������Ϸͳ�ƣ������ܹ�����"+count+"�λ���ʤ������");
						System.out.println("������������ :��1��ѡ���������ȥ���������ⰴ��:�˳���Ϸ ");
						String  c  = sc.next();
						//System.out.println("�����룺"+c);
						if(c.equals("1") ){
							guessNum();
						}else{
							System.out.println("��������ѡ���˽�����Ϸ��");
							System.exit(0);
							 
						}
					}
					//��û�¶ԣ���˭�����ָ��ӽӽ���
					if(cha > 0){
							System.out.println("�����µø�����");
					} else if(cha < 0 ){
							System.out.println("��µø������Ͳ�һ���ˣ�");
					}else{
						System.out.println("��Ͱ����µ�һ������������~~");
					}	
					//���÷�������̬�Ļ����˲µ�ֵ�ı䡣
					getJiqiNum(jiqiNum, random);
			 }
			 catch(Exception e){
				 System.out.println("�㱾���������������ϵͳĬ��Ϊ������50");
				  num= 50;
				//���÷�������̬�Ļ����˲µ�ֵ�ı䡣
				getJiqiNum(jiqiNum, random);
			 }
		}
	}
}
	

