import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

public class tcp_client {
    public static void main(String[] args) throws Exception {
        // 1、创建TCP客户端socket，申请与Localhost:10086端口的连接
        Socket socket = new Socket(InetAddress.getLocalHost(),10086);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要发送的消息：");
        String msg = sc.nextLine();

        while (!Objects.equals(msg, "exit")) {
            // 2、获取socket的输出流，向服务器端发送数据
            socket.getOutputStream().write(msg.getBytes());
            // 重新获取用户数据输入
            System.out.println("请输入要发送的消息：");
            msg = sc.nextLine();
        }
        // 3、关闭客户端socket
        socket.close();
    }
}
