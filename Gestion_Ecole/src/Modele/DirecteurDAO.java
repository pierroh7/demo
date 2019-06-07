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
public class DirecteurDAO extends DAO<Directeur> {

    public DirecteurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Directeur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Directeur o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Directeur find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Directeur> getTable() {
        HashMap<Integer, Directeur> directeurs = new HashMap<>();
        try {
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Directeur'");
            while(result.next()) {
                int ID = result.getInt("ID");
                directeurs.put(ID, new Directeur(ID, 2, result.getString("Nom"), result.getString("Prenom")));
            }
        } catch (SQLException ex) {}

        return directeurs;
    }
}
