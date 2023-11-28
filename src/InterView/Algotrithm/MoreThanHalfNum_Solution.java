package InterView.Algotrithm;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] test={1,2,3,2,4,2,5,2,3};
    int rs=  new MoreThanHalfNum_Solution().MoreThanHalfNum_Solution2(test);
    System.out.println("vvvv");
	}
    
	/**
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
	 *                     
	 *                    �������鳤�ȵ�һ�룬��ô����������ȫ���������һ����зֲ�
	 *                    �϶����Խ ����������������зֲ�
	 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2��
	 * ��������������0��  
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int [] array) {
		int len=array.length;
		if(len==0||len==1){
			return 0;
		}
        Map<Integer, Integer> hashMap=new HashMap<>();
        for(int i=0;i<array.length;i++){
        	if(hashMap.containsKey(array[i])){
        		int count=hashMap.get(array[i]);
        		hashMap.put(array[i], count+1);
        		if((count+1)>len/2){
        			return array[i];
        		}
        	}else
        	{
        		hashMap.put(array[i],1);
        	}
        }
		return 0;    
	    }
	/**
	 *  ��һ��˼·
	 *  1.�����һ�����ֺ�֮ǰ��ѡ������ͬ�� nTimes++;
	 *  2.else ,nTimes--
	 *  3.���������nTimes=0����target�滻��ǰ������nTimes��������Ϊ1
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution2(int [] array){
		if(array==null){
			return 0;
		}
		int len=array.length;
		int target=array[0];
		if(len==1) return array[0];
		int nTimes=1;
		for(int i=1;i<len;i++){
			if(nTimes==0){
				target=array[i];
				nTimes=1;
			}else{
				if(array[i]==target){
					nTimes++;	
				}else
				{ 
					//ּ��ͬʱ������������ͬ������
					nTimes--;
				}
				
			}
			
		}
		int count=0;
		for(int i=0;i<array.length;i++){
			if(array[i]==target){
				count++;
			}
		}
		if(count*2>len)  return target;
		return 0;
	}
}
