//package Game.Random3;
//������
import java.util.Random;
import java.util.Scanner;
//4.0��   ���� �� 
//	��ԭ�л����ϼ��Ϲ�����
//	���������С��Ϸ��
//��һ��1-100֮��������,��Һͻ�����һ���ϵͳ������������֣���˭�Ȳµ���

public class RandomGame4 {
	
	public static void main(String[] args) {
		//���ù����ַ�����������
		RandomGame4.RollSyso();
	}
	//�ķ����ǹ�������ַ���
	public static void RollSyso(){
		String s ="��ӭ������ ������������Ϸϵ��֮��������� ����          @author:�� ׷ ��";
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
				// TODO Auto-generated catch block
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
	static int rebortLen = 0;
	static int personLen = 0;//������Ҳµ����ֺ�Ŀ����֮��ľ���
	static int  cha = personLen - rebortLen;//���������˲µĸ�Զ��Ŀ����
	//ϵͳ�����������
	static int   random = (int)((Math.random() * 100)+1);
	//���������˰����ĳ�ʼֵ��
	static int jiqiNum  = (int)((Math.random() * 100 )+1);
	
	//����Random����
	static Random rn  =new Random();
	//����������
	static int count ;
	//������Ϸ���ӳ̶ȣ��������˵����̶ܳȣ���
	static int  diffculty = 3;
	
	//�ṩ���ѡ����Ϸ�Ѷȵķ���
	public static void switchDif(){
		System.out.println("��ѡ����Ϸ�Ѷȣ��������˰��������̶ܳȣ�����1����   ��2��һ��  ��3������");
		Scanner sc = new Scanner(System.in);
		try{
			int  dif = sc.nextInt();
			switch(dif){
				case  1 :
					diffculty =1;
					System.out.println("�����Ѿ�����ɵ��ģʽ��Сѧһ�꼶ˮƽ");
					break;
				case  2 :
					diffculty = 2;
					System.out.println("�����Ѿ�������ͨ��ģʽ������һ�꼶ˮƽ");
					break;
				case  3 :
					System.out.println("�����Ѿ���������Ů��ģʽ������һ�꼶ˮƽ");
					diffculty = 3;
					break;
				default :
					System.out.println("�����������ϵͳĬ��Ϊ���Ѷ�");
					break;
			}
		}catch(Exception e){
			
			System.out.println("����Ƿ�����������1��2��3�����롣 ");
			switchDif();
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
		
		//System.out.println("");
		count = 0;
		//����ѡ����Ϸ�Ѷȷ���
		switchDif();
		Scanner sc = new Scanner(System.in);
		while(true){
			
			count ++;
			
			System.out.println();
			System.out.println("********-��-��-��-��-��-��-��-��********");
			System.out.println();
			if(count == 6){
				System.out.println("ϵͳ��⵽��������Ƚ����ѣ������С��ʾ��Ҫ�µ����ָ�λ��֮����"+(random /10 + random % 10));
				
			}
			System.out.println("�����˰����£�		"+jiqiNum);
			System.out.print("������µ����֣�	");
			
			//�����û���������Ĵ�����Ϣ
			 try{
				 int  num = sc.nextInt();//��¼��Ҳµ�����,�Ȱ�������Ϣ�����ַ���������}
				 personLen = Math.abs(num - random);//��¼��Һ�Ŀ����֮��ľ���
				//System.out.println("wanjia��Ŀ����֮����룺"+personLen);
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
						System.out.println("�����˰������ۣ�$_$,������Ŷ ������һ�ΰɣ������� :��1�� ѡ���������ȥ��������������:�˳���Ϸ ");
						int  c  = sc.nextInt();
						//System.out.println("�����룺"+c);
						if(c == 1 ){
							//�����趨������
							//count=0;
							//�����趨Ŀ�����ֵ
							random = (int)((Math.random() * 100)+1);
							jiqiNum  = (int)((Math.random() * 100 )+1);
							guessNum();
						}else{
							System.out.println("�����˰������´μǵ������氡���������ź���PKŶ��");
							//System.out.println("������Ϸͳ�ƣ�����ܹ�����"+count+"�λ���ʤ������");
							//break;
							System.exit(0);
						 
						}
					}
					//�����˲�����
					if(rebortLen ==0){
						System.out.println("��ϲ�����˰����¶��ˣ�");
						System.out.println("������Ϸͳ�ƣ������ܹ�����"+count+"�λ���ʤ������");
						System.out.println("�������ߣ����Ǽ���ò���ǻ���һ��Ļ����ˣ�����Һ���������������һ���� ~~\n������ :��1��ѡ���������ȥ������������������:�˳���Ϸ ");
						int  c  = sc.nextInt();
						//System.out.println("�����룺"+c);
						if(c == 1 ){
							//�����趨countֵ
							//count = 0;
							//�����趨Ŀ�����ֵ
							random = (int)((Math.random() * 100)+1);
							//�����趨�����µ�����
							jiqiNum  = (int)((Math.random() * 100 )+1);
							guessNum();
						}else{
							System.out.println("�´μǵ������氡���������ź���PKŶ��");
							System.exit(0);
							//System.out.println("������Ϸͳ�ƣ�����ܹ�����"+count+"�λ���ʤ������");
							//break;
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
				 System.out.println("������������������¿�ʼ��ı��ݣ���");
				 guessNum();
			 }
		}
	}
}
	

