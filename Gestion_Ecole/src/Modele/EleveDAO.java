/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE ID = " + ID  + " AND Type = 'Etudiant'");
            if (result.first()) {
                eleve = new Eleve(
                        ID,
                        0, // l'accès
                        result.getString("Nom"),
                        result.getString("Prenom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }
    
    @Override
    public int getNbRows() {
        int nbRows = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Etudiant'");
            result.last();
            nbRows = result.getRow(); // Donne le numéro de la dernière ligne, par conséquent le nombre de lignes
            result.beforeFirst();
            
        } catch (SQLException ex) {}
        return nbRows;
    }
    
    @Override
    public HashMap<Integer, Eleve> getTable() {
        HashMap<Integer, Eleve> eleves = new HashMap<>();
        try {
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Etudiant'");
            while(result.next()) {
                int ID = result.getInt("ID");
                eleves.put(ID, new Eleve(ID, 0, result.getString("Nom"), result.getString("Prenom")));
            }
        } catch (SQLException ex) {}

        return eleves;
    }
}