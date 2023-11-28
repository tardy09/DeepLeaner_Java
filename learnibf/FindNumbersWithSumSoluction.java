package learnibf;

import java.util.ArrayList;

public class FindNumbersWithSumSoluction {
	/**
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
	 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
	 * 分两步骤进行分析 】
	 * 先找到和为s的序列对
	 * 然后求和最小的
	 * @param array
	 * @param sum
	 * @return
	 */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
         
    	ArrayList<Integer> result=new ArrayList();
          int s=array.length;
          int left=0;
          int right=s-1;
          int Cursum=array[left]+array[right];
          int backIndex=right;
          int fontIndex=left;
          int maxQui=1;
          if(array==null){
        	  return result;
          }
          while(left<right)
          {
        	  if(Cursum==sum){
        		  if(array[left]*array[right]>maxQui)
        		  {  
        			   backIndex=right;
        	           fontIndex=left;
        			  maxQui=array[left]*array[right];
        			  
        		  }
        	  }
        	  while(Cursum>sum&&left<right)
        	  {      
        			  right--;
        			  if(right<=left){
        				  break;
        			  }
        			  Cursum=array[left]+array[right];
        			  if(Cursum==sum)
        			  {
                		  if(array[left]*array[right]>maxQui)
                		  {
                			  maxQui=array[left]*array[right];
                		  }
                	  }
        	  }
        	  if(left>=right){
        		  break;
        	  }
        	  left++;
        	  Cursum=array[left]+array[right];
        	 }
          if(array[fontIndex]+array[backIndex]==sum){
        	  result.add(array[fontIndex]);
              result.add(array[backIndex]);
          }
          return result;
    } 
    
    public static void main(String [] args){
    	int array[]={1,2,4,7,11,16};
    	ArrayList<Integer> result=	new FindNumbersWithSumSoluction().FindNumbersWithSum(array, 10);
    }
    }

