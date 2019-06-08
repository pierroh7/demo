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
public class NiveauDAO extends DAO<Niveau> {

    public NiveauDAO(Connection conn) {
        super(conn);
    }
    @Override
    public boolean create(Niveau o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Niveau o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Niveau find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Niveau> getTable() {
        HashMap<Integer, Niveau> niveaux = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM niveau");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                niveaux.put(ID, new Niveau(ID,rs.getString("Nom")));
            }
        } catch (SQLException ex) {}

        return niveaux;      
    }
    
}
