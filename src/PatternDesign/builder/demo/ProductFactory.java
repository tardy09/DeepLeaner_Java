package PatternDesign.builder.demo;

/**
 * Created by Administrator on 2016/11/30.
 *  //定义产品工厂。。。来获取需要的产品
 */
public abstract class ProductFactory {
   public abstract Productor getProduct();
   public void showProductInfo(){
       getProduct().toString();
   }
}
