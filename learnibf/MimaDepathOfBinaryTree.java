package learnibf;

/**
 * 
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along 
 * the shortest path from the root 
 * node down to the nearest leaf node.
 * @author Administrator
 *
 */
public class MimaDepathOfBinaryTree {
	 public int run(TreeNode root) 
	 {  
		 return getDepth(root);
	 }
  private int getDepth(TreeNode root) {
		// TODO Auto-generated method stub
	  
	  //1.
	  if(root==null){
		  return 0;
	  }
	  //2.
	  if(root.left==null&&root.right==null){
		  return 1;
	  }
	  //只 有两棵树都不为空的情况下 才继续 往下面走
	  //走着 走着 如果发现 一边的树节点 是空了 那么 立即终止操作
	  if(root.left==null){
		  return getDepth(root.right)+1;
	  }
	  if(root.right==null){
		  return getDepth(root.left)+1;
	  }
	  return Math.min(getDepth(root.left),getDepth(root.right))+1;
	}
  
  


public static void main(String [] args){
	TreeNode treeNode1=new TreeNode(0);
//      TreeNode treeNode1=new TreeNode(9);
//      TreeNode treeNode2=new TreeNode(3);
//      TreeNode treeNode3=new TreeNode(2);
//      TreeNode treeNode4=new TreeNode(4);
//      TreeNode treeNode5=new TreeNode(4);
//      TreeNode treeNode6=new TreeNode(0);
//      TreeNode treeNode7=new TreeNode(6);
//      TreeNode treeNode8=new TreeNode(5);
//      treeNode1.left=treeNode2;
//      treeNode1.right=treeNode3;
//      treeNode2.right=treeNode4;
//      treeNode3.left=treeNode5;
//      treeNode3.right=treeNode6;
//      treeNode4.left=treeNode7;
//      treeNode5.left=treeNode8;
      MimaDepathOfBinaryTree mimaDepathOfBinaryTree=new MimaDepathOfBinaryTree();
      int m=mimaDepathOfBinaryTree.run(null);
      System.out.println("......."+m);		  
  }
}
