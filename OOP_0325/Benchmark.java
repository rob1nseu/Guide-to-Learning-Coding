package ch01.OOP_0325;
import java.util.Arrays;
import java.lang.reflect.Array;

public abstract class Benchmark {
    protected final Integer[] Data=new Integer[1000];
    protected final Integer[] Answer=new Integer[1000];

    abstract Integer[] bubbleSorting();//抽象

    public final void  timeRecord()//记录排序时间的final方法
    {
        Integer[] a=new Integer[1000];
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            a=bubbleSorting();
        }
        boolean mark=true;
        for(int t=0;t<1000;t++)
        {
            if(a[t]!=Answer[t])
            {
                mark=false;
            }
        }
        if(mark) {
            long endtime = System.currentTimeMillis();
            System.out.println("Time:" + (endtime - starttime));
        }
    }
}
