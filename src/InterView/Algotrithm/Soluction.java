package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Soluction {
	 public static void main(String[] args) {

//	        ArrayList<Integer> inputs = new ArrayList<Integer>();
//	        Scanner in = new Scanner(System.in);
//	        String line = in.nextLine();
//	        if(line != null && !line.isEmpty()) {
//	            int res = resolve(line.trim());
//	            System.out.println(String.valueOf(res));
//	        }
	        System.out.println("1 1 + 2 ^ *".trim());
	      String[] ss=  "1 1 + 2 ^ *".split(" ");
	       System.out.println("vvv");
	        int res = resolve("11+2^*");
	    }

	    // write your code here
	    public static int resolve(String expr) {
	    	if(expr==null){
	    		return 0;
	    	}
	    	char exprArray []=expr.toCharArray();
	    	Stack<Integer> stak=new Stack();
	    	for(int i=0;i<expr.length();i++){
	    		if(exprArray[i]>'0'&&exprArray[i]<'9'){
	    			stak.push(exprArray[i]-'0');
	    		}
	    		else{
	    			switch(exprArray[i]){
	    			case '^':
	    				if(stak.isEmpty()){
	    					return -1;
	    				}
	    				else
	    				{
	    					int temp=stak.pop();
	    					stak.push(temp+1);
	    				}
	    				break;
	    			case '+':
	    		        if(stak.size()>=2){
	    		        	int temp1=stak.pop();
	    		        	int temp2=stak.pop();
	    		        	stak.push(temp1+temp2);
	    		        }
	    		        else{
	    		        	return -1;
	    		        }
	    		        break;
	    			case '*':
	    				if(stak.size()>=2){
	    		        	int temp1=stak.pop();
	    		        	int temp2=stak.pop();
	    		        	stak.push(temp1*temp2);
	    		        }
	    		        else{
	    		        	return -1;
	    		        }
	    				break;
	    			}
	    		}
	    		
	    	}
			return stak.peek();
	       
	    }
}
