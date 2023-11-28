package InterView.Algotrithm;

import java.util.Scanner;

public class MakeRevernseString {
	/**
	 * ����һ���ַ���s������Դ���ɾ��һЩ�ַ���
	 * ʹ��ʣ�µĴ���һ�����Ĵ������ɾ������ʹ�û��Ĵ���أ�
                 �����Ҫɾ�����ַ�������
         abcda  aca   toobt---toot
         adcba
         google  goog 
         azmoomztx  moon
         2
         ���ǵ����ĵ����ʣ����Կ��ǽ�ԭ�����ַ������з�ת��Ȼ��
         ����������Ӵ�ƥ��
         ��һ������
         �� A={a1,a2,a3,...am}
     B={b1,b2,b3,...bn}
     ��A��B�������������ΪZ={v1,v2...vk}
     ���am=bn--->z[k-1]��{a1,a2,a3,...am-1}��{b1,b2,b3,...bn-1}��lcs
     ��֮�����Z[k]!=am,��z[k-1]
         
         z[k]=
           1. z[k-1]+1 ��am=bn
           2. Max{}
	 */
  public static int getTheLongstString(String s){
	  if(s==null) return 0;
	  
	  int len=s.length();
	  //�����ַ����ķ�ת����
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
