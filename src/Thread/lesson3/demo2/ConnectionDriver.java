package Thread.lesson3.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ConnectionDriver {
    /**
     * 使用动态代理 获得一个Connection对象
     * 该Connection代理的实现仅仅是在commit()方法
     * 调用时候休眠100ms
     */
    static class ConnnectionHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){
                TimeUnit.SECONDS.sleep(100);
            }
            return null;
        }
    }
    //创建一个Connnection的代理，在commit时候休眠100ms
    public static  final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class<?>[]{Connection.class},
                new ConnnectionHandler());
    }
}
