package myOwnCollection.LinearList;

/**
 * Created by Administrator on 2016/11/11.
 */
public class DuLinkList<T> {
    private class Node{
        private T data;
        private Node prev;
        private Node next;
        public Node(){

        }

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }
    //保存头结点
    private Node header;
    private Node tail;
    private int size;

    public DuLinkList(){
        header=null;
        tail=null;
    }
    public DuLinkList(T element){
        header=new Node(element,null,null);
        tail=header;
        size++;
    }
    public int length(){
        return size;
    }
    public T get(int index){
        return getNodeByIndex(index).data;
    }
    public Node getNodeByIndex(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException();
        }
        if(index<size>>1){
            //从header节点开始
            Node current=header;
            for(int i=0;i<size/2&&current!=null;i++,current=current.next){
                if(i==index){
                    return current;
                }
            }
        }else {
            //从tail节点开始查找
            Node current=tail;
            for(int i=size-1;i>size/2&&current!=null;current=current.next,i++){
                if(i==index){
                    return current;
                }
            }
        }
        return null;
    }
    public int locate(T element){
        //查找双向链表指定位置处的索引
        Node current=header;
        for(int i=0;i<size&&current!=null;current=current.next,i++){
            if(current.data.equals(element)){
                return i;
            }
        }
        return -1;//没有找到
    }
    //向线性链表的指定位置插入元素
    public void insert(T element,int index){
        if(index<0||index>size-1){
            throw  new IndexOutOfBoundsException();
        }
        if(header==null){
            //空的链表
            add(element);//尾插法建立表
        }
        else {
            if(index==0){
                addAtHeader(element);
            }
            else {
                Node prev=getNodeByIndex(index-1);
                Node next=prev.next;
                Node newNode=new Node(element,prev,next);
                prev.next=newNode;
                next.prev=newNode;
                size++;
            }
        }
    }
    //利用尾插法 为链表插入节点
    public void  add(T element){
        if(header==null){
            header=new Node(element,null,null);
            tail=header;
            //size++;
        }
        else
        {
            //创建新的节点，新的节点的prev指向原来tail节点
            Node newNode=new Node(element,tail,null);
            //让尾节点的next指向新增的节点
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public void addAtHeader(T elememt){
        //创建新的节点，让新的节点的next指向原来的header
        //并以新的节点作为新的header  --注意头结点 没有前驱
        header=new Node(elememt,null,header);
        if(tail==null){
            tail=header;
        }
        size++;
    }
    //删除链表里面指定位置处的元素
    public T delete(int index){
        if(index<0||index>size-1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node del=null;
        if(index==0){
            del=header;
            header=header.next;
            //手动释放header的prev引用 ，防止内存泄露
            header.prev=null;
        }
        //header.prev=null;
        else
        {
            //获取删除节点的前向节点
            Node prev=getNodeByIndex(index-1);
            del=prev.next;
            prev.next=del.next;
            if(del.next!=null){

                del.next.prev=prev;
            }
            //手动将要删除节点的前向和后向引用记为空
            del.prev=null;
            del.next=null;
        }
        size--;
        return del.data;
    }
    //删除链式线性表的最后一个元素
    public T remove(){
        return delete(size-1);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        header=null;
        tail=null;
        size=0;
    }

    @Override
    public String toString() {
        if(size==0){
            return "[]";
        }else {
            StringBuilder str=new StringBuilder();
            for(Node current=header;current!=null;current=current.next){
                str.append(current.data.toString()+", ");
            }
            int len=str.length();
            return str.delete(len-2,len).append("]").toString();
        }
    }
}

