package learnibf;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassiFyTheIp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        int [] res=new int[7];
        while(scanner.hasNext()){
        	String input=scanner.nextLine();
        	int spiltIndex=input.indexOf('~');
        	String ip=input.substring(0, spiltIndex);
        	String hiddenCode=input.substring(spiltIndex+1);
            if(!isValidIP(ip)){
            	res[5]+=1;
            }
            if(!isValidCode(hiddenCode)){
            	res[5]+=1;
            }
            String []  ipStr=ip.split("\\.");
            int fsn=Integer.valueOf(ipStr[0]);
            
	       if(fsn>=1&&fsn<=126)			
	       {
	    	   res[0]+=1;
	       }
	       if(fsn>=128&&fsn<=191){
	    	   res[1]+=1;
	       }
	       if(fsn>=192&&fsn<=223){
	    	   res[2]+=1;
	       }
	       if(fsn>=224&&fsn<=239){
	    	   res[3]+=1;
	       }
	       if(fsn>=240&&fsn<=255){
	    	   res[4]+=1;
	       }
	      
	    	// 判断是否是私网IP
	   String ipSubStr = ip.substring(ip.indexOf(".") + 1);
	   String snStr = ipSubStr.substring(0, ipSubStr.indexOf("."));
	   int sn = Integer.valueOf(snStr);
	   if (fsn == 10 || (fsn == 172 && sn >= 16 && sn <= 31) || (fsn == 192 && sn == 168)) 
	   {
		   res[6]++;
	   }
	   
        }
        scanner.close();
        for(int i=0;i<7;i++){
 		   System.out.print(res[i]+" ");
 	   }
         
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
    public static boolean isValidCode(String s){
    	String []  res=s.split("\\.");
    	for(int i=0;i<4;i++){
    		int  nu=Integer.valueOf(res[i]);
    		if(nu==255){
    			continue;
    		}
    	    //找到code的最后一位不为0的位置
    		int index=0;
    		int flag=1;
    		while(flag<=128){
    			
    			if((nu&flag)!=0){
    				//index++; //
    				break;
    			}
    			flag<<=1;
    			index++;
    		}
    		flag*=2;
    		while(index<8&&flag<=128){
    			if((nu&flag)==0){
    				return false;
    			}
    			index++;
    			flag<<=1;
    		}
    	}
		return true;
    	
    	
    }
    /**
     * 判断ip是否合法
     * @param ss
     * @return
     */
    public static boolean isValidIP(String ss){
    	 String []  res=ss.split("\\.");
    	 if(ss.length()<4){
    		 return false;
    	 }
    	 for(int i=0;i<4;i++){
    		 String temp=res[i];
    		 if(temp==null||temp.equals("")){
    			 return false;
    		 }
    		 else
    		 {
    			 if(Integer.valueOf(temp)>255){
    				 return false;
    			 }
    		 }
    	 }
    	return true;
    }
}
