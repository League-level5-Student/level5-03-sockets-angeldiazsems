package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import _01_Intro_To_Sockets.client.*;
import _01_Intro_To_Sockets.server.*;
/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp extends JFrame{
	
	JFrame frame = new JFrame();
	_00_Click_Chat.networking.Server server;
	_00_Click_Chat.networking.Client client;
	ClientGreeter c =  new ClientGreeter();
	ServerGreeter s = new ServerGreeter();
	JButton button;
		
		//create joption pane to show the readUTF, by changing jlabel
	
		public static void main(String[] args) {
			new ChatApp();
		}
		
		public ChatApp(){
			
			int response = JOptionPane.showConfirmDialog(null, "Would s like to host a connection?", "Buttons!", JOptionPane.YES_NO_OPTION);
			if(response == JOptionPane.YES_OPTION){
				server = new _00_Click_Chat.networking.Server(8080);
				setTitle("SERVER");
				JOptionPane.showMessageDialog(null, "Server started at: " + server.getIPAddress() + "\nPort: " + server.getPort());
				button.addActionListener((e)->{
					server.sendClick();
				});
				add(button);
				setVisible(true);
				setSize(400, 300);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				server.start();
				
			}else{
				setTitle("CLIENT");
				String ipStr = JOptionPane.showInputDialog("Enter the IP Address");
				String prtStr = JOptionPane.showInputDialog("Enter the port number");
				int port = Integer.parseInt(prtStr);
				client = new _00_Click_Chat.networking.Client(ipStr, port);
				button.addActionListener((e)->{
					client.sendClick();
				});
				add(button);
				setVisible(true);
				setSize(400, 300);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				client.start();
			}


	
		}

}
