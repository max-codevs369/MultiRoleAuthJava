import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class FormLogin extends javax.swing.JFrame {

   
    public FormLogin() {
        initComponents();
        Koneksi();
    }
    
    
    Connection con;
    String email, pass, role;
    PreparedStatement psCek, ps;
    ResultSet rsCek, rs, r;
    
  
    private void Koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_projectjava4", "root", "");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void pindah(){
        new FormRegister().setVisible(true);
        this.dispose();
    }
    
    public void pindahKePembeli(){
        new pembeliHome().setVisible(true);
        this.dispose();
    }
    
    public void pindahKeKasir(){
        new kasirHome().setVisible(true);
        this.dispose();
    }
    
    public void ambilData(){
        email = jemail.getText().trim();
        pass = new String(jpass.getPassword());
    }
    
    public void batal(){
        jemail.setText("");
        jpass.setText("");
    }
    
    public void lihatPassword(){
        if(jlihatpass.isSelected()){
            jpass.setEchoChar((char) 0);
            jlihatpass.setText("Sembunyikan Password");
        }else{
            jpass.setEchoChar('\u2022');
            jlihatpass.setText("Lihat Password");
        }
    }
    
    public boolean validasi(){
        ambilData();
        
        if(email.isEmpty() || pass.isEmpty()){
            JOptionPane.showMessageDialog(this, "Data harus diisi", "Perhatian", JOptionPane.YES_OPTION);
            jemail.requestFocus();
            return false;
        }
        
        return true;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jemail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpindah = new javax.swing.JLabel();
        jlihatpass = new javax.swing.JCheckBox();
        jpass = new javax.swing.JPasswordField();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LogIn");

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        jButton1.setText("Login");
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

        jpindah.setText("Belum punya akun? Register");
        jpindah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpindahMouseClicked(evt);
            }
        });

        jlihatpass.setText("Lihat Password");
        jlihatpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlihatpassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlihatpass)
                    .addComponent(jpindah)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jemail, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addComponent(jpass)))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jlihatpass)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(31, 31, 31)
                        .addComponent(jpindah)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpindahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpindahMouseClicked
        pindah();
    }//GEN-LAST:event_jpindahMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        batal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jlihatpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlihatpassActionPerformed
        lihatPassword();
    }//GEN-LAST:event_jlihatpassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ambilData();
            
            if(!validasi()){
                return;
            }
            
            psCek = con.prepareStatement("select * from users where email =?");
            psCek.setString(1, email);
            rsCek = psCek.executeQuery();
            if(rsCek.next()){
                ps = con.prepareStatement("select * from users where email=? and password=?");
                ps.setString(1, email);
                ps.setString(2, pass);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                   role = rs.getString("role");
                   Sesi.nama = rs.getString("nama");
                   
                   
                   if(role.equalsIgnoreCase("pembeli")){
                       pindahKePembeli();
                   }else if(role.equalsIgnoreCase("kasir")){
                       pindahKeKasir();
                   }else{
                        JOptionPane.showMessageDialog(this, "Role tidak dikenali, Silahkan Registrasi Ulang!", "Error", JOptionPane.ERROR_MESSAGE);
                        pindah();
                   }
                   
                }else{
                    JOptionPane.showMessageDialog(this, "Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
                    jpass.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Email tersebut belum terdaftar!", "Error", JOptionPane.ERROR_MESSAGE);
                jemail.requestFocus();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        FormLogin test = new FormLogin();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTextField jemail;
    private javax.swing.JCheckBox jlihatpass;
    private javax.swing.JPasswordField jpass;
    private javax.swing.JLabel jpindah;
    // End of variables declaration//GEN-END:variables
}
