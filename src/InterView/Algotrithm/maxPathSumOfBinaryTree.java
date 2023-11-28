package InterView.Algotrithm;
/**
 * �ڶ���������һ��·����ʹ�ø�·���ĺ����
 * ��·�����ԴӶ������κν�㿪ʼ��Ҳ���Ե��κν�������
 * @author Administrator
 *˼·���ݹ���һ������root�����·��
 *������·�������ǣ�
1) ���ĳ��·�� + root + �ұ�ĳ��·��
2) ���ĳ��·�� + root
3) root + �ұ�ĳ��·��
4) root
 */
public class maxPathSumOfBinaryTree {
	
   public int maxPathSum(TreeNode root) {
	   int max=Integer.MIN_VALUE;
	   
//	   if(root==null){
//		   return 0;
//	   }
	   getMaxNumPath(root,max);
       return max; 
    }

private int getMaxNumPath(TreeNode root,int max) {
	// TODO Auto-generated method stub
	
	if(root==null){
		return 0;
	}

	int value=root.val;
	int leftmax=0;
	int rightmax=0;
if(root.left!=null){
	leftmax=getMaxNumPath(root.left,max);
	if(leftmax>0){
		value+=leftmax;
	}
	}
if(root.right!=null){
	leftmax=getMaxNumPath(root.right,max);
	if(rightmax>0){
		value+=rightmax;
	}
	}
   //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}
   if(value>max){
	   max=value;
   }
    //���� return max of (root.val, root.val + lmax, root.val + rmax) 
	return Math.max(max, Math.max(root.val+leftmax, root.val+rightmax));
}
public static void main(String [] args){
	TreeNode treeNode1=new TreeNode(1);
	TreeNode treeNode2=new TreeNode(2);
	TreeNode treeNode3=new TreeNode(3);
	treeNode1.left=treeNode2;
	treeNode1.right=treeNode3;
	maxPathSumOfBinaryTree m=new maxPathSumOfBinaryTree();
	m.maxPathSum(treeNode1);
}
}
