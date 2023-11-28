package InterView.Algotrithm;

public class NumberOf1Between1AndN {
   public static void main(String[] args) {
		// TODO Auto-generated method stub
  int res=new NumberOf1Between1AndN().count(2593, 5);
  System.out.println("bbb"+res);
	}
	/**
	 * 1~13  
	 * 1 10 11  12 13 
	 * 100~1300?
	 * 1可能出现在任意一个位置上
	 * 很快的求出任意非负整数区间中1出现的次数。
	 * @param n
	 * @return
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		//1.首先确定n的位数和每一位的数字
		
		//暴力穷举
		//当最后一位为1
		int sum=0;
		for(int i=1;i<=n;i++){
		  sum+=getNumOf1(i);
		}
		return sum;
	    
    }
	private int getNumOf1(int n) {
		int num=getNumOfN(n);
		int arr[]=new int[num];
		//int totalSum[]=new int[num];
		for(int i=num-1;i>=0;i--){
			arr[i]=n%10;
			n=n/10;
		}
		int res=0;
		for(int i=0;i<num;i++){
			if(arr[i]==1){
			  res++;	
			}
		}
		return res;
	}
	/**
	 *  12 -----
	 * 
	 * @param n
	 * @return
	 */
	private int getNumOfN(int n) {
		// TODO Auto-generated method stub
		int result=0;
		if(n/10==0){
			return 1;
		}
		while(n!=0){
			n/=10;
			result++;
		}
		return result;
	}
	/**
	 * 计算数字X在1到n里面出现的次数
	 * 
	 * 总结一下以上的算法，可以看到，当计算右数第 i i 位包含的 X 的个数时：
        1.取第 i i 位左边（高位）的数字，乘以 10 i−1  10i−1，得到基础值 a a。
        2.取第 i i 位数字，计算修正值： 1.如果大于 X，则结果为 a+10 i−1  a+10i−1。
        2.如果小于 X，则结果为 a a。
        3.如果等 X，则取第 i i 位右边（低位）数字，设为 b b，最后结果为 a+b+1 a+b+1。


	 * 
	 * 
	 * @param n
	 * @param X
	 * @return
	 */
	public int count(int n,int X){
		
		int total=0,k = 0;
		//得到n的位数和每一位的数字
		int tempN=n;
		while(tempN!=0){
			tempN/=10;
			k++;
		}
		int arr[]=new int[k];
		for(int i=0;i<k;i++){
			arr[i]=n%10;
			n/=10;
		}
		int  result[]=new int[k];
		//依次计算从右边数起来的第1位到第k位  //由低位到高位
		for(int j=1;j<=k;j++){
			int temp=j;
			int a=0;
			for(int i=temp+1;i<=k;i++){
			  a+=arr[i-1]*Math.pow(10,i-temp-1);	
			}
			//a=(int) (a*(Math.pow(10, j)));
			//修正该值
			if(j>=1&&arr[j-1]<X){
			    result[j-1]=(int) (a*Math.pow(10, j-1));
			    //continue;
			}
			if(j>=1&&arr[j-1]>X){
				result[j-1]=(int) (a*Math.pow(10, j-1)+Math.pow(10,(j-1)));
			}
			if(j>=1&&arr[j-1]==X){
				int b=0;
				//
				for(int i=0;i<=j-2;i++){
					b+=arr[i]*Math.pow(10,i);
				}
				result[j-1]=(int) (a*Math.pow(10, j-1)+b+1);
			}
		}
		for(int i=0;i<k;i++){
			total+=result[i];
		}
		return total;
		
	}
}
