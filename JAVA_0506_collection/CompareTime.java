package ch01.JAVA_0506_collection;

//只需要进行list1与list2的名称变换即可
//对了 还要改一下temp的数据类型
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CompareTime {
    public static void main(String[] args) {
        int times=1000;
        int rounds=10000;
        LinkedList<String> list_1=new LinkedList<String>();
        ArrayList<String> list_2=new ArrayList<String>();
         for(int i=0;i<times;i++)
         {
             list_1.add("Tommy");
         }
         for(int i=0;i<times;i++)
         {
             list_2.add("Robby");
         }
        LinkedList<String> temp=list_1;

         //对链表get(i)
        long time_11=System.currentTimeMillis();
        for(int i=0;i<rounds;i++)
        {
            for(int j=0;j<times;j++)
            {
                list_1.get(j);
            }
        }
        long time_12=System.currentTimeMillis();
        System.out.println(time_12-time_11);
        System.gc();

        //遍历链表的元素
        Iterator<String> it_1=list_1.iterator();
        long time_13=System.currentTimeMillis();
        for(int i=0;i<rounds*500;i++)
        {
            while(it_1.hasNext())
            {
                String a=it_1.next();
            }
        }
        long time_14=System.currentTimeMillis();
        System.out.println(time_14-time_13);
        System.gc();

        //对链表进行插入100000个元素的操作
        long time_15=System.currentTimeMillis();
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<times;j++)
            {
                list_1.add(j,"Happy");
            }
            //对list_1进行还原
            list_1=temp;
        }
        long time_16=System.currentTimeMillis();
        System.out.println(time_16-time_15);
        System.gc();

        //delete one by one
        list_1=temp;
        Iterator<String> it_2=list_1.iterator();
        long time_17=System.currentTimeMillis();
        for(int i=0;i<rounds*500;i++)
        {
            list_1=temp;
            while(!list_1.isEmpty())
            {
                list_1.removeLast();
            }
        }
        long time_18=System.currentTimeMillis();
        System.out.println(time_18-time_17);
        System.gc();
    }
}
