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
public class DAOFactory {

    protected static final Connection conn = Connexion.getConnexion();

    /**
     *
     * @return DAO
     */
    public static DAO getAnneeDAO() { return new AnneeDAO(conn); }
    public static DAO getBulletinDAO() { return new BulletinDAO(conn); }
    public static DAO getClasseDAO() { return new ClasseDAO(conn); }
    public static DAO getDetailBulletinDAO() { return new DetailBulletinDAO(conn); }
    public static DAO getDirecteurDAO() { return new DirecteurDAO(conn); }
    public static DAO getDisciplineDAO() { return new DisciplineDAO(conn); }
    public static DAO getEcoleDAO() { return new EcoleDAO(conn); }
    public static DAO getEleveDAO() { return new EleveDAO(conn); }
    public static DAO getEnseignantDAO() { return new EnseignantDAO(conn); }
    public static DAO getEnseignementDAO() { return new EnseignementDAO(conn); }
    public static DAO getEvaluationDAO() { return new EvaluationDAO(conn); }
    public static DAO getInscriptionDAO() { return new InscriptionDAO(conn); }
    public static DAO getNiveauDAO() { return new NiveauDAO(conn); }
    public static DAO getTrimestreDAO() { return new TrimestreDAO(conn); }

}