package InterView.Algotrithm;

public class FindTheUniqueNUmber {
   public int getTheSingleNumber(int [] arr){
	   if(arr==null||arr.length==1){
		   return -1;
	   }
	   int lostNum=0;
	   for(int i=0;i<arr.length;i++){
		  lostNum^=arr[i];
	   }
	   return  lostNum;
   }
   public int getTheSpecialNumber(int [] arr){
	   if(arr==null||arr.length==1){
		   return -1;
	   }
	   //Ѱ�ҷָ��
	   int diveIndex=0;
	   for(int i=0;i<arr.length;i++){
		   diveIndex^=arr[i];   
	   }
	   //����divideIndexΪ��������
	   
	   
	   return 0;
	   
   }
}
