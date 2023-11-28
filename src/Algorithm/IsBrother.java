package Algorithm;

/**
 * Created by Administrator on 2017/2/27.
 *
 *  变位词，如果两个单词的出现次数一样，出现的顺序一样，则认为这两个字符串是兄弟字符串
 *
 */
public class IsBrother
{
    public static boolean isBrother(String str1,String str2){
        if(str1==null&&str2==null){
            return true;
        }
        else if(str1==null||str2==null){
            return false;
        }
        else
        {
            if(str1.length()!=str2.length()){
                return false;
            }
            int [] index=new int[128];
            for (int i = 0; i <128 ; i++) {
                index[i]=0;
            }

            for(int i=0;i<str1.length();i++){

                ++index[str1.charAt(i)];
                --index[str2.charAt(i)];
            }
            for(int i=0;i<128;i++){
                if(index[i]!=0){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String [] args){
        System.out.println(isBrother("rqhelo","olerqh"));
    }
}
