package InterView.Algotrithm;

public class GetNextTreeNode {
    /**
     * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
     * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
     * 
     * @param pNode
     * @return
     */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
        	return null;
        }
        //�ұ�������Ϊ��
        if(pNode.right!=null)
        {
        	TreeLinkNode tempNode=pNode.right;
        	while(tempNode.left!=null){
        		tempNode=tempNode.left;
        	}
        	return tempNode;
        }
		//����ұ�����Ϊ�գ��򷵻ظ��ڵ�
        //�ҵ���һ���ڵ�Ϊ��ǰ�ڵ�ĸ��ڵ�
        while(pNode.next!=null){
        	{
        	    //TreeLinkNode parentNode=pNode.next;	
        		if(pNode.next.left==pNode){
        			return pNode.next;
        		}
        		pNode=pNode.next;
        	}
        }
        
        
		return  null;
    }
	public static void main(String [] args){
		TreeLinkNode treeLinkNode1=new TreeLinkNode(4);
		TreeLinkNode treeLinkNode2=new TreeLinkNode(8);
		TreeLinkNode treeLinkNode3=new TreeLinkNode(3);
		TreeLinkNode treeLinkNode4=new TreeLinkNode(6);
		TreeLinkNode treeLinkNode5=new TreeLinkNode(5);
		TreeLinkNode treeLinkNode6=new TreeLinkNode(2);
		treeLinkNode1.left=treeLinkNode2;
		treeLinkNode1.right=treeLinkNode3;
		treeLinkNode2.next=treeLinkNode1;
		//treeLinkNode1.next=treeLinkNode6;
		treeLinkNode2.left=treeLinkNode4;
		treeLinkNode2.right=treeLinkNode5;
		treeLinkNode5.next=treeLinkNode1;
		treeLinkNode4.next=treeLinkNode2;
		treeLinkNode5.next=treeLinkNode2;
		treeLinkNode3.left=treeLinkNode6;
		treeLinkNode3.next=treeLinkNode1;
		treeLinkNode6.next=treeLinkNode3;
		System.out.println("vvvvv");
	}
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
