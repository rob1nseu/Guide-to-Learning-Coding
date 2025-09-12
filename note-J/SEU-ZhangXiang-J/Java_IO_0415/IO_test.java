package ch01.Java_IO_0415;
import java.io.*;

public class IO_test {

    public static void main(String[] args) {
        File f=new File("D:/ALL_PYTHON/hello.txt");
        try{
            FileInputStream fis=new FileInputStream(f);
            FileOutputStream fos=new FileOutputStream(f);
            fos.write(97);
            fos.write('b');
            fos.write(new String("好").getBytes());
            System.out.println(fis.available()+" size");
            int i=fis.read();
            while(i!=-1)
            {
                System.out.println((char)i);
                i=fis.read();
            }
            fos.close();
            fis.close();
        }
        catch (IOException e) {
            System.out.println("WTF");
        }
    }
}
