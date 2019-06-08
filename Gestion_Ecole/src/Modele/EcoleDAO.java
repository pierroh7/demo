/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class EcoleDAO extends DAO<Ecole> {

    EcoleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Ecole o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Ecole o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ecole find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Ecole> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deteleTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteAllTables() {
        DAO<Eleve> eleveDAO = DAOFactory.getEleveDAO();
        DAO<Niveau> niveauDAO = DAOFactory.getNiveauDAO();
        DAO<Discipline> disciplineDAO = DAOFactory.getDisciplineDAO();
        DAO<Annee> anneeDAO = DAOFactory.getAnneeDAO();
        DAO<Classe> classeDAO = DAOFactory.getClasseDAO();
        DAO<Trimestre> trimestreDAO = DAOFactory.getTrimestreDAO();
        DAO<Inscription> inscriptionDAO = DAOFactory.getInscriptionDAO();
        DAO<Enseignement> enseignementDAO = DAOFactory.getEnseignementDAO();
        DAO<Bulletin> bulletinDAO = DAOFactory.getBulletinDAO();
        DAO<DetailBulletin> detailBulletinDAO = DAOFactory.getDetailBulletinDAO();
        DAO<Evaluation> evaluationDAO = DAOFactory.getEvaluationDAO();
        
        eleveDAO.deteleTable();
        niveauDAO.deteleTable();
        disciplineDAO.deteleTable();
        anneeDAO.deteleTable();
        classeDAO.deteleTable();
        trimestreDAO.deteleTable();
        inscriptionDAO.deteleTable();
        enseignementDAO.deteleTable();
        bulletinDAO.deteleTable();
        detailBulletinDAO.deteleTable();
        evaluationDAO.deteleTable();
    }

    @Override
    public int getMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
