package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 *  导出到文件的对象
 *
 */
public class ExportTextFile implements ExportFileApi {
    @Override
    public boolean exportData(String data) {
        System.out.println("导出"+data+"到text文件");
        return true;
    }
}
