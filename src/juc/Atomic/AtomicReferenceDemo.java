package juc.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2017/2/24.
 * AtomicReference用来以原子方式更新复杂类型，它有一个类型参数，
 * 使用时需要指定引用的类型。以下代码演示了其基本用法：
 */
public class AtomicReferenceDemo {
    static class Pair {
        final private long first;
        final private long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        public long getFirst() {
            return first;
        }

        public long getSecond() {
            return second;
        }
    }
    class Mytask implements Runnable{
        Pair pair;
        AtomicReference<Pair> pairRef;
        Mytask(Pair pair,AtomicReference<Pair> pairAtomicReference){

            this.pair=pair;
            this.pairRef=pairAtomicReference;
        }
        @Override
        public void run() {
            System.out.println("jsdssssss");
              this.updatePair(pair,new Pair(100,Math.round(5.7)));
            System.out.println(Thread.currentThread().getName()+"更新 后"+pair.getFirst());
        }
        private void updatePair(Pair P,Pair neP){
            pairRef.compareAndSet(P,neP);
        }
    }
    public static void main(String[] args) {
        Pair p = new Pair(100, 200);
        AtomicReference<Pair> pairRef = new AtomicReference<>(p);
        Mytask mytask=new AtomicReferenceDemo().new Mytask(p,pairRef);
        for (int i = 0; i < 6; i++) {
            System.out.println("*6s6w6w");
            Thread thread=new Thread(mytask,"sub_thread"+i);
            thread.start();
        }
        pairRef.compareAndSet(p, new Pair(100, 100));
        System.out.println(p.getFirst());


        System.exit(0);
    }
}
