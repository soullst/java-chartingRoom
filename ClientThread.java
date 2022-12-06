package Charting_Room;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//接收客户端的消息并打印消息
public class ClientThread extends Thread  //客户端
{
    private DataInputStream dataInputStream = null;

    public ClientThread(Socket socket)
    {
        try//获取客户端的输入对象
        {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        String messageToClient = null;
        try
        {
            while(true)
            {
                messageToClient = this.dataInputStream.readUTF();//将客户端发送的消息写到内存中
                System.out.println("Client : " + messageToClient);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
