/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

/**
 *
 * @author Maju
 */
public class ClientReqProcess {
     public String ip;
    public    String proc;
    public    String status;

    public ClientReqProcess(String pro, String ip,String st) {
        this.proc = pro;
        this.ip = ip;
        this.status=st;
    }
    
    
}
