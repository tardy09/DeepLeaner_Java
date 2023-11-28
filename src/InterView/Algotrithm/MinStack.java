package InterView.Algotrithm;

import java.util.Stack;

/**
 * Created by Administrator on 2017/4/14.
 * 定义栈的数据结构，
 *  请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStack {
    Stack<Integer> stack1=new Stack();
    Stack<Integer> stack2=new Stack();//使用一个附加的栈结构，如果当前的栈为 空，
    // 那么就直接将该元素放入到栈里面  ，s2存储当前的栈结构里面的最小值
    //
    public void push(int node) {
        //存储当前栈结构里面的最小值

         if(stack1.empty()){
             stack1.push(node);
             stack2.push(node);
         }else {
             if(node<stack2.peek()){
                 //更新 最小栈结构
                 stack2.push(node);
                 stack1.push(node);
             }
             else {
                 stack1.push(node);
             }
         }
    }

    public void pop() {
        if (stack2.peek()==stack1.peek()){
            stack1.pop();
            stack2.pop();
        }
        else {
            stack1.pop();
        }
    }

    public int top() {
       return stack1.peek();
    }

    public int min() {
       return  stack2.peek();
    }

    /**
     *  1,4,2,7,8
     *
     *  分析
     *  1.  s1 {1}              s2{1}
     *  2.
     * @param args
     */
    public static void main(String [] args){
       MinStack minStack=new MinStack();
       minStack.push(3);
       minStack.push(4);
       minStack.push(2);
       minStack.push(7);
        System.out.println("vvvvv");
    }
}
