package myOwnCollection.LinearList;

import java.util.Arrays;
import java.util.EventListener;

/**
 * Created by Administrator on 2016/11/11.
 */
public class SequenceStack<T> {
    private int DAFAULT_SIZE=10;
    //保存数组的长度
    public int capacity;
    //当定义的数组的容量不足的时候，每次需要增加的数组的长度
    private int capacityIncrement;
    private Object[] elememtData;
    private int size;//当前栈里面元素的个数
    public SequenceStack(){
        capacity=DAFAULT_SIZE;
        elememtData=new Object[capacity];
    }
    //通过一个初始化元素来创建栈
    public SequenceStack(T element){
        this();
        elememtData[0]=element;
        size++;
    }

    /**
     *   通过指定长度的数组来创建顺序栈
     * @param element
     * @param initSize
     */
    public SequenceStack(T element,int initSize){
        this.capacity=initSize;
        elememtData=new Object[capacity];
        elememtData[0]=element;
        size++;
    }
    public SequenceStack(T element,int initSize,int capacityIncrement){
        this.capacity=initSize;
        this.capacityIncrement=capacityIncrement;
        elememtData=new Object[capacity];
        elememtData[0]=element;
        size++;
    }
    //获取顺序栈的大小
    public int size(){
        return size;
    }
    //入栈
    public void push(T elememt){
        ensureCapacity(size+1);
        elememtData[size++]=elememt;
    }
    private void ensureCapacity(int minCapacity){
        if(minCapacity>capacity){
            if(capacityIncrement>0){
                while (capacity<minCapacity){
                    capacity+=capacityIncrement;
                }
            }
            else {
                while (capacity<minCapacity){
                    capacity<<=1;
                }
            }
        }
        elememtData= Arrays.copyOf(elememtData,capacity);
    }
    //出栈
    public T pop(){

        T oldValue= (T) elememtData[size-1];
        //手动释放栈顶元素 ，防止内存泄露
        elememtData[size-1]=null;
        return oldValue;
    }
    public T peek(){
        return (T) elememtData[size-1];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        Arrays.fill(elememtData,null);
        size=0;
    }

    @Override
    public String toString() {
        return "SequenceStack{" +
                "DAFAULT_SIZE=" + DAFAULT_SIZE +
                ", capacity=" + capacity +
                ", capacityIncrement=" + capacityIncrement +
                ", elememtData=" + Arrays.toString(elememtData) +
                ", size=" + size +
                '}';
    }
}
