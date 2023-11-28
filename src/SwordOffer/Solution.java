package SwordOffer;
/**
 * Created by Administrator on 2016/12/6.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {
    /**
     *   .不影响字符串长度
     *   *可以动态变
     *   @param str
     *   @param pattern
     *   @return
     */
    public boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null)
        {

            return false;
        }
        return mathCore(str,0,pattern,0);
    }
    /**
     *  主要分析两类情况：
     *  1.当模式串的下一个字符不是*的情况
     *    a.如果模式串的当前字符和字串的当前字符相匹配，那么字符串和模式串都
     *    相互向后面后移动一个位置
     *    b.反之如果不匹配，直接返回false
     *     模式当前第二个字符不是*，那么判断字符串当前字符和模式当前字符是否相等或者模式当前字符为.，
     *     如果符合这两种情况则递归匹配下一个字符。如果不符合则返回false
     *    (例如：
     *  2.如果模式串的下一个字符是*的情况
     *     a.如果字符串的当前位置和模式串的当前位置不匹配，那么，模式串后移动两个位置
     *     继续进行匹配，(例如：acd           b*acd)
     *     b.反之，分成三种;
     *       1.模式后移动两个位置，进行匹配  ---》 (例如：ab     a*b）
     *            pttern当前字符能匹配 str 中的 0 个字符
     *       2.字符串后移动1个字符,模式后移动两个字符，匹配（例如：abb a*b）
     *            pttern当前字符能匹配 str 中的 1 个字符
     *       3.字符串后移动一个字符，模式不变，即就是继续匹配下一个字符，因为*可以匹配多位
     *                    aaa  a*
     * @param str
     * @param sindex
     * @param pattern
     * @param pindex
     * @return
     */
    private boolean mathCore(char[] str, int sindex, char[] pattern, int pindex) {
        if(sindex==str.length&&pindex==pattern.length){
            return true;
        }
        if(sindex!=str.length&&pindex==pattern.length){
            //如果模式串已经匹配完，而子串还是没完，匹配失败
            return false;
        }
        //模式第二个为*
        if(pindex+1<pattern.length&&pattern[pindex+1]=='*'){
            if(sindex!=str.length&&pattern[pindex]==str[sindex]||
                    pattern[pindex]=='.'&&sindex!=str.length){
                return mathCore(str,sindex,pattern,pindex+2)||
                        mathCore(str,sindex+1,pattern,pindex+2)||
                        mathCore(str,sindex+1,pattern,pindex);
            }
            else {
                return   mathCore(str,sindex,pattern,pindex+2);
            }
        }
        //模式第二个不为*
        if(sindex!=str.length&&str[sindex]==pattern[pindex]||
                pattern[pindex]=='.'&&sindex<str.length){
            return mathCore(str,sindex+1,pattern,pindex+1);
        }

        return false;
    }

    public static void main(String [] args){
        String s="acd";
        String ggg="b*acd";
        char str[]=s.toCharArray();
        char pa[]=ggg.toCharArray();
        System.out.println(new Solution().match(str,pa));
    }
}
