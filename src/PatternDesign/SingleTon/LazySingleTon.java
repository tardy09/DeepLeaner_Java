package PatternDesign.SingleTon;

/**
 * Created by Administrator on 2016/11/18.
 */
public class LazySingleTon {
    private static LazySingleTon lazySingleTon=null;

    private LazySingleTon() {

    }
  //懒汉式 延迟加载--需要时候产生
    public  synchronized static LazySingleTon getLazySingleTon() {
       if(lazySingleTon==null){
           lazySingleTon=new LazySingleTon();
       }
       return lazySingleTon;
    }
}
