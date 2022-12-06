package Charting_Room;

import java.io.IOException;
import java.net.Socket;

//客户端界面
public class Client {
    public static void main(String[] args) {
        Socket serverSocket = null;
        try
        {
            serverSocket = new Socket("127.0.0.1",8888);// 根据IP和port获取和服务端连接的Socket对象
            ClientToServerThread clientToServerThread = new ClientToServerThread(serverSocket);//向服务端发送消息
            ServerThread serverThread = new ServerThread(serverSocket);//接收服务端的消息并输出

            clientToServerThread.start();
            serverThread.start();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
