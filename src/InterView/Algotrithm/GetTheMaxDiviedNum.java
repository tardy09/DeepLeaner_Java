package InterView.Algotrithm;

public class GetTheMaxDiviedNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] arr={10,5,7,6,5,3};
     int count=  soluction(arr);
	}
	public static int soluction(int [] arr){
		int s=arr.length;
		if(s==0||s==1){
			return 0;
		}
		int res[]=new int[s];
		int leftMin=arr[0];
		for(int i=1;i<s;i++){
			//ͬʱҪ���ϵĽ��и�����Сֵ
			if(leftMin<arr[i])
			{
			      	int curDiveSum=leftMin-arr[i];
			      	res[i]=Math.min(curDiveSum, res[i-1]);
			}
			else 
			{
				//���¼�������С��ֵ
				leftMin=arr[i];
				res[i]=res[i-1];
			}
		}
		return res[s-1];
		
	}

}
