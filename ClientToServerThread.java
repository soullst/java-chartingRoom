package Charting_Room;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//向服务端server发送消息
public class ClientToServerThread extends Thread{
    private DataOutputStream dataOutputStream = null;
    private Scanner scanner = null;

    public ClientToServerThread(Socket socket)
    {
        try
        {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.scanner = new Scanner(System.in);
        }
        catch (IOException e)
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
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
