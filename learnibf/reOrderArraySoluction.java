package learnibf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author Administrator
 *
 */
public class reOrderArraySoluction {
	 public void reOrderArray(int [] array) 
	 {
	     int s=array.length;
	     if(s==0||s==1){
	    	 return;
	     }
	     List Oddquene=new ArrayList<>();
	     List Evenquene=new ArrayList<>();
	     for(int i=0;i<s;i++){
	    	 if(array[i]%2==0){
	    		 Evenquene.add(array[i]);
	    	 }else
	    	 {
	    		 Oddquene.add(array[i]);
	    	 }
	     }
	     for(int j=0;j<Oddquene.size();j++){
	    	 array[j]=(int) Oddquene.get(j);
	     }
	     for(int i=0;i<Evenquene.size();i++){
	    	 array[i+Oddquene.size()]=(int) Evenquene.get(i);
	     }
		
	 }
	 /**
	  * 借鉴 冒泡排序的思想
	  * @param array
	  */
	 public void reOrderArray2(int [] array) {
		 int s=array.length;
		 if(s==0||s==1){
			 return ;
		 }
		 for(int i=0;i<s;i++){
			 for(int j=0;j<s-i;j++){
				 //进行扫描 如果发现 具有偶数排在奇数的前面  则进行交换  -将最后的一个偶数放在了它正确的位置
				 //同时保证 奇数都排在了偶数的前面
				 if(array[j]%2==0&&array[j+1]%2==1){
					 int t=array[j];
					 array[j]=array[j+1];
					 array[j+1]=t;
				 }
			 }
		 }
	 }
	 public static  void main(String [] args){
		int array[]={ 2,3,6,7,8};
		new reOrderArraySoluction().reOrderArray(array);
		System.out.println("vvvvv");
	 }
}
