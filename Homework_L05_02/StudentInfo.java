package ch01.Homework_05_02;

/**
 * @author 09022211李宾
 * 创建一个StudentInfo类，保存学生信息
 * **/
public class StudentInfo
{
    public String id;
    public String name;
    public double score;
    public StudentInfo(String id,String name,double score)
    {
        this.id=id;
        this.name=name;
        this.score=score;
    }
    @Override
    /*重载toString函数 方便输出*/
    public String toString()
    {
        return id+" "+name+" "+score+" ";
    }
}
