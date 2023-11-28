package InterView.Algotrithm;

public class EntryNodeOfLoopSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ListNode Node1=new ListNode(1);
       ListNode Node2=new ListNode(3);
       ListNode Node3=new ListNode(5);
       ListNode Node4=new ListNode(7);
       ListNode Node5=new ListNode(6);
       ListNode Node6=new ListNode(8);
       ListNode Node7=new ListNode(10);
       Node1.next=Node2;
       Node2.next=Node3;
       Node3.next=Node4;
       Node4.next=Node5;
       Node5.next=Node6;
       Node6.next=Node7;
       Node7.next=Node4;
     ListNode listNode=  new EntryNodeOfLoopSoluction().EntryNodeOfLoop(Node1);
	}
	/**
	 * ��������Ƿ���л��ṹ
	 * @param phead
	 * @return
	 */
	static boolean  isExitsCircle(ListNode phead){
		if(phead==null){
			return false;
		}
		ListNode  quick=phead,slow=phead;
		while(quick!=null&&quick.next!=null){
			slow=slow.next;
			quick=quick.next.next;
			if(quick==slow) {
				break;
			}
		}
		return !(quick!=null||quick.next==null);
		
	}
    /**
     * һ�������а����������ҳ�������Ļ�����ڽ�㡣
     * @param pHead
     * @return
     */
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)  return  null;
        ListNode  slow=pHead;
        ListNode  quick=pHead;
        //���� �� n^2
         //�ҵ�p1��p2�ĵ�һ��������ײ��,,��ʱ����ײ��
        //�ͻ�·�������k��λ�ã�
        while(slow.next!=null&&quick.next!=null){
        	slow=slow.next;
        	if(quick.next.next==null){
        		return null;
        	}
        	quick=quick.next.next;
        	if(slow==quick){
        		break;
        	}
        }
        //�����飬�۲������Ƿ�����ײ��λ�ã�Ҳ������û�л�·
        if(quick==null||quick.next==null){
        	return null;
        }
        if(quick==pHead){
        	return  quick;
        }
        slow=pHead;
        //���߿�ʼһ����
        while(slow.next!=null&&quick.next!=null){
        	slow=slow.next;
        	quick=quick.next;
        	if(slow==quick){
        		break;
        	}
        }
        //��Ҫ��� 
		return slow;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}