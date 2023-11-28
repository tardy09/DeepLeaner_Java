package InterView.Algotrithm;

import java.util.*;

/**
 * Created by Administrator on 2017/3/1.
 */
public class Coder {
    public String[] findCoder(String[] A, int n) {
        String [] result=null;
        int []a=new int [n];
        for (int i = 0; i <A.length;i++) {
            //快速淘汰不包含的字符串
            if(!A[i].toUpperCase().contains("CODER"))
            {
                continue;
            }
            //在每一个子串里面统计出现的次数
            int pervious=-1;
            String tempS=A[i].toUpperCase();
            for (int j = 0; j <tempS.length() ; j++) {
                if(tempS.indexOf("CODER",j)!=-1){
                    if(tempS.indexOf("CODER",j)!=pervious)
                    {
                        //记录这次找到的索引
                        pervious=tempS.indexOf("CODER",j);
                        ++a[i];
                    }
                }
            }
        }
        Map hashMap=new HashMap();
        for (int i = 0; i <n ; i++) {
            if(a[i]==0){
                continue;
            }
            hashMap.put(a[i],i);
        }
        int size=hashMap.size();
        result=new String[size];
        Arrays.sort(a);
        for (int i = 0; i <size ; i++) {

            result[hashMap.size()-1-i]=A[(int) hashMap.get(a[i])];
        }
        return result;
    }
    public static void main(String [] args){
      String [] ss={"coder",
              "xfcoderjbixcoderpuvwhcoderodpacoderycacoderjskcoderptcoderkcoderdtwcodergalucoderfnjpwcoderagmtcodermkzoqcoderysqsycoderlvccodervbycoderacuagcodereueucoderscoderrbcoder",
              "xbxcoderlafrcoderyuccoderjcoderefldcodersstujcoderelcoder",
              "dvfowcoderfencoderqekcoderbtmcoderehcoderriyjdcodermocoder",
              "ncbacoderjnvcoderfqcoderenwjpcoderkintcoderwtgcoder"};
        ss=new Coder().findCoder(ss,5);
        System.out.println();
    }
}
