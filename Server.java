package Charting_Room;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//服务端界面
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;//服务器端socket
        Socket clientSocket = null;//客户端socket

        try//创建一个服务端socket服务
        {
            serverSocket = new ServerSocket(8888);
            while(true)//模拟客户端一直启动
            {
                clientSocket = serverSocket.accept();//获取连接服务器的客户端socket
                ClientThread clientThread = new ClientThread(clientSocket);//接受客户端的消息并输出
                ServerToClientThread serverToClientThread = new ServerToClientThread(clientSocket);//向客户端发送消息

                clientThread.start();
                serverToClientThread.start();

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            if(clientSocket != null)
            {
                try
                {
                    clientSocket.close();
                }catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
            if(serverSocket != null)
            {
                try
                {
                    serverSocket.close();
                }catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
        }
    }
}
