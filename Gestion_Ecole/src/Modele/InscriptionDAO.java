/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class InscriptionDAO extends DAO<Inscription> {
    
    public InscriptionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Inscription o) {
        try {
            String query = "INSERT INTO inscription (ID, IDEtudiant, IDClasse)"
                         + " VALUES (?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_Eleve());
            preparedStmt.setInt(3, o.getID_Classe());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout inscription echoue."); }
        return true;      
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Inscription o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Inscription> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Inscription> getTableSpecID(int ID_Eleve) {
        HashMap<Integer, Inscription> inscription = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM inscription WHERE IDEtudiant = " + ID_Eleve);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                inscription.put(ID, new Inscription(
                        ID,
                        rs.getInt("IDEtudiant"),
                        rs.getInt("IDClasse")));
            }
        } catch (SQLException ex) {}
        return inscription;
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM inscription";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table inscription supprimee");
            
            query = "ALTER TABLE inscription AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table inscription echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM inscription");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
