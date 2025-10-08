import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

// 服务端多线程的线程类
public class tcpServerReaderThread extends Thread {
    private Socket socket;

    // 构造函数（利用主线程传递的socket对象）
    public tcpServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    // 重写run方法（线程执行的代码）
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            // 循环读取客户端发送的数据
            while (true) {
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if (len == -1) {
                    System.out.println(socket.getRemoteSocketAddress() + " 断开连接");
                    socket.close();
                    inputStream.close();
                    break;
                }
                System.out.println(socket.getRemoteSocketAddress() + ": " + new String(buffer, 0, len));
            }
        } catch (Exception e) {
            System.out.println("【服务端多线程出错】");
        }
    }
}