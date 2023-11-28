package SwordOffer;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/30.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i <array.length ; i++) {
            int index=Arrays.binarySearch(array[i],target);
            if(index>=0){
                return true;
            }
//            if(array[i][Arrays.binarySearch(array[i],target)]==target){
//                return true;
//            }
        }
        return false;
    }
    public boolean Find2(int target, int [][] array) {
        boolean flag=false;
        int row=array.length-1;
        int col=array[0].length-1;
        if(row>=0&&col>=0){
            int s_row=0;
            int s_col=col;
            while (s_row<=row&&s_col>=0){
                /**
                 * 维数组的右上角的元素开始判断，因为此元素是它所在行的最大数，是它所在的列的最小数
                 */
                if(array[s_row][s_col]==target){
                    flag= true;
                    break;
                }
                else if(array[s_row][s_col]>target){
                    //排除所在的列
                    --s_col;
                }
                else {
                    //排除所在的行
                    ++s_row;
                }
            }
        }
        return flag;
    }
    public static void main(String [] args){
        int c [][]={
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

//       int [] ff= c[0];
//        for (int i = 0; i <ff.length ; i++) {
//            System.out.print(ff[i]+" ");
//        }
      //  System.out.println(c.length);
//        for (int i = 0; i <c[0].length ; i++) {
//            System.out.print(c[0][i]+" ");
//        }
        System.out.println(new Solution1().Find2
                (15,c));
    }
}
