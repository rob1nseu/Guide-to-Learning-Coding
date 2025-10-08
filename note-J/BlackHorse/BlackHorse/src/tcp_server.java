import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server {
    public static void main(String[] args) throws IOException {
        System.out.println("---服务器端启动---");
        // 1、注册服务器端socket，监听10086端口
        ServerSocket serverSocket = new ServerSocket(10086);

        // 循环接收客户端连接
        while (true) {
            // 2、等待多客户端连接，获取下一用户socket连接
            Socket serversocket = serverSocket.accept();
            System.out.println(serversocket.getRemoteSocketAddress() + " 连接成功");
            // 3、创建线程对象，启动线程
            new tcpServerReaderThread(serversocket).start();
        }
    }
}
