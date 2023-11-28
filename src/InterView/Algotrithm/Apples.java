package InterView.Algotrithm;

public class Apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * nֻ�� 
	 * 1--��ƻ���ֳ�n�ݣ����һ���ӵ� �������Լ�����һ��  n*x1+1=X--->x1=(X-1)/n
	 * 2--��ʣ�µ�ƻ�� �ֳ�n�ݣ������һ���ӵ��������Լ���һ��  n*x2+1+x1+1=X--->x2=(X-2-(X-1)/n)/n
	 * ....
	 * 
	 * n ��ʣ�µ�ƻ���ֳ�n�ݣ������һ�����ӵ��������Լ���һ��
	 * ע���Լ���һ�ݿ�����0��
	 * 
	 * @param n �ܵĸ���
	 * @return
	 */
	 public int getInitial(int n) {
		 //��֤��һ�������ٿ��Էֵ�һ��ƻ��
		 int initial=n+1;
		 int bear=n;
		 int i=0;
		 for(i=initial;;i++)
		 {
			 //Ȼ��ͨ��i��Ϊ��������ȥ�����������
			 int temp=i;
			 while(temp>=0&&bear>0){
				 if(temp%n==1){
					 temp=temp-temp/n-1;
					 bear--;
				 }else{
					 break;
				 }
			 } 
			 if(bear==0){
				 return i;
			 }
		 }    // write code here
	    }
}
