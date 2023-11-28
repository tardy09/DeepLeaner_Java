package myOwnCollection.LinearList;

import com.sun.javaws.jnl.InstallerDesc;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/11.
 *
 *   为了避免队列的假满现象，可以将顺序队列改成循环队列，循环队列就是首部和尾部
 *   相互连接的队列，当front、rear变量到达数组的capacity-1之后，再次前进一步就自动变成0
 */
public class LoopQuene<T> {
    private int DAFAULT_SIZE=10;
    private int capacity;
    private Object[] elementData;
    private int front=0;
    private int rear=0;
    public LoopQuene(){
        capacity=DAFAULT_SIZE;
        elementData=new Object[capacity];
    }
    public LoopQuene(T element){
        this();
        elementData[0]=element;
        rear++;
    }
    public LoopQuene(T element,int initSize){
        this.capacity=initSize;
        elementData=new Object[capacity];
        elementData[0]=element;
        rear++;
    }
    public int length(){
        if(isEmpty()){
            return 0;
        }
        return rear>front? rear-front:capacity-(front-rear);
    }
    public boolean isEmpty(){
        return rear==front&&elementData[rear]==null;
    }
    public void add(T element){
        if(rear==front&&elementData[front]!=null){
            throw new IndexOutOfBoundsException("队列已满");
        }
        elementData[rear++]=element;
        rear=rear==capacity?0:rear;
    }
    public T remove(){
        //移除队列
        if(isEmpty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        T oldValue= (T) elementData[front];
        elementData[front++]=null;
        front=front==capacity?0:front;
        return oldValue;
    }
    public T element(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elementData[front];
    }
    public void clear(){
        Arrays.fill(elementData,null);
        front=0;
        rear=0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        else {

            if (front < rear) {
                //如果front<rear，有效元素就是front到rear之间的元素
                StringBuilder stringBuilder = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    stringBuilder.append(elementData[i].toString() + ", ");
                }
                int len = stringBuilder.length();
                return stringBuilder.delete(len - 2, len).append("]").toString();
            }
            /**
             * 如果font大于rear则有效元素为front到capacity，0到font之间的元素
             */
            else
            {
                StringBuilder stringBuilder = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    stringBuilder.append(elementData[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    stringBuilder.append(elementData[i] + ", ");
                }
                int len = stringBuilder.length();
                return   stringBuilder.delete(len - 2, len).append("]").toString();
            }
        }

    }
}
