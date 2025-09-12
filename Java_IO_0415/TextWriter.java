package ch01.Java_IO_0415;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
    public static void main(String[] args) {
        try{
            File f=new File("D:/ALL_PYTHON/hello.txt");
            FileWriter writer=new FileWriter(f,true);
            writer.write("CSE");
            writer.write("计算机科学与工程学院");
            writer.flush(); //待缓存区清空再读取
            FileReader reader=new FileReader(f);
            int character=reader.read();
            while(character!=-1)
            {
                System.out.println((char)character);
                character=reader.read();
            }
        }
        catch(IOException e)
        {
            System.out.println("幽默？！");
        }
    }
}
