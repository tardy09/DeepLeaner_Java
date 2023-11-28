package InterView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/2/27.
 *
 *  弱引用具有很大的不确定性，而；垃圾回收机制，通常
 *  又不受程序员控制
 */
public class WeakReferenceTest {
    public static void main(String [] args){
        String string = new String("ahhaahah");
        //创建弱引用对象，让弱引用对象  引用到string
        WeakReference<String> weakReference=new WeakReference<String>(string);
        string=null;//切断string和字符串对象之间的引用
        System.out.println(weakReference.get());//取出弱引用所引用的对象
        System.gc();//强制进行垃圾回收
        System.runFinalization();
        System.out.println(weakReference.get());//再次取出弱引用所引用的对象
    }
}
