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
public class TrimestreDAO extends DAO<Trimestre> {

    public TrimestreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Trimestre o) {
        try {
            String query = "INSERT INTO trimestre (ID, IDAnnee, Numero, Debut, Fin)"
                         + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_Annee());
            preparedStmt.setInt(3, o.getNumero());
            preparedStmt.setString(4, o.getDebut());
            preparedStmt.setString(5, o.getFin());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout trimestre echoue."); }
        return true; 
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Trimestre o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trimestre find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Trimestre> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Trimestre> getTableSpecID(int ID_Annee) {
        HashMap<Integer, Trimestre> trimestres = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM trimestre WHERE IDAnnee = " + ID_Annee);
            while(rs.next()) {
                int ID = rs.getInt("ID");
                trimestres.put(ID, new Trimestre(
                        ID,
                        rs.getInt("IDAnnee"),
                        rs.getInt("Numero"), 
                        rs.getString("Debut"),
                        rs.getString("Fin")));
            }
        } catch (SQLException ex) {}        
        
        return trimestres;   
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM trimestre";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table trimestre supprimee");
            
            query = "ALTER TABLE trimestre AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table trimestre echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM trimestre");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
