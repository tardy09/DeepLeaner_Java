package InterView.Algotrithm;

public class LeftRotateStringSoluction {
    /**
     * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
     * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
     * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
     * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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
