package myOwnCollection.LinearList;

/**
 * Created by Administrator on 2016/11/11.
 * 由于链式队列采用链表结构来保存队列里面的所有元素，该队列
 * 允许添加无限多个元素数据，因此链式队列没有队列满的概念
 */
public class LinkQuene<T> {
    private class Node{
        private T data;
        private Node next;
        private Node(){

        }
        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    private Node front;
    private Node rear;
    private int size;
    public LinkQuene(){
        //空的链式队列，其中front和rear都是null
        front=null;
        rear=null;
    }
    public LinkQuene(T element){
        front=new Node(element,null);
        rear=front;
        size++;
    }
    public int length(){
        return size;
    }
    public void  add(T element){
        //如果该队列是空队列
        if(front==null){
            front=new Node(element,null);
            rear=front;
        }
        else {
            //创建新的节点
            Node newNode=new Node(element,null);
            //让尾节点的next引用指向新的节点
            rear.next=newNode;
            //以新的节点作为新的尾节点
            rear=newNode;
        }
        size++;
    }

    public T remove(){
        Node oldFront=front;
        front=front.next;
        //释放要删除的节点的引用，避免内存泄露
        oldFront.next=null;
        size--;
        return oldFront.data;
    }
    //删除队列里面最好一个元素
    public T element(){
        return rear.data;
    }
    public void clear(){
        front=null;
        rear=null;
        size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public String toString() {
        if(isEmpty()){
            return "[]";
        }
        else {
            StringBuilder stringBuilder=new StringBuilder("[");
            for(Node current=front;current!=null;current=current.next){
                stringBuilder.append(current.data.toString()+", ");
            }
            int len=stringBuilder.length();
            return stringBuilder.delete(len-2,len).append("]").toString();
        }
    }
}
