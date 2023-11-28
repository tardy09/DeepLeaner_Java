package InterView.Algotrithm;

public class ReverTheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(7);
		ListNode node5=new ListNode(9);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=null;
		new ReverTheLinkedList().soluction(node1);
		
	}
	/**
	 * ʵ�ֵ�����ľ͵�����
	 * Ϊ����ȷ�ĵ���һ��������Ҫ����ָ���ָ��
	 * ����������� 1��3��5���ԣ�
	 * ���辭�����ɲ�����֮��
	 * �Ѿ��ѽڵ�1֮ǰ��ָ���������ˣ�
	 * ��Щ�ڵ��nextָ�붼ָ����ǰһ���ڵ�
	 * ���ڱ������ڵ�3��ʱ�򣬵�Ȼ��Ҫ�����ڵ��nextָ��
	 * ����ʼ��ָ��ڵ�1������������Ҫע����ǣ�һ��������ָ���ָ������ͶϿ��ˣ�
	 * ��Ϊû��ָ��ָ��5�ˣ�û�а취�ٴα������ڵ�5 �ˣ����Ϊ�˱�������Ͽ�������Ҫ�ڵ���
	 * m��m_next֮ǰ��n�������������������ҵ���ת��������ͷ�ڵ㣬���ѷ�����
	 * ��ת��������ͷ�����ԭʼ�������β�ͽڵ㡣
	 * @param pHead
	 * @return
	 */
	public ListNode soluction(ListNode pHead){
		if(pHead==null||pHead.next==null){
			return pHead;
		}
		ListNode  current=pHead,pRecerHead=null,previous=null;
		
		while(current!=null){
			ListNode next=current.next;
			if(next==null){
				//current.next=previous;
				pRecerHead=current;
			}
			current.next=previous;
			previous=current;
			current=next;
		}
		return pRecerHead;	
	}
}
