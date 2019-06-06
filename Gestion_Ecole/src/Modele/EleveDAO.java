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
public class EleveDAO extends DAO<Eleve> {

    public EleveDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Eleve obj) {
        return false;
    }
    
    @Override
    public boolean delete(int ID) {
        return false;
    }
    
    @Override
    public boolean update(Eleve obj) {
        return false;
    }

    @Override
    public Eleve find(int ID) {
        Eleve eleve = new Eleve();

        try {
            ResultSet result = this.co.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM personne WHERE ID = " + ID  + " AND Type = 'Etudiant'");
            if (result.first()) {
                eleve = new Eleve(
                        ID,
                        result.getString("Nom"),
                        result.getString("Prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }
}