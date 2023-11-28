package PatternDesign.SingleTon;

/**
 * Created by Administrator on 2016/11/18.
 */
public  class HangrySingleTon {
    private static final HangrySingleTon hangrySingleTon=new HangrySingleTon();
    private HangrySingleTon(){

    }
    //饿汉式单例--线程安全的
    public  static HangrySingleTon getHangrySingleTon(){
        return hangrySingleTon;
    }
    //类里面的其他方法，尽量是static
    public static void doSomething(){

    }
}
