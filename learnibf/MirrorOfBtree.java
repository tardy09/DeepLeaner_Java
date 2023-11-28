package learnibf;
/**
 * 
 * @author Administrator
 *
 */
public class MirrorOfBtree {
	 public void Mirror(TreeNode root) {
	          if(root==null){
	        	  return;
	          }
	          //空不空 无所谓的 其实
	        TreeNode tempTreeNode=root.left;
	        root.left=root.right;
	        root.right=tempTreeNode;
	        if(root.left!=null){
	        	Mirror(root.left);
	        }
	        if(root.right!=null){
	        	Mirror(root.right);
	        }
	          
	    }
	 
	 public static  void main(String [] args){
		 
		 TreeNode  treeNode1=new TreeNode(5);
		 TreeNode  treeNode2=new TreeNode(6);
		 TreeNode  treeNode3=new TreeNode(7);
		 TreeNode  treeNode4=new TreeNode(8);
		 TreeNode  treeNode5=new TreeNode(9);
		 TreeNode  treeNode6=new TreeNode(10);
		 TreeNode  treeNode7=new TreeNode(11);
		 treeNode4.left=treeNode2;
		 treeNode4.right=treeNode6;
		 treeNode2.left=treeNode1;
		 treeNode2.right=treeNode3;
		 treeNode6.left=treeNode5;
		 treeNode6.right=treeNode7;
		 MirrorOfBtree mirrorOfBtree=new MirrorOfBtree();
		 mirrorOfBtree.Mirror(treeNode4);
		System.out.println("**********");
	 }
}

