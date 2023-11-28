package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 */
public class Client {
    public static void main(String [] args){
        ExportOperate exportOperate=new ExportTextOperate();
        exportOperate.export("测试数据");//导出测试数据到text文件
    }
}
