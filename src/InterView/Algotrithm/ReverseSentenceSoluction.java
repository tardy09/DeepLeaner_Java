package InterView.Algotrithm;

public class ReverseSentenceSoluction {

	public static void main(String [] args){
	
		String test=" ";
	String ss=	new ReverseSentenceSoluction().ReverseSentence(test);
	System.out.println(ss);
	}
	/**
	 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��
	 * дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ��
	 * ��һ������Fish������������ȴ������������˼�����磬��student. a am I����
	 * I ma a .tneduts
	 * I am a student.
	 * ��������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
	 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
	 * @param str
	 * @return
	 */
     public String ReverseSentence(String str) {
		
		StringBuilder result=new StringBuilder();
		int  len=str.length();
		if(str==null){
			return null;
		}
		if(len==1||len==0){
			return str;
		}
		String temp= ReverStr(str,0,len-1);
		 String [] strArray=temp.split(" ");
		 for(int i=0;i<strArray.length-1;i++){
			 result.append(ReverStr(strArray[i],0,strArray[i].length()-1));
			 result.append(" ");
		 }
		 result.append(ReverStr(strArray[strArray.length-1],0,strArray[strArray.length-1].length()-1));
	     return result.toString();
	  }
     /**
      * 
      * @param str
      * @param start
      * @param end
     * @return 
      */
	private String ReverStr(String str, int start, int end) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=end;i>=start;i--){
			stringBuilder.append(str.charAt(i));
		}
		return stringBuilder.toString();
	}
}
