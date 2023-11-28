package myOwnCollection.LinearList;
/**
 * Created by Administrator on 2016/11/11.
 *
 * 链栈 空间利用效率相对顺序栈要高
 */
public class LinkStack<T> {
    //  进栈----让top引用指向新添加的元素，新的元素的next引用指向原来的栈顶元素
    //让记录栈内元素的个数加1
    //出栈 让top指向原来栈顶元素的下一个元素，并释放原来的栈顶元素
    //让记录栈内元素的size-1
    private class Node{
        //定义内部节点--代表链栈的节点
        private T data;
        private Node next;
        public Node(){

        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node top;
    private int size;
    public LinkStack(){
        top=null;
        //空的链栈，top=null
    }
    public LinkStack(T element){
        top=new Node(element,null);
        size++;
    }
    public int length(){
        return size;
    }
    public void push(T element){
        //让top指向新建的元素，新元素的next指向原来的栈顶元素
        top=new Node(element,top);
        size++;
    }
    public T pop(){
        Node oldTop=top;
        //让top指向top的下一个元素
        top=top.next;
        //释放原来栈顶元素的next引用
        oldTop.next=null;
        size--;
        return oldTop.data;
    }
    public T peek(){
        //访问栈顶元素
        return top.data;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void clear(){
        top=null;size=0;
    }

    @Override
    public String toString() {

        if(isEmpty()){
            return "[]";
        }
        else {
            StringBuilder stringBuilder=new StringBuilder("[");
            for (Node current=top;current!=null;current=current.next){
                stringBuilder.append(current.data.toString()+", ");
            }
            int len=stringBuilder.length();
            return stringBuilder.delete(len-2,len).append("]").toString();
        }
    }
}

