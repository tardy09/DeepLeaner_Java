package learnibf;

public class ConvertTreeNode {
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。 BST
	 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
	 * 前---》左
	 * 后---》右
	 * @param pRootOfTree
	 * @return
	 */
	 public TreeNode Convert(TreeNode pRootOfTree) {
		     TreeNode  LastLinkedTreeNode=null;
		     ConvertNode(pRootOfTree,LastLinkedTreeNode);
		     TreeNode  HeadlinkListTreeNode=LastLinkedTreeNode;
		     //修正 前向指针的指向
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
	 TreeNode lastTreeNodeInList=null;//保存双向链表里面的最后一个节点，
	 public TreeNode Convert2(TreeNode pRootOfTree){
		 if(pRootOfTree==null){
			 return null;
		 }
		// TreeNode lastTreeNodeInList=null;//保存双向链表里面的最后一个节点，
		 //方便在遍历到根节点的时候 如果和根节点连续的时候 进行使用
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
		TreeNode currentNode=pRootOfTree;//保护根节点
		//左根右的方式进行遍历
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

