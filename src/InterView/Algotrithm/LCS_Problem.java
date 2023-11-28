package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/4/25.
 */
public class LCS_Problem {
    /**
     * 求解s1,s2的
     * @param s1
     * @param s2
     * @return
     */
    public int  soluction(String s1,String s2){
        if(s1==null||s2==null){
            return 0;
        }
        int len1=s1.length();
        int len2=s2.length();
        int [][] len=new int[len1+1][len2+1];
        /**
         *  分析：对于两个序列 s1、s2
         *  1.假如s1的最后一个元素和s2的最后一个元素相等
         *    那么，LCS={s1去掉最后一个元素之后|和{s2去掉最后一个元素之后}的lcs加上1
         *  2.假如s1与s2的最后一个元素
         *    其中 len[1][1]代表第i个和 第j个
         *
         *
         */
        for (int i = 0; i <len1+1; i++) {
            len[i][0]=0;
        }
        for (int i = 0; i <len2+1; i++) {
            len[0][i]=0;
        }
        for (int i = 1; i <len1+1 ; i++) {
            for (int j = 1; j <len2+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    len[i][j]=len[i-1][j-1]+1;
                }else {
                    len[i][j]=Math.max(len[i-1][j],len[i][j-1]);
                }
            }
        }
        return len[len1][len2];
    }
    public static void main(String [] args){
               String s1="aabcdgh";
               String s2="habcdghQr";
             int tempLength=  new LCS_Problem().soluction(s1,s2);
        System.out.println("长度"+tempLength);
    }
}
