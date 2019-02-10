/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.ImageIcon;

/**
 *
 * @author Maju
 */
public interface ClientInterface extends Remote {
    public ImageIcon getclient_imageicon() throws RemoteException;
    public void messg(String msggg)throws RemoteException;
    public void messg(String msggg,String iii) throws RemoteException ;
    public void AllowedResources(String proce,String ip,String status)throws RemoteException;
    public void disconnectUser(String msggg,String iii) throws RemoteException;
}
