package LeeCode.whetherIsCircleOfNodeList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/8.
 */
public class Solution {
    /** 这里假设将LinkedList当做单链表
     * 反转链表进行 比较检测
     * @param head
     * @return
     */
    boolean isPalindrome1(LinkListNode<Integer> head){
        LinkListNode<Integer> slow=head;
        LinkListNode<Integer> fast=head;
        Stack<Integer> stack=new Stack<>();
        while (fast!=null&&fast.next!=null){
            stack.push(slow.data);
            slow=slow.next;
            fast=fast.next.next;
        }
        //奇数个 否则偶数个
        if(fast!=null){
            slow=slow.next;//slow指向后半部分第一个数
        }
        while (slow!=null)
        {
            int top=stack.pop().intValue();
            if(top!=slow.data){
                return false;
            }
            slow=slow.next;
        }
        return true;
    }

    /**
     *   迭代访问法
     * @param head
     * @return
     *   若是要想探测链表的前半部分是否为
     *   后半部分所反转而成，只需要将链表的前半部分进行反转，可以利用栈来进行实现
     *
     *      我们需要将前半部分进行入栈，根据节点长度已知与否，入栈有两种方式。
     *      若链表长度已知，可以利用for循环迭代访问前半部分的节点，将每个节点入栈
     *      ，当然要小心的处理长度为奇数的情况
     *      如果链表长度未知:可以利用快慢指针的思想描述访问链表，在迭代循环的每一步
     *      ，将慢速runnner的数据入栈，在快速runnner抵达链表末尾的时候，慢速runner
     *      刚好位于链表的中间位置，至此，栈里面就存放了链表前半部分的所有节点
     *      ，不过顺序是相反的
     *      接下来我们只需要比较访问迭代的链表剩余的节点，每次迭代的时候，比较当前的
     *      节点和栈顶的节点元素，迭代的时候比较结果完全相同，则该链表是回文序列。
     *
     */
    boolean isPalindrome2(LinkedList head){

        return true;
    }
    class LinkListNode<T>{
        private T data;
        private LinkListNode<Integer> next;
        public LinkListNode(){

        }
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public LinkListNode<Integer> getNext() {
            return next;
        }

        public void setNext(LinkListNode<Integer> next) {
            this.next = next;
        }
    }
}
