package PatternDesign.factory.methodFactory;

/**
 * Created by Administrator on 2016/11/30.
 *   顶层的Creator
 */
public abstract class ExportOperate {
    public boolean export(String data){
        ExportFileApi api=factoryMethod();

        return api.exportData(data);
    }

    protected abstract ExportFileApi factoryMethod();

}
