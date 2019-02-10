/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.main;

/**
 *
 * @author Maju
 */
import com.edw.rmi.ClientImplement;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.edw.rmi.Message;

public class Main {
    
    private void doTest(){
        try {
			// fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry("169.254.150.106", 1099);
			
			// search for myMessage service
            Message impl = (Message) myRegistry.lookup("myMessage");
            
			
			// call server's method			
            
			
            System.out.println("Message Sent");
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    
    public static void main(String[] args) {
        Main main = new Main();
        //main.doTest();
   
        ClientHome oo =new ClientHome();
        oo.show();
    }
}