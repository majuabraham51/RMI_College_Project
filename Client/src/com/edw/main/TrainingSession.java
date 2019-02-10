/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.main;

import com.edw.rmi.ClientImplement;
import com.edw.rmi.Message;
import java.awt.AWTException;
import java.awt.Image;
import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Maju
 */
public class TrainingSession implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    /**
     * @param args
     * @throws AWTException
     */
    static JPanel pan;
    static JFrame fr;
    static int i = 0;
    static String ipAddressio;
    Thread td;
    Message server;
    public ImageIcon ix;
    JLabel picLabel = new JLabel();
    JDialog oo = new JDialog();
    ClientImplement iuo;

    public TrainingSession(Message ss) {
        server = ss;
        oo.setSize(200, 300);

        //  Timer timer = new Timer();
        if (server != null) // timer.schedule(this, 100, 100);
        {
            fr = new JFrame("Image");
        }

//       / fr.setLocation(100, 100);
        int widthx = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int Heightx = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        fr.setSize(widthx, Heightx + 37);

        pan = new JPanel();

        fr.setAlwaysOnTop(true);
        fr.setResizable(false);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //fr.setUndecorated(true);
        fr.show();

        try {
            iuo = new ClientImplement();
            InetAddress addr = InetAddress.getLocalHost();
            ipAddressio = addr.getHostAddress();
        } catch (Exception ex) {
            Logger.getLogger(TrainingSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        Runnable run = new Runnable() {

            @Override
            public void run() {

                while (true) {

                    try {
                        AtomicBoolean on_off = server.get_AtomicBoolean();

                        String ss = iuo.disct;
                        String ssop = iuo.ipU;

                        if (ssop != null) {
                            if (ssop.equals(ipAddressio) && ss.equals("Disconnect")) {
                                server = null;
                                picLabel = null;
                                fr = null;
                                System.exit(0);

                            }
                        }
                        //System.out.println("Swich value" + on_off.get());

                        if (on_off.get() == false) {
                            ix = server.get_imageicon();
                            picLabel.setIcon(ix);

                        } else {
                            try {
                                  Image im = new ImageIcon(this.getClass().getResource("/resources/stop.png")).getImage();
                                ImageIcon iconLogo = new ImageIcon(im);
                                picLabel.setIcon(iconLogo);

                                //picLabel.setIcon(new ImageIcon(ImageIO.read(new File("f://src/stop.png"))));
                            } catch (Exception ex) {
                                Logger.getLogger(TrainingSession.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (RemoteException ex) {
                        oo.setTitle("From client Training section" + ex.getMessage());
                        oo.show();
                        Logger.getLogger(TrainingSession.class.getName()).log(Level.SEVERE, null, ex);
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
}
