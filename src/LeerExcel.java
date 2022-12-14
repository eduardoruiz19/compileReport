/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Clases.EscribirInformeErrores;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JasperCompileManager;
// C:\Users\eduar\Documents\admin1_202223280923.xls
/**
 *
 * @author eduar
 */
public class LeerExcel extends javax.swing.JFrame {

    public static void mostrarError(Exception ex) {
        ex.printStackTrace();
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        //LeerExcel.mostrarError(errors.toString());
        String texto = LeerExcel.txarea.getText();
        texto = texto + "\n" + errors.toString();
        LeerExcel.txarea.setText(texto);
        EscribirInformeErrores.Escribir(texto);

    }

    public static void mostrarMensaje(String txt) {
        String texto = LeerExcel.txarea.getText();
        texto = texto + "\n" + txt;
        LeerExcel.txarea.setText(texto);
        EscribirInformeErrores.Escribir(texto);
    }

    /**
     * Creates new form LeerExcel
     */
    public LeerExcel() {
        initComponents();
        this.setTitle("Compilador de Archivos Jrxml");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreArchivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txarea = new javax.swing.JTextArea();
        btnprocesar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreArchivo.setText("C:\\ramos\\GioConfig\\src\\controlador\\ReciboBasculaTransito.jrxml");
        txtNombreArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreArchivoActionPerformed(evt);
            }
        });

        jLabel2.setText("Archivo:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("jLabel1");

        txarea.setColumns(20);
        txarea.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txarea.setRows(5);
        jScrollPane1.setViewportView(txarea);

        btnprocesar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnprocesar.setText("Compilar Archivo Jrxml a Jasper");
        btnprocesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocesarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Abrir Archivo de Reportes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreArchivo)
                    .addComponent(jbar, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(77, 77, 77))
                    .addComponent(jScrollPane1)
                    .addComponent(btnprocesar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnprocesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprocesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocesarActionPerformed
  try {

    String reportName = LeerExcel.txtNombreArchivo.getText();
    String str[]=reportName.split("\\.");
    String reportName_jasper = str[0] + ".jasper";
      System.out.println("reportName_jasper:"+reportName_jasper);
    // compiles jrxml
    JasperCompileManager.compileReportToFile(reportName, reportName_jasper);
      System.out.println("ARchivo Creado:"+reportName_jasper);
      LeerExcel.mostrarMensaje("Archivo Creado con Exito: \n"+reportName_jasper);
  } catch (Exception ex) {
      LeerExcel.mostrarError(ex);
      ex.printStackTrace();

  }

        //Progress p = new Progress(jLabel1, jbar, txarea, this);
        //p.execute();
    }//GEN-LAST:event_btnprocesarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarArchivo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(LeerExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeerExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeerExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeerExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                LeerExcel leerExcel = new LeerExcel();
                leerExcel.setLocationRelativeTo(null);
                leerExcel.setVisible(true);
            }
        });
    }

    public void iniciar() {
        JOptionPane.showMessageDialog(null, "ARCHIVO GENERADO CON EXITO.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnprocesar;
    private javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JProgressBar jbar;
    public static javax.swing.JTextArea txarea;
    public static javax.swing.JTextField txtNombreArchivo;
    // End of variables declaration//GEN-END:variables

    private void cargarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("ARCHIVO .JRXML", "jrxml");
        fileChooser.setFileFilter(imgFilter);
        int result = fileChooser.showOpenDialog(this);

        if (result != JFileChooser.CANCEL_OPTION) {

            File fileName = fileChooser.getSelectedFile();

            if ((fileName == null) || (fileName.getName().equals(""))) {
                return;
            } else {
                txtNombreArchivo.setText(fileName.getAbsolutePath());
            }
        }
    }
}
