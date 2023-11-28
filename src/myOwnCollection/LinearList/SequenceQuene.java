package myOwnCollection.LinearList;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/11.
 *
 *     队列和一般线性表不同的是，队列不支持从中间任意位置访问
 *     元素的方法，只允许在队头删除元素在对尾插入元素
 */
public class SequenceQuene<T> {
    /*
       系统采用一系列地址连续的存储单元来依次存放队列里面从
       rear到front端的元素，程序只需要两个整型变量来记录队列
       front端的元素索引和rear端的元素索引
       队列的font端总是保留队列即将出列的元素的索引
       队列的rear端总是保留队列下一个即将进入队列的元素的索引
       */
    private int DAFAULT_SIZE=10;
    private int capacity;
    private Object[] elementData;
    private int font=0;
    private int rear=0;
    public SequenceQuene(){
        capacity=DAFAULT_SIZE;
        elementData=new Object[capacity];
    }
    public SequenceQuene(T element){
        this();
        elementData[0]=element;
        rear++;
    }
    public SequenceQuene(T element,int inisize){
        this.capacity=inisize;
        elementData=new Object[capacity];
        elementData[0]=element;
        rear++;
    }
    public int length(){
        return rear-font;
    }
    public void add(T elememt){
        if(rear>capacity-1)
        {
            throw  new IndexOutOfBoundsException();
        }
        elementData[rear++]=elememt;
    }
    public boolean empety(){
        return rear==font;
    }
    //移除
    public T remove(){
        if(empety()){
            throw new IndexOutOfBoundsException();
        }
        //保留队列的rear端的元素的值
        T oldValue= (T) elementData[font];
        //释放队首引用
        elementData[font++]=null;
        return oldValue;
    }
    public T element(){
        //返回队首元素但是不移除
        if(empety()){
            throw new IndexOutOfBoundsException();
        }
        return (T) elementData[font];
    }
    public void clear(){
        font=0;
        rear=0;
        Arrays.fill(elementData,null);
    }

    @Override
    public String toString() {

        if(empety()){
            return "[]";
        }
        else {
            StringBuilder stringBuilder=new StringBuilder("[");
            for(int i=font;i<rear;i++){
                stringBuilder.append(elementData[i].toString()+", ");
            }
            int len=stringBuilder.length();
            return stringBuilder.delete(len-2,len).append("]").toString();
        }
    }
}
