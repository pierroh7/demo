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
public class DisciplineDAO extends DAO<Discipline> {

    public DisciplineDAO(Connection conn) {
        super(conn);
    }
    
    @Override
        public boolean create(Discipline o) {
        try {
            String query = "INSERT INTO discipline (ID, Nom)"
                         + " VALUES (?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setString(2, o.getNom());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout discipline echoue."); }
        return true;
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean update(Discipline o) {
        return false;
    }

    @Override
    public Discipline find(int ID) {
        Discipline discipline = new Discipline();
        return discipline;
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Discipline> getTable() {
        HashMap<Integer, Discipline> disciplines = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM discipline");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                disciplines.put(ID, new Discipline(
                        ID,
                        rs.getString("Nom")));
            }
        } catch (SQLException ex) {}

        return disciplines;    
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM discipline";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table discipline supprimee");
            
            query = "ALTER TABLE discipline AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table discipline echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM discipline");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
