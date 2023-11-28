package InterView.Algotrithm;

import java.util.Scanner;

public class GetK_SmallNum {
   
	public static void main(String [] args){
		//int [] arr={3,2,7,5,1};
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			int [] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
			soluction(arr,k);
			//scanner.close();
		}
		
	}
	public static  void soluction(int []arr,int k){
		int s=arr.length;
		if(s==0||s==1){
			return;
		}
		int index=Paration(arr,0,s-1);
		if(index==k){
			System.out.println(index);
			return;
		}
	    if(index<k){
	    	Paration(arr,index,s-1);
	    }
	    if(index>k){
	    	Paration(arr,0,index);
	    }
	    
	}
	
	private static int Paration(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
	    int base=start;
	  //  swap(arr[start], arr[end]);
	    int i=end,j=end;
	    //j����ָ��Ȼ�׼��С������
	    //�����ǰ�����Ȼ�׼��С ��ôi,j����ͬ�����м�С�ģ�����j����
	    for(;i>=start;i--){
	    	if(arr[i]>=arr[base]){
	    		if(i!=j)
	    		{
	    			//j�Ѿ�ָ��Ȼ�׼�����ִ��������
	    			//�����ǰ�����ֱȻ�׼����С
	    			swap(arr,i,j);
	    		}
	    	  j--;
	    	}
	    }
	    swap(arr,base, arr[j]);
		return j;
	}
	private static void swap(int arr[],int base, int i) {
		// TODO Auto-generated method stub
		int temp=arr[base];
		arr[base]=arr[i];
		arr[i]=temp;
	}
}
