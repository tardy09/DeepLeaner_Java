package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

public class FirstNotRepeatingCharSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new FirstNotRepeatingCharSoluction().FirstNotRepeatingChar("google");
         System.out.println("".trim().length());
	}
	/**
	 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ���ɴ�д��ĸ���)��F
	 * �ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
	 * @param str
	 * @return
	 */
	 public int FirstNotRepeatingChar(String str) {
		     int len=str.length();
		     if(str.trim()!=null&&len==1){
		    	 return 0;
		     }
		     Map<Character,Integer> hashMap=new HashMap();
		     for(int i=0;i<len;i++){
		    	 if(hashMap.containsKey(str.charAt(i))){
		    		 int cout=hashMap.get(str.charAt(i));
		    		 hashMap.put(str.charAt(i), cout+1);
		    	 }
		    	 else
		    	 {
		    		 hashMap.put(str.charAt(i), 1); 
		    	 }
		     }
		     ArrayList<Character> arrayList=new ArrayList<>();
		     int mindex=Integer.MAX_VALUE;
		     for(Map.Entry<Character, Integer> entr:hashMap.entrySet()){
		    	 if(entr.getValue()==1){
		    		 int i=str.indexOf(entr.getKey());
		    		 if(i<mindex){
		    			 mindex=i;
		    		 }
		    	 }
		     }
			return mindex;
	    }

}
