package myOwnCollection.LinearList;

import java.util.Arrays;
/**
 * Created by Administrator on 2016/11/11.
 * 基于数组实现的简单的线性表  不是线程安全的，在多线程下肯能遇到线程安全问题
 */
public class SequenceList<T> {
    private int DEFAULT_SIZE = 16;
    private int capacity;
    //定义一个数组来保存顺序线性表的元素
    private Object[] elementData;
    private int size = 0;//当前的元素的个数

    public SequenceList() {
        capacity = DEFAULT_SIZE;
        //size=0;
        elementData = new Object[capacity];
    }

    //通过一个初始化元素来创建顺序表
    public SequenceList(T element) {
        this();
        elementData[0] = element;
        size++;
    }
    /**
     * 通过指定的长度来创建顺序线性表
     *
     * @param element
     * @param inisize
     */
    public SequenceList(T element, int inisize) {
        //
        capacity = 1;
        while (capacity < inisize) { //左移 使得capacity为大于inisize的最小的2次幂
            capacity <<= 1;
        }
        elementData = new Object[capacity];
        elementData[0] = element;
        size++;
    }

    public int length() {
        return size;
    }
    /**
     * 获取索引为i的元素
     *
     * @param i
     * @return
     */
    public T get(int i) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        return (T) elementData[i];
    }
    //查找顺序表里面 指定元素处的索引
    public int locate(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    //
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        enSureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }
    public void enSureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            //如果目前所需要的长度大于数组的原有的长度
            while (capacity < minCapacity) {
                capacity <<= 1;
            }
            elementData = Arrays.copyOf(elementData, capacity);
        }
    }

    public T delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        T oldValue = (T) elementData[index];
        int numberMoved = size - index - 1;
        if (numberMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numberMoved);
        }
        //注意释放内存
        elementData[--size] = null;
        return oldValue;
    }
    //删除线性表最后的一个元素
    public T remove(){
        return delete(size-1);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void  clear(){
        Arrays.fill(elementData,null);
        size=0;
    }
    public String toString(){
        if(size==0){
            return "[]";
        }else {
            StringBuilder str=new StringBuilder();
            for(int i=0;i<size;i++){
                str.append(elementData[i].toString()+",");
            }
            int len=str.length();
            return str.delete(len-2,len).append("]").toString();
        }
    }
}