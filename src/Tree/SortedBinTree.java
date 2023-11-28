package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/11/12.
 * 之前我们学习的hashMap和hashSet一个共同的限制是没有顺序，我们提到，
 * 它们都有一个能保持顺序的对应类TreeMap和TreeSet，这两个类的共同实现基础是排序二叉树，
 * 与哈希表一样，树也是计算机程序中一种重要的数据结构和思维方式。为了能够快速操作数据，
 * 哈希和树是两种基本的思维方式，不需要顺序，优先考虑哈希，需要顺序，考虑树。
 * 除了容器类TreeMap/TreeSet，数据库中的索引结构也是基于树的（不过基于B树，而不是二叉树），
 * 而索引是能够在大量数据中快速访问数据的关键。
 * 排序二叉树保持了元素的顺序，而且是一种综合效率很高的数据结构，基本的保存
 * 、删除、查找的效率都为O(h)，h为树的高度，在树平衡的情况下，
 * h为log2(N)，N为节点数，比如，如果N为1024，则log2(N)为10。
 *
 */
public class SortedBinTree<T extends Comparable> {
    static class Node{
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", parent=" + parent +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this==obj){
                return true;
            }
            if(obj.getClass()==Node.class){
                Node target= (Node) obj;
                return data.equals(target.data)&&
                        left==target.left&&
                        right==target.right&&
                        parent==target.parent;
            }
            return false;
        }
    }
    private Node root;
    public SortedBinTree(){
        root=null;
    }
    public SortedBinTree(T o){
        root=new Node(o,null,null,null);
    }
    //添加节点

    /**
     *  插入

     在排序二叉树中，插入元素首先要找插入位置，即新节点的父节点，
     怎么找呢？与查找元素类似，从根节点开始往下找，其步骤为：

     与当前节点比较，如果相同，表示已经存在了，不能再插入。
     如果小于当前节点，则到左子树中寻找，如果左子树为空，则当前节点即为要找的父节点。
     如果大于当前节点，则到右子树中寻找，如果右子树为空，则当前节点即为要找的父节点。
     找到父节点后，即可插入，如果插入元素小于父节点，则作为左孩子插入，否则作为右孩子插入。
     * @param ele
     */
    public void add(T ele){
        if(root==null){
            root=new Node(ele,null,null,null);
        }
        else {
            Node current=root;
            Node parent=null;
            int cmp=0;
            do {
                parent=current;
                cmp=ele.compareTo(current.data);
                if(cmp>0){
                    //以右子树作为当前的节点
                    current=current.right;
                }
                else {
                    //以左子树作为当前的节点
                    current=current.left;
                }
            }while (current!=null);
            //创建新的节点
            Node newNode=new Node(ele,parent,null,null);
            //如果新节点的值大于父节点的值
            if(cmp>0){
                //新节点作为父亲节点的右子节点
                parent.right=newNode;
            }
            //如果新节点的值小于父节点的值
            else
            {
                parent.left=newNode;
            }
        }
    }
    //删除节点 比较复杂
    /**
     *  分成三组：
     *  1.被删除节点为叶子节点 ---直接删除
     *  2.被删除节点只有一个孩子---则替换待删节点为孩子节点
     *  3.被删除节点既有左孩子还有右孩子---
     *  对于这种情况 ，将要删除节点的左子树取代被删除节点的位置，然后将右子树设置为要删除的节点的最右下方的节点
     *
     * @param ele
     */
    public void remove(T ele){
        Node target=getNode(ele);
        if(target==null){
            return;
        }
        //第一种情况
        if(target.left==null&&target.right==null){
            //被删除的节点是根节点
            if(target==root){
                root=null;
            }
            else {
                //被删除节点是父节点的左子节点
                if(target==target.parent.left){
                    target.parent.left=null;
                }else {
                    target.parent.right=null;
                }
                //释放指向父亲节点的引用，方便gc，避免内存泄露
                target.parent=null;
            }
        }
        //左子树为空 ，右子树不为空
        else if(target.left==null&&target.right!=null){
            //被删除节点是根节点
            if(target==root){
                root=target.right;
            }
            else {
                //被删除节点是父节点的左子节点
                if(target==target.parent.left){
                    target.parent.left=target.right;
                }else {
                    //让target的父节点的right指向target的右子树
                    target.parent.right=target.right;
                }
                //让target的parent指向target的parent
                target.right.parent=target.parent;
            }
        }else if(target.left!=null&&target.right==null){
            if(target==root){
                root=target.left;
            }
            else {
                //被删除节点是父节点的左子节点
                if(target==target.parent.left){
                    //让父节点的left指向target的左子树
                    target.parent.left=target.left;
                }else {
                    target.parent.right=target.left;
                }
                //
                target.left.parent=target.parent;
            }
        }else {
            //左右子树不为空
            //用leftMaxNode用于保存target节点的左子树值最大的节点
            Node leftMaxNode=target.left;
            //搜索target节点的左子树中值最大的点
            while (leftMaxNode.right!=null){
                leftMaxNode=leftMaxNode.right;
            }
            //从原来子树中删除leftMaxNode节点
            leftMaxNode.parent.right=null;//直接让父节点对其失去引用即可---》让其引用失去即可
            //让leftMaxNode的parent直接指向target的parent
            leftMaxNode.parent=target.parent;
            //如果被删的节点是父亲节点的左子节点
            if(target==target.parent.left){
                target.parent.left=leftMaxNode;
            }
            else {
                target.parent.right=leftMaxNode;
            }
            leftMaxNode.left=target.left;
            leftMaxNode.right=target.right;
            //去掉被删除节点对父亲 儿子节点的引用
            target.parent=target.left=target.right=null;


        }
    }
    private Node getNode(T ele){
        //从根节点开始搜索
        Node p=root;
        while (p!=null){
            int cmp=ele.compareTo(p.data);
            if(cmp<0){
                p=p.left;
            }
            else if (cmp>0){
                p=p.right;
            }
            else {
                return p;
            }
        }
        return null;
    }
    public List<Node> broadProiotyFirst(){
        Queue<Node> queue=new ArrayDeque<>();
        List<Node> list=new ArrayList<>();
        if(root!=null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            //将队列的对尾元素加入list
            list.add(queue.peek());
            Node p=queue.poll();
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
