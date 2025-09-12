package ch01.Homework_05_02;

import java.util.HashMap;
/**
 * @author 09022211李宾
 * 创建一个HashMap_demo类 将学生信息保存在此类的一个实例中
 * HashMap_demo类中存在一个类型为 HashMap<Integer,StudentInfo> 的HashMap
 * **/
public class HashMap_demo
{
    public HashMap<Integer,StudentInfo> hashMap_student;
    public HashMap_demo()
    {
        hashMap_student=new HashMap<Integer,StudentInfo>();
    }
    public static void main(String[] args)
    {
        //利用Hashmap的put方法 将数据写入HashMap中
        HashMap_demo map=new HashMap_demo();
        map.hashMap_student.put(1,new StudentInfo("71108501","张三",80.0));
        map.hashMap_student.put(2,new StudentInfo("71108502","李四",79.5));
        map.hashMap_student.put(3,new StudentInfo("71108503","王五",91.0));
        map.hashMap_student.put(4,new StudentInfo("71108504","赵六",60.0));
        map.hashMap_student.put(5,new StudentInfo("71108505","宋七",18.6));
        //利用HashMap中的get方法 打印HashMap中的内容
        for(int i=1;i<=map.hashMap_student.size();i++)
        {
            System.out.println(map.hashMap_student.get(i)+"");
        }
    }
}
