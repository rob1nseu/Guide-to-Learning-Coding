package ch01.JAVA_BASIC_b0325;
import java.util.ArrayList;

/**
 * @author JumpingRobin
 * @serial JAVA-张祥-Week5
 * 2024年3月18日
 * */

public class House_GC_experiment {
    private int space=100;
    House_GC_experiment(int space)
    {
        this.space=space;
    }
    public static void main(String[] args) {
        System.gc();
        System.out.println("Memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("Creating Houses ......");
        ArrayList<House_GC_experiment> Houses=new ArrayList<>();
        for(int i=0;i<1e2;i++)
        {
            Houses.add(new House_GC_experiment(150));
        }
        //当b>a时，出现了扩容现象
        System.out.println("Memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("Collecting Garbage ......");
        System.gc();
        //垃圾回收后 可用内存 c<a -->内存泄漏
        System.out.println("Memory: "+Runtime.getRuntime().freeMemory());
    }
}

//1、JAVA中的动态数组--Arraylist  ---在 java.util.ArrayList 包内
// (1) 初始化
// ArrayList<E> objectName =new ArrayList<>();  其中E为泛型数据类型 只能为引用数据类型

// (2) 添加元素    objectname.add()

// (3) 删除元素    objectname.remove(k)  其中k为索引

// (4) 关于引用类型的补充
// 若使用基本数据类型 需要使用它的包装类  如: int -> Integer

// (5)ArrayList 排序
// import java.util.Collections;  引入 Collections 类
// Collection.sort(Arraylist)     默认为升序排序

//2、toString() 转化为字符串表示
// System.out.println(对象名)   等价于   System.out.println(对象名.toString());
// （1）重载对象Object父类中的方法
//      public String toString()
//    {
//        return this.name;
//    }
//  重载时请去查看 java.lang.Object
//
// （2）补充：Object对象中的常用可重载方法
//      1)toString()
//      2)hashCode()
//      3)clone()
//      4)equals()