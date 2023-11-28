package InterView.Algotrithm;

import java.util.ArrayList;

public class GetLeastNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]={4,2,8,3};
  int res=new GetLeastNumbers().anOtherParationFunction(arr,0,3);
   System.out.println();
      
	}
	/**
	 * ����n���������ҳ�������С��K������
	 * ��������4,5,1,6,2,7,3,8��8�����֣�
	 * ����С��4��������1,2,3,4,��
	 * @param input
	 * @param k
	 * @return
	 */
   public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	  int len=input.length;
	  ArrayList<Integer> result=new ArrayList<>();
	  if(input==null||len<k||k<=0){
		  return result;
	  }
	  int index=Paration(input,0,len-1);
//	  if(index==k-1){
//		  for(int i=0;i<=index;i++){
//			  result.add(input[i]);
//		  }
//		  return result;
//	  }
	  //���С�� 3 5
	  int start=0,end=len-1;
	  while(index!=k-1){
		  if(index<k-1){
			     start=index+1;
				 index= Paration(input,start,end);
			  }
			  if(index>k-1){
				  end=index-1;
				 index= Paration(input,start,end);
			  }
	  }
	  if(index==k-1){
		  for(int i=0;i<=index;i++){
			  result.add(input[i]);
		  }
		  return result;
	  }
	   return result;
    }
    /*
     * ��������ķ�������
     * @param input
     * @param i
     * @param j
     * @return
     */
	private int Paration(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		int base=input[start];//��׼�����浽start����
		int i=start;
		int j=end;
        while(i!=j){
        	while(input[j]>=base&&i<j){
        		j--;
        	}
        	while(input[i]<=base&&i<j){
        		i++;
        	}
        	if(i<j){
        		swap(input,i,j);
        	}
        }
        //��׼�����й�λ����
        swap(input,start,j);
		return j;
	}
	/**
	 * 4,2,8,3
	 * ��׼ѡ��4
	 * 2,1,8,4
	 * i=1,j=1  --1  ----2,1,8,4
	 * i=2,j=1  ---  ----2,1,8,4
	 * i=3,j=1 ---------- 
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private int anOtherParationFunction(int [] arr,int start,int end){
		int base=arr[0];
		swap(arr, start, end);//Ŀ����ѡ���һ������Ϊ��׼
		int j=0;//����jʼ��ָ����ڻ�׼������
		for(int i=0;i<end;i++){
			if(arr[i]<base){
				 if(i>j){
					 swap(arr, i, j);
				 }
				j++;//���jʼ��С�����Ļ�׼������ôi,��j����ͬ���������ӵ�
			}
		}
		swap(arr, j, end);
		return j;
		
	}
	private void swap(int[] input, int j, int i) {
		// TODO Auto-generated method stub
		int temp=input[i];
		input[i]=input[j];
		input[j]=temp;
	}
}
