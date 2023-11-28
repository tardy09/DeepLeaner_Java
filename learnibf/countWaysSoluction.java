package learnibf;

public class countWaysSoluction {
	
	/**
	 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，
	 * 要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
            给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
            测试样例：
     2,2
     f(i,j)=f(i-1,j)+f(i,j-1)
            记f(i,j)为走到 i,j点的总数
            返回：2
            总体来说 总共走 x加上向下y步
            每一步要么向下 要么向右边
         (0,0)---(x-1,y-1)
           假设第 n-1步走了
	 * @param x
	 * @param y
	 * @return
	 */
	public int countWays(int x, int y) {
		int f[][]=new int[x][y];
		f[0][0]=1;//第一步=1
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
