package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/4/26.
 */
public class PartiontaTionSolucton {

    /**
     *
     * @param array
     * @param start
     * @param end
     */
  public int  fast_Paration(int [] array,int start,int end){
      int s=array.length;
      if(s==0){
          return -1;
      }
      int base=array[0];
      int i=start,j=start;
      if(start==end){
          return 0;
      }
      //将区间第一位数作为参照数
      Swap(array, 0, end);
      Swap(array,base,array[s-1]);
      //遍历 将比目标数字大的都放在右边，反之左边
      //其中 j始终指向期望的比基准数字大的最大

      for (;i<s;i++){
          if(array[i]<base)
          {
              //只要遍历的数比基准数字小 i,j都是同步进行增长的
              if(i!=j){
                  //也就是i>j
                  Swap(array,i,j);//j指向比较大的数，当前的数比参照数小，则进行交换
                  //如果数组里面不存在比参照数字大的数，则j最终会指向参照数
                  //如果数组里面存在比参照数大的数，则J会指向比参照数大的数
              }
              j++;
          }
          //否则 j不增加，碰到这种情况表明遇到了比基准数字大的数了
      }
      return j;
  }

    private void Swap(int[] array, int base, int i) {
        int temp=array[base];
        array[base]=array[i];
        array[i]=temp;
    }

    public static  void main(String [] args){
      /**
       *
       *    4, 3, 6, 2, 9, 7 ----  7，3, 6, 2, 9,  4
       *    0  1  2  3  4  5       0  1  2  3  4  5
       *    进行paraton分区操作
       *
       *    base=4  基准选择第一个数
       *    int font=0;
       *    int
       *
       *   2,3,4,6,7,9
       *
       *   返回的数字表征是第j+1大的数字
       *
       *
       */
      int [] exa={4, 3, 6, 2, 9, 7};
     int s=new PartiontaTionSolucton().fast_Paration(exa,0,5);
        System.out.println("vvvvv");
  }
/**
 *
 *
 *
 *
 */
}
