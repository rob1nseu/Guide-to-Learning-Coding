package ch01.MultiThread_ATM;

public class ATM_thread {
    ATM O;
    Thread tom;
    Thread mary;
    public ATM_thread()
    {
        O=new ATM();
        tom=new Thread(new TomTask(O),"Tom");
        mary=new Thread(new MaryTask(O),"Mary");
        tom.start();
        mary.start();
    }

    public static void main(String[] args) {
        ATM_thread threads=new ATM_thread();
    }
}
