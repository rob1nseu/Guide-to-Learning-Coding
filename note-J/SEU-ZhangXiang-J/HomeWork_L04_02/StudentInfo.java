package ch01.HomeWork_04_02;
/*
 * @author 09022211李宾
 * StudentInfo 学生信息类
 * 保存studentId、name、score的private变量
 * 提供对上述三个变量的get操作 不支持初始化后对变量的修改
 * **/
public class StudentInfo {
    private String studentId;//学生学号
    private String name;//学生姓名
    private double score;//学生成绩

    public StudentInfo(String studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    /*重载Object类中的toString()方法。返回需要的输出格式*/
    public String toString() {
        return studentId + " " + name + " " + score;
    }
}
