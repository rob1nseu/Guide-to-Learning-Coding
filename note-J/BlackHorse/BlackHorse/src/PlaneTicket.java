import java.util.Scanner;
public class PlaneTicket{
    public static void main(String[] args) {
        // 1、键入机票原价、月份、头等舱
        Scanner sc = new Scanner(System.in); // 初始化Scanner对象
        System.out.println("请输入机票的价格");
        double price = sc.nextDouble();
        System.out.println("请输入当前月份");
        int month = sc.nextInt();
        System.out.println("请输入舱位：0--经济舱：1--头等舱");
        int seat_level = sc.nextInt();

        // 2、通过月份判断是否为淡季/旺季 或 头等/经济
        if(month>=5 && month<=10)
        {
            if(seat_level==0){price*=0.85;}
            else if(seat_level==1){price*=0.9;}
        }
        else if(month>=1 && month<=12)
        {
            if(seat_level==0){price*=0.65;}
            else if(seat_level==1){price*=0.7;}
        }
        else{
            System.out.println("月份输入非法！");
        }

        System.out.println(price);
    }

}