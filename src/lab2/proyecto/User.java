/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


package lab2.proyecto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author umg
 */
public class User extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(User.class.getName());

    public static Registro formres;
    
    public User() {
        initComponents();
        setLocationRelativeTo(null);
        crearAdminSiNoExiste();
    }

     private void crearAdminSiNoExiste() {
    ArrayList<CrUsuarios> usuarios = ArchivoUsuarios.cargar();

    if (usuarios.isEmpty()) {
        usuarios.add(new CrUsuarios("Usr-001", "rootx9", "1234", true));
        ArchivoUsuarios.guardar(usuarios);
    }
}

     private void recuperarPassword() {

    String email = JOptionPane.showInputDialog("Correo:");
    if (email != null) email = email.trim();
    if (email == null || email.isEmpty()) return;

    String letra = JOptionPane.showInputDialog("2da letra de tu nombre:");
    if (letra == null || letra.isEmpty()) return;

    ArrayList<CrUsuarios> usuarios = ArchivoUsuarios.cargar();

    for (CrUsuarios u : usuarios) {

        if (u.email.equalsIgnoreCase(email.trim())) {

            // 🔒 proteger admin
            if (u.esAdmin) {
                JOptionPane.showMessageDialog(null, "Acción no permitida");
                return;
            }

            // ⚠️ Validar longitud (IMPORTANTE)
            if (u.nombreCompleto.length() < 2) {
                JOptionPane.showMessageDialog(null, "Datos inválidos");
                return;
            }

            // 🔍 Validación de la 2da letra
            String segundaLetra = u.nombreCompleto.substring(1, 2);

            if (!segundaLetra.equalsIgnoreCase(letra)) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                return;
            }

            // 🔑 Nueva contraseña
            JPasswordField campo = new JPasswordField();
int opcion = JOptionPane.showConfirmDialog(null, campo, "Nueva contraseña", JOptionPane.OK_CANCEL_OPTION);

if (opcion != JOptionPane.OK_OPTION) return;

String nuevaPass = new String(campo.getPassword());
if (nuevaPass.isEmpty()) return;


// 🔁 Confirmar contraseña
            JPasswordField campo2 = new JPasswordField();
            int opcion2 = JOptionPane.showConfirmDialog(null, campo2, "Confirmar contraseña", JOptionPane.OK_CANCEL_OPTION);

            if (opcion2 != JOptionPane.OK_OPTION) return;

            String confirmar = new String(campo2.getPassword());

            if (!nuevaPass.equals(confirmar)) {
                JOptionPane.showMessageDialog(null, "No coinciden");
                return;
            }

            u.pass = nuevaPass;

            ArchivoUsuarios.guardar(usuarios);

            JOptionPane.showMessageDialog(null, "Contraseña actualizada");

            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Correo no encontrado");
}
     
   private void abrirMenuAdmin() {
    new MenuAdmin().setVisible(true);
    this.dispose();
}

private void abrirMenuUsuario() {
    new MenuUsuario().setVisible(true);
    this.dispose();
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmailLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordLogin = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(445, 480));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/310818 (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("User Login");

        EmailLogin.setName(""); // NOI18N
        EmailLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailLoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo:");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("¿Olvidaste tu contraseña?");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jButton1.setText("Registrarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Iniciar Sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(PasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailLoginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        formres = new Registro(null, true);
        formres.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    String email = EmailLogin.getText();
    String pass = new String(PasswordLogin.getPassword());

    ArrayList<CrUsuarios> usuarios = ArchivoUsuarios.cargar();

    for (CrUsuarios u : usuarios) {
        if (u.email.equals(email) && u.pass.equals(pass)) {

            if (u.esAdmin) {
                abrirMenuAdmin();
            } else {
                abrirMenuUsuario();
            }
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Datos incorrectos");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        recuperarPassword();
    }//GEN-LAST:event_jLabel5MouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
        new User().setVisible(true);
    }
});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailLogin;
    private javax.swing.JPasswordField PasswordLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
