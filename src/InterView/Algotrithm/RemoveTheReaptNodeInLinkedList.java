package InterView.Algotrithm;

public class RemoveTheReaptNodeInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * ɾ��������������ظ��ڵ㣬
	 * ��1����ɢ�б�������������������ÿ���ڵ���뵽ɢ�б����棬����������ظ�Ԫ���򽫸ýڵ�������������
	 * ɾ����Ȼ���������
	 * �÷�����ʱ�临�Ӷ�ΪO(n),
	 * ��2�����������ʹ�ö���Ļ����������Կ�����������ָ����е�������
	 * curret����������������runnner���ڼ������Ľڵ��Ƿ����ظ�
	 * @param phead
	 * @return
	 */
	public ListNode deleteNodes(ListNode phead){
		
		if(phead==null){
			return  null;
		}
		ListNode  currentNode=phead;
		//ListNode  runnner=phead;
		while(currentNode!=null){
			
			ListNode  runnner=currentNode;
			 while(runnner.next!=null){
				 if(runnner.next.val==currentNode.val){
					 runnner.next=runnner.next.next;//ȥ��
				 }else
				 {
					 
				 }
			 }
			
		}
		return phead;
		
	}

}
