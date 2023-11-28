package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/29.
 */
public class Productor<T,S,U> {
    private  T part1;
    private  S part2;
    private  U part3;

    public Productor() {
    }

    public Productor(T part1, S part2, U part3) {
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    public T getPart1() {
        return part1;
    }

    public void setPart1(T part1) {
        System.out.println("创建part1");
        this.part1 = part1;
    }

    public S getPart2() {
        return part2;
    }

    public void setPart2(S part2) {
        System.out.println("创建part2");
        this.part2 = part2;
    }

    public U getPart3() {
        return part3;
    }

    public void setPart3(U part3) {

        System.out.println("创建part3");
        this.part3 = part3;
    }

    @Override
    public String toString() {
        return "Productor{" +
                "part1=" + part1 +
                ", part2=" + part2 +
                ", part3=" + part3 +
                '}';
    }
}
