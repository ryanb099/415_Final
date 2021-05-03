import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UDPClient {

    public static void main(String[] args) throws IOException {
    	
    //	UDPGUI p = new UDPGUI(1238);
    	DatagramSocket s = new DatagramSocket(1327);

        try {

            // get a UDP socket
              //bind to any port

        	
            // construct a packet
            String hellomessage = "Hello, I am online";  	// fixed message

	    // Read a message from keyboard?	

            //convert string to byte array
            byte[] buf = hellomessage.getBytes();
            InetAddress address = InetAddress.getByName("172.17.159.114");  // get the ip address of the host.

            //construct datagram packet
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1327);

            // send a packet
            s.send(packet);

        } catch (IOException e) {

            System.err.print(e.getMessage());

        }
        while (true) {
        	byte[] buf1 = new byte[256];
        	DatagramPacket packet1 = new DatagramPacket(buf1, buf1.length);
        	s.receive(packet1);
        	String received = new String(packet1.getData(), 0, packet1.getLength());
        	System.out.println(received);
        	
        	byte[] buf2 = new byte[256];
        	DatagramPacket packet2 = new DatagramPacket(buf2, buf2.length);
        	s.receive(packet2);
        	String received2 = new String(packet2.getData(), 0, packet2.getLength());
        	
        	  JFrame frame = new JFrame("Alert");
        //      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.getContentPane().setBackground(Color.RED);
              JLabel message = new JLabel(received2);
              message.setForeground(Color.YELLOW);
              message.setFont(new Font("Serif", Font.BOLD, 50));
              frame.getContentPane().add(message, BorderLayout.CENTER);
              frame.setVisible(true);
        	break;
    }
        System.out.println("Type 1 to exit server: ");
        Scanner input= new Scanner(System.in);
        int number = input.nextInt();
        if (number==1) {
        	try {
        		String byemessage = "I am going offline";  	// fixed message

        	    // Read a message from keyboard?	

                    //convert string to byte array
                    byte[] buf3 = byemessage.getBytes();
                    InetAddress address = InetAddress.getByName("172.17.159.114");  // get the ip address of the host.

                    //construct datagram packet
                    DatagramPacket packet3 = new DatagramPacket(buf3, buf3.length, address, 1327);

                    // send a packet
                    s.send(packet3);
        	} catch (IOException e) {

                System.err.print(e.getMessage());

            }
        }
        
    }
}