package Charting_Room;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//向客户端client发送消息
public class ServerToClientThread extends Thread //服务端
{
    private DataOutputStream dataOutputStream = null;//输出服务端给客户端的信息
    private Scanner scanner = null; //将服务端在控制台输入的信息存入内存

    public ServerToClientThread(Socket socket)
    {
        try
        {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());//获取客户端信息
            scanner = new Scanner(System.in);//获取控制台输入的对象（服务端）
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        String messageToServer = null;
        while(true)
        {
            try
            {
                messageToServer = scanner.nextLine();//将控制台信息读入内存
                this.dataOutputStream.writeUTF(messageToServer);//向客户端发送消息
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
