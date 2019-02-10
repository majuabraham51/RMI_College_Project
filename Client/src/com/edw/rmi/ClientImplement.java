/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Maju
 */
public class ClientImplement extends UnicastRemoteObject implements ClientInterface {
    
    
    public static ArrayList<ClientReqProcess> reqproc = new ArrayList<ClientReqProcess>();
    public static String nwoff;
    public static String iiik;
    public static String disct;
    public static String ipU;
   
    public ClientImplement()throws RemoteException
    {
        
    }

    @Override
    public ImageIcon getclient_imageicon() throws RemoteException {
        try {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                 BufferedImage capture = null;

                 capture = new Robot().createScreenCapture(screenRect);
                 return new ImageIcon(capture);
        } catch (AWTException ex) {
            Logger.getLogger(ClientImplement.class.getName()).log(Level.SEVERE, null, ex);
             return new ImageIcon();
        }
    }
public void messg(String msggg,String iii) throws RemoteException 
{
    nwoff=msggg;
    iiik=iii;
}
public void disconnectUser(String msggg,String iii) throws RemoteException 
{
    disct=msggg;
   
    ipU=iii;
}
    @Override
    public void messg(String msggg) throws RemoteException {
       
            
     
        JDialog oo=new JDialog();
        oo.setSize(55, 25);
        oo.setTitle(msggg);
        oo.show();
        //System.out.println(msggg);
         
   
         
    }

    @Override
    public void AllowedResources(String proce,String ip,String status) throws RemoteException {
        
          ClientReqProcess l = new ClientReqProcess(proce, ip,status);
           //System.out.println(" before add Sizeee   "+reqproc.size());
           reqproc.add(l);
           int sizz=reqproc.size();
          //System.out.println("Sizeee   "+sizz);
        JFrame oo= new JFrame("Permission:"+status);
         oo.setSize(55, 25);
        oo.show();
        oo.setAlwaysOnTop(true);
        
       }
    
}
