package InterView.Algotrithm;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/14.
 */
public class TwoStackForQuene
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * s1的栈顶永远指向入队元素
     * s2的栈顶指向出队列元素--其中s2保证是正序排列的
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while (stack1.size()!=1){
            if(stack1.isEmpty()){
                break;
            }
            stack2.push(stack1.pop());
        }
        System.out.println(stack1.pop()+" ");
        return stack1.pop();
    }
    public static  void  main(String [] args){
        TwoStackForQuene twoStackForQuene=new TwoStackForQuene();
        twoStackForQuene.push(1);
        twoStackForQuene.push(2);
        twoStackForQuene.push(3);
        twoStackForQuene.pop();
        twoStackForQuene.pop();
        twoStackForQuene.push(4);
        twoStackForQuene.pop();
        twoStackForQuene.push(5);
        twoStackForQuene.pop();
        twoStackForQuene.pop();

    }
}
