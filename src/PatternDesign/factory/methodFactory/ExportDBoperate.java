package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 */
public class ExportDBoperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportToDb();
    }
}
