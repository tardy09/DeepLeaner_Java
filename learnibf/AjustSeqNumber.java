package learnibf;

import java.util.ArrayList;
import java.util.Scanner;

public class AjustSeqNumber {
	/**
	 *  ��һ���ַ����Ĵ�д��ĸ�ŵ��ַ����ĺ��棬�����ַ������λ�ò��䣬�Ҳ����������Ŀռ�
	 *  @param str
	 *   AkleBiCeilD
	 *1. kAleBiCeilD
	 *   klAeBiCeilD
	 *   kleABiCeilD
	 *   kleAiBCeilD
	 *   kleiABCeilD
	 *   kleiABeCilD
	 *   kleiABeiClD
	 *   kleiABeilCD 
	 *   kleiABeilCD
	 * 
	 * kleieilABCD
	 */
    public  static String soulction(String str){
    	int s=str.length();
    	if(s==0||s==1){
    		return str;
    	}
    	char arr[]=str.toCharArray();
    	for(int i=0;i<str.length();i++){
    		for(int j=0;j<str.length()-1-i;j++){
    	       if(arr[j+1]>='a'&&arr[j+1]<='z'&&arr[j]>='A'&&arr[j]<='Z'){
    	    	   char temp=arr[j+1];
    	    	   arr[j+1]=arr[j];
    	    	   arr[j]=temp;
    	    	 //  continue;
    	       }
    		}
    	}
    	return new String(arr);
    }
	
	public static void main(String [] args){
		
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNextLine()){
			String tempStirng=scanner.nextLine();
			System.out.println(soulction(tempStirng));
		}
		
	}
}
