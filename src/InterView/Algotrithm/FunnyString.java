package InterView.Algotrithm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FunnyString {
  public static void main(String [] args){
	   Scanner sc=new Scanner(System.in);
	   while(sc.hasNextLine()){
		   int n=sc.nextInt();
		   int [] arr=new int[n];
		   for(int i=0;i<n;i++){
			   arr[i]=sc.nextInt();
		   }
		   soluction(arr,n);
	   }
  }
  /**
   * 
   �����������������ݡ�
   ����ÿ��������ݣ�
 N - �������������n����
a1,a2...an - ��Ҫ���������
   ��֤:
 1<=N<=100000,0<=ai<=INT_MAX.
   * @param arr
   * @param n
   */
  public static void soluction(int[] arr,int n){
	  int len=arr.length;
	 if(n<=0||n==1||(n!=len)){
		 return ;
	 }
	 int max=0;
	 int min=0;
	 Arrays.sort(arr);//�������������
	 Map<Integer,Integer> hashMap=new HashMap();
	 for(int i=0;i<arr.length;i++){
		 if(hashMap.containsKey(arr[i])){
			 int count=hashMap.get(arr[i]);
			 hashMap.put(arr[i], count+1);
		 }
		 else{
			 hashMap.put(arr[i], 1);
		 }
	 }
	 //���˵������ ���е�Ԫ�ض���ͬ
     if(hashMap.size()==1){
    	  max=n*(n-1)/2;
    	  min=max;
    	  System.out.print(min+" "+max);
    	  return;
     }
     //�����Сֵ ��Ҫ���Ƿ����ظ���Ԫ��
     if(hashMap.size()<n){
    	 //���ظ�Ԫ�ط�����ЩԪ�����ظ���
    	 for(Entry<Integer, Integer> entry:hashMap.entrySet()){
    		 int value=entry.getValue();
    		 if(value>=2){
    			 min+=(value-1)*value/2;
    		 }
    	 }
     }
     else
     {
    	 //1 3 5 7 11 18 19
    	 for(int i=0;i<n-1;i++){
    		 int temp=arr[i+1]-arr[i];
    	     if(temp>min){
    	    	 min=temp;
    	     }
    	 }
     }
     //�����ֵ
     int maxNum=hashMap.get(arr[n-1]);
     int minNum=hashMap.get(arr[0]);
     max=maxNum*minNum;
     System.out.println(min+" "+max);
     return;
  }
}
