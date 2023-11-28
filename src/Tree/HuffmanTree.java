package Tree;

import java.util.List;

/**
 * Created by Administrator on 2016/11/12.
 * 哈弗曼树
 * 节点之间的路径长度：从一个节点到另一个节点的分支数量成为两个节点的路径长度
 * 树的路径长度：从根节点到树的每一个节点的路径长度之和
 * 节点的带权路径长度：从该节点到根节点的路径长度和节点上的权值的乘积
 * 树的带权路径长度：树中所有的叶子节点的带权路径长度之和
 * 带权路径长度最小的二叉树称之哈夫曼树
 *有
 *   另外对于哈弗曼树而言：n个叶子节点的哈弗曼树一共需要2*n-1个节点，因为
 *   对于二叉树而言，有三种类型的节点：度数为2的节点和度数为1的节点，以及度数为
 *   0的叶子节点，而哈弗曼树的非叶子节点都是由两个节点合并而来，因此，不会出现
 *   度数为1的节点，而生成的非叶子节点的个数为叶子节点的个数-1，因此n个叶子节点的哈弗曼
 *   树，一共需要2*n-1个节点，。
 *
 *   关于哈弗曼编码：假设有n个叶子节点需要编码，最终得到的哈弗曼树一定有N层，哈弗曼树得到的二进制的最大长度为n-1
 */
public class HuffmanTree {
    public static class Node<E> {
        E data;
        double weight;
        Node leftChild;
        Node rightChild;

        public Node(E data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static Node createTree(List<Node> nodes){
        //只要nodes数组里面具有两个以上的节点
        while (nodes.size()>1){
            QuickSort(nodes);
            //获取两个权值最小的节点
            Node left=nodes.get(nodes.size()-1);
            Node rigth=nodes.get(nodes.size()-2);
            //生成新的节点,新的节点的权值等于
            Node parent=new Node(null,left.weight+rigth.weight);
            parent.leftChild=left;
            parent.rightChild=rigth;
            nodes.remove(nodes.size()-1);
            nodes.remove(nodes.size()-1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    //实现快速排序算法，，用于对节点进行排序
    private static void subSort(List<Node> nodes,int start,int end){
        if(start<end) {
            //以第一个元素作为分界值
            Node base = nodes.get(start);
            //定义左指针i 从左边进行搜索，搜索大于分界值得元素的索引
            int i = start;
            //j从右边搜索，搜寻小于分界值的元素的索引
            int j = end + 1;
            while (true)
            {
                //找到大于分界值的元素的索引，或者i已经到达了end处
                while (i < end && nodes.get(++i).weight >= base.weight)
                    //找到小于分界值的元素的索引，或者j已经到达了start处
                    while (j > start && nodes.get(--j).weight <= base.weight);
                if(i<j){
                    swap(nodes,i,j);
                }
                else {
                    break;
                }
            }
            //碰头时候交换关键字
            swap(nodes,start,j);
            //递归左边子序列
            subSort(nodes,start,j-1);
            //递归右边子序列
            subSort(nodes,j+1,end);
        }
    }
    public  static void QuickSort(List<Node> nodes){
        subSort(nodes,0,nodes.size()-1);
    }
    private static void swap(List<Node> nodes,int i,int j){
        Node tmp;
        tmp=nodes.get(i);
        nodes.set(i,nodes.get(j));
        nodes.set(j,tmp);
    }
}

