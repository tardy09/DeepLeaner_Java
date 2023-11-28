package InterView.Algotrithm;

/**
 * Created by Administrator on 2017/6/3.
 */
public class LCA_Soluction {

    public  static  void  main(String [] args){
        Tree_Node  tree_node1=new Tree_Node(8);
        Tree_Node  tree_node2=new Tree_Node(6);
        Tree_Node  tree_node3=new Tree_Node(7);
        Tree_Node  tree_node4=new Tree_Node(4);
        Tree_Node  tree_node5=new Tree_Node(3);
        Tree_Node  tree_node6=new Tree_Node(5);
        Tree_Node  tree_node7=new Tree_Node(2);

        tree_node1.left=tree_node2;
        tree_node1.right=tree_node3;
        tree_node2.left=tree_node4;
        tree_node2.right=tree_node5;
        tree_node3.left=tree_node6;
        tree_node5.left=tree_node7;
        tree_node2.parent=tree_node1;
        tree_node3.parent=tree_node1;
        tree_node4.parent=tree_node2;
        tree_node5.parent=tree_node2;
        tree_node7.parent=tree_node5;
        tree_node6.parent=tree_node3;
        Tree_Node tree_node= new  LCA_Soluction().soluction(tree_node7,tree_node6);
        System.out.println(tree_node);

    }

    /**
     * 找到tree_node1和节点tree_nod2的公共父亲节点
     * @param tree_node1
     * @param tree_node2
     * @return
     */
    public Tree_Node  soluction(Tree_Node tree_node1,Tree_Node tree_node2){
        if(tree_node1==null||tree_node2==null)  return null;
        int  depth1=getDepth(tree_node1);
        int  depth2=getDepth(tree_node2);
        Tree_Node  deepperTree_Node=depth1>depth2?tree_node1:tree_node2;
        Tree_Node  temTreeNode=depth1<depth2?tree_node1:tree_node2;
        //移动到同一高度
        for (int i = 0; i <depth1-depth2 ; i++) {
            deepperTree_Node=deepperTree_Node.parent;
        }
        while (temTreeNode!=null&&deepperTree_Node!=null){
            if(temTreeNode.val==deepperTree_Node.val){
                return  temTreeNode;
            }
            temTreeNode=temTreeNode.parent;
            deepperTree_Node=deepperTree_Node.parent;
        }
        return null;
    }
    private int getDepth(Tree_Node tree_node1) {
        int  count=0;
        while(tree_node1!=null){
            count++;
            tree_node1=tree_node1.parent;
        }
        return count;
    }
}
class  Tree_Node{
    int  val;
    Tree_Node left;
    Tree_Node right;
    Tree_Node  parent;

    public Tree_Node(int val) {
        this.val = val;
    }

}
