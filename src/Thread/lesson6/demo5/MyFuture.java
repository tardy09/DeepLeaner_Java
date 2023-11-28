package Thread.lesson6.demo5;

/**
 * Created by Administrator on 2017/2/24.
 */
public interface MyFuture <V> {
    /**
     * 这个接口的get方法返回真正的结果，如果结果还没有计算完成，get会阻塞直到计算完成，如果调用过程发生异常，则get方法抛出调用过程中的异常
     * @return
     * @throws Exception
     */
    V get() throws Exception ;
}
