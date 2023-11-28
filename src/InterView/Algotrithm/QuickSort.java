package InterView.Algotrithm;

public class QuickSort {
	/**
	 *  �ص���� ��� �������
	 *   
	 * @param arr ={2,6,1,7,9,4,5}
	 */
  public void  quickSort(int[] arr){
	  //���ϵĽ��е��� ֱ���������鶼����Ϊֹ��
	  //�����ѡ��һ����׼�ο�����Ȼ�� ÿһ�� ���֮�� ��������������ĺ�С���������
	  //�������ڸ�����һ�� 
	  paration(arr,0,arr.length-1);
  }
  private void paration(int []arr,int left,int right){
	  if(left>right){
		  return ;
	  }
	  int base=arr[left];//����ѡ���һ������Ϊ��׼��
	  //����һ�����򽫻�׼���ַŵ��������������ȷ��λ�þͺ�
	  int i=left;
	  int j=right;
	  while(i!=j){
		  //�ҵ���һ���Ȼ�׼����С������
		  while(arr[j]>=base&&i<j){
			  j--;
		  }
		  while(arr[i]<=base&&i<j){
			  i++;//�ҵ���һ���Ȼ�׼���ִ������
		  }
		  if(i<j){
			  int temp=arr[i];
			  arr[i]=arr[j];
			  arr[j]=temp;
		  }
		  
	  }
	//��׼����λ
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
