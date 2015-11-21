package udp;

import java.net.*;
import java.io.*;

public class UDPServer {
		public static void main(String arg[]) throws IOException{
			@SuppressWarnings("resource")
			DatagramSocket serverSocker= new DatagramSocket(9876);
			byte[] receiveData =new byte[1024];
			byte[]	sendData=new byte[1024];
			while(true)
			{
				DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
				serverSocker.receive(receivePacket);
				String sentence =new String(receivePacket.getData());
				InetAddress IPAddress=receivePacket.getAddress();
				int port =receivePacket.getPort();
				String capitalizedSentence= sentence.toUpperCase();
				sendData=capitalizedSentence.getBytes();
				DatagramPacket sendPacket=new DatagramPacket(sendData, sendData.length,IPAddress,port);
				serverSocker.send(sendPacket);
			}
		}
}
