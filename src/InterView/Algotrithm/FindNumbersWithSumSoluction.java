package InterView.Algotrithm;

import java.util.ArrayList;

public class FindNumbersWithSumSoluction {
	/**
	 * ����һ����������������һ������S���������в�����������
	 * ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
	 * ����������з��� ��
	 * ���ҵ���Ϊs�����ж�
	 * Ȼ�������С��
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

