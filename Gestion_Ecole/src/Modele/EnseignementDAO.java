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
public class EnseignementDAO extends DAO<Enseignement> {

    public EnseignementDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Enseignement o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignement find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Enseignement> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Enseignement> getTableSpecID(int ID_Enseignant) {
        HashMap<Integer, Enseignement> enseignements = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM enseignement WHERE IDEnseignant = " + ID_Enseignant);
            while(rs.next()) {
                int ID = rs.getInt("ID");
                enseignements.put(ID, new Enseignement(
                        ID,
                        rs.getInt("IDDiscipline"),
                        rs.getInt("IDEnseignant"), 
                        rs.getInt("IDClasse")));
            }
        } catch (SQLException ex) {}        
        
        return enseignements;   
    }
}
