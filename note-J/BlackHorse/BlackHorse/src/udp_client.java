import java.net.*;

// UDP通信客户端
public class udp_client {
    public static void main(String[] args) throws Exception {
        // 1、创建UDP客户端socket
        DatagramSocket ds = new DatagramSocket(); // 若不指定端口号，自动分配一个可用端口

        // 2、创建发向localhost:10086端口的数据包
        String msg = "Hello, Server!";
        byte[] data = msg.getBytes(); // 将字符串转化为字节数组
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 10086);

        // 3、发送数据包
        ds.send(packet);

        System.out.println("UDP客户端发送完毕！");
    }
}
