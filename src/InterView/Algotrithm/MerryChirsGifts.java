package InterView.Algotrithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/4.
 */
public class MerryChirsGifts {

    public  static  void  main(String [] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            int [][] arr=new int[m][n];
            for (int i = 0; i <m ; i++) {
                for (int j = 0; j <n ; j++) {
                   arr[i][j]=scanner.nextInt();
                }
            }
           int res= soluction(arr,m,n);
            System.out.println(res);
        }

    }

    /**
     * 输入一个二维矩阵
     *   2 4
     *   1 2 3 40
     *   6 7 8 90
     *
     *
     *     记f[i,j]为走到i,j的时候的最大值
     *       那么
     *       f[i,j]=Max{f[i-1,j],f[i,j-1]}+arr[i][j]  ,0<=i<m,0=<j<n,
     *       如果i=0,只能往下走
     *       如果j=0,只能往右边走
     *
     *
     * @param arr
     * @param m
     * @param n
     * @return
     */
    public static  int soluction(int [] []arr,int m,int n){
        if(arr==null){
            return 0;
        }
        int res[][]=new int[m][n];
        res[0][0]=arr[0][0];
        for (int i = 1; i <n; i++) {
            res[0][i]=res[0][i-1]+arr[0][i];
        }
        for (int i = 1; i <m; i++) {
            res[i][0]=res[i-1][0]+arr[i][0];
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                res[i][j]=Math.max(res[i-1][j],res[i][j-1])+arr[i][j];
            }
        }
        return res[m-1][n-1];
    }
}
