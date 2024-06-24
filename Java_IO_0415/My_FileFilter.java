package ch01.Java_IO_0415;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class My_FileFilter {
    private ArrayList<File> filenames;
    File path;
    String suffix;
    public My_FileFilter(File path,String s)
    {
        this.path=path;
        this.suffix=s;
        this.filenames=new ArrayList<>();
    }

    public void filter()
    {
        //若用户输入的path确实是一个文件夹
        if(path.isDirectory())
        {
            File[] fileInThisPath=path.listFiles();
            for(File f:fileInThisPath)
            {
                if(f.isDirectory())
                {
                    path=f;
                    filter();
                }
                else if(f.toString().endsWith(suffix))
                {
                    this.filenames.add(f);
                }
            }
        }
    }

    public void reverseSort()
    {
        Collections.sort(filenames,(f1,f2)->-f1.compareTo(f2));
        System.out.println(filenames.toString());
    }

    public static void main(String[] args) {
//        My_FileFilter lister=new My_FileFilter(new File("D:/ALL_PYTHON/"),".py");
//        lister.filter();
//        lister.reverseSort();
        ArrayList<Integer> array= new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            array.add(i);
        }
        System.out.println(array);
        array.clear();
        System.out.println(array);
    }
}

