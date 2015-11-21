package udp;

import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		//	����������
		BufferedReader inFromUser =new BufferedReader(new InputStreamReader(System.in));
		//����clientSocket
		DatagramSocket clientSocket=new DatagramSocket();
		//��������ַ������
		InetAddress IPAddress=InetAddress.getByName("127.0.0.1");
		byte[] sendData =new byte[1024];
		byte[] receiveData =new byte [1024];
		//���̶�����Ϣ
		System.out.print("�ӿͻ�������Сд�ַ���");
		String sentence =inFromUser.readLine();
		//ת��Ϊbyte����
		sendData =sentence.getBytes();
		//	�������ͷ��飬������
		//	����,����,IP��ַ,�˿ں�
		DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length,IPAddress,9876);
		//���ͷ���
		clientSocket.send(sendPacket);
		//�����������ݱ�
		DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);
		//���շ���
		clientSocket.receive(receivePacket);
		//��ȡ�����е�����
		String modifiedSentence =new String(receivePacket.getData());
		//��ʾ
		System.out.println("�ӷ����������д�ַ�:"+modifiedSentence);
		clientSocket.close();
	}

}
