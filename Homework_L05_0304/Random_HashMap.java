package ch01.Homework_05_0304;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 09022211李宾
 * 利用Random随机类中的nextInt()方法 生成随机整数
 * 再利用此整数在String[]中进行索引查找 得到搭配姓+名 得到随机英文名 --存入HashMap中
 * **/
public class Random_HashMap
{
    public static void main(String[] args)
    {
        // 创建一个HashMap实例
        HashMap<String, Integer> map = new HashMap<>();

        // 随机生成1000个姓名记录，并放入HashMap中
        for (int i = 0; i < 1000; i++)
        {
            String name = generateRandomName();
            int score = generateRandomScore();
            map.put(name, score);
        }

        // 保存HashMap到文件中
        saveHashMapToFile(map, "hashmap.dat");

        // 从文件中读取HashMap
        HashMap<String, Integer> loadedMap = loadHashMapFromFile("hashmap.dat");

        // 验证读取的HashMap是否正确
        if (loadedMap != null)
        {
            //利用包含键值对的Entry方法 for-each进行输出
            for (Map.Entry<String, Integer> entry : loadedMap.entrySet())
            {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    // 随机生成一个英文姓名 firstName+LastName
    private static String generateRandomName()
    {
        //名字纯属胡思乱想
        String[] firstNames = {"SEU","Robin","Tom","Kobe","Messi","John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah", "David", "Laura"};
        String[] lastNames = {"Mamba","Coco","Jay","Li","Tao","Jackie","JAVA","Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Martinez", "Hernandez"};
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
    }

    // 随机生成一个成绩
    private static int generateRandomScore()
    {
        Random random = new Random();
        // 生成0到99之间的随机成绩
        return random.nextInt(100);
    }

    // 将HashMap保存到文件
    private static void saveHashMapToFile(HashMap<String, Integer> map, String fileName)
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            oos.writeObject(map);
            System.out.println("HashMap已保存到文件：" + fileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 从文件中读取HashMap
    private static HashMap<String, Integer> loadHashMapFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName)))
        {
            HashMap<String, Integer> map = (HashMap<String, Integer>) ois.readObject();
            System.out.println("HashMap已从文件读取：" + fileName);
            return map;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}