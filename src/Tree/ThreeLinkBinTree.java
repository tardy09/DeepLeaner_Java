package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/11/12.
 */
public class ThreeLinkBinTree<T> {
    public static class TreeNode{
        Object data;
        TreeNode left;
        TreeNode right;
        TreeNode  parent;
        public TreeNode(){

        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    private TreeNode root;
    public ThreeLinkBinTree(){
        this.root=new TreeNode();
    }
    public ThreeLinkBinTree(T data){
        this.root=new TreeNode(data);
    }
    public TreeNode addTreeNode(TreeNode parent,T data,boolean isLeft){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        if(!isLeft&&parent.right!=null){
            throw new RuntimeException(parent+"节点已经有啦右边节点");
        }
        if(isLeft&&parent.left!=null){
            throw new RuntimeException(parent+"节点已经有啦左边节点");
        }
        TreeNode newNode=new TreeNode(data);
        if(isLeft){
            parent.left=newNode;
        }
        else {
            parent.right=newNode;
        }
        newNode.parent=parent;
        return newNode;
    }
    public boolean isEmpty(){
        return root.data==null;
    }
    public TreeNode root(){
        if(isEmpty()){
            throw new RuntimeException("树为空");
        }
        return root;
    }
    public T parent(TreeNode treeNode){
        if(treeNode==null){
            throw new RuntimeException(treeNode+"为空");
        }
        return (T) treeNode.parent.data;
    }
    public T leftChild(TwoLinkBinTree.TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.left==null?null:(T)parent.left.data;
    }
    public T rightChild(TwoLinkBinTree.TreeNode parent){
        if(parent==null){
            throw new RuntimeException(parent+"节点为空");
        }
        return parent.right==null?null:(T)parent.right.data;
    }
    public  int deep(){
        return deep(root);
    }
    public int deep(TreeNode treeNode){
        if(treeNode==null)
        {
            return 0;
        }
        if(treeNode.right==null&&treeNode.right==null)
        {
            return 1;
        }
        else {
            int leftDeep=deep(treeNode.left);
            int rightDeep=deep(treeNode.right);
            int max=leftDeep>rightDeep?leftDeep:rightDeep;
            return max+1;
        }
    }
    //可以看出，三叉链表通过对树节点增加一个parent引用，可以让
    //每个节点都可以非常高效的访问其父亲节点，三叉链表的二叉树既可以
    // 很方便的向下访问节点也可以很方便的向上访问节点。
    //先序遍历
    public List<TreeNode> preIterator(){
        return preIterator(root);
    }
    private List<TreeNode> preIterator(TreeNode treeNode){
        List<TreeNode> list=new ArrayList<>();
        //先处理根节点
        list.add(treeNode);
        if(treeNode.left!=null){
            list.addAll(preIterator(treeNode.left))  ;
        }
        if(treeNode.right!=null){
            list.addAll(preIterator(treeNode.right));
        }
        return list;
    }
    //中序遍历
    public List<TreeNode> inIterator(){
        return inIterator(root);
    }
    private List<TreeNode> inIterator(TreeNode treeNode
    ){
        List<TreeNode> list=new ArrayList<>();
        if(treeNode.left!=null){
            list.addAll(inIterator(treeNode.left));
        }
        //处理根节点
        list.add(treeNode);
        if(treeNode.right!=null){
            list.addAll(inIterator(treeNode.right));
        }
        return list;
    }
    //后序遍历
    public List<TreeNode> postIterator(){
        return postIterator(root);
    }
    private List<TreeNode> postIterator(TreeNode treeNode){

        List<TreeNode> list=new ArrayList<>();
        if(treeNode.left!=null){
            list.addAll(inIterator(treeNode.left));
        }

        if(treeNode.right!=null){
            list.addAll(inIterator(treeNode.right));
        }
        //处理根节点
        list.add(treeNode);
        return list;
    }
    /**
     * 广度优先遍历
     */
    public List<TreeNode> broastIteraotr(){
        Queue<TreeNode> queue=new ArrayDeque<>();
        List<TreeNode> list=new ArrayList<>();
        if(root!=null){
            //将根元素入队
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //将队列的对尾元素添加入list
            list.add(queue.peek());
            TreeNode p=queue.poll();//出队
            if(p.left!=null){
                queue.offer(p.left);
            }
            if(p.right!=null){
                queue.offer(p.right);
            }
        }
        return list;
    }
}
