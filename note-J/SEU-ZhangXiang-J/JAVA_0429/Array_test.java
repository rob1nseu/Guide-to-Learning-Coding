package ch01.JAVA_0429;

import java.util.Arrays;

public class Array_test {
    String[] str={"Robin","Kobe","kobe","Laoda","kobe"};

    public void run()
    {
        Arrays.sort(str);
        System.out.println("Array_1: "+Arrays.toString(str));
    }

    public static void main(String[] args) {
        Array_test test=new Array_test();
        test.run();
    }
}
