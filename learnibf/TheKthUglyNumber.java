package learnibf;

public class TheKthUglyNumber {
    /**
     * 一个数除了2、3、5是它的因数外，其他都不是他的因数
     * 4、6是丑数
     * 而14不是
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
	 * 分析  如果是从第一个丑数 到后面的丑数进行累加分析
	 * 直到计算到第index的丑数的话，对于从0开始的每一个数都需要进行 
	 * 一个丑数判断，进行计数，
	 * 这样的时间复杂度是很高的
	 * 
	 * 可以这样考虑 
	 * 只对丑数 进行 除法  和 取余数
	 * 记unlgy[k] 为第k个丑数
	 * 那么 假定在求unlgy[k]的时候前面k-1个丑数都已经按照
	 * 从大到小的顺序完成了排列
	 * ungly[k]可能就是 前面的k-1个乘以2、3、5得到
	 * 假设 ungly[k]  是前面的ungly[m]*2得到1<= m<=k-1
	 * 而q>m的 ungly[k]乘以2都大于ungly[k]
	 * 而 1<=q<m 的 都小于ungly[k]
	 * 因此 计算判断的过程里面 就可以将ungly[k]的结果保存下来
	 * 每次计算后进行更新操作
	 * 	同理 对于2、3、5也满足同样的规律
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
		//定义 三个下标 都从第一个开始找
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
