package IO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        // TODO 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(3333);

        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("等待连接");
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    System.out.println("已连接");

                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            System.out.println("开始输出");
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                            System.out.println("输出完毕");
                        } catch (IOException e) {
                        }
                    }).start();

                    new Thread(() -> {
                        try {
                            while (true) {
                                socket.getOutputStream().write((new Date() + ": from server").getBytes());
                                Thread.sleep(2000);
                            }

                        } catch (Exception e) {
                        }
                    }).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}