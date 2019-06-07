/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class EvaluationDAO extends DAO<Evaluation> {

    public EvaluationDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Evaluation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Evaluation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evaluation find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Evaluation> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Evaluation> getTableSpecID(int ID_DetailBulletin) {
        HashMap<Integer, Evaluation> notes = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM evaluation WHERE IDDetailBulletin = " + ID_DetailBulletin);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                notes.put(ID, new Evaluation(
                        ID,
                        rs.getInt("IDDetailBulletin"),
                        rs.getInt("Note"),
                        rs.getInt("Coefficient"),
                        rs.getString("Appreciation")));
            }
        } catch (SQLException ex) {}
        return notes;
    }
    
}
