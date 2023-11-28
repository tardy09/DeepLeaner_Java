package InterView.Algotrithm;

public class minNumberInRotateArraySolucion {
	/**
	 * 
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
                 ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
                ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
         5,1,2,3,4 
         index=2----2 ��������
               ��ô��Ҫ��(0,2)֮����в���  index=1----1
               ���� ���� 1,2,3,4,5,6���ԣ� 
         4,5,6,1,2,3
         index=2  ---6    ǰ�߱���С ��߱���С +1���ǽ��
         
         5��6��1,2,3,4     ---
                  �յ�Ϊ 1��ǰһ�������� ��߱�����---
         index=2    ---��Ӧ�յ�Ϊ1  �� arr[index]<arr[index+1]
            Ӧ������߲���     ��С�����ֿ϶���������������������
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
		//���� �ǵݼ����� ��ת֮�󣬿϶�����ֹյ�  Ҳ���������� ���� �ٴ������С
		int  resultIndex=0;
		if(array[left]<array[right]){
		   return  array[0];
		}
		//��СֵҪô�������м�Ҫô����������
		//����left  ָ��---��ǰ����������һ��Ԫ�� 
		//����right ָ��---���������еĵ�һ��Ԫ��
		//���ڶ���ָ��ָ��ĸպ�����С��Ԫ�أ������ѭ���Ľ���������
		while(left<right){
			int middle=(left+right)>>1;
		    if(left+1>=right){
		    	break;
		    }
		    if(array[middle]>array[0]){
		    	//�м�� ��ǰ��ĵ�����������
		    	left=middle;
		    }
		    else{
		    	//�м���ں����������������
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
