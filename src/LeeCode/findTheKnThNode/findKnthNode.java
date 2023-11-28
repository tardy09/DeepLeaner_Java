package LeeCode.findTheKnThNode;

/**
 * Created by Administrator on 2016/11/30.
 */
public class findKnthNode {

    public LinkedListNode get_Last_nTheListNode(LinkedListNode head,int k){
        if(k<=0) return null;
        LinkedListNode p1=head;//慢指针
        LinkedListNode p2=head;//快指针
        //p2向前移动 k个节点---使得两个指针相互距离为k
        for (int i = 0; i <k-1 ; i++) {
            if(p2==null) return null;
            p2=p2.next;
        }
        if(p2==null) return null;
        /**
         *  现在两个指针按照相同的速度前进，移动p1和p2,当p2到达链表结尾的
         *  时候，p1刚好指向第k个节点
         */
        while (p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    class LinkedListNode<T>{
        private T data;
        private LinkedListNode next;
        public LinkedListNode(){

        }
        public LinkedListNode(T data,LinkedListNode next){
            this.data=data;
            this.next=next;
        }
    }
}


