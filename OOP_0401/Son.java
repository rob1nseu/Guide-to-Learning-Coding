package ch01.OOP_0401;

public class Son extends Father{
    public String name="Son";

    public void print(){
        System.out.println(name);
    }
    public static void main(String[] args) {
        Father person=new Son();
        person.showName();
    }
}
