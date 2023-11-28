package Enum.lesson2;

/**
 * Created by Administrator on 2016/11/15.
 * 当一个枚举实现一个接口时，每个枚举对象都必须实现接口里面的抽象方法
 */
public enum MyColors implements Info {

      RED {
          @Override
          public String getColor() {
              return "红色";
          }
      },
    Green {
        @Override
        public String getColor() {
            return "蓝色";
        }
    },
    Blue {
        @Override
        public String getColor() {
            return "绿色";
        }
    }
}
