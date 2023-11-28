package InterView.Algotrithm;

public class TreeDepthSoluction {
  
	public static  void main(String [] args){
		TreeNode  treeNode1=new TreeNode(4);
		TreeNode  treeNode2=new TreeNode(3);
		TreeNode  treeNode3=new TreeNode(6);
		TreeNode  treeNode4=new TreeNode(7);
		TreeNode  treeNode5=new TreeNode(9);
		treeNode1.left=treeNode2;
		treeNode1.right=treeNode3;
		treeNode2.right=treeNode4;
		treeNode4.left=treeNode5;
	int res=	new TreeDepthSoluction().TreeDepth(treeNode1);
	System.out.println();
	}
	/**
	 * ����һ�ö����������������ȡ�
	 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·����
	 * �·���ĳ���Ϊ�������
	 * @param root
	 * @return
	 */
   public int TreeDepth(TreeNode root) {
	   
	   if(root==null){
		   return 0;
	   }
	   	int  leftDepth=TreeDepth(root.left);
		int   rightDepth=TreeDepth(root.right);
		int temp=leftDepth>rightDepth? leftDepth+1:rightDepth+1;
	   return leftDepth>rightDepth? leftDepth+1:rightDepth+1; 
    }
	
}
