package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationSoluction {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char [] test={'a','b','c'};
       ArrayList<String> result=new ArrayList<>();
       getTheFullParation(result, test, 0);
       System.out.println("vvvv");
	}
	/**
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
	 * ���������ַ���abc,
	 * ���ӡ�����ַ�a,b,c����
	 * ���г����������ַ���abc,acb,bac,bca,cab��cba�� 
	 *  ��ʵ���ݹ飬�ݹ����ջ�ظ������ʼ��״̬��
	 * abc
	 * acb
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
		   ArrayList<String> result=new ArrayList<>();
		   if(str==null||str.length()==0){
			   return result;
		   }
		   if(str.length()==1){
			   result.add(str);
			   return result;
		   }
		   //�õ�ȫ����
		   char [] strArray=str.toCharArray();
		   getTheFullParation(result,strArray,0); 
		   //ȥ��
		   Collections.sort(result);
	       return result;
    }
	/**
	 *   aP(bc)=a(bP(C)+cP(b))
	 *   bP(ac)=b(aP(c)+cP(a))
	 *   cP(ab)=c(aP(b)+bP(a))
	 *   
	 * @param result
	 * @param str
	 * @param index
	 * @author zdf
	 * @since 2017
	 */
	private static void getTheFullParation(ArrayList<String> result, char [] strArray,int index) {
		// TODO Auto-generated method stub
		int len=strArray.length;
		if(index>=len-1){
			StringBuilder stringBuilder=new StringBuilder();
			for(int i=0;i<len;i++){
			   stringBuilder.append(strArray[i]);
			}
			result.add(stringBuilder.toString());
			return ;
		}
		for(int i=index;i<len;i++){
			Swap(strArray,index,i);
			getTheFullParation(result,strArray,index+1);
			Swap(strArray,index,i);
		}
	}
	private static void Swap(char[] strArray, int i, int j) {
		// TODO Auto-generated method stub
		char temp=strArray[i];
		strArray[i]=strArray[j];
		strArray[j]=temp;
	} 
}
