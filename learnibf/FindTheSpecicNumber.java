package learnibf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindTheSpecicNumber {
	public static  void   main(String [] args){
		
		///////////////////////////////////////////////
	  Scanner  scanner=new Scanner(System.in);
	  String inStr=scanner.nextLine();
	  String[] numbers=inStr.split(",");
	  if(check(inStr)||numbers.length!=3){
		  System.out.println(-1);
		  return ;
	  }
	  int a=0,b=0,c=0;
	  a=Integer.parseInt(numbers[0]);
	  b=Integer.parseInt(numbers[1]);
	  c=Integer.parseInt(numbers[2]);
	  if(a<=0||a>9||b<=0||b>9||c<=0||c>9){
		  System.out.println(-1);
		  return ;
	  }
	  if(a==b||a==c||b==c){
		  System.out.println(-1);
		  return;
	  }
	  Set<Integer> s=new HashSet();
	  s.add(a);
	  s.add(b);
	  s.add(c);
	  if(s.contains(2)&&s.contains(5)||
			  s.contains(6)&&s.contains(9)){
		  System.out.println(-1);
		  return;
	  }
	  int max=Math.max(a, Math.max(b, c));
	  ArrayList arrayList=new ArrayList();
	  addThreeNumbers(arrayList,a,b,c);
	  //对于2,5,6,9
	  if(a==2||a==5){
		  addThreeNumbers(arrayList, 7-a, b, c);
	  }
	  if(b==2||b==5){
		  addThreeNumbers(arrayList, a, 7-b, c);
	  }
	  if(c==2||c==5){
		  addThreeNumbers(arrayList, a, b, 7-c);
	  }
	  if(a==6||a==9){
		  addThreeNumbers(arrayList, 15-a,b, c);
	  }
	  if(b==6||b==9){
		  addThreeNumbers(arrayList, a,15-b, c);
	  }
	  if(c==6||c==9){
		  addThreeNumbers(arrayList, a,b, 15-c);
	  }
	  //考虑到 2与6、9 或者 5与6、9同时存在
	  if((s.contains(2)||s.contains(5))&&(s.contains(6)||s.contains(9))) {
		  int x=s.contains(2)?2:5;
		  int y=s.contains(9)?6:9;
		  int z=a+b+c-x-y;
		  addThreeNumbers(arrayList, 7-x,15-y, z);
	  }
			  remove(arrayList);
			  Collections.sort(arrayList);
			  System.out.println(arrayList.get(max-1));
	  
	}

	private static void remove(ArrayList<Integer> arrayList) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<Integer>();
		for(Integer x:arrayList){
			set.add(x);
		}
		arrayList.removeAll(arrayList);
		for(Integer x:set){
			arrayList.add(x);
		}
	}

	private static void addThreeNumbers(ArrayList arrayList, int a, int b, int c) {
		// TODO Auto-generated method stub
		arrayList.add(a);
		arrayList.add(b);
		arrayList.add(c);
		arrayList.add(a*10+b);
		arrayList.add(a*10+c);
		arrayList.add(b*10+a);
		arrayList.add(b*10+c);
		arrayList.add(c*10+a);
		arrayList.add(c*10+b);
		arrayList.add(a*100+b*10+c);
		arrayList.add(a*100+c*10+b);
		arrayList.add(b*100+a*10+c);
		arrayList.add(b*100+c*10+a);
		arrayList.add(c*100+a*10+b);
		arrayList.add(c*100+b*10+a);
	}

	private static boolean check(String inStr) {
		// TODO Auto-generated method stub
		for(int i=0;i<inStr.length();i++){
			char ch=inStr.charAt(i);
			if(!(Character.isDigit(ch))||ch==','){
				return false;
			}
		}
		return true;
	}

}
