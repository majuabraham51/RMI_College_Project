/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.main;

import com.edw.rmi.ClientInterface;
import java.awt.AWTException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 *
 * @author Maju
 */
public class TrainingSession implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    int numClicks = 0;
    /**
     * @param args
     * @throws AWTException
     */
    static JPanel pan;
    static JFrame fr;
    static int i = 0;
    Thread td;
    ClientInterface server;
    public ImageIcon ix;
    JLabel picLabel = new JLabel();
    JDialog oo = new JDialog();

           
    public TrainingSession(String ss) {
        //server = ss;
        
        Registry myRegistry1;
        try {
            myRegistry1 = LocateRegistry.getRegistry(ss, 9001);
            server = (ClientInterface) myRegistry1.lookup("myClientMessage");

        } catch (Exception ex) {
            Logger.getLogger(TrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        oo.setSize(200, 300);


        //  Timer timer = new Timer();

        if (server != null) // timer.schedule(this, 100, 100);
        {
            fr = new JFrame("client Screen");
        
        }
        
//       / fr.setLocation(100, 100);
        fr.setSize(1450, 730 + 50);

        pan = new JPanel();
      fr.show();
        fr.setAlwaysOnTop(true);
        fr.setResizable(false);
       //
         fr.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            server=null;
            pan=null;
            picLabel=null;
            fr=null;
        
            
	      // System.exit(0);
         }        
      });  
        
  
 


        Runnable run;
        run = new Runnable() {
            
            @Override
            public void run() {
//                oo.setTitle("Run method");
//                oo.show();
                while (true) {
                    
if (server != null)
{
   
                    
                    try {
                        
                        
                    
                        //System.out.println("Swich value" + on_off.get());
                        
                        
//                            fr.dispose();
                            ix = server.getclient_imageicon();
                        
                        picLabel.setIcon(ix);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    } catch (RemoteException ex) {
                        oo.setTitle("FRom server section"+ex.getMessage());
                        oo.show();
                        Logger.getLogger(TrainingSession.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                    pan.add(picLabel);
                    pan.revalidate();
                    fr.add(pan);
                    fr.repaint();
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                    }
                }

            }
        };

        td = new Thread(run);
        td.start();



    }
 

    public TrainingSession() {
    }

    public static void main(String[] args) throws AWTException {
        // TODO Auto-generated method stubString driveLetter = "";
        
      
    }


//    @Override
////    public void actionPerformed(ActionEvent e) {
////        
////         numClicks++;
////         k.dispose();
////         server=null;
////        System.out.println(numClicks+ "  " + server);
////        
////       }

}
