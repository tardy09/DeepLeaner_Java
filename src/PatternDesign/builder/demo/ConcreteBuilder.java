package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/29.
 */
public  class ConcreteBuilder extends Builder {
    //具体的产品。。
    private Productor productor;

    public ConcreteBuilder(Productor productor) {
        this.productor = productor;
    }

    @Override
    public void buildPartA() {
        // 在此创建出部件
        String part1A="part1A";
        // 把partA传递给product
        productor.setPart1(part1A);
    }

    @Override
    public void buildPartB() {
        String partB="part2";
        productor.setPart2(partB);
    }

    @Override
    public void buildPartC() {
       String part3="part3";
        productor.setPart3(part3);
    }
    // 返回复杂产品对象

    public Productor<String, String, String> getProductor() {
        return productor;
    }

}
