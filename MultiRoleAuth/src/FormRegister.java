import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class FormRegister extends javax.swing.JFrame {

    
    public FormRegister() {
        initComponents();
        Koneksi();
    }
    
    Connection con;
    PreparedStatement pst, pstCek;
    ResultSet rs, rsCek;
    String nama, email, pass, cpass;
    int k;
    
    public void Koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_projectjava4", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reset(){
        jnama.setText("");
        jemail.setText("");
        jpass.setText("");
        jcpass.setText("");
        jnama.requestFocus();
    }
    
    public void ambilData(){
        nama = jnama.getText();
        email = jemail.getText().trim();
        pass = new String(jpass.getPassword());
        cpass = new String(jcpass.getPassword());
    }
    
    public void pindah(){
        new FormLogin().setVisible(true);
        this.dispose();
    }
    
    public boolean validasi(){
       ambilData();
       if(nama.isEmpty() || email.isEmpty() || pass.isEmpty() || cpass.isEmpty()){
           JOptionPane.showMessageDialog(this, "Data harus di isi!", "Perhatian", JOptionPane.WARNING_MESSAGE);
           jnama.requestFocus();
           return false;
       }else if(!email.endsWith("@gmail.com")){
            JOptionPane.showMessageDialog(this, "Email harus menggunakan @gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
            jemail.requestFocus();
            return false;
        }else if(!cpass.equals(pass)){
            JOptionPane.showMessageDialog(this, "Konfirmasi password tidak sesuai!", "Error", JOptionPane.ERROR_MESSAGE);
            jcpass.requestFocus();
            return false;
       }
       return true;
    }
    
    public void lihatPassword(){
        if(jlihatpass.isSelected()){
            jpass.setEchoChar((char) 0);
            jcpass.setEchoChar((char) 0);
            jlihatpass.setText("Sembunyikan Password");
        }else{
           jpass.setEchoChar('\u2022');
           jcpass.setEchoChar('\u2022'); 
           jlihatpass.setText("Lihat Password");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jnama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpass = new javax.swing.JPasswordField();
        jcpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jlihatpass = new javax.swing.JCheckBox();
        jpindah = new javax.swing.JLabel();
        jemail = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama");

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        jLabel4.setText("Konfirmas Password");

        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Register");

        jlihatpass.setText("Lihat Password");
        jlihatpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlihatpassActionPerformed(evt);
            }
        });

        jpindah.setText("Sudah punya akun? Login");
        jpindah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpindahMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                        .addComponent(jcpass, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jpindah)
                                            .addComponent(jlihatpass))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(85, 85, 85))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpass)
                            .addComponent(jemail, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jlihatpass)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addComponent(jpindah)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlihatpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlihatpassActionPerformed
        lihatPassword();
    }//GEN-LAST:event_jlihatpassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jpindahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpindahMouseClicked
        pindah();
    }//GEN-LAST:event_jpindahMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           if(!validasi()){
             return;
           }
           
            pstCek = con.prepareStatement("select * from users where email =?");
            pstCek.setString(1, email);
            rsCek = pstCek.executeQuery();
            
            if(rsCek.next()){
                JOptionPane.showMessageDialog(this, "Email tersebut sudah digunakan oleh pengguna lain!");
                jemail.requestFocus();
            }else{
              pst = con.prepareStatement("insert into users(nama, email, password) values (?, ?, ?)");
              pst.setString(1, nama);
              pst.setString(2, email);
              pst.setString(3, pass);
              k = pst.executeUpdate();
              
              if(k == 1){
                  JOptionPane.showMessageDialog(this, "Registrasi berhasil!");
                  pindah();
              }else{
                  JOptionPane.showMessageDialog(this, "Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
                  reset();
              }
              
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jcpass;
    private javax.swing.JFormattedTextField jemail;
    private javax.swing.JCheckBox jlihatpass;
    private javax.swing.JTextField jnama;
    private javax.swing.JPasswordField jpass;
    private javax.swing.JLabel jpindah;
    // End of variables declaration//GEN-END:variables
}
