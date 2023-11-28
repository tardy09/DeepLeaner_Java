package InterView.Algotrithm;

public class countWaysSoluction {
	
	/**
	 * ��һ��XxY������һ��������ֻ���߸����ֻ�����һ������ߣ�
	 * Ҫ�����Ͻ��ߵ����½ǡ������һ���㷨������������ж������߷���
            ��������������int x,int y���뷵�ػ����˵��߷���Ŀ����֤x��yС�ڵ���12��
            ����������
     2,2
     f(i,j)=f(i-1,j)+f(i,j-1)
            ��f(i,j)Ϊ�ߵ� i,j�������
            ���أ�2
            ������˵ �ܹ��� x��������y��
            ÿһ��Ҫô���� Ҫô���ұ�
         (0,0)---(x-1,y-1)
           ����� n-1������
	 * @param x
	 * @param y
	 * @return
	 */
	public int countWays(int x, int y) {
		int f[][]=new int[x][y];
		f[0][0]=1;//��һ��=1
		if(x==1&&y==1){
			
			return 1;
		}
		for(int i=1;i<x;i++){
			f[i][0]=f[i-1][0];
		}
		for(int i=1;i<y;i++){
			f[0][i]=f[0][i-1];
		}
		for(int i=1;i<x;i++){
			for(int j=1;j<y;j++){
				f[i][j]=f[i-1][j]+f[i][j-1];
			}
		}
		return f[x-1][y-1];
        // write code here
    }
}
