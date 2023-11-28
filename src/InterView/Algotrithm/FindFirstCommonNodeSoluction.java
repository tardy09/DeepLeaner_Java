package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/4/17.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNodeSoluction {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode  pNode1=pHead1;
        ListNode  pNode2=pHead2;
        ListNode  preNode1=null;
        ListNode preNode2=null;
        ListNode  pReverseHead1=null;
        ListNode pReverseHead2=null;
        while (pNode1!=null){
            ListNode nextNode=pNode1.next;
            if(nextNode==null){
                pReverseHead1=pNode1;
            }
            pNode1.next=preNode1;
            //更新preNode
            preNode1=pNode1;
            pNode1=nextNode;
        }
        while (pNode2!=null){
            ListNode  nextNode=pNode2.next;
            if(nextNode==null){
                pReverseHead2=pNode2;
            }
            pNode2.next=preNode2;
            //更新preNode
            preNode2=pNode2;
            pNode2=nextNode;
        }
        //从后面往前面找  就地逆置空后 从后面往前走 到第一个不同的   ---关键是卡看 是否 允许破坏链表的结构了
        return  null;
    }
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2)
    {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int lenListNode1=0;
        int lenListNode2=0;
        ListNode listNode1=pHead1;
        ListNode listNode2=pHead2;
        ListNode  tempNode=null;
        int distance=0;
        ListNode longestListHead=null;
        while (listNode1!=null){
            lenListNode1++;
            listNode1=listNode1.next;
        }
        while (listNode2!=null){
            lenListNode2++;
            listNode2=listNode2.next;
        }
        if(lenListNode1>lenListNode2){
            longestListHead=pHead1;
            tempNode=pHead2;
            distance=lenListNode1-lenListNode2;
        }else {
            longestListHead=pHead2;
            tempNode=pHead1;
            distance=lenListNode2-lenListNode1;
        }
        for (int i = 0; i <distance ; i++) {
            //长的链表 先开始走起来
            longestListHead=longestListHead.next;
        }
        while (tempNode!=null&&longestListHead!=null){
            if(tempNode.val==longestListHead.val){
                return tempNode;
            }
            tempNode=tempNode.next;
            longestListHead=longestListHead.next;
        }

        return tempNode;
    }
    public static void main(String [] args){
        ListNode  listNode1=new ListNode(9);
        ListNode  listNode2=new ListNode(1);
        ListNode  listNode3=new ListNode(4);
        ListNode  listNode4=new ListNode(5);
        ListNode  listNode5=new ListNode(3);
        ListNode  listNode6=new ListNode(6);
        ListNode  listNode7=new ListNode(8);
        ListNode  listNode8=new ListNode(7);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode4.next=listNode5;
        listNode3.next=listNode6;
        listNode5.next=listNode6;
        listNode6.next=listNode7;
        listNode7.next=listNode8;
        new FindFirstCommonNodeSoluction().FindFirstCommonNode2(listNode1,listNode4);
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}