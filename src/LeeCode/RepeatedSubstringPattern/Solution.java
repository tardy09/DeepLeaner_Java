package LeeCode.RepeatedSubstringPattern;

import java.awt.image.ReplicateScaleFilter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * Created by Administrator on 2016/11/29.
 */
public class Solution {
    /**
     *  查看是否存在重复的小子串构成str
     *  1.找到一个潜在可能存在的串
     * @param str
     * @return
     */
    public boolean repeatedSubstringPattern(String str) {
        for (int i=1; i<=str.length()/2; i++) {
            if (str.length() % i != 0) {//找到恰当的模式字符串长度
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(i));//截取了从索引i开始的字符串
            sb.append(str.substring(0, i));
            if (str.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }
    public boolean repeatedSubstringPattern2(String str){
        if(str.length()==1) return true;
        for(int j=1;j<=str.length()/2;j++){
            if(str.length()%j!=0){
                continue;//寻找合适长度的子串
            }
            String tempString=str.substring(0,j);//先提取第一个可能的整型子串，如果满足，则开始继续扩展逐步-等步进
            int i=j;
            while (i<=str.length()-j){
                String temp=str.substring(i,i+j);
                if(temp.equals(tempString))
                {
                    i+=j;
                }
                else
                {
                    break;
                }
            }
            if(i==str.length()) return true;
        }
        return false;
    }
    public static void main(String[] args){

        System.out.println(new Solution().repeatedSubstringPattern("a"));
        System.out.println("abcabc".substring(1,3));

    }
}
