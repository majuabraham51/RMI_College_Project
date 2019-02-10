package com.edw.main;

import com.edw.rmi.ClientInterface;
import com.edw.rmi.Message;
import com.edw.rmi.MessageImpl;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    
    private void startServer(){
        try {
            try {
                // create on port 1099
                Registry registry = LocateRegistry.createRegistry(1099);
                
                // create a new service named myMessage
                registry.rebind("myMessage", new MessageImpl());
            } catch (Exception e) {
                e.printStackTrace();
            }      
              InetAddress addr = InetAddress.getLocalHost();
          
            //Getting IPAddress of localhost - getHostAddress return IP Address
            // in textual format
            String ipAddress = addr.getHostAddress();
          
            System.out.println("IP address: " + ipAddress);
          
            System.out.println("Server is ready dear user");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void doTestClient(){
        try {
             
			// fire to localhost port 1099
            Registry myRegistry1 = LocateRegistry.getRegistry("169.254.150.106", 1098);
			
			// search for myMessage service
            ClientInterface impl = (ClientInterface) myRegistry1.lookup("myClientMessage");
            
			
			// call server's method			
            
			
            System.out.println("Message Sent");
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.startServer();
       
       // main.doTestClient();
        AdminPresentation a= new AdminPresentation();
        //a.show();
        Admin_Home kk=new Admin_Home();
        kk.show();
    }
}