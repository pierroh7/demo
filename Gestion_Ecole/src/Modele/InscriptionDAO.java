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
public class InscriptionDAO extends DAO<Inscription> {
    
    public InscriptionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Inscription o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
