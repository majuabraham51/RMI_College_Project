package com.edw.rmi;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

public interface Message extends Remote {

    void sayHello(String Uname, String ip) throws RemoteException;

    //String listUsb() throws RemoteException;
    void Get_Usb_list(ArrayList usblst, String clientIP) throws RemoteException;
    //RenderedImage grtimage() throws RemoteException;

    String Connection(String qry) throws RemoteException;
public String Allow_all() throws RemoteException;

  public String Remove_all() throws RemoteException;
    public void upload(String filename, byte[] file) throws RemoteException;

    public void grandReq(String procs, String ip, String status) throws RemoteException;

    ImageIcon get_imageicon() throws RemoteException;

    ImageIcon getClient_imageicon(ImageIcon screen) throws RemoteException;
    public static AtomicBoolean paused = new AtomicBoolean();
    public static AtomicBoolean ChatOn = new AtomicBoolean();
    

    public String ChangeUserMode() throws RemoteException;
     public String turnOff() throws RemoteException;

    public String Chatwindow() throws RemoteException;

    public String Client_serverChating(String cli_msg) throws RemoteException;

    public AtomicBoolean get_ChatBoolean() throws RemoteException;

    public AtomicBoolean get_AtomicBoolean() throws RemoteException;
}