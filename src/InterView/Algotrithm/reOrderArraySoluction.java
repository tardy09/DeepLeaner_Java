package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
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
	  * ��� ð�������˼��
	  * @param array
	  */
	 public void reOrderArray2(int [] array) {
		 int s=array.length;
		 if(s==0||s==1){
			 return ;
		 }
		 for(int i=0;i<s;i++){
			 for(int j=0;j<s-i;j++){
				 //����ɨ�� ������� ����ż������������ǰ��  ����н���  -������һ��ż������������ȷ��λ��
				 //ͬʱ��֤ ������������ż����ǰ��
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
