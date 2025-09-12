package ch01.HomeWork_04_02;

/**
 * 09022211 李宾
 * StudentInfoManager 学生信息管理类
 * 管理所有的StudentInfo对象  并设计writeFile与readFile接口，将记录写入文件中
 * **/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoManager {

    private static final String FILE_NAME = "student_records.txt";

    // 将记录写入student_records.txt文件
    public static void writeRecordsToFile(List<StudentInfo> records)
    {
        try
        {
            //利用BufferedWriter 先将文件写入缓冲区 再统一写入内存 提升代码性能
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (StudentInfo record : records)
            {
                //调用record记录中重载的toString
                writer.write(record.toString());
                //换行
                writer.newLine();
            }
        } catch (IOException e)
        {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // 从student_records.txt文件中读取记录
    public static List<StudentInfo> readRecordsFromFile()
    {
        List<StudentInfo> records = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            //当line不为空时 将String类的line字符串按照“ ”进行分隔成多个子串
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(" ");
                if (parts.length == 3)
                {
                    String studentId = parts[0];
                    String name = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    records.add(new StudentInfo(studentId, name, score));
                }
            }
        } catch (IOException e)
        {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return records;
    }

    // 打印record里的所有记录
    public static void displayRecords(List<StudentInfo> records)
    {
        for (StudentInfo record : records)
        {
            System.out.println(record);
        }
    }

    // 添加新记录
    public static void addRecord(String studentId, String name, double score)
    {
        List<StudentInfo> records = readRecordsFromFile();
        records.add(new StudentInfo(studentId, name, score));
        writeRecordsToFile(records);
    }

    // 主方法
    public static void main(String[] args)
    {
        // 题设中要求的初始记录列表
        List<StudentInfo> initialRecords = new ArrayList<>();
        initialRecords.add(new StudentInfo("71108501", "张三", 80.0));
        initialRecords.add(new StudentInfo("71108502", "李四", 79.5));
        initialRecords.add(new StudentInfo("71108503", "王五", 91.0));
        initialRecords.add(new StudentInfo("71108504", "赵六", 60.0));
        initialRecords.add(new StudentInfo("71108505", "宋七", 18.6));
        // 将上面的学生信息写入文件
        writeRecordsToFile(initialRecords);
        // 读取并显示学生信息记录
        List<StudentInfo> records = readRecordsFromFile();
        System.out.println("Initial records:");
        displayRecords(records);
        // 添加学生信息
        addRecord("71108506", "李宾", 100.0);
        // 读取并打印添加学生信息后的当前Info列表
        records = readRecordsFromFile();
        System.out.println("\nRecords after adding a new record:");
        displayRecords(records);
    }
}