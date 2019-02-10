/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.main;

import com.edw.rmi.ClientImplement;
import com.edw.rmi.Message;
import java.io.File;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Maju
 */
public class Detect_Usb {

    Message impl;
    JDialog oo = new JDialog();
    static String ipAddress;
    ClientImplement iuo;
    Runtime r;
    Thread td;

    public ArrayList Get_Usb_list() throws RemoteException {
        ArrayList<String> usblist = new ArrayList<String>();
        try {




            String driveLetter = "";

            FileSystemView fsv = FileSystemView.getFileSystemView();

            File[] f = File.listRoots();
            for (int i = 0; i < f.length; i++) {
                String drive = f[i].getPath();
                String displayName = fsv.getSystemDisplayName(f[i]);
                String type = fsv.getSystemTypeDescription(f[i]);
                boolean isDrive = fsv.isDrive(f[i]);
                boolean isFloppy = fsv.isFloppyDrive(f[i]);
                boolean canRead = f[i].canRead();
                boolean canWrite = f[i].canWrite();

                if (canRead && canWrite && !isFloppy && isDrive && (type.toLowerCase().contains("removable") || type.toLowerCase().contains("rimovibile"))) {
                    // log.info("Detected PEN Drive: " + drive + " - "+ displayName);
                    System.out.println("Detected PEN Drive: " + drive + " - " + displayName);
                    driveLetter = displayName;
                    usblist.add(driveLetter);
                    boolean hj = usblist.contains(driveLetter);


                    if (hj == false) {
                        usblist.add(driveLetter);
                    }
 System.out.println("Detected PEN Size: " +usblist.size());


                }

            }

            if (driveLetter.equals("")) {
                // USB Drive not found
                // System.out.println("USB NOT  FOUND");
                // ....			
            } else {
                // USB drive found: driveLetter
                // ...
                System.out.println("USB  FOUND");


            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return usblist;
    }

    public Detect_Usb() {
        try {

            String ip = ClientHome.IpIp;

            Registry myRegistry = LocateRegistry.getRegistry(ip, 1099);



            // search for myMessage service
            final Message impl = (Message) myRegistry.lookup("myMessage");

            // call server's method	

            InetAddress addr = InetAddress.getLocalHost();
            ipAddress = addr.getHostAddress();

            iuo = new ClientImplement();
            r = Runtime.getRuntime();

            Runnable run = new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        String ss = iuo.nwoff;
                        String ssop = iuo.iiik;


                        try {

                            if (ssop != null) {
                                if (ssop.equals(ipAddress) && ss.equals("TUrnOFFNOW")) {


                                    r.exec("shutdown -s");
                                }
                            }
                            ArrayList getusb_list = Get_Usb_list();

                            //System.out.println("Size of usb list "+getusb_list.size());
                            impl.Get_Usb_list(getusb_list, ipAddress);

                        } catch (Exception ex) {
                          
                            Logger.getLogger(Detect_Usb.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            };
            td = new Thread(run);
            td.start();






        } catch (Exception ex) {
            Logger.getLogger(Detect_Usb.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}
