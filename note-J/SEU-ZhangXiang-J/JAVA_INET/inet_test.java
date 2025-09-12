package ch01.JAVA_INET;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class inet_test
{
    public void getIP()
    {
        try
        {
            InetAddress iaddr=InetAddress.getLocalHost();
            String localIP=iaddr.getHostAddress().toString();
            String hostName=iaddr.getHostName().toString();
            System.out.println("IP address: "+localIP);
            System.out.println("Hostname: "+hostName);
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        inet_test i=new inet_test();
        i.getIP();
    }
}
