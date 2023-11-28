package InterView.Algotrithm;

public class TheLittleestNum {
  
	public static  void main(String [] args){
		
		int [] arr={5,6,3,9,4};
		int res=MaxDivide(arr,5);
		System.out.println(res+"cccccccccccccc");
	}
	/**
	 * �������� arr�� ʹ��
	 * 0<=a<b<n
	 * ʹ��A[b]-A[a]�Ĳ�ֵ���
	 * 5,6,3,9,4
	 * [5]---0    leftMin=5    res=0
	 * [5,6]---1  leftMin=5   res=1
	 * [5,6,3]-   leftMin=3   res=1
	 * [5,6,3,9]  leftMin=3  res=6
	 * [5,6,3,9,4]  leftMin=3 res=6
 	 * 
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int MaxDivide(int [] arr,int n){
		if(n==0||n==1){
			return 0;
		}
		int res[]=new int[n];
		int leftMin=arr[0];
		//int maxLen=0;
		for(int i=1;i<n;i++){
			if(leftMin<arr[i]){
				int currSum=arr[i]-leftMin;
				res[i]=Math.max(currSum, res[i-1]);
			}
			else
			{
				//�����ڸ��µĿ�����
				leftMin=arr[i];
				res[i]=res[i-1];
			}
		}
		return res[n-1];
	}
}
