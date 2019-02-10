/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

/**
 *
 * @author Admin
 */
public class ClientInfo {
 public String name;
    public    String ip;
    public ClientInfo() {
        
    }
    public ClientInfo(String _ip,String _name) {
      name=_name;
      ip=_ip;
        
        
    }
}
