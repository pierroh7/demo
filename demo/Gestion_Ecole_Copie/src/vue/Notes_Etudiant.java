/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.mysql.jdbc.Statement;
import gestion_ecole.Connexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modele.Notes_Manip;

/**
 *
 * @author pierr
 */
public class Notes_Etudiant extends javax.swing.JFrame {

    /**
     * Creates new form Notes_Etudiant
     */
    
    Connexion connect = new Connexion();
    Statement etat;
    ResultSet result;
    DefaultTableModel tab_notes = new DefaultTableModel();
    
    
    public Notes_Etudiant(String id, String name, String surname, String classe) {
        initComponents();
        String etudiant = name + " " + surname;
        Etudiant.setText(etudiant);
        Classe.setText(classe);
        ID.setText(id);
        
        tab_notes.addColumn("Matière");
        tab_notes.addColumn("Semestre");
        tab_notes.addColumn("DS1");
        tab_notes.addColumn("DS2");
        tab_notes.addColumn("NS1");
        tab_notes.addColumn("NS2");
        
        
        //Communication et affichage de la base de données
        //*****
        try{
            etat=(Statement) connect.getConnection().createStatement();
            result = etat.executeQuery("SELECT * from notes WHERE ID="+id);
            while(result.next()){
            tab_notes.addRow(new Object[]{result.getString("Matiere"), result.getInt("Semestre"), result.getString("DS1"), result.getString("DS2"),
                result.getString("NS1"),result.getString("NS2")});
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        notes.setModel(tab_notes);
        
        //****
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
        modif_notes = new javax.swing.JButton();
        back = new javax.swing.JButton();
        ajout_notes = new javax.swing.JButton();
        txt_semestre = new javax.swing.JComboBox<>();
        txt_ns2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_ns1 = new javax.swing.JTextField();
        txt_ds2 = new javax.swing.JTextField();
        txt_ds1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Etudiant = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Classe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        txt_matiere = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        modif_notes.setText("Modifier Note(s)");
        modif_notes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modif_notesMouseClicked(evt);
            }
        });
        jPanel1.add(modif_notes);
        modif_notes.setBounds(390, 360, 142, 32);

        back.setText("Retour");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(560, 360, 132, 32);

        ajout_notes.setText("Ajouter Note(s)");
        ajout_notes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajout_notesMouseClicked(evt);
            }
        });
        jPanel1.add(ajout_notes);
        ajout_notes.setBounds(230, 360, 142, 32);

        txt_semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jPanel1.add(txt_semestre);
        txt_semestre.setBounds(80, 310, 70, 26);
        jPanel1.add(txt_ns2);
        txt_ns2.setBounds(80, 250, 73, 24);

        jLabel5.setText("Semestre :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 310, 80, 16);

        jLabel4.setText("NS1 :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 220, 50, 16);
        jPanel1.add(txt_ns1);
        txt_ns1.setBounds(80, 220, 73, 24);
        jPanel1.add(txt_ds2);
        txt_ds2.setBounds(80, 190, 73, 24);
        jPanel1.add(txt_ds1);
        txt_ds1.setBounds(80, 160, 73, 24);

        jLabel3.setText("DS2 :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 190, 50, 16);

        jLabel2.setText("DS1 :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 160, 50, 16);

        notes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Matiere", "Semestre", "DS1", "DS2", "NS1", "NS2"
            }
        ));
        notes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(notes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(180, 130, 550, 180);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Profil étudiant :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 50, 143, 48);

        Etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtudiantActionPerformed(evt);
            }
        });
        jPanel1.add(Etudiant);
        Etudiant.setBounds(160, 60, 165, 24);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Classe :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(330, 50, 80, 48);
        jPanel1.add(Classe);
        Classe.setBounds(410, 60, 50, 24);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ID :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 50, 40, 48);
        jPanel1.add(ID);
        ID.setBounds(530, 60, 50, 24);

        txt_matiere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "math", "info", "elec", "lfh" }));
        jPanel1.add(txt_matiere);
        txt_matiere.setBounds(80, 280, 73, 26);

        jLabel6.setText("NS2 :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 250, 40, 16);

        jLabel7.setText("Matière :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 280, 60, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Sélection des notes dans le tableau
    private void deplace(int i){
        try{
            txt_matiere.setSelectedItem(tab_notes.getValueAt(i,0).toString());
            txt_semestre.setSelectedItem(tab_notes.getValueAt(i,1).toString());
            if(tab_notes.getValueAt(i,2)!= null)
                txt_ds1.setText(tab_notes.getValueAt(i,2).toString());
            if(tab_notes.getValueAt(i,3)!= null)
                txt_ds2.setText(tab_notes.getValueAt(i,3).toString());
            if(tab_notes.getValueAt(i,4)!= null)
                txt_ns1.setText(tab_notes.getValueAt(i,4).toString());
            if(tab_notes.getValueAt(i,5)!= null)
                txt_ns2.setText(tab_notes.getValueAt(i,5).toString());
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de deplacment "+e.getLocalizedMessage());
        }
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Gestion_Etudiants_par_Prof gestion = new Gestion_Etudiants_par_Prof();               
        gestion.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void EtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EtudiantActionPerformed
    
    //Pour afficher les notes du tableau dans les textfield
    private void notesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesMouseClicked
        try{
            int i = notes.getSelectedRow();
            deplace(i);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "erreur de deplacement " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_notesMouseClicked

    //Ajouter nouvelle note
    private void ajout_notesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajout_notesMouseClicked
        // TODO add your handling code here:
        try{
            etat.executeUpdate("UPDATE notes SET DS1='"+txt_ds1.getText()+"', DS2='"+txt_ds2.getText()+"', NS1='"+txt_ns1.getText()+"', NS2='"+txt_ns2.getText()+"' WHERE ID='"+ID.getText()+"' AND Matiere='"+txt_matiere.getSelectedItem().toString()+"' AND Semestre='"+txt_semestre.getSelectedItem().toString()+"'");
            
            JOptionPane.showMessageDialog(null, "Note(s) ajoutée(s) !"); 
            txt_ds1.setText("");
            txt_ds2.setText("");
            txt_ns1.setText("");
            txt_ns2.setText("");
            txt_semestre.setSelectedItem("math");
            
            //Code d'actualisation du tableau
            mise_a_jour();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());}  
    }//GEN-LAST:event_ajout_notesMouseClicked

    //Modifer notes étudiant
    private void modif_notesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modif_notesMouseClicked
        try{
            if (JOptionPane.showConfirmDialog (null, "Enregistrer la modification ?", "modif", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
                etat.executeUpdate("UPDATE notes SET DS1='"+txt_ds1.getText()+"', DS2='"+txt_ds2.getText()+"', NS1='"+txt_ns1.getText()+"', NS2='"+txt_ns2.getText()+"' WHERE ID='"+ID.getText()+"' AND Matiere='"+txt_matiere.getSelectedItem().toString()+"' AND Semestre='"+txt_semestre.getSelectedItem().toString()+"'");
                }
                //Code d'actualisation du tableau 
                mise_a_jour();
                
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Modification non-effectuée " +e.getMessage());
            System.out.println(e);
        }
    }//GEN-LAST:event_modif_notesMouseClicked

    public void mise_a_jour(){
        try{
            tab_notes.setRowCount(0);
            etat=(Statement) connect.getConnection().createStatement();
            result = etat.executeQuery("SELECT * from notes WHERE ID="+ID.getText());
            while(result.next()){
                tab_notes.addRow(new Object[]{result.getString("Matiere"), result.getInt("Semestre"), result.getString("DS1"), result.getString("DS2"),
                    result.getString("NS1"),result.getString("NS2")});
                }

            }catch(Exception e){
                System.out.println(e);
            }

            notes.setModel(tab_notes);
    }
    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notes_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notes_Etudiant().setVisible(true);
            }
        });
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Classe;
    private javax.swing.JTextField Etudiant;
    private javax.swing.JTextField ID;
    private javax.swing.JButton ajout_notes;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modif_notes;
    private javax.swing.JTable notes;
    private javax.swing.JTextField txt_ds1;
    private javax.swing.JTextField txt_ds2;
    private javax.swing.JComboBox<String> txt_matiere;
    private javax.swing.JTextField txt_ns1;
    private javax.swing.JTextField txt_ns2;
    private javax.swing.JComboBox<String> txt_semestre;
    // End of variables declaration//GEN-END:variables

}