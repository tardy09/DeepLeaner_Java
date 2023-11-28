package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 */
public class ExportTextOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTextFile();
    }
}
