package InterView.Algotrithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HuaWei {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        while (in.hasNext()) {//ע��while������case
	             String s=in.nextLine();
	             soluction(s);
	        }
		
		
	}
 	public static void  soluction(String s){
 		  Map<Integer,String> hashMap=new  HashMap();
 		  
 			   hashMap.put(0, "F");
 			   hashMap.put(1, "G");
 			   hashMap.put(2, "R");
 			   hashMap.put(3, "S");
 			   hashMap.put(4, "T");
 			   hashMap.put(5, "L");
 			   hashMap.put(6, "M");
 			   hashMap.put(7, "N");
 			   hashMap.put(8, "O");
 			   hashMap.put(9, "P");
 			   hashMap.put(10, "Q");
 			   //
 			   hashMap.put(11, "W");
 			   hashMap.put(12, "X");
 			   hashMap.put(13, "Y");
 			   hashMap.put(14, "Z");
 			   hashMap.put(15, "U");
 			   hashMap.put(16, "A");
 			   hashMap.put(17, "G");
 			   hashMap.put(18, "H");
 			   hashMap.put(19, "I");
 			   hashMap.put(20, "J");
 			   hashMap.put(21, "K");
 			   //
 			   hashMap.put(22, "B");
 			   hashMap.put(23, "C");
 			   hashMap.put(24, "D");
 			   hashMap.put(25, "E");
 			   hashMap.put(26, "I");
 			   hashMap.put(27, "m");
 			   hashMap.put(28, "n");
 			   hashMap.put(29, "o");
 			   hashMap.put(31, "i");
 			   hashMap.put(32, "j");
 			   hashMap.put(33, "k");
 			   //
 			   hashMap.put(34, "f");
 			   hashMap.put(35, "g");
 			   hashMap.put(36, "h");
 			   hashMap.put(37, "a");
 			   hashMap.put(38, "b");
 			   hashMap.put(39, "c");
 			   hashMap.put(40, "d");
 			   hashMap.put(48, "s");
 			   hashMap.put(49, "t");
 			   hashMap.put(50, "u");
 			   hashMap.put(51, "v");
 		   
        	int len=s.length();
        	if(len==0){
        		return ;
        	}
        	int  cos=0;
        	for(int i=0;i<len;i++){
        		if(s.charAt(i)=='#'){
        			cos++;
        		}
        	}
        	if(cos==len){
        		System.out.println();
        		return;
        	}
        	String [] str=s.split("#");
        	StringBuilder res=new StringBuilder();
        	for(int i=0;i<str.length;i++){
        		String tempStr=str[i];
        		int NumTempStr=Convert(tempStr);
        		if(NumTempStr>51){
        			System.out.println("ERROR");
        			return;
        		}
        		//System.out.println(hashMap.get(NumTempStr));
        		res.append(hashMap.get(NumTempStr));
        	}
        	System.out.println(res.toString());
	}
	private static int Convert(String tempStr) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<tempStr.length();i++){
			if(tempStr.charAt(i)=='-'){
				stringBuilder.append("0");
			}
			else
			{
				stringBuilder.append("1");	
			}
		}
		String targetString=stringBuilder.toString();
		int res=0;
		for(int j=targetString.length()-1;j>=0;j--){
			char temp=targetString.charAt(j);
			//System.out.println(temp);
			if(targetString.charAt(j)=='0'){
			  continue;
			}
			int dd=targetString.length()-1-j;
			res+=Math.pow(2, (targetString.length()-1-j))*(Integer.valueOf(targetString.charAt(j))-48);
		}
		return res;
	}
}