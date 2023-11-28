package InterView.Algotrithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Administrator on 2017/3/22.
 *
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 *
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return list;
        }
        Stack<Integer> stack = new Stack<Integer>();
        list=findPath(root,target,stack,new ArrayList<Integer>(),new ArrayList<ArrayList<Integer>>());
        return list;
    }
    //static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target,Stack<Integer> path,ArrayList<Integer> list1,ArrayList<ArrayList<Integer>> list ){

        if(root == null){
            return list;
        }
        if(root.left==null && root.right==null){
            if(root.val==target){
                ArrayList<Integer> temp=new ArrayList<>();
                list1=temp;
                System.out.println("startpath:");
                //path.add(root.val);
                for(Integer i:path){
                    list1.add(i);
                }
                list1.add(root.val);
                list.add(list1);//
            }
        }
        else
        {
            path.push(root.val);
            findPath(root.right,target-root.val,path,list1,list);
            findPath(root.left,target-root.val,path,list1,list);
            path.pop();//小步伐走  走完 一条合理的路径之后，立即回头稍微观察看看。--回退一步就好了
        }
        return list;///这块有问题，以返回直接变空了
    }
    public static void main(String args[])
    {
        TreeNode root1=new TreeNode();
        TreeNode node1=new TreeNode();
        TreeNode node2=new TreeNode();
        TreeNode node3=new TreeNode();
        TreeNode node4=new TreeNode();
       // TreeNode node5=new TreeNode();
      //  TreeNode node6=new TreeNode();
        root1.left=node1;
        root1.right=node2;
        node1.left=node3;
        node1.right=node4;
        //node2.right=node5;
       // node4.left=node6;
        root1.val=10;
        node1.val=5;
        node2.val=12;
        node3.val=4;
        node4.val=7;
        //node5.val=13;
      //  node6.val=13;
        Solution testFindPath=new Solution();
        ArrayList<ArrayList<Integer>> ss=	testFindPath.FindPath(root1, 35);
        System.out.println("vv");
    }
}
class TreeNode {
    int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode left = null;
    TreeNode right = null;
}