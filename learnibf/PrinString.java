package learnibf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PrinString {
  
	public String  soluction(String s){
		if(s==null||s.length()<5){
			return null;
		}
		Set hashSet=new TreeSet();
		char string[]=s.toCharArray();
		for(int i=4;i<s.length();i+=5){
			hashSet.add(string[i]);
		}
		Iterator<Character> iterator=hashSet.iterator();
		StringBuilder stringBuilder=new StringBuilder();
		while(iterator.hasNext()){
			stringBuilder.append(iterator.next());
		}
		return stringBuilder.toString();
	}
	public String  soluction2(String s){
		
		return s;
		
	}
	public static void main(String [] args){
		String s="acssfs6789s11253d7777d";
		String sq=new PrinString().soluction(s);
		System.out.println(sq);
	}
}
