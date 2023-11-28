package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/4/20.
 */
public class FindKthToTaiSoluction {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
          if(head==null||k<=0){
              return null;
          }
          ListNode fast=head;
          ListNode slow=head;
          //快速指针 先走上k步
        for (int i = 0; i <k-1 ; i++) {
            fast=fast.next;
            if(fast==null){
                return null;
            }
        }
           fast=fast.next;
        //然后快慢指针一起走
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public  static  void main(String [] args){
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        ListNode listNode6=new ListNode(6);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        /**
         *    1--2--3--4--5--6
         *    1 2   3  4  5  6  倒数第1 ----6   倒数第2---5    长度为n的单链表  倒数第k个
         *                       正数第6        正数第5        等价于正数第n-k+1个
         *
         *                       可以考虑 快慢指针的思想 让 快指针 先走 k－１步 然后 快慢指针一起走 等到快指针 走到了链表
         *                       的末尾的时候 ，接着慢速度指针 也刚好落后于慢速度指针 k＋１步也就是 倒数第k个元素
         *
          */
    }

}