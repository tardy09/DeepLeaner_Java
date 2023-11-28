package learnibf;

public class CommonFisrtNodeOfList {
	/**http://blog.csdn.net/troubleshooter/article/details/7705769
	 * 数据结构 - 如何判断两个无环单链表是否相交；
	 * 如果相交，给出相交的第一个结点
	 * 比较好的方法有两个：
将其中一个链表首尾相连，检测另外一个链表是否存在环；
如果存在，则两个链表相交，而检测出来的环入口即为相交的第一个结点。
如果两个链表相交，那个两个链表从相交点到链表结束都是相同的节点。
我们可以先遍历一个链表，直到尾部，再遍历另外一个链表，如果也可以走到同样的结尾点，
则两个链表相交。这时我们记下两个链表的长度，再遍历一次。长链表节点先出发前进
（长链表长度-短链表长度）步，之后两个链表同时前进，
每次一步，相遇的第一点即为两个链表相交的第一个点。

 编程之美: 求二叉树中节点的最大距离
 http://blog.csdn.net/gao1440156051/article/details/51692410
 http://blog.csdn.net/pediy_yuhan/article/details/18619375
	 */
	public  void  soluction(){
		
		
		
	}

}
