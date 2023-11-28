package InterView.Hash;

import java.util.HashSet;

/**
 * Created by Administrator on 2017/3/7.
 */
public class Client {
    public static void main(String [] args)
    {
        Person p1=new Person("hi",30);
        Person p2=new Person("hi",30);
        System.out.println(p1.equals(p2));
        HashSet hashSet=new HashSet();
        System.out.println("p1的 hashCode"+p1.hashCode());
        System.out.println("p2的 hashCode"+p2.hashCode());
        System.out.println(p1==p2);
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet.size());
    }
}
