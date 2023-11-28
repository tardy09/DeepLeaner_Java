package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/11/11.
 *  子节点表示法，让父节点记住它所有的子节点，
 *
 *  在这种方式下， 由于每个父亲节点要记住它的所有子节;
 *
 *  在这种方式下，由于每个父亲节点要记住多个子节点，因此必须采取子节点
 *  链的表示法
 *   分析：在定义树节点的时候，在类的 内部封装了一个内部类Node表示树节点
 *   在Node里面增加了一个first域指针，该first用于保存对该节点的子节点
 *   链的引用，通过这种方式即可以记录树中节点之间的父子关系。
 *     使用这种子节点链的表示法来存储树的 时候，添加节点只需要找到指定父节点的子节点链
 *     的最后节点，并让它指向新增的节点。
 */
public class TreeChild<E> {
    //子节点 链接表示法
    private static class SonNode {
        private int pos;
        private SonNode next;

        public SonNode(int pos, SonNode next) {
            this.pos = pos;
            this.next = next;
        }
    }
    public static class Node<T>
    {
        T data;
        SonNode first;
        public Node(T data){
            this.data=data;
            this.first=null;
        }

        @Override
        public String toString() {
            if(first!=null){
                return "TreeChild$Node[data"+", "+data+
                        ", first"+first.pos+"]";
            }
            else {
                return "TreeNode$Node[data"+", first=-1";
            }
        }
    }

    private final int DAFALUT_SIZE=100;
    private int treeSize=0;
    private Node<E> [] Nodes;
    private int nodeNums;
    //通过指定的根节点创建树
    public TreeChild(E data){
        treeSize=DAFALUT_SIZE;
        Nodes=new Node[treeSize];
        Nodes[0]=new Node<>(data);
        nodeNums++;
    }
    public TreeChild(E data,int treeSize){
        this.treeSize=treeSize;
        Nodes=new Node[treeSize];
        Nodes[0]=new Node<>(data);
        nodeNums++;
    }
    public void addNode(E data,Node parent){
        for (int i=0;i<treeSize;i++){
            //找到数组里面第一个为null的元素，该元素保存新的节点
            if(Nodes[i]==null){
                //创建新节点，并用指定数组元素来保存它
                Nodes[i]=new Node<>(data);
                if(parent.first==null){
                    parent.first=new SonNode(i,null);
                }
                else {
                    //获取该节点的第一个孩子节点
                    SonNode next=parent.first;
                    while (next.next!=null){
                        next=next.next;
                    }
                    //找到最后一个节点
                    next.next=new SonNode(i,null);
                }
                nodeNums++;
                return;
            }
        }
        throw new RuntimeException("该树已满，无法添加新的节点");
    }
    //根节点是否为空
    public  boolean isEmpty(){
        return Nodes[0]==null;
    }
    public List<Node<E>> Chirldren(Node parent){
        List<Node<E>> list=new ArrayList<Node<E>>();
        SonNode firstChild=parent.first;
        //沿着孩子链不断的搜寻下一个子节点
        while (firstChild!=null){
            //添加孩子链中的节点
            list.add(Nodes[firstChild.pos]);
            firstChild=firstChild.next;
        }
        return list;
    }

    /**
     *  返回指定节点（非叶子节点）的第index个子节点
     * @param parent
     * @param index
     * @return
     */
    public Node<E> child(Node parent,int index){
        SonNode firstChild=parent.first;
        for(int i=0;firstChild!=null;i++){
            if(index==i){
                return Nodes[firstChild.pos];
            }
            firstChild=firstChild.next;
        }
        return null;
    }
    public int deep(){
        return deep(root());//递归处理
    }
    //返回根节点
    private Node<E> root(){
        return Nodes[0];
    }

    /**
     *  递归方法，每一棵子树的深度为所有的子树的最大深度+1
     * @param node
     * @return
     */
    private int deep(Node<E> node){
        if(node.first==null){
            return 1;
        }
        else {
            //记录所有子树的最大深度
            int max=0;
            SonNode next=node.first;
            while (next!=null){
                //获取以子节点为根的子树的深度
                int tmp=deep(Nodes[next.pos]);
                if(tmp>max){
                    max=tmp;
                }
                next=next.next;
            }
            //最后返回，所有的子树的最大深度+1
            return max+1;
        }
    }

    /**
     * 返回包含指定的值得节点
     * @param node
     * @return
     */
    public int pos(Node node){
        for(int i=0;i<treeSize;i++){
            if(Nodes[i]==node){
                return i;
            }
        }
        return -1;
    }
}
/**
 * http://www.2cto.com/kf/201206/134758.html
 * http://www.2cto.com/kf/201611/561246.html
 */
