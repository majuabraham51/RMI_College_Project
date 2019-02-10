package com.edw.rmi;

import com.edw.main.GrandReq;
import com.edw.main.Training_Home;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MessageImpl extends UnicastRemoteObject implements Message {

    //public static String serverIp = "127.0.0.1";
    public static ArrayList<ClientInfo> clientList = new ArrayList<ClientInfo>();
    public static ArrayList<Aallloooo> allo = new ArrayList<Aallloooo>();
    public static ArrayList<USB_liList> usb_llist = new ArrayList<USB_liList>();
    public static ArrayList<Removeeee> removeei = new ArrayList<Removeeee>();
   public static Vector<String> vs = new Vector<String>();
    JDialog oojk = new JDialog();
    ImageIcon screen;
    BufferedImage buffered;
    static JPanel pan;
    static String fi;
    JDialog uxb = new JDialog();
    static JFrame fr;
    JLabel picLabel;
    public static String so = "";
    public static String sooo = "";

    public static String changemode;
    public static String vvvk;

    public static String vvvJUk;
    public static String cc;
    public static String chat_widw;
    public static String chat_Server;
    Training_Home vbn = new Training_Home();

    public MessageImpl() throws RemoteException {
    }

    @Override
    public void sayHello(String Uname, String ip) throws RemoteException {

        ClientInfo l = new ClientInfo(ip, Uname);
        clientList.add(l);

    }

    @Override
    public String Connection(String qry) throws RemoteException {

        return "am frm server" + qry;

    }

    public String ChangeUserMode() throws RemoteException {

        return changemode;

    }

    public String Chatwindow() throws RemoteException {

        return chat_widw;

    }

    @Override
    public String Allow_all() throws RemoteException {

        if (vvvJUk != null) {
            String lo = vvvJUk;

            return lo;
        }
        return null;
    }

    public String Remove_all() throws RemoteException {

        return vvvk;

    }

    public String Client_serverChating(String cli_msg) throws RemoteException {

        so = so + cli_msg;

        return so;

    }

    @Override
    public ImageIcon get_imageicon() throws RemoteException {
        try {

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = null;

            capture = new Robot().createScreenCapture(screenRect);
            return new ImageIcon(capture);
        } catch (AWTException ex) {
            Logger.getLogger(MessageImpl.class.getName()).log(Level.SEVERE, null, ex);
            return new ImageIcon();
        }

    }

    @Override
    public AtomicBoolean get_AtomicBoolean() throws RemoteException {
        return paused;
    }

    public AtomicBoolean get_ChatBoolean() throws RemoteException {
        return ChatOn;
    }

    @Override
    public ImageIcon getClient_imageicon(ImageIcon screen1) throws RemoteException {
        System.out.println("client scrren");
        screen = screen1;

        Thread td;
        picLabel = new JLabel();
        fr = new JFrame("Client Screen");
        fr.setLocation(100, 100);
        fr.setSize(500, 500);
        pan = new JPanel();

        fr.show();

        Runnable run = new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (true) {
//                  
//
//                    Image image = screen.getImage();
//
//                    RenderedImage rendered = null;
//                    if (image instanceof RenderedImage) {
//                        rendered = (RenderedImage) image;
//                    } else {
//                        buffered = new BufferedImage(screen.getIconWidth(), screen.getIconHeight(), BufferedImage.TYPE_INT_RGB);
//                        Graphics2D g = buffered.createGraphics();
//                        g.drawImage(image, 0, 0, null);
//                        g.dispose();
//                        rendered = buffered;
//                    }
//                    try {
//                        ImageIO.write(rendered, "JPEG", new File((i++)+"image.jpg"));
//                    } catch (IOException ex) {
//                        Logger.getLogger(MessageImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                    picLabel.setIcon(screen);
                    pan.add(picLabel);
                    pan.revalidate();
                    fr.add(pan);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    //System.out.println("client scrren repeting");
                }

            }
        };
        td = new Thread(run);
        td.start();

        return screen;

    }

    @Override
    public void Get_Usb_list(ArrayList usblst, String clientIP) throws RemoteException {
        if (usblst.isEmpty()) {
            //System.out.println("==========Client uSb Exception Occured");
        } else {

            //  System.out.println("=====Client"+clientIP+" Connected Usb  : " + usblst);
            String cc = usblst.toString();
            //System.out.println("xx" + usblst);
//            HashSet set = new HashSet(usb_llist);
//                usb_llist.clear();
//                usb_llist.addAll(set);
            //vs = new Vector<String>();
            
            USB_liList l = new USB_liList(cc, clientIP);
            usb_llist.add(l);

            for (USB_liList lo : MessageImpl.usb_llist) {

                boolean bl = vs.contains(lo._lis);
               
                 boolean b2 = vs.contains(lo._ipo);
             
                 if(vs.isEmpty())
                 {
                     vs.add("");
                 }
                if (b2 == false) {
                    vs.add(lo._ipo);
                    
                    System.out.println("first time"+b2);
                     uxb.show();
                }
                if(b2 == true && bl==false)
                {
                     vs.add(lo._lis);
                     System.out.println("Second time"+bl);
//                     if(bl==true)
//                     {
//                         
//                         
//                         vs.removeElement(lo._lis);
//                         usb_llist.remove(l);
//                     }
                      uxb.setTitle(lo._ipo+" :"+lo._lis);
                  
                }
                 
                   
                }
                int size = vs.size();
                System.out.println("size vector" + size);
            
            int ss = usb_llist.size();

//            if(usb_llist.isEmpty())
//            {
//                
//                usb_llist.add(l);
//                
//                
//                
//                 System.out.println("usb list is empty"+l._ipo);
//            }
//            else
//            {
//                System.out.println("name : "+cc.equals(l._lis)+"\tip "+clientIP.equals(clientIP));
//                 if(cc.equals(l._lis)&&clientIP.equals(clientIP))
//                {
//                    //usb_llist.add(l);
//                    System.out.println("mATHCED"+l._lis);
//                }
//             
//           System.out.println("ha aha "+ss);
//            }
//                    for(USB_liList k:usb_llist)
//                    {
//                        boolean contains = k._ipo.contains(clientIP);
//                         boolean contains1 = k._lis.contains(cc);
//                        
//                               System.out.println("usb "+contains +contains1);
//                         
//                         
//                    }
//                  if(!uxb.isActive())
//                {
//                    uxb.setTitle(fi+usblst);
//                    uxb.show();
//                }
        }
    }

    public void upload(String filename, byte[] fileContent) throws RemoteException {
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
            os.write(fileContent);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }
        ;
    }

    @Override
    public void grandReq(String procs, String ip, String status) {
//        ClientReqProcess l = new ClientReqProcess(procs, ip);
//        reqproc.add(l);
        System.out.println("from client msg " + procs);

        GrandReq oo = new GrandReq(procs, ip);
        oo.show();

    }

    @Override
    public String turnOff() throws RemoteException {

        return cc;
    }

}
