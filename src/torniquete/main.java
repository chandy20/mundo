/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import java.awt.AWTException;
import java.awt.Toolkit;

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
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int xSize = ((int) tk.getScreenSize().getWidth());
//        int ySize = ((int) tk.getScreenSize().getHeight());
//        g.setSize(xSize, ySize);
        g.setVisible(true);
        g.communicator.connect();
        if (g.communicator.getConnected() == true) {
            if (g.communicator.initIOStream() == true) {
                g.communicator.initListener();
                g.btnConnect.setVisible(false);
                g.btnDisconnect.setVisible(false);
                g.cboxPorts.setVisible(false);
                g.txtCodigo.requestFocus();
            }
        }
    }

}