package learnibf;

public class QuickSort {
	/**
	 *  重点分析 最好 最差的情况
	 *   
	 * @param arr ={2,6,1,7,9,4,5}
	 */
  public void  quickSort(int[] arr){
	  //不断的进行调整 直到整个数组都有序为止，
	  //随机的选定一个基准参考数，然后 每一趟 完成之后 ，将大于这个数的和小于这个数的
	  //各放置在该数的一边 
	  paration(arr,0,arr.length-1);
  }
  private void paration(int []arr,int left,int right){
	  if(left>right){
		  return ;
	  }
	  int base=arr[left];//例如选择第一个数字为基准数
	  //经过一趟排序将基准数字放到它理想排序后正确的位置就好
	  int i=left;
	  int j=right;
	  while(i!=j){
		  //找到第一个比基准数字小的数字
		  while(arr[j]>=base&&i<j){
			  j--;
		  }
		  while(arr[i]<=base&&i<j){
			  i++;//找到第一个比基准数字大的数字
		  }
		  if(i<j){
			  int temp=arr[i];
			  arr[i]=arr[j];
			  arr[j]=temp;
		  }
		  
	  }
	//基准数归位
	  arr[left]=arr[i];
	  arr[i]=base;
	  paration(arr,left,i-1);
	  paration(arr, i+1, right);
  }
  public static void main(String [] args){
	  int arr[]={2,6,1,7,9,4,5};
	  QuickSort quickSort=new QuickSort();
	  quickSort.quickSort(arr);
	  System.out.println(".....");
  }
}
