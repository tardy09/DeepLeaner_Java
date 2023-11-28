package LeeCode.whetherIsCircleOfNodeList;

/**
 * Created by Administrator on 2016/12/8.
 *
 * http://blog.csdn.net/guyuealian/article/details/51119499
 */
public class ReverseNodeLinst {
    /**
     * head-->Node1-->Node2-->Node3-->Node4-->null
     *         head   next1    next2   next3
     * null<--Node1---Node2<--Node3--Node4<--reverseHead
     *  假若从Nod4开始反转：
     *  step1:直接让reverseHead=Node4
     *  head-->Node1-->Node2-->Node3-->Node4<--reverseHead
     *         head   next1    next2   next3
     *  step2：修改指针引用  Node3而言：对于此时实际意义上：head=next2 next=next3
     *  要让next3指向Node3,Node3的next指向null
     *  head-->Node1-->Node2-->Node3<--Node4<--reverseHead
     *         head   next1    next2   next3
     *  head.getNext也就是next3,
     * reverSe
     * 在单链表里面，前一个节点的指针域指向当前节点--head
     * 当前节点的指针域指向下一个节点 --next
     * 方案1，递归转法，在反转当前的节点前，。。层层往前
     * @param head
     * @return
     */
    public static Node Reverse1(Node head){
        if(head==null||head.getNext()==null){
            return head;//如果为空链表或者是链表的末尾的话直接返回
        }

       Node reverseHead=  Reverse1(head.getNext());//先对后继节点进行反转
        //然后修改指针引用
        head.getNext().setNext(head);//将当前结点的指针域指向前一结点
        head.setNext(null);//前一个节点的指针域为空..
        return reverseHead;
    }
    public static void main(String [] args){
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse1(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

}
/**
 * 要实现单链表存储，首先是创建一结点类
 */
class Node {
    private int Data;// 数据域
    private Node Next;// 指针域

    public Node(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node Next) {
        this.Next = Next;
    }
}
