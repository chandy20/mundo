/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

import gnu.io.*;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

public class Communicator implements SerialPortEventListener {

    //passed from main GUI
    GUI2 window = null;

    //for containing the ports that will be found
    private Enumeration ports = null;
    
    //map the port names to CommPortIdentifiers
    private HashMap portMap = new HashMap();

    //this is the object that contains the opened port
    private CommPortIdentifier selectedPortIdentifier = null;
    private SerialPort serialPort = null;

    //input and output streams for sending and receiving data
    private InputStream input = null;
    private OutputStream output = null;
    
    //just a boolean flag that i use for enabling
    //and disabling buttons depending on whether the program
    //is connected to a serial port or not
    private boolean bConnected = false;
    final static int TIMEOUT = 2000;
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;
    String logText = "";
    public Communicator(GUI2 window) {
        this.window = window;
    }

    //search for all the serial ports
    //pre: none
    //post: adds all the found ports to a combo box on the GUI
    public void searchForPorts() {
        ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println("curPort.getName():"+curPort.getName());
                if(curPort.getName().isEmpty()==false) {   
                    window.cboxPorts.addItem(curPort.getName());
                    portMap.put(curPort.getName(), curPort);
                }
            }
        }
    }

    //connect to the selected port in the combo box
    //pre: ports are already found by using the searchForPorts method
    //post: the connected comm port is stored in commPort, otherwise,
    //an exception is generated
    public void connect() {
        String selectedPort = (String) window.cboxPorts.getSelectedItem();
        selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);
        CommPort commPort = null;
        try {
            commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
            serialPort = (SerialPort) commPort;
            setConnected(true);
            logText = selectedPort + " opened successfully.";
            window.keybindingController.toggleControls();
        } catch (PortInUseException e) {
            logText = selectedPort + " is in use. (" + e.toString() + ")";
        } catch (Exception e) {
            logText = "Failed to open " + selectedPort + "(" + e.toString() + ")";
        }
    }

    //open the input and output streams
    //pre: an open port
    //post: initialized intput and output streams for use to communicate data
    public boolean initIOStream() {
        boolean successful = false;
        try {
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            //getcounter();
            successful = true;
            return successful;
        } catch (IOException e) {
            logText = "I/O Streams failed to open. (" + e.toString() + ")";
            return successful;
        }
    }

    //starts the event listener that knows whenever data is available to be read
    //pre: an open serial port
    //post: an event listener for the serial port that knows when data is recieved
    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "Too many listeners. (" + e.toString() + ")";
        }
    }

    //disconnect the serial port
    //pre: an open serial port
    //post: clsoed serial port
    public void disconnect() {
        try {
            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConnected(false);
            window.keybindingController.toggleControls();
            logText = "Disconnected.";
        } catch (Exception e) {
            logText = "Failed to close " + serialPort.getName() + "(" + e.toString() + ")";
        }
    }

    final public boolean getConnected() {
        return bConnected;
    }

    public void setConnected(boolean bConnected) {
        this.bConnected = bConnected;
    }

    String entrada = "";
    
    //what happens when data is received
    //pre: serial event is triggered
    //post: processing on the data it reads
    public void serialEvent(SerialPortEvent evt) {
        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                byte singleData = (byte) input.read();
                if (singleData != NEW_LINE_ASCII) {
                    logText = new String(new byte[]{singleData});
                    entrada += logText;
                    if (logText.equals("E")) {
                        finalizarLlegada();
                    }
                }
            } catch (Exception e) {
                logText = "Failed to read data. (" + e.toString() + ")";
            }
        } else {
//            finalizarLlegada();
        }
    }

    //method that can be called to send data
    //pre: open serial port
    //post: data sent to the other device
    public void writeData(int leftThrottle, int rightThrottle,String mensaje) {
        try {
//            System.out.println("Escribiendo");
//            String EN = "S006000000E20";
//            System.out.println("Mensaje: "+mensaje);
            for (int i = 0; i < mensaje.length(); i++) {
                char c = mensaje.charAt(i);
                int ascii = (int) c;
                output.write(ascii);
            }
            output.flush();
        } catch (Exception e) {
            logText = "Failed to write data. (" + e.toString() + ")";
        }
    }

    private void finalizarLlegada() {
        TorniqueteDAO dao = new TorniqueteDAO();
        boolean verif = dao.registrarActualizar(1);
        boolean verifHora = dao.registrarActualizarHora(1);
        boolean verifDia = dao.registrarActualizarDia(1);
        boolean verifMes = dao.registrarActualizarMes(1);
        boolean verifAnio = dao.registrarActualizarAnio(1);
        boolean verifTodosDia = dao.registrarActualizarTodosDia();
        if(entrada.indexOf("S011000000000E") != -1) {
            if (verif)
                dao.contarSalida(1,GUI2.Fecha);
            else
                dao.salida(1,GUI2.Fecha);
            if (verifHora)
                dao.contarSalidaHora(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-5) + "00");
            else
                dao.salidaHora(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-5) + "00");
            if (verifDia)
                dao.contarSalidaDia(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            else
                dao.salidaDia(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            if (verifMes)
                dao.contarSalidaMes(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-12));
            else
                dao.salidaMes(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-12));
            if (verifAnio)
                dao.contarSalidaAnio(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-15));
            else
                dao.salidaAnio(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-15));
            if (verifTodosDia)
                dao.contarSalidaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            else
                dao.salidaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
        } else if(entrada.indexOf("S010000000000E") != -1) {
            if (verif)
                dao.contarEntrada(1,GUI2.Fecha);
            else
                dao.entrada(1,GUI2.Fecha);
            if (verifHora)
                dao.contarEntradaHora(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-5) + "00");
            else
                dao.entradaHora(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-5) + "00");
            if (verifDia)
                dao.contarEntradaDia(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            else
                dao.entradaDia(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            if (verifMes)
                dao.contarEntradaMes(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-12));
            else
                dao.entradaMes(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-12));
            if (verifAnio)
                dao.contarEntradaAnio(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-15));
            else
                dao.entradaAnio(1,GUI2.Fecha.substring(0, GUI2.Fecha.length()-15));
            if (verifTodosDia)
                dao.contarEntradaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
            else
                dao.entradaTodosDias(GUI2.Fecha.substring(0, GUI2.Fecha.length()-9));
        } else {
            System.out.println("Posible mensaje de error de retorno");
        }
        entrada = "";
    }
    
    public void bloqueaDesbloquea(int est) {
        String mensaje;
        if (est == 0)
            mensaje="S015000000E22";
        else
            mensaje="S016000000E21";
        writeData(TIMEOUT, TIMEOUT, mensaje);
    }
    
    public void getcounter() {
//      String mensaje="S006000000E20";
//      writeData(TIMEOUT, TIMEOUT, mensaje);
    }
    
    private char calcularChecksum(String str, int nLength) {
        char uRet = 0;
        for (int i = 0; i < nLength; i++) {
            uRet ^= (char) str.charAt(i);
        }
        return uRet;
    }
}