package _02_Chat_Application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ClientChat {
	public static JLabel serverLabel;
	public static void main(String[] args) {
		// 1. Create a String for the ip address of the server.
		// If you don't know how to find a computer's ip address, ask about ifconfig on
		// linux/mac and ipconfig on windows.
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		serverLabel = new JLabel("E");

		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.add(panel);
		panel.add(serverLabel);

		String ip = "172.31.28.180";

		// 2. Create an integer for the server's port number

		int portNum = 8080;

		// 3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.

		// 4. Create an object of the Socket class. When initializing the object, pass
		// in the ip address and the port number
		try {
			Socket s = new Socket(ip, portNum);
			DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
			String response = JOptionPane.showInputDialog(null, "what do you want to say");
			dataOut.writeUTF(response);

			DataInputStream dataIn = new DataInputStream(s.getInputStream());
			System.out.println(dataIn.readUTF());
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5. Create a DataOutputStream object. When initializing it, use the Socket
		// object you created in step 4 to call the getOutputStream() method.

		// 6. Use the DataOutputStream object to send a message to the server using the
		// writeUTF(String message) method

		// 7. Create a DataInputStream object. When initializing it, use the Server
		// object you created in step 4 to call the getInputStream() method.

		// 8. Use the DataInputStream object to print a message from the server using
		// the readUTF() method.

		// 9. Close the client's server object

	}

}
