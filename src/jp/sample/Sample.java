package jp.sample;
import java.util.Random;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello, World!");
		int age = 20;
		System.out.println(age);
		String name = "たろう";
		System.out.println(name);
		System.out.println(4*6);
		
		boolean isHappy = false;
		
		System.out.println(isHappy);
		
		char grade = 'A';
		
		System.out.println(grade);
		
		float number = 6.28f;
		System.out.println(number);
		
		long num = 123456789012345L;
		System.out.println(num);
		
		String enjoy = "プログラミングは楽しい!";
		System.out.println(enjoy);
		
		int a = 5; int b = 2;
		int result = a / b;
		System.out.println(result);
		
		int x = 10;
		x += 5;
		System.out.println(x);
		
		int xa = 7;
		int y = 3;
		int resulta = xa % y;
		System.out.println(resulta);
		
		int aa = 3 + 4 * 2;
		System.out.println(aa);
		
		double d = 5.8;
		int i =(int) d;
		System.out.println(i);
		
		
	
		System.out.println(3+4*2);
		
		int ab =10;
		System.out.println(ab+1);
		
		System.out.println("Hello"+5);
		
		System.out.print("Java");
		System.out.println("学習");
		
		System.out.println((int) 7.9);
		
		int intResult =8/3;
		double doubleResult = 8/3.0;

		if ((double) intResult == doubleResult) {
			System.out.println("結果は同じ");
		} else {
			System.out.println("結果は違う");
		}
		
		int ac = 3;
		int bc = 5;
		System.out.println(Math.max(ac + 2,bc - 1));
		
		System.out.println("\"Java\"の勉強");

		int wt = 70;
		if (wt >= 30) {
			System.out.println("大きいね！");
		}
		
		for (int count = 1; count <=10; count++)
		{
			if (count % 2 ==0) {
				System.out.println(count);
			}
		}
		
		Scanner scanner = new Scanner(System.in);
        // 入力処理を行う
       
        Random random = new Random();
		
		String janken = scanner.next();
		 scanner.close();
		
		int cpuHandnum = random.nextInt(3);
		String cpuHand = "";
		
		if (cpuHandnum == 0) {
			cpuHand = "グー";
		} else if (cpuHandnum == 1) {
			cpuHand = "チョキ";
		} else {
			cpuHand = "パー";
		}
		
		System.out.println("あなた:" + janken + "あいて:" + cpuHand);
		
		if (janken.equals(cpuHand)) {
			System.out.println("あいこ");
		} else if (
				(janken.equals("グー") && cpuHand.equals("チョキ"))||
				(janken.equals("パー") && cpuHand.equals("グー"))||
				(janken.equals("グー") && cpuHand.equals("チョキ"))
				){
			System.out.println("勝ち");
		} else {
			System.out.println("負け");
		}
	
						
		

		greet();
		showTriangle(5);
		 System.out.println(calcAverage(1,4,10));
		
	
		
		
	}
	public static void greet() {
	    System.out.println("こんにちは！Javaプログラミングの世界へようこそ!");
	}
	public static void showTriangle(int size) {
		for (int i = 1; i <=size; i++) {
			for(int j = 1; j<= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static double calcAverage(int a, int b, int c) {
	    return (a + b + c) / 3.0;
	}


}
