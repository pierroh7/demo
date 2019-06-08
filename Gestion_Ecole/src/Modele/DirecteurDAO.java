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
public class DirecteurDAO extends DAO<Directeur> {

    public DirecteurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Directeur o) {
        try {
            String query = "INSERT INTO personne (ID, Nom, Prenom, Type)"
                         + " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setString (2, o.getNom());
            preparedStmt.setString   (3, o.getPrenom());
            preparedStmt.setString(4, "Directeur");
            preparedStmt.execute();
        } catch (SQLException e) { System.out.println("Ajout directeur echoue."); }        
        return true;    
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
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Directeur'");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                directeurs.put(ID, new Directeur(ID, 2, rs.getString("Nom"), rs.getString("Prenom")));
            }
        } catch (SQLException ex) {}

        return directeurs;
    }

    @Override
    public void deteleTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
