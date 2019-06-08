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
public class AnneeDAO extends DAO<Annee> {

    public AnneeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Annee o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Annee o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Annee find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Annee> getTable() {
        HashMap<Integer, Annee> annees = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM annee");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                annees.put(ID, new Annee(ID));
            }
        } catch (SQLException ex) {}

        return annees;     
    }
    
}
