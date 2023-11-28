package Tree;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by Administrator on 2016/11/12.
 */
public class TwoLinkBinTree<E> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        public TreeNode(){

        }
        public TreeNode(Object data){
            this.data=data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode root;
    public TwoLinkBinTree(){
        this.root=new TreeNode();
    }
    public TwoLinkBinTree(E data){
        this.root=new TreeNode(data);
    }

    /**
     * 为指定的节点添加子节点
     * @param parent
     * @param data
     * @param left
     * @return
     */
    public TreeNode addNode(TreeNode parent,E data,boolean left){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        if(left&&parent.left!=null){
            throw new RuntimeException(parent+"已经有左子节点，无法添加左子节点");
        }
        if(!left&&parent.right!=null){
            throw new RuntimeException(parent+"已经有右子节点，无法添加右子节点");
        }
        TreeNode newNode=new TreeNode(data);
        if(left){
            parent.left=newNode;
        }
        else {
            parent.right=newNode;
        }
        return newNode;
    }
    public boolean isEmpty(){
        return root.data==null;
    }
    public TreeNode root(){
        if(isEmpty()){
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }
    //返回指定节点的父节点
    public E parent(TreeNode nod){
        //对于二叉链表，如果要访问指定节点的父节点，必须要遍历二叉树
        return null;
    }
    //返回指定节点（叶子节点）的左子节点，当左子节点不存在的时候返回null
    public E leftChild(TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.left==null?null:(E)parent.left.data;
    }
    public E rightChild(TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.right==null?null:(E)parent.right.data;
    }
    public int deep(){
        return deep(root);
    }
    //返回指定节点的深度
    public int deep(TreeNode node){
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        else {
            int leftDeep=deep(node.left);
            int rightDeep=deep(node.right);
            int max=leftDeep>rightDeep?leftDeep:rightDeep;
            return max+1;
        }
    }
}
