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

    protected static final Connection conn = Connexion.getConnection();

    /**
     *
     * @return DAO
     */
    public static DAO getClasseDAO() {
        return new ClasseDAO(conn);
    }

    /**
     *
     * @return DAO
     */
    public static DAO getEnseignantDAO() {
        return new EnseignantDAO(conn);
    }

    /**
     *
     * @return DAO
     */
    public static DAO getEleveDAO() {
        return new EleveDAO(conn);
    }

    /**
     *
     * @return DAO
     */
    public static DAO getDisciplineDAO() {
        return new DisciplineDAO(conn);
    }
}