package PatternDesign.Adapter;

/**
 * Created by Administrator on 2016/11/13.
 */
//测试类完成对类适配器的调用
public class Client {
    public static void main(String [] args){
        Target concreTagget=new ConcreTarget();
        concreTagget.request();//普通类 具有 普通功能.
        AdapterOfClass adapterOfClass=new AdapterOfClass();
        adapterOfClass.request();//被适配类具有 特殊功能...
        Target adapetTarget=new AdapterOfObject(new Adaptee());
        adapetTarget.request();//被适配类具有 特殊功能...
    }
}
