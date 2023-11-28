package InterView.Algotrithm;

public class PrintUnSameString {
   public void print(String s){
	   if(s==null){
		   return;
	   }
	   char str[]=s.toCharArray();
	   int maxCount=s.length()/5;
	  
	   Character [] newStr=new Character[maxCount];
	   for(int i=4;i<s.length();i+=5){
		   newStr[(i+1)/5-1]=str[i];
	   }
	   for(int i=0;i<maxCount;i++){
		  for(int j=i+1;j<maxCount;j++){
			  if(newStr[j]==newStr[i]){
				  for(int k=j+1;k<maxCount;k++){
					  newStr[k-1]=newStr[k]; 
				  }
				  
				 // newStr[maxCount-1].
				 // maxCount--;
				  
			  }  
		  }  
	   }
      System.out.println("vvvv");
   }
   public static void main(String [] args){
	   String s="cssfs6789s11253d7777d";
	   new PrintUnSameString().print(s);
	   
   }
}
