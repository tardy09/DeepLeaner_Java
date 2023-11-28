package InterView.Algotrithm;

public class IsBalanced_SolutionTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TreeNode  treeNode1=new TreeNode(1);
      TreeNode  treeNode2=new TreeNode(2);
      TreeNode  treeNode3=new TreeNode(3);
      TreeNode  treeNode4=new TreeNode(4);
      TreeNode  treeNode5=new TreeNode(5);
      TreeNode  treeNode6=new TreeNode(6);
      TreeNode  treeNode7=new TreeNode(7);
      treeNode1.left=treeNode2;
      treeNode1.right=treeNode3;
      treeNode2.left=treeNode4;
      treeNode2.right=treeNode5;
      treeNode5.left=treeNode7;
      treeNode3.right=treeNode6;
      new IsBalanced_SolutionTest().IsBalanced_Solution(treeNode1);
       
	}
	 public boolean IsBalanced_Solution(TreeNode root) {
		
		//int depth=0;
		return isBancledTree(root,new Holder());
	        
	    }
         
	 private  class Holder{
		 int n;
		 
	 }
	private boolean isBancledTree(TreeNode root, Holder h) {
		// TODO Auto-generated method stub
		if(root==null){
			h.n=0;
			return true;
		}
		Holder l=new Holder();
		Holder  r=new Holder();
		if(isBancledTree(root.left, l)&&isBancledTree(root.right, r)){
			int diff=l.n-r.n;
			if(Math.abs(diff)<=1){
		       		h.n+=Math.max(l.n+1, r.n+1);
		       		return true;
			}
		}
		return false;
	}
	 
	 
}
