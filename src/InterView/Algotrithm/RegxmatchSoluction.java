package InterView.Algotrithm;

public class RegxmatchSoluction {
        /**
         * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
         * 模式中的字符'.'表示任意一个字符，
         * 而'*'表示它前面的字符可以出现任意次（包含0次）。 
         * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，
         * 字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
         * a*
         * .aa
         * 但是与"aa.a"和"ab*a"均不匹配
         * @param str
         * @param pattern
         * @return
         */
	    public boolean match(char[] str,char[] pattern)
	    {
	       if(str==null||pattern==null){
	    	   return false;
	       }
	           int strIndex = 0;
	    	   int patternIndex = 0;
	    	  return matchCore(str, strIndex, pattern, patternIndex);
	    }
		private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) 
		{
			// TODO Auto-generated method stub
			if(strIndex==str.length&&patternIndex==pattern.length){
				return true;
			}
			//原本的字符串已经走完了 模式串 还没有走完
			if(strIndex!=str.length&&patternIndex==pattern.length)
			{
				return false;
			}
			//模式串第二个是*
			if(patternIndex+1<pattern.length&&
					pattern[patternIndex+1]=='*')
			{
					//第一个匹配
				  if ((strIndex != str.length &&
							pattern[patternIndex] == str[strIndex]) || 
							(pattern[patternIndex] == '.' && strIndex != str.length)) 
					{
						//第一个匹配的情况下
					   /**
					    * aa
					    * a*
					    * 分析情况 
					    * 1. 可能匹配一个 
					    *     str:     ac
					    *     pattern: a*c matchCore(str, strIndex+1, pattern, patternIndex+2);
					    * 2.可能匹配0个
					    *     str:     ax
					    *     pattern: .*ax -->matchCore(str, strIndex, pattern, patternIndex+2); 
					    * 3.    
					    */
					  return matchCore(str, strIndex+1, pattern, patternIndex+2)||
							  matchCore(str, strIndex, pattern, patternIndex+2)||
							  matchCore(str, strIndex+1, pattern, patternIndex);
					}
					else
					{
						return matchCore(str, strIndex, pattern, patternIndex+2); 
					}
					     
			}
				
			   //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
	if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || 
			(pattern[patternIndex] == '.' && strIndex != str.length)) 
	{			
		return matchCore(str, strIndex+1, pattern, patternIndex+1);
	}
	return false;
  }		
		public static void main(String [] args){
			char [] str={'a','a'};
			char [] ptr={'a','*'};
			new RegxmatchSoluction().match(str, ptr);
		}
}

