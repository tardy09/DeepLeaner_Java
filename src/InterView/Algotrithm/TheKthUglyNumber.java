package InterView.Algotrithm;

public class TheKthUglyNumber {
    /**
     * һ��������2��3��5�����������⣬������������������
     * 4��6�ǳ���
     * ��14����
     * @param n
     * @return
     */
	public boolean  isUngly(int n){
		if(n<=0){
			return false;
		}
		while(n%2==0){
			n/=2;
		}
		while(n%3==0){
			n/=3;
		}
		while(n%5==0){
			n/=5;
		}
		return n==1;
	}
	/**
	 * ����  ����Ǵӵ�һ������ ������ĳ��������ۼӷ���
	 * ֱ�����㵽��index�ĳ����Ļ������ڴ�0��ʼ��ÿһ��������Ҫ���� 
	 * һ�������жϣ����м�����
	 * ������ʱ�临�Ӷ��Ǻܸߵ�
	 * 
	 * ������������ 
	 * ֻ�Գ��� ���� ����  �� ȡ����
	 * ��unlgy[k] Ϊ��k������
	 * ��ô �ٶ�����unlgy[k]��ʱ��ǰ��k-1���������Ѿ�����
	 * �Ӵ�С��˳�����������
	 * ungly[k]���ܾ��� ǰ���k-1������2��3��5�õ�
	 * ���� ungly[k]  ��ǰ���ungly[m]*2�õ�1<= m<=k-1
	 * ��q>m�� ungly[k]����2������ungly[k]
	 * �� 1<=q<m �� ��С��ungly[k]
	 * ��� �����жϵĹ������� �Ϳ��Խ�ungly[k]�Ľ����������
	 * ÿ�μ������и��²���
	 * 	ͬ�� ����2��3��5Ҳ����ͬ���Ĺ���
	 *   num: 1 2 3 4 5        xxx     yyyy
	 * index: 0 1 2 3 4 ....  index-1 index
	 *                        
	 * @param index
	 * @return
	 */
	public int GetUglyNumber_Solution(int index) {
		if(index<=0){
			return 0;
		}
		if(index==1||index==2||index==3){
			return index;
		}
		int [] ungly=new int[index+1];
		ungly[0]=1;
		//���� �����±� ���ӵ�һ����ʼ��
		int t2=0,t3=0,t5=0;
		int count=0;
		int tmp=0;
		while(count<index-1){//0<3=4-1  index=4
	       tmp=Math.min(ungly[t2]*2, Math.min(ungly[t5]*5, ungly[t3]*3));//2	
	       if(ungly[t2]*2==tmp){t2++;}
	       if(ungly[t3]*3==tmp){t3++;}
	       if(ungly[t5]*5==tmp){t5++;}
	       ungly[++count]=tmp;
		}
		return ungly[index-1];
    }
	public static void main(String [] args){
		
		
		
	}
}
