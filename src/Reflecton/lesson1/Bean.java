package Reflecton.lesson1;

/**
 * Created by Administrator on 2016/11/19.
 */
public class Bean {
    private String name;
    private boolean flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
