package InterView.Algotrithm;

public class KthNodeSolution {
	int count = 0;
	TreeNode KthNode(TreeNode pRoot, int k)
    {    
		if(pRoot!=null){
			TreeNode node = KthNode(pRoot.left,k);
			if(node!=null){
				return node;
			}
			count++;
			if(count==k){
				return pRoot;
			}
			node = KthNode(pRoot.right, k);
			if(node!=null){
				return node;
			}
			
		}
		return null;
        
    }
    //class wrappe
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode  t1Node = new TreeNode(5);
		TreeNode  t2Node = new TreeNode(3);
		TreeNode  t3Node = new TreeNode(7);
		TreeNode  t4Node = new TreeNode(2);
		TreeNode  t5Node = new TreeNode(4);
		TreeNode  t6Node = new TreeNode(6);
		TreeNode  t7Node = new TreeNode(8);
		t1Node.left = t2Node;
		t1Node.right = t3Node;
		t2Node.left = t4Node;
		t2Node.right=t5Node;
		t3Node.left = t6Node;
		t3Node.right = t7Node;
				
		KthNodeSolution test = new KthNodeSolution();
		System.out.println(test.KthNode(t1Node, 5).val);

	}
}
