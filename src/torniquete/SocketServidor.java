/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torniquete;

import java.io.*;
import java.net.*;

/**
 *
 * @author JAK LIZCANO
 */
public class SocketServidor {
    
    ServerSocket serverAddr = null;
    Socket sc = null;
    
    Communicator communicator = null;
    
    /**
     * @param args the command line arguments
     */
    public void Escuchar() {
        try {
            serverAddr = new ServerSocket(2500);
        } catch (Exception e) {
            System.err.println("Error creando socket");
        }
        while (true) {
            try {
                sc = serverAddr.accept(); // esperando conexión
                InputStream istream = sc.getInputStream();
                ObjectInput in = new ObjectInputStream(istream);
                int Estado = (int) in.readObject();
                communicator.bloqueaDesbloquea(Estado);
                System.out.println("conexión");
                Thread.sleep(2000);
                DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
                ostream.writeChars("Torniquete bloqueado");
                ostream.flush();
                sc.close();
            } catch (Exception e) {
                System.err.println("excepcion " + e.toString());
                e.printStackTrace();
            } // try
        } // while
    }
    
}