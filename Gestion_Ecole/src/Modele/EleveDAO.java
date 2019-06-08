/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class EleveDAO extends DAO<Eleve> {

    public EleveDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Eleve o) {
        try {
            String query = "INSERT INTO personne (ID, Nom, Prenom, Type)"
                         + " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setString (2, o.getNom());
            preparedStmt.setString   (3, o.getPrenom());
            preparedStmt.setString(4, "Etudiant");
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout eleve echoue."); }        
        return true;
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
        } catch (SQLException ex) {}
        return eleve;
    }
    
    @Override
    public int getNbRows() {
        int nbRows = 0;
        try {      
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Etudiant'");
            rs.last();
            nbRows = rs.getRow(); // Donne le numéro de la dernière ligne, par conséquent le nombre de lignes
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return nbRows;
    }
    
    @Override
    public HashMap<Integer, Eleve> getTable() {
        HashMap<Integer, Eleve> eleves = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM personne WHERE Type = 'Etudiant'");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                eleves.put(ID, new Eleve(ID, 0, rs.getString("Nom"), rs.getString("Prenom")));
            }
        } catch (SQLException ex) {}

        return eleves;
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM personne";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table personne supprimee");
            
            query = "ALTER TABLE personne AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table personne echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM personne");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) { System.out.println("cle peut pas trouver"); }
        return maxID;
    }
}