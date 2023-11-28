package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/3/21.
 *
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 *
 *  当 n=1  ---》1
 *  当n=2  ----》2种
 *  当n>=3的时候
 *    1.第一次如果竖着放，那么则还有f(n-1)种
 *    2.第一次如果横着放在左上角的位置，那么还有f(n-2)种结果-
 *
 *    总计 f(n-1)+f(n-2)
 *
 *
 */
public class RectCoverPoblem {
    public int RectCover(int target) {
        int first=1;
        int second=2;
        int third=0;
        if(target ==1||target ==2){
            return target;
        }
        for(int i=3;i<=target;i++){
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }
}
