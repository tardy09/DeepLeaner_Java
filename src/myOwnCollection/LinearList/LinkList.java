package myOwnCollection.LinearList;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/11/11.
 */
public class LinkList<T> {
    //定义一个内部类Node，Node实例代表链表的节点
    private class  Node
    {
        //保存节点的数据
        private T data;
        private Node next;//保存指向下一个节点的引用
        public Node(){

        }
        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    //保存链表的头结点
    private Node header;
    //保存链表的尾节点
    private Node tail;
    //保存该链表里面已经包含的节点数
    private int size;
    public LinkList(){
        //空链表
        header=null;
        tail=null;
    }
    public LinkList(T element){
        header=new Node(element,null);
        //只有一个节点，header.tail都指向该节点
        tail=header;
        size++;
    }
    public int length(){
        return size;
    }
    //获取链表里面索引为index的元素
    public T get(int index){
        return getNodeByIndex(index).data;
    }
    private Node getNodeByIndex(int index){
        if (index<0||index>size-1){
            throw new IndexOutOfBoundsException("越界");
        }
        Node current=header;
        for(int i=0;i<size&&current!=null;i++,current=current.next){
            if(i==index){
                return current;
            }
        }
        return null;
    }
    //查找链表处指定元素的索引
    public int locate(T element) {
        Node current = header;
        for (int i = 0; i < size && current != null; current = current.next) {
            if (current.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }
    //向线性链表的指定位置插入元素
    public void insert(T element ,int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("越界");
        }
        if(header==null){
            add(element);
        }
        else {
            if(index==0){
                addAtHeader(element);
            }
            else {
                //获取插入点的前一个节点
                Node prev=getNodeByIndex(index-1);
                prev.next=new Node(element,prev.next);
                size++;
            }
        }
    }
    //采用头插法建立单链表
    public void addAtHeader(T element){
        //创建新的节点，是的新的节点
        header=new Node(element,header);
        //如果插入之前是空链表
        if(tail==null){
            tail=header;
        }
        size++;
    }
    //尾插法建立单链表
    public void add(T element){
        if(header==null){
            //空链表
            header=new Node(element,null);
            //只有一个节点那么tail和header都指向该节点
            tail=header;
        }
        else {
            //创建新的节点
            Node newNode=new Node(element,null);
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public T delete(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException();
        }
        Node del=null;
        if(index==0){
            del=header;
            header=header.next;
        }
        else {
            //获取删除节点的上一个节点
            Node prev=getNodeByIndex(index-1);
            del=prev.next;
            prev.next=del.next;
            del.next=null;
        }
        size--;
        return del.data;
    }
    //删除链式线性表的最后一个元素
    public T remove(){
        return  delete(size-1);
    }
    public  boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        //将header和 tail置空
        header=null;
        tail=null;
        size=0;
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        else {
            StringBuilder stringBuilder=new StringBuilder();
            for(Node current=header;current!=null;current=current.next){
                stringBuilder.append(current.data.toString()+", ");
            }
            int len=stringBuilder.length();
            //去掉后面的“，”
            return stringBuilder.delete(len-2,len).append("]").toString();
        }
    }
}

