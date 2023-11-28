package PatternDesign.lesson2;

/**
 * Created by Administrator on 2016/11/18.
 */
public class Soldier {
    private AbstractGun abstractGun;
    public void setGun(AbstractGun abstractGun){
        this.abstractGun=abstractGun;
    }
    public void killEnimey(){
        System.out.println("士兵开始杀人了,,,,,,,,");
        abstractGun.shoot();
    }
}
