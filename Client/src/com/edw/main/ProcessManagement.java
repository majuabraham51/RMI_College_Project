/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maju
 */
public class ProcessManagement {

    private static final String KILL = "taskkill /IM ";
    String processName = "notepad.exe";

    public void KillProcess(Process _old, Process _new) {

        System.out.println("JUST ***********cHECKING");

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader newbr =
                new BufferedReader(new InputStreamReader(_new.getInputStream()));
        BufferedReader oldbr =
                new BufferedReader(new InputStreamReader(_old.getInputStream()));
        System.out.println("...." + newbr);

        try {
            String oldP = "";
            System.out.println("Readline" + oldP);
            String newP = "";
            while ((newP = newbr.readLine()) != null) {
                boolean flag = true;
                String OldExe = null;
                String NewExe = getProcessName(newP);
                //System.out.println("new process\t"+NewExe);
                while ((oldP = oldbr.readLine()) != null) {

                    OldExe = getProcessName(oldP);

                    if (NewExe.equals(OldExe)) {
                        //System.out.println("NNNNNNNNNN\t"+OldExe);
                        flag = false;
                        break;

                    }
                    // break;
                }
                System.out.println(" ------------------------");
                System.out.println(NewExe + "--" + OldExe);

                if (flag) {

                    Runtime.getRuntime().exec(KILL + NewExe);
                    //break;
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ProcessManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProcessName(String sp) {
        String result = "";
        String[] splist = sp.split(" ");
        for (String s : splist) {
            if (s.endsWith(".exe") || s.endsWith(".EXE")) {
                result = s;
            }
        }

        return result;
    }
}
