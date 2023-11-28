package InterView.Algotrithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/23.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ComplexList {

    /**
     *  分两步思路来解决这个问题
     *  1.将原来节点的每个节点进行复制，然后对应的用m_next连接起来，从 N得到复制节点N'
     *  同时 用一个HashMop来完成N到N‘的对应映射关系。
     *  2.设置复制链表里面的节点N'的m_spinest的对应链接位置，由于在原始的链表里面我们的N的m_spinest对应的指向S节点
     *  相应的，在复制链表里面我们的N'对应的指向S'节点。
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> hashMap=new HashMap<>();//用hashMap来维护相应的对应关系
        RandomListNode pNode=pHead;//中间迭代节点
        //增加头指针 和 尾巴指针
        RandomListNode HeadrandomListNode=new RandomListNode(pHead.label);//新的链表的头结点
        RandomListNode tempHeadNode=HeadrandomListNode;
        hashMap.put(pHead,HeadrandomListNode);//维护头结点的对应关系
        //第一步 尾插法建立单链表
        while (pNode!=null){//还没有复制完
            if (pNode.next!=null) {
                pNode=pNode.next;
                RandomListNode temNode=new RandomListNode(pNode.label);
                //同时在这里完成hashMap的维护
                hashMap.put(pNode,temNode);
                tempHeadNode.next=temNode;
                tempHeadNode=temNode;
            }
            else {
                tempHeadNode.next=null;
                break;
            }
        }
        // HeadrandomListNode.next=pNode;
        //第二步 。完成复制表里面 对应的映射
        for(Map.Entry<RandomListNode, RandomListNode> entry:hashMap.entrySet()){
            RandomListNode temp=entry.getKey().random;
            entry.getValue().random=temp;
        }
        return HeadrandomListNode;
    }

    public static  void main(String [] args){
        ComplexList complexList=new ComplexList();
        RandomListNode randomListNode1=new RandomListNode(1);
        RandomListNode randomListNode2=new RandomListNode(2);
        RandomListNode randomListNode3=new RandomListNode(3);
        RandomListNode randomListNode4=new RandomListNode(4);
        RandomListNode randomListNode5=new RandomListNode(5);
        randomListNode1.next=randomListNode2;
        randomListNode2.next=randomListNode3;
        randomListNode3.next=randomListNode4;
        randomListNode4.next=randomListNode5;
        randomListNode1.random=randomListNode3;
        randomListNode4.random=randomListNode2;
        randomListNode2.random=randomListNode5;
        RandomListNode randomListNodes=   complexList.Clone(randomListNode1);
        System.out.println("*******************");
    }
}
