package learnibf;

import java.util.Scanner;

public class MakeRevernseString {
	/**
	 * 给定一个字符串s，你可以从中删除一些字符，
	 * 使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
                 输出需要删除的字符个数。
         abcda  aca   toobt---toot
         adcba
         google  goog 
         azmoomztx  moon
         2
         考虑到回文的性质，可以考虑将原来的字符串进行反转，然后
         进行最长公共子串匹配
         不一定连续
         记 A={a1,a2,a3,...am}
     B={b1,b2,b3,...bn}
     记A、B的最长公共子序列为Z={v1,v2...vk}
     如果am=bn--->z[k-1]是{a1,a2,a3,...am-1}和{b1,b2,b3,...bn-1}的lcs
     反之，如果Z[k]!=am,则z[k-1]
         
         z[k]=
           1. z[k-1]+1 ，am=bn
           2. Max{}
	 */
  public static int getTheLongstString(String s){
	  if(s==null) return 0;
	  
	  int len=s.length();
	  //进行字符串的反转操作
	  StringBuilder stringBuilder=new StringBuilder();
	  for(int i=len-1;i>=0;i--){
		  stringBuilder.append(s.charAt(i));
	  }
	  String inverString=stringBuilder.toString();
	  int[][]C=new int[len+1][len+1];
	  
	  for(int i=0;i<len;i++){
		C[0][i]=0;  
	  }
      for(int i=0;i<len;i++){
    	  C[0][i]=0; 
	  }
      int max=0;
	  for(int i=1;i<=len;i++){
		  for(int j=1;j<=len;j++){
			  if(s.charAt(i-1)==inverString.charAt(j-1)){
				  C[i][j]=C[i-1][j-1]+1;
			  }
			  else
			  {
				  C[i][j]=Math.max(C[i-1][j], C[i][j-1]);
			  }
			  if(max<C[i][j]){
				  max=C[i][j];
			  }
		  }
	  }
	  //
	  return len-max;
  }
  public static void main(String [] args){
	  Scanner sc=new Scanner(System.in);
	  while(sc.hasNextLine()){
		  String s=sc.nextLine();
		 int result= getTheLongstString(s);
		 System.out.println(result);
	  }
  }
}
