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
public class TrimestreDAO extends DAO<Trimestre> {

    public TrimestreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Trimestre o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
