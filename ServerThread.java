package Charting_Room;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//接收服务端的消息并打印消息
public class ServerThread extends Thread{

    private DataInputStream dataInputStream = null;

    public ServerThread(Socket socket)
    {
        try
        {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        String message = null;
        while(true)
        {
            try
            {
                message = this.dataInputStream.readUTF();
                System.out.println("Server : " + message);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
