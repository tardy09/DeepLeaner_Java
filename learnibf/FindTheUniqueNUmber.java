package learnibf;

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
	   //寻找分割点
	   int diveIndex=0;
	   for(int i=0;i<arr.length;i++){
		   diveIndex^=arr[i];   
	   }
	   //其中divideIndex为特殊数据
	   
	   
	   return 0;
	   
   }
}
