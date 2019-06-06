/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.*;


/**
 *
 * @author Nathan
 */
public class EnseignantDAO extends DAO<Enseignant> {

    public EnseignantDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Enseignant obj) {
        return false;
    }
    
    @Override
    public boolean delete(int ID) {
        return false;
    }
    
    @Override
    public boolean update(Enseignant obj) {
        return false;
    }

    @Override
    public Enseignant find(int ID) {
        Enseignant enseignant = new Enseignant();
        String type;
        int acces = 0;

        try {
            ResultSet result = this.co.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM personne WHERE ID = " + ID  + " AND Type = 'Enseignant'");
            if (result.first()) {
                type = result.getString("Type");
                if ("Etudiant".equals(type)) acces = 0;
                if ("Professeur".equals(type)) acces = 1;
                if ("Directeur".equals(type)) acces = 2;
                enseignant = new Enseignant(
                        ID,
                        acces,
                        result.getString("Nom"),
                        result.getString("Prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }
}
