/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torniquete;

/**
 *
 * @author Enovasoft
 */
//import java.io.*;
//import java.net.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI2 extends javax.swing.JFrame {

    /**
     * Creates new form GUI2
     */
    static int estado = 0;
    static int torniquete_id = 16;
    static Date fecha = new Date();
    static SimpleDateFormat Formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static String Fecha = Formateador.format(fecha) + ":00";
    Communicator communicator = null;
    KeybindingController keybindingController = null;
//    ServerSocket serverAddr = null;
//    Socket sc = null;

    public GUI2() {
        initComponents();
        createObjects();
        communicator.searchForPorts();
        keybindingController.toggleControls();
        keybindingController.bindKeys();
        Connection connection = Conexion.getConnection();
        if (connection != null) {
            System.out.print(connection);
        }
    }

    private void createObjects() {
        communicator = new Communicator(this);
        keybindingController = new KeybindingController(this);
    }

    //    public void Escuchar() {
//        try {
//            serverAddr = new ServerSocket(2500);
//        } catch (Exception e) {
//            System.err.println("Error creando socket");
//        }
//        while (true) {
//            try {
//                sc = serverAddr.accept(); // esperando conexión
//                InputStream istream = sc.getInputStream();
//                ObjectInput in = new ObjectInputStream(istream);
//                int Estado = (int) in.readObject();
//                Thread.sleep(2000);
//                DataOutputStream ostream = new DataOutputStream(sc.getOutputStream());
//                if (Estado != -1) {
//                    communicator.bloqueaDesbloquea(Estado);
//                    if (estado == 0) {
//                        estado = 1;
//                        jLabel1.setText("Torniquete desbloqueado");
//                    } else {
//                        estado = 0;
//                        jLabel1.setText("Torniquete bloqueado");
//                    }
//                }
//                ostream.writeInt(estado);
//                ostream.flush();
//                sc.close();
//            } catch (Exception e) {
//                System.err.println("excepcion " + e.toString());
//                e.printStackTrace();
//            } // try
//        } // while
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cboxPorts = new java.awt.Choice();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/good.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxPorts, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxPorts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(cboxPorts, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblLogo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
        //Tomo el texto y determino el tamaño
        String codigo = txtCodigo.getText();
        
        //Ahora tomo el codigo y consulto en la base de datos si el usuario esta en la base de datos
        int resultado = -1;
        try {
            TorniqueteDAO dao = new TorniqueteDAO();
            resultado = dao.validarTarjeta(codigo);
            switch (resultado) {
                case 0:
                    communicator.bloqueaDesbloquea(estado);
                    dao.actualizarEstado(torniquete_id, estado);
                    if (estado == 0) {
                        estado = 1;
                        jLabel1.setText("Torniquete desbloqueado");
                    } else {
                        estado = 0;
                        jLabel1.setText("Torniquete bloqueado");
                    }
                    lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/good.png")));
                    break;
                case 1:
                    lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bad.png")));
                    jLabel1.setText("No existe la tarjeta");
                    break;
                case -1:
                    lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/warning.png")));
                    jLabel1.setText("Error al ejecutar la consulta");
                    break;
            }
            txtCodigo.setText(null);
            txtCodigo.requestFocus();
            dao.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(GUI2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
        public void run() {
                new GUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    java.awt.Choice cboxPorts;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JLabel lblLogo;
    public java.awt.TextField txtCodigo;
    // End of variables declaration//GEN-END:variables

}
