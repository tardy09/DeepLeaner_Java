package InterView.Algotrithm;


import java.util.HashSet;
import java.util.Set;

public class DuplicateSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]={2,1,3,1,4};
       int ss[]=new int[5];
       boolean flag=new DuplicateSoluction().duplicate(arr, 5, ss);
	}
	/**
	 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
	 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
	 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}��
	 * ��ô��Ӧ��������ظ�������2����3��
	 * @param numbers
	 * @param length
	 * @param duplication
	 * @return
	 */
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(length==0||numbers==null)  return false;
		Set<Integer>  hashMap=new HashSet();
		for(int i=0;i<length;i++){
			if(hashMap.contains(numbers[i]))
			{
			  duplication[0]=numbers[i];
			  return true;
			}
			else
			{
				hashMap.add(numbers[i]);
			}
		}
		return false;
    }
}
