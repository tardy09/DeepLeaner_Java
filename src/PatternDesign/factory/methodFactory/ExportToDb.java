package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 */
public class ExportToDb implements ExportFileApi {
    @Override
    public boolean exportData(String data) {

        System.out.println("导出"+data+"到数据库");
        return true;
    }
}
