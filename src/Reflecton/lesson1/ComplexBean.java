package Reflecton.lesson1;

/**
 * Created by Administrator on 2016/11/19.
 */
public class ComplexBean {
    private String name;

    private Bean refBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bean getRefBean() {
        return refBean;
    }

    public void setRefBean(Bean refBean) {
        this.refBean = refBean;
    }

    @Override
    public String toString() {
        return "ComplexBean{" +
                "name='" + name + '\'' +
                ", refBean=" + refBean +
                '}';
    }
}
