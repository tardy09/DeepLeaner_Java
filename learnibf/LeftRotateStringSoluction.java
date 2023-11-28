package learnibf;

public class LeftRotateStringSoluction {
    /**
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
     * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
     * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * S=abcXYZdef n=3 --> XYZdefabc
     * A=abc
     * B=XYZdef
     * 1.fedZYXcba
     * 
     * 2.XYZdefabc
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
    	int s=str.length();
    	if(s==0||s==1||n<=0){
    		return str;
    	}
    	n%=s;
        str= inverString(str,0,s-1);
        str=inverString(str,n+1,s-1);
        str=inverString(str,0,n-1);
        
        return str;
    }

	private String inverString(String str, int start, int end) {
		// TODO Auto-generated method stub
		if(str==null||str.length()==1){
			return str;
		}
		
		char [] strArray=str.toCharArray();
		while(start<end){
			char temp=strArray[start];
			strArray[start++]=strArray[end];
			strArray[end--]=temp;
		}
		str=new String(strArray);
		return str;
	}
	public static void main(String [] args){
		String ss="abcdefg";
		new LeftRotateStringSoluction().LeftRotateString(ss, 2);
	}
}
