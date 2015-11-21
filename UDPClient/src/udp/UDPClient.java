package udp;

import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		//	创建输入流
		BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
		//创建clientSocket
		DatagramSocket clientSocket=new DatagramSocket();
		//创建“地址”对象
		InetAddress IPAddress=InetAddress.getByName("127.0.0.1");
		byte[] sendData =new byte[1024];
		byte[] receiveData =new byte [1024];
		//键盘读入信息
		System.out.print("从客户端输入小写字符：");
		String sentence =inFromUser.readLine();
		//转化为byte数组
		sendData =sentence.getBytes();
		//	创建发送分组，参数：
		//	数据,长度,IP地址,端口号
		DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length,IPAddress,9876);
		//发送分组
		clientSocket.send(sendPacket);
		//创建接收数据报
		DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);
		//接收分组
		clientSocket.receive(receivePacket);
		//获取分组中的数据
		String modifiedSentence =new String(receivePacket.getData());
		//显示
		System.out.println("从服务器输出大写字符:"+modifiedSentence);
		clientSocket.close();
	}

}
