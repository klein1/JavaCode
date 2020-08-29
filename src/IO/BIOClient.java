package IO;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3333);

        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                while (true) {
                    socket.getOutputStream().write((new Date() + ": from client").getBytes());
                    Thread.sleep(2000);
//                        socket.getOutputStream().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    int len;
                    byte[] data = new byte[1024];
                    InputStream inputStream = socket.getInputStream();
                    while ((len = inputStream.read(data)) != -1) {
                        System.out.println(new String(data, 0, len));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}