package PatternDesign.Adapter;

/**
 * Created by Administrator on 2016/11/13.
 */
class AdapterOfObject implements Target
{
    private Adaptee adaptee;
    public AdapterOfObject(Adaptee adaptee){
        this.adaptee=adaptee;
    }
    @Override
    public void request() {
           this.adaptee.specificRequest();
    }
}
