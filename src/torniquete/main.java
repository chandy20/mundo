/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import java.awt.AWTException;

/**
 *
 * @author JorgeAndres
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        // TODO code application logic here        
        GUI2 g = new GUI2();
        TorniqueteDAO t = new TorniqueteDAO();
        g.setVisible(true);
        g.communicator.connect();
        if (g.communicator.getConnected() == true) {
            if (g.communicator.initIOStream() == true) {
                g.communicator.initListener();
                g.cboxPorts.setVisible(false);
                g.txtCodigo.requestFocus();
                g.communicator.getcounter();
                g.communicator.temporizador();
            }

        }
    }

}
