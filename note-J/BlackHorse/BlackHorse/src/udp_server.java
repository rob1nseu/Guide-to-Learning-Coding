import java.net.*;
// UDP通信服务器端
public class udp_server{
    public static void main(String[] args) throws Exception{
        System.out.println("-----开启UDP服务端-----");
        // 1、创建UDP服务器端socket
        DatagramSocket ds = new DatagramSocket(10086); // 约定服务端的端口号为10086

        // 2、创建接收数据包的韭菜盘子
        byte[] buffer = new byte[1024*64]; // 创建64kb的字节数组
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // 3、服务端socket接收发送到当前
        ds.receive(packet);
        String rcv = new String(packet.getData(),0,packet.getLength());

        // 读取当前所接收数据包
        System.out.println(rcv);
    }
}
