package InterView.Algotrithm;

public class ConvertTreeNode {
	/**
	 * ����һ�ö��������������ö���������ת����һ�������˫������ BST
	 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
	 * ǰ---����
	 * ��---����
	 * @param pRootOfTree
	 * @return
	 */
	 public TreeNode Convert(TreeNode pRootOfTree) {
		     TreeNode  LastLinkedTreeNode=null;
		     ConvertNode(pRootOfTree,LastLinkedTreeNode);
		     TreeNode  HeadlinkListTreeNode=LastLinkedTreeNode;
		     //���� ǰ��ָ���ָ��
		     while(HeadlinkListTreeNode!=null&&HeadlinkListTreeNode.left!=null){
		    	 HeadlinkListTreeNode=HeadlinkListTreeNode.left;
		     }
	          return HeadlinkListTreeNode;
	    }
	 public TreeNode Convert3(TreeNode pRootOfTree){
		 if(pRootOfTree==null){
			 return null;
		 }
		 if(pRootOfTree.left==null&&pRootOfTree.right==null){
			 return pRootOfTree;
		 }
		 TreeNode left=Convert3(pRootOfTree);
		 TreeNode tempLeft=left;
		 while(tempLeft!=null&&tempLeft.right!=null){
			 tempLeft=tempLeft.right;
		 }
		 if(left!=null){
			 tempLeft.right=pRootOfTree;
			 pRootOfTree.left=tempLeft;
		 }
		 TreeNode right=Convert3(pRootOfTree.right);
		 if(right!=null){
			 right.left=pRootOfTree;
			 pRootOfTree.right=right;
		 }
		 return left!=null?left:pRootOfTree; 
	 }
	 TreeNode lastTreeNodeInList=null;//����˫��������������һ���ڵ㣬
	 public TreeNode Convert2(TreeNode pRootOfTree){
		 if(pRootOfTree==null){
			 return null;
		 }
		// TreeNode lastTreeNodeInList=null;//����˫��������������һ���ڵ㣬
		 //�����ڱ��������ڵ��ʱ�� ����͸��ڵ�������ʱ�� ����ʹ��
		 TreeNode  currentNode=pRootOfTree;
		 if(currentNode.left!=null){
			 ConvertToNode2(pRootOfTree.left,lastTreeNodeInList);
			// Convert2(currentNode.left);
		 }
		 if(lastTreeNodeInList!=null){
			 lastTreeNodeInList.right=currentNode;
		 }
		 currentNode.left=lastTreeNodeInList;
		 lastTreeNodeInList=currentNode;
		 if(currentNode.right!=null){
			 ConvertToNode2(currentNode.right,lastTreeNodeInList);
			// Convert2(currentNode.right);
		 }
		 TreeNode headList=lastTreeNodeInList;
		 while(headList!=null&&headList.left!=null){
			 headList=headList.left;
		 }
		 return headList;
	 }
	private void ConvertToNode2(TreeNode left, TreeNode lastTreeNodeInList) {
		// TODO Auto-generated method stub
		
		
	}
	private void ConvertNode(TreeNode pRootOfTree, TreeNode LastLinkedTreeNode) 
	{
		if(pRootOfTree==null){
			return ;
		}
		TreeNode currentNode=pRootOfTree;//�������ڵ�
		//����ҵķ�ʽ���б���
		if(currentNode.left!=null){
			ConvertNode(currentNode.left, LastLinkedTreeNode);
		}
		
		currentNode.left=LastLinkedTreeNode;
		if(LastLinkedTreeNode!=null){
			LastLinkedTreeNode.right=currentNode;
		}
		//
		LastLinkedTreeNode=currentNode;
		if(currentNode.right!=null){
			ConvertNode(currentNode.right, LastLinkedTreeNode);
		}
		// TODO Auto-generated method st
	}
	public static void main(String [] args){
		TreeNode treeNode1=new TreeNode(10);
		TreeNode treeNode2=new TreeNode(6);
		TreeNode treeNode3=new TreeNode(14);
		TreeNode treeNode4=new TreeNode(4);
		TreeNode treeNode5=new TreeNode(8);
		TreeNode treeNode6=new TreeNode(12);
		TreeNode treeNode7=new TreeNode(16);
		treeNode1.left=treeNode2;
		treeNode1.right=treeNode3;
		treeNode2.left=treeNode4;
		treeNode2.right=treeNode5;
		treeNode3.left=treeNode6;
		treeNode3.right=treeNode7;
	TreeNode treeNodeList=	new ConvertTreeNode().Convert3(treeNode1);
	System.out.println("ccc"+treeNodeList);
	}
}

