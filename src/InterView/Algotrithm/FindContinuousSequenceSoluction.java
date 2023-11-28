package InterView.Algotrithm;

import java.util.ArrayList;

public class FindContinuousSequenceSoluction {
	/**
	 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,
	 * �����Ͼ�д������ȷ����100�����������������ڴ�,
	 * �����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
	 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
	 * sum=100
	 * 1. [9, 10, 11, 12, 13, 14, 15, 16] 8
	 * 2. [18, 19, 20, 21, 22]  5    
	 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? 
	 * Good Luck! 
	 * @param sum
	 * @return
	 * ��Ϊ���ٰ���������������Ҫ����������˶���sum����
	 * 1--(sum/2)-1,(sum/2��
	 * 
	 * �϶�С��n/2��
	 * 
	 */
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		if(sum<3){
			return null;
		}
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		int small=1, big=2;
		int currentSum=small+big;
		while(small<(sum+1)/2){
			//currentSum=(small+big)*(big-small+1)/2;
			if(currentSum==sum){
				ArrayList<Integer> tmp=new ArrayList();
				for(int i=small;i<=big;i++)
				{   //���������������ݷŵ�List����
				    tmp.add(i);
				        
				}
				result.add(tmp);
				//break;
			}
			while(currentSum>sum&&small<(sum+1)/2){
				//������small ʹ��������������ٵ�����
				currentSum-=small;
				small++;
				if(currentSum==sum){
					ArrayList<Integer> tmp=new ArrayList();
					for(int i=small;i<=big;i++)
					{   //���������������ݷŵ�List����
					    tmp.add(i);
					        
					}
					result.add(tmp);	
				}
			}
			big++;	
			currentSum+=big;
		}
		return result;      
    }
	
	public static void main(String [] args){
		ArrayList<ArrayList<Integer>> result=  new FindContinuousSequenceSoluction().FindContinuousSequence(9);	
	   
	}
	
}
