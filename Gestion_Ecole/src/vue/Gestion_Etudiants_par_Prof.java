package vue;


import com.mysql.jdbc.Statement;
import gestion_ecole.Connexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pierr
 */
public class Gestion_Etudiants_par_Prof extends javax.swing.JFrame {

    /**
     * Creates new form Gestion_Etudiant_par_Prof
     */
    Connexion connect = new Connexion();
    Statement etat;
    ResultSet result;
    DefaultTableModel default_table = new DefaultTableModel();
    
    
    public Gestion_Etudiants_par_Prof() {
        initComponents();
        
        default_table.addColumn("ID");
        default_table.addColumn("Nom");
        default_table.addColumn("Prenom");
        default_table.addColumn("Classe");
        
        //Communication et affichage de la base de données
        try{
            etat=(Statement) connect.getConnection().createStatement();
            result = etat.executeQuery("Select * from etudiant");
            while(result.next()){
                default_table.addRow(new Object[]{result.getString("ID"), result.getString("Nom"),
                result.getString("Prenom"),result.getString("Classe")});
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        table.setModel(default_table);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_surname = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_class = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jLabel1.setText("Nom");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 40, 50, 16);

        jLabel2.setText("ID Etudiant");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 10, 60, 16);

        jLabel3.setText("Prenom");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 70, 45, 16);

        jLabel4.setText("Classe");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(0, 100, 60, 20);

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_name);
        txt_name.setBounds(70, 35, 110, 24);

        txt_surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_surnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_surname);
        txt_surname.setBounds(70, 65, 110, 24);
        jPanel2.add(txt_id);
        txt_id.setBounds(70, 5, 110, 24);

        txt_class.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TD 1", "TD 2", "TD 3", "TD 4" }));
        jPanel2.add(txt_class);
        txt_class.setBounds(70, 95, 110, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 210, 140);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(230, 50, 440, 240);

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(45, 220, 100, 32);

        jButton4.setText("Modifier informations");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(20, 300, 160, 32);

        jButton3.setText("Supprimer étudiant");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(480, 290, 140, 32);

        jButton2.setText("Ajouter étudiant");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(310, 290, 130, 32);

        jButton5.setText("Profil de l'étudiant");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(25, 260, 150, 32);

        jLabel5.setText("Liste des étudiants");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(310, 10, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void deplace(int i){
        try{
            txt_id.setText(default_table.getValueAt(i,0).toString());
            txt_name.setText(default_table.getValueAt(i,1).toString());
            txt_surname.setText(default_table.getValueAt(i,2).toString());
            txt_class.setSelectedItem(default_table.getValueAt(i,3).toString());
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacment "+e.getLocalizedMessage());
        }
        
        
    }
    
    private void txt_surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_surnameActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    //Selection dans tableau
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        try{
            int i = table.getSelectedRow();
            deplace(i);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erreur de deplacement " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_tableMouseClicked
    
    //Modifier étudiant
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            if (JOptionPane.showConfirmDialog (null, "Enregistrer la modification ?", "modif", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                etat.executeUpdate("UPDATE etudiant SET Nom='"+txt_name.getText()+"',Prenom='"+txt_surname.getText()+"', Classe='"+txt_class.getSelectedItem().toString()+"' WHERE ID="+txt_id.getText());
                }
                //Code d'actualisation du tableau 
                //*******
                try{
                    default_table.setRowCount(0);
                    etat=(Statement) connect.getConnection().createStatement();
                    result = etat.executeQuery("Select * from etudiant");
                    while(result.next()){
                        default_table.addRow(new Object[]{result.getString("ID"), result.getString("Nom"),
                        result.getString("Prenom"),result.getString("Classe")});
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
              
                table.setModel(default_table);
                //*******
                
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Modification non-effectuée " +e.getMessage());
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    //Ajout étudiant
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String id = txt_id.getText();
        String nom = txt_name.getText();
        String prenom = txt_surname.getText();
        String classe = txt_class.getSelectedItem().toString();
        
        String requete = "INSERT INTO etudiant(ID, Nom, Prenom, Classe) VALUES ('"+id+"', '"+nom+"', '"+prenom+"', '"+classe+"')";
        String requete_math = "INSERT INTO notes_math(ID) VALUES ('"+id+"')";
        String requete_elec = "INSERT INTO notes_elec(ID) VALUES ('"+id+"')";
        try{
            etat.executeUpdate(requete);
            etat.executeUpdate(requete_math);
            etat.executeUpdate(requete_elec);
            
            JOptionPane.showMessageDialog(null, "Etudiant ajouté !"); 
            txt_id.setText("");
            txt_name.setText("");
            txt_surname.setText("");
            txt_class.setSelectedItem(1);
            
            //Code d'actualisation du tableau
            //*******
            try{
                default_table.setRowCount(0);
                etat=(Statement) connect.getConnection().createStatement();
                result = etat.executeQuery("Select * from etudiant");
                while(result.next()){
                    default_table.addRow(new Object[]{result.getString("ID"), result.getString("Nom"),
                    result.getString("Prenom"),result.getString("Classe")});
                }
            }catch(Exception e){
                System.out.println(e);
            }

            table.setModel(default_table);
            //*******
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());}  
    }//GEN-LAST:event_jButton2MouseClicked
    
    //Suppression étudiant
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        try{
            if (JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer un étudiant ?", "supprimer étudiant", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                if(txt_id.getText().length() != 0){
                    etat.executeUpdate("DELETE FROM etudiant WHERE ID="+txt_id.getText());
                    etat.executeUpdate("DELETE FROM notes_math WHERE ID="+txt_id.getText());
                    etat.executeUpdate("DELETE FROM notes_elec WHERE ID="+txt_id.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "Merci de remplir le champ ID svp");
                }
            }
            
            //Code d'actualisation du tableau
            //*******
            try{
                default_table.setRowCount(0);
                etat=(Statement) connect.getConnection().createStatement();
                result = etat.executeQuery("Select * from etudiant");
                while(result.next()){
                    default_table.addRow(new Object[]{result.getString("ID"), result.getString("Nom"),
                    result.getString("Prenom"),result.getString("Classe")});
                }
            }catch(Exception e){
                System.out.println(e);
            }

            table.setModel(default_table);
            //*******
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton3MouseClicked

    
    //Notes étudiant
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        Profil_Etudiant profil = new Profil_Etudiant(txt_id.getText(), txt_name.getText(), txt_surname.getText(), txt_class.getSelectedItem().toString());
        profil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_Etudiants_par_Prof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Etudiants_par_Prof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Etudiants_par_Prof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Etudiants_par_Prof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gestion_Etudiants_par_Prof gestion = new Gestion_Etudiants_par_Prof();               
                gestion.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> txt_class;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_surname;
    // End of variables declaration//GEN-END:variables

    private Statement executeUpdate(String requete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
