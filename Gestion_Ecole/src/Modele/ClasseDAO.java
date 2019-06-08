/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.HashMap;



/**
 *
 * @author Nathan
 */
public class ClasseDAO extends DAO<Classe> {

    public ClasseDAO(Connection conn) {
        super(conn);
    }
    
    @Override
        public boolean create(Classe o) {
        try {
            String query = "INSERT INTO classe (ID, IDNiveau, IDAnnee, Nom)"
                         + " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_Niveau());
            preparedStmt.setInt(3, o.getID_Annee());
            preparedStmt.setString(4, o.getNom());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout classe echoue."); }
        return true;            
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean update(Classe obj) {
        return false;
    }

    @Override
    public Classe find(int ID) {
        Classe classe = new Classe();
        return classe;
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Classe> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Classe> getTableSpecID(int ID_Niveau) {
        HashMap<Integer, Classe> classes = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM classe WHERE IDNiveau = " + ID_Niveau);
            while(rs.next()) {
                int ID = rs.getInt("ID");
                classes.put(ID, new Classe(
                        ID,
                        rs.getInt("IDNiveau"),
                        rs.getInt("IDAnnee"), 
                        rs.getString("Nom")));
            }
        } catch (SQLException ex) {}        
        
        return classes;   
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM classe";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table classe supprimee");
            
            query = "ALTER TABLE classe AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table classe echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM classe");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
