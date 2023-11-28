package learnibf;
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
   输入包含多组测试数据。
   对于每组测试数据：
 N - 本组测试数据有n个数
a1,a2...an - 需要计算的数据
   保证:
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
	 Arrays.sort(arr);//对数组进行排序
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
	 //极端的情况下 所有的元素都相同
     if(hashMap.size()==1){
    	  max=n*(n-1)/2;
    	  min=max;
    	  System.out.print(min+" "+max);
    	  return;
     }
     //求解最小值 主要看是否有重复的元素
     if(hashMap.size()<n){
    	 //有重复元素分析哪些元素是重复的
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
     //求最大值
     int maxNum=hashMap.get(arr[n-1]);
     int minNum=hashMap.get(arr[0]);
     max=maxNum*minNum;
     System.out.println(min+" "+max);
     return;
  }
}
