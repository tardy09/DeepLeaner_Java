package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
 public static void main(String [] args){
	    
        boolean res= soluction("100-trade-done","1*trade*done");
        if(res){
        	System.out.println(1);
        }else{
        	System.out.println(0);
        }
 }

private static boolean soluction(String string, String pattern) {
	// TODO Auto-generated method stub
	if(string==null||pattern==null){
		return false;
	}
	int s=string.length();
	int t=pattern.length();
	boolean flag=false;
	char sArray[]=string.toCharArray();
	char pArray[]=pattern.toCharArray();
	for(int i=0;i<s;i++){
		for(int j=0;j<t;j++){
		  if(pArray[j]=='*'||pArray[j]=='?'){
			  if(pArray[j]=='*')
			  {
				  //������������������ַ�
				  j++;
				  while(pArray[j]!=sArray[i]){
					  i++;
				  }
				  i++;
			  }
			  else
			  {
				  i++;
				  j++;
			  }
		  }
		  else{
			  if(pArray[j]!=sArray[i]){
				  return false;
			  }
			  else{
				  i++;
				  //j++;
			  }
		  }
		}
		flag=true;
	}
	return flag;
}
private static boolean soluction2(String string, String pattern) {
	// TODO Auto-generated method stub
	if(string==null||pattern==null){
		return false;
	}
	int s=string.length();
	int t=pattern.length();
	boolean flag=false;
	char sArray[]=string.toCharArray();
	char pArray[]=pattern.toCharArray();
	int i=0,j=0;
	while(i<=s&&j<=t){
		  if(pArray[j]=='*'||pArray[j]=='?'){
			  if(pArray[j]=='*')
			  {
				  //������������������ַ�
				  j++;
				  while(pArray[j]!=sArray[i]){
					  i++;
				  }
			  }
			  else
			  {
				  i++;
				  j++;
			  }
		  }
		  else{
			  if(pArray[j]!=sArray[i]){
				  return false;
			  }
			  else{
				  i++;
				  //j++;
			  }
		  }
		flag=true;
	}
	return flag;
}
}