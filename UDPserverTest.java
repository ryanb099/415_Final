import java.io.*; 
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class UDPserverTest {

    public final static int MAX_PACKET_SIZE = 65507;
    public  DatagramSocket s1; 
    static ArrayList list= new ArrayList();

    public UDPserverTest (int port) {
    

        try {
    // Please do not run the file until you finish the coding
            // create your udp server listen the port number 54234
           

   // wait for an UDP packet
        s1 = new DatagramSocket(1328);
           



            //close the server
            //s.close();


        } catch (Exception e) {

            System.err.println(e.getMessage());

        }


    }

    /*
     *    Show the alert window
     */


    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
      DatagramSocket s1 = new DatagramSocket(1329);

           while (true) {
               // receive a packet 
               byte[] buf = new byte[256];
               DatagramPacket packet = new DatagramPacket(buf, buf.length);
               s1.receive(packet);
               
               
               

               // display response
               String received = new String(packet.getData(), 0, packet.getLength());
               InetAddress here= packet.getAddress();
          //     System.out.println(packet.getAddress() + "is now online" + "\n");
               list.add(here);
               if (!list.isEmpty()) {
            	   System.out.println(list + " is online" + "\n");
               }
               else {
            	   System.out.println("Nobody is online");
               }
               
            //   while loop for getting and receiving messages here
               while (true) {
            	   send packet to client
            	   client send packet back
            	   if (packet not received) {
            		   print client is offline
            		   break
            	   }
               }
               //show alert
               // display an alert window when a packet is received
           
           try {
           	

               // get a UDP socket
               DatagramSocket s = new DatagramSocket();  //bind to any port


               // construct a packet
               String hellomessage = "Welcome";  	// fixed message

   	    // Read a message from keyboard?	

               //convert string to byte array
               byte[] buf1 = hellomessage.getBytes();
               InetAddress packetLocation = packet.getAddress();  // get the ip address of the host.

               //construct datagram packet
               DatagramPacket packet1 = new DatagramPacket(buf1, buf1.length, packetLocation, 1327);
               
               

               // send a packet
               s.send(packet1);
               System.out.println("Alert message has been sent to "+ packetLocation);


               //close the datagram socket
               s.close();


           } catch (IOException e) {

               System.err.print(e.getMessage());
           }

           

        // This simple program will pop up an alert window when it receive a packet
        // from certain port
        //  serverTest p = new UDPserverTest(1327);
          }
    }
}


    

