package InterView.Algotrithm;

public class LastRemaining_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 /**
	  * ���ƹ�ʽ
	  * f(i)=
	  * 
	  *   0  --i=0
	  *   (f(i-1)+m)/i --->   ��i>1
	  *   0,1,2,3,4,5,6  n=7
	  *   m=3
	  *   1:  0,1,3,4,5,6  2����
	  *   2��   3,4,6,0,1  5����
	  *   3.  6,0,3,4      1����
	  *   
	  *   
	  *   
	  *   0,1,2,.....n-1   m-1
	  *   0,1,2,3...m-2,m-1,m,m+1,....n-1  ---��n���� ʵ��  m-1����
	  *   0,1,2,3,....m-2,m,m+1,....n-2,n-1   --->  
	  *   ^^^^^^^^^^^^^^^^^^^^^^
	  *    ���Ǵ� n-1���ӳ��������
	  *
	  *   $$$$$$$$$$$$$$$$$$$$$$$$
	  *   m,m+1,...n-1,0,1,2,3....m-2  
	  *   ?
	  * ��ʵ   m,m+1,...n-1,n,n+1,n+2,,,n+m-2
	  *   
	  * ���⣺ 0,1,......................n-2  ---n-1����
	  * @param n
	  * @param m
	  * @return
	  */
	 public int LastRemaining_Solution(int n, int m) {
		 if(n==0||m==0){
			 return 0;
		 }
		 int f[]=new int[n+1];
		 f[0]=0;f[1]=0;
		 for(int i=1;i<=n;i++){
	       f[i]=(f[i-1]+m)%i;
	       System.out.println(i+" Ҫ������....");
		 }
		return f[n];
	 }

}
