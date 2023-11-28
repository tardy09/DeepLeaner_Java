package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/29.
 */
public class Client {
    public static void main(String [] args){
        // 对于客户端而言，只需要关心具体的建造者，无需关心产品内部构建流程。
        // 我如果需要其他的复杂产品对象，只需要选择其他的建造者，如果需要扩展，则只需要写一个新的builder就行。
        // 如果可以，这个建造者甚至可以用配置文件做，增加更多的扩展性。
        Builder builder=new ConcreteBuilder(new RobotProductFayctory().getProduct());//可考虑使用工厂模式来提高灵活性
        // 把建造者注入导演
        Director director = new Director(builder);
        // 指挥者负责流程把控
        director.build();
        // 建造者返回一个组合好的复杂产品对象
        //Productor productor = builder.g();
        System.out.println();
    }
}
