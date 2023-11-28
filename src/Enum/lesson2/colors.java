package Enum.lesson2;

import Enum.lesson1.Color;

/**
 * Created by Administrator on 2016/11/15.
 * 枚举可以用在代码的各个角落，只要定义的对象具有枚举的形式，均可以使用枚举
 * 对其进行定义，在枚举里面也可以直接定义构造方法，另外需要注意的是一旦构造方法
 * 被定义后，则所有的枚举对象都必须明确的调用此构造方法
 */
public enum colors {
    Red("红色"),//前面声明的枚举类，要完全的按照后面定义的构造方法进行调用
    Bule("蓝色"),
    Green("绿色");
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //另外在枚举里面的构造方法是不能够被声明为public的，因为外部是不能够调用枚举的
    //构造方法的
    colors(String name){
        this.setName(name);
    }
}
