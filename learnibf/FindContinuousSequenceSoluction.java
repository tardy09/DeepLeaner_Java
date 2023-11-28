package learnibf;

import java.util.ArrayList;

public class FindContinuousSequenceSoluction {
	/**
	 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
	 * 他马上就写出了正确答案是100。但是他并不满足于此,
	 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
	 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	 * sum=100
	 * 1. [9, 10, 11, 12, 13, 14, 15, 16] 8
	 * 2. [18, 19, 20, 21, 22]  5    
	 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? 
	 * Good Luck! 
	 * @param sum
	 * @return
	 * 因为至少包含两个数，而且要求连续，因此对于sum而言
	 * 1--(sum/2)-1,(sum/2）
	 * 
	 * 肯定小于n/2的
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
				{   //将满足条件的数据放到List里面
				    tmp.add(i);
				        
				}
				result.add(tmp);
				//break;
			}
			while(currentSum>sum&&small<(sum+1)/2){
				//则增大small 使得序列里面包含少的数字
				currentSum-=small;
				small++;
				if(currentSum==sum){
					ArrayList<Integer> tmp=new ArrayList();
					for(int i=small;i<=big;i++)
					{   //将满足条件的数据放到List里面
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
