package PatternDesign.builder.demo;
/**
 * Created by Administrator on 2016/11/29.
 *
 * 这是导演，负责流程规范，在导演类中可以注入建造者对象。
 */
public class Director {
    private Builder builder;
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    public Director(Builder builder) {
        this.builder = builder;
    }
    public void build(){
        builder.buildPartB();
        builder.buildPartA();

        builder.buildPartC();
    }
}
