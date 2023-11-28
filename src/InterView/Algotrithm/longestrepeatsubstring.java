package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Created by Administrator on 2017/5/4.
 *    最长的重复子串
 *    用后缀数组解决（vector< string> lastsubstring），例如abcdabcda，后缀数组为：
 lastsubstring[0]=abcdabcda;
 lastsubstring[1]=bcdabcda;
 lastsubstring[2]=cdabcda;
 lastsubstring[3]=dabcda;
 lastsubstring[4]=abcda;
 lastsubstring[5]=bcda;
 lastsubstring[6]=cda;
 lastsubstring[7]=da;
 lastsubstring[8]=a;
 */
public class longestrepeatsubstring {
    public  static  void  main(String [] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String inputStr=scanner.nextLine();
            soluction(inputStr);
        }
//        String s1="abc";
//        String s2="ab";
//        int res= GetLongestCommonStr(s1,s2);
//        System.out.println("vvvv");
    }
    /**]
     *
     * @param s
     * @return
     */
    public static  int soluction(String s){
        int len=s.length();
        if(len==0){
            return 0;
        }
        ArrayList<String> arrayList=new ArrayList();
        for (int i = 0; i <len ; i++) {
            arrayList.add(s.substring(i));
        }
        //对后缀数组进行排序操作
        /**
         0 = "a"
         1 = "abcda"
         2 = "abcdabcda"
         3 = "bcda"
         4 = "bcdabcda"
         5 = "cda"
         6 = "cdabcda"
         7 = "da"
         8 = "dabcda"
         */
        Collections.sort(arrayList);
        //两两进行比较
        int maxLen=0;
        int  maxIndex=0;
        for (int i = 0; i <arrayList.size()-1; i++) {
            int curLen=GetLongestCommonStr(arrayList.get(i),arrayList.get(i+1));
            if(curLen>maxLen){
                maxLen=curLen;
                //更新下标
                maxIndex=i;
            }
        }
        System.out.println(s.substring(maxIndex-1,maxIndex+maxLen-1));
        return 0;
    }
    /**
     *  获取两个子串的公共长度
     * @param s
     * @param s1
     * @return
     */
    private static int GetLongestCommonStr(String s, String s1) {
        int len1=s.length();
        int len2=s1.length();
        if(len1==0||len2==0){
            return 0;
        }
        int i=0,j=0;
        int count=0;
        while (i<len1&&j<len2){
            if(s.charAt(i++)!=s1.charAt(j++)){
                break;
            }
            count++;
        }
        return count;
    }
}
