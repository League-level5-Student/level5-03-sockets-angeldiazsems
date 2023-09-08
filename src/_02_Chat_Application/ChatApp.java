package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.net.*;

import java.io.*;
import _01_Intro_To_Sockets.client.*;
import _01_Intro_To_Sockets.server.*;
/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField text = new JTextField();
	static JLabel serverLabel = new JLabel("E");


	public static void main(String[] args) {
		new ChatApp();
	}

	public ChatApp() {

		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.add(panel);
		panel.add(serverLabel);		
		panel.add(text);
		boolean e = true;
		String word = JOptionPane.showInputDialog("What are ou going to say");
		server(word);
		String word2 = JOptionPane.showInputDialog("Now what are you going to say");
		client(word2);
	}

	public static void client(String word) {

		String ip = "172.31.28.180";
		
		int portNum = 8080;

		try {
			Socket s = new Socket(ip, portNum);
			DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
			dataOut.writeUTF(word);
			DataInputStream dataIn = new DataInputStream(s.getInputStream());
			serverLabel.setText(word);
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void server(String word) {
		
		Thread t = new Thread(()->{
		boolean bool = true;
		String output;
		while (bool) {

			try {
				ServerSocket serverSocket = new ServerSocket(8080);

				Socket sock = serverSocket.accept();
				DataInputStream dataIn = new DataInputStream(sock.getInputStream());
				DataOutputStream dataOut = new DataOutputStream(sock.getOutputStream());
				serverLabel.setText(word);

				dataOut.writeUTF(word);

			} catch (SocketTimeoutException e) {
				JOptionPane.showMessageDialog(null, "Error");
				e.printStackTrace();
				bool = false;
			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
				e.printStackTrace();
				bool = false;

			}
		}
		
		
		});
		t.start();

	}

}
