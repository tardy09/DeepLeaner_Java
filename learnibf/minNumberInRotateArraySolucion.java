package learnibf;

public class minNumberInRotateArraySolucion {
	/**
	 * 
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
                 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
                例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
         5,1,2,3,4 
         index=2----2 增长区间
               那么需要在(0,2)之间进行查找  index=1----1
               或者 对于 1,2,3,4,5,6而言： 
         4,5,6,1,2,3
         index=2  ---6    前边比它小 后边比他小 +1就是结果
         
         5，6，1,2,3,4     ---
                  拐点为 1，前一个比它大 后边比他大---
         index=2    ---对应拐点为1  且 arr[index]<arr[index+1]
            应该在左边查找     最小的数字肯定是落在了增长区间里面
	 * @param array
	 * @return
	 */
	 public int minNumberInRotateArray(int [] array) 
	 {
		int s=array.length;
		int left=0;
		int right=s-1;
		if(s==0){
			return 0;
		}
		if(s==1){
			return  array[0];
		}	
		//分析 非递减序列 旋转之后，肯定会出现拐点  也就是先整体 增大 再次整体减小
		int  resultIndex=0;
		if(array[left]<array[right]){
		   return  array[0];
		}
		//最小值要么出现在中间要么出现在两边
		//最终left  指向---向前面数组的最后一个元素 
		//最终right 指向---后面数组中的第一个元素
		//而第二个指针指向的刚好是最小的元素，这就是循环的结束条件。
		while(left<right){
			int middle=(left+right)>>1;
		    if(left+1>=right){
		    	break;
		    }
		    if(array[middle]>array[0]){
		    	//中间点 在前面的递增序列里面
		    	left=middle;
		    }
		    else{
		    	//中间点在后面的自增序列里面
		    	right=middle;
		    }	
		}
		resultIndex=right;
		return array[resultIndex];
	 }
	 public static  void main(String [] args){
		 int arr[]={};
	 }
   
}
