package learnibf;

public class StepsCount {
   public static void main(String [] args){
	   
   }
   /**
    *   有个小孩 上楼梯，小孩一次可以爬1级、2级、3级台阶，
    *   实现方法计算小孩爬取n级台阶 总共有多少种方式
    *  
    *   n==1-->f(1)=1  ---1
    *   n==2-->f(1)+1
    *   第一次爬取1级 f(1)
    *   第一次爬取2级 1
    *   f(2)=f(2-1)+1=1+f(1)=2
    *   n=3  
    *   第一次爬取一级 f(2)
    *   第一次爬取 2级 f(1)
    *   第一次爬取3级 1
    *   f(3)=1+f(3-1)+f(3-2)=1+f(2)+f(1);
    *   n=4  
    *   第一次爬取 3级 一种 f(1)
    *   第一次爬取 2级 f(2)
    *   第一次爬取 1级 f(3)
    *   f(4)=f(1)+f(2)+f(3)=\
    *   n=5
    *   第一次
    *   第一次爬取3级 f(2)
    *   第一次爬取2级 f(3)
    *   第一次爬取1级 f(4)
    *   f(5)=f(4)+f(3)+f(2)
    *   
    *   ....
    *   
    *   f(n)=
    *   
    * @param n
    * @return
    */
   public int soluction(int n){
	   if(n==1||n==2){
		   return n;
	   }
	   if(n==3){
		   return 4;
	   }
	   int f[]=new int[n+1]; 
	   f[1]=1;
	   f[2]=2;
	   f[3]=4;
	   //返回之前的暂存结果
	   if(f[n]!=0) return f[n];
	   f[n]=f[n-1]+f[n-2]+f[n-3];
	   return f[n];
   }
}
