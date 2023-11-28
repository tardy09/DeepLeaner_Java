package Tree;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/12..
 *  1.初始化操作
 *   2.判断二叉树是否为空
 *   3.为指定的节点增加子节点
 *   4.返回根节点
 *   5.返回指定节点（非根节点）的父节点
 *   6.返回指定节点的左子节点
 *   7，返回指定节点的右子节点
 *   8.返回二叉树的深度
 *   9.返回指定节点的位置
 *   顺序存储实现的二叉树，充分利用了满二叉树的性质，----每一层的节点数依次为：
 *   1， 2,4，8，.....2^i-1,也就是一棵深度为i的二叉树最多包含2^i-1个节点
 *   因此需要定义一个长度为2^i-1的数组就可以存储这课二叉树
 *     对于普通二叉树，那些空出来的节点对应的数组元素留空就可以了，
 *     由此可见，二叉树采用顺序存储会造成一定的空间浪费，
 */
public class ArrayBinTree<T> {
    //使用数组来记录树的所有节点
    private Object[] datas;
    private int DAFAULT_DEEP=8;
    private int deep;
    private int arraySize;
    public ArrayBinTree(){
        this.deep=DAFAULT_DEEP;
        this.arraySize=(int)Math.pow(2,deep)-1;
        datas=new Object[arraySize];
    }
    //通过指定的深度创建二叉树
    public ArrayBinTree(int deep){
        this.deep=deep;
        this.arraySize=(int) Math.pow(2,deep)-1;
        datas=new Object[arraySize];
    }
    //通过指定深度，指定根节点创建二叉树
    public ArrayBinTree(int deep,T data){
        this.deep=deep;
        this.arraySize=(int) Math.pow(2,deep)-1;
        datas=new Object[arraySize];
        datas[0]=data;
    }

    /**
     * 为指定的节点 添加子节点
     * @param index  需要添加子节点的父节点的索引
     * @param data   新的子节点的数据
     * @param left   是否为左节点
     */
    public void add(int index,T data,boolean left){
        if(datas[index]==null){
            throw new RuntimeException(index+"处节点不存在");
        }
        if(2*index+1>=arraySize){
            throw new RuntimeException("树的底层数组已满，无法添加");
        }
        if(left){
            datas[2*index+1]=data;
        }
        else {
            datas[2*index+2]=data;
        }
    }
    public boolean isEmpty(){
        return datas[0]==null;
    }
    public T root(){
        return (T) datas[0];
    }
    //返回指定节点（非根节点）的父亲节点
    public T parent(int index){
        return (T) datas[(index-1)/2];
    }
    public T left(int index){
        if(2*index+1>=arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[2*index+1];
    }
    public T right(int index){
        if(2*index+1>=arraySize){
            throw new RuntimeException("该节点为叶子节点，无子节点");
        }
        return (T) datas[2*index+2];
    }
    public int deep(int index){
        return deep;
    }
    //返回指定的节点的位置
    public int pos(T data){
        for (int i=0;i<arraySize;i++){
            if(datas[i].equals(data)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        return Arrays.toString(datas);
    }
}
