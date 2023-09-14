package _02_Chat_Application;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ClientChat {
	

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
	  		
	    int portNum = 8080;
		 String ip = "172.31.18.55";
		 Scanner scan = new Scanner(System.in);
		 Socket s = null;
		 String clientResponse;
		 DataOutputStream dataOut = null;
      //2. Create an integer for the server's port number
      
	boolean bool = true;
	   
	   DataInputStream dataIn = null;
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
	   System.out.println("WHile loop is starting for client");
    do {
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
	    try {
			s = new Socket(ip, portNum);
			System.out.println("What do you want to say to SERVER");
			clientResponse = scan.nextLine();
			dataOut = new DataOutputStream(s.getOutputStream());
			dataOut.writeUTF(clientResponse);	
			dataIn = new DataInputStream(s.getInputStream());
			System.out.println("Server says "+dataIn.readUTF());
			
			System.out.println("End of try-catch for client");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    while(!scan.nextLine().equals("quit"));
    System.out.println("While loop is over for client");
	scan.close();
	try {
		s.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         
         //7. Create a DataInputStream object. When initializing it, use the Server object you created in step 4 to call the getInputStream() method.
         
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         
         //9. Close the client's server object

   }
   public static void sendMessage(String message) {
	   
	
		
   }
   public static void receiveMessage() {
		
   }
}
