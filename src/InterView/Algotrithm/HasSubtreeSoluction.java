package InterView.Algotrithm;

public class HasSubtreeSoluction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                TreeNode treeNode1=new TreeNode(8);
                TreeNode treeNode2=new TreeNode(8);
                TreeNode treeNode3=new TreeNode(7);
                TreeNode treeNode4=new TreeNode(9);
                TreeNode treeNode5=new TreeNode(3);
                TreeNode treeNode6=new TreeNode(4);
                TreeNode treeNode7=new TreeNode(7);
                treeNode1.left=treeNode2;
                treeNode1.right=treeNode3;
                treeNode2.left=treeNode4;
                treeNode2.right=treeNode5;
                treeNode5.left=treeNode6;
                treeNode5.right=treeNode7;
                
                TreeNode treeNode8=new TreeNode(8);
                TreeNode treeNode9=new TreeNode(9);
                TreeNode treeNode10=new TreeNode(2);
                treeNode8.left = treeNode9;
                treeNode8.right = treeNode10;
                new HasSubtreeSoluction().HasSubtree(treeNode1, treeNode8);
	}
	 /**
	  * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
	  * ��ps������Լ��������������һ�������ӽṹ��
	  * @param root1
	  * @param root2
	  * @return
	  */
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1==null){
			return false;
		}
		if(root2==null){
			return true;
		}
		
		//�������ܳ���������������������Ҳ�п��ܰ������ڵ�
		/**
		 * 1������ ���ڵ� 
		 * 2.������
		 */
		boolean result = false;
		if(root1.val==root2.val){
			result=doesTree1HaveTree2(root1,root2);
			  
		  }
		  if(!result)
		  {
			  result =   HasSubtree(root1.left, root2)||HasSubtree(root1.right, root2);  
		  }    
		
		return result;
	  }
	 public boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2)
		{
			if(root2==null)
				return true;
			else
				if(root1==null)
					return false;
			if(root1.val!=root2.val)
				return false;
			else {
				return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
			}
		}

}
