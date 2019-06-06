/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import form.FMain;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lukabaljak
 */
public class Server extends Thread {

    ServerSocket serverSocket;
    static FMain fmain;
    List<ServerNit> klijenti;
    
    public Server(int port, FMain fmain) throws IOException {
        serverSocket = new ServerSocket(port);
       this.fmain = fmain;
       klijenti= new ArrayList<>();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Socket socket = serverSocket.accept();
                ServerNit nit = new ServerNit(socket);
                
                nit.start();
                fmain.upisiNoviLogin(nit.getName());
            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
    }

    public static void upisiNoviLogout(String ime){
        fmain.upisiNoviLogout(ime);
    }
    
    public void zaustavi() throws IOException{
        serverSocket.close();
        interrupt();
    }

}
