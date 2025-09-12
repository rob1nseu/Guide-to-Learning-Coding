package ch01.OOP_0325;

import java.util.Arrays;

public class BenchmarkImpl extends Benchmark{
    public BenchmarkImpl()
    {
            Integer[] temp=new Integer[1000];
            for(int i=0;i<1000;i++)
            {
                this.Data[i]=(int)(Math.random()*100+1);
                temp[i]=this.Data[i];
            }
            Arrays.sort(temp);
            for(int i=0;i<1000;i++)
            {
                this.Answer[i]=temp[i];
            }
    }
    @Override
    Integer[] bubbleSorting()
    {
        Integer[] temp=new Integer[1000];
        int t=0;
        for(int i=0;i<1000-1;i++)
        {
            for(int j=0;j<1000-i-1;j++)
            {
                if(this.Data[i]>this.Data[i+1])
                {
                    Data[i]=t;
                    Data[i]=Data[i+1];
                    Data[i+1]=t;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
    BenchmarkImpl a=new BenchmarkImpl();
    a.timeRecord();
    }
}
