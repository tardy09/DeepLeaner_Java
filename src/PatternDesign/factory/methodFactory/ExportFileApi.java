package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 *
 *   导出文件接口对象 相当于最终需要的对象的顶层抽象---根据需要决定需要何种具体的product
 */
public interface ExportFileApi {
    public boolean exportData(String data);
}
