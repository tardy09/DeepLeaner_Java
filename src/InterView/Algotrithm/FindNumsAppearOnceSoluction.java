package InterView.Algotrithm;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/18.
 */
public class FindNumsAppearOnceSoluction {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * @param array  2,5,6,6,5,1,2,3
     * @param num1
     * @param num2
     * //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
          int distance=0;

        for (int i = 0; i <array.length ; i++) {
           distance^=array[i];
        }
        //得到distance的二进制位上从右往左第一个非0的数
        int flag=1;
        num1[0]=0;
        num2[0]=0;
        if(array.length==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }
        while (flag!=0){
            int temp=distance&flag;
            if(temp!=0){
                break;
            }
            flag<<=1;
        }
        ArrayList<Integer> arrayList1=new ArrayList();
        ArrayList<Integer> arrayList2=new ArrayList();
        //根据这个位置将数组里面的数据进行分组
        for (int i = 0; i <array.length; i++) {
            if((array[i]&flag)==0){
                arrayList1.add(array[i]);
            }
            else {
                arrayList2.add(array[i]);
            }
        }
        for (int i = 0; i <arrayList1.size() ; i++) {
            num1[0]^=arrayList1.get(i);
        }
        for (int i = 0; i <arrayList2.size() ; i++) {
            num2[0]^=arrayList2.get(i);
        }
    }
   public static void main(String [] args){
        int [] aa={2,4,3,6,3,2,5,5};
        int num1[]=new int[1];
       int num2[]=new int[1];
        new FindNumsAppearOnceSoluction().FindNumsAppearOnce(aa,num1,num2);
       System.out.println("vvvvv");
   }
}
