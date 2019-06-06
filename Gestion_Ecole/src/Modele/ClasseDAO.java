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
public class ClasseDAO extends DAO<Classe> {

    public ClasseDAO(Connection conn) {
        super(conn);
    }
    
    @Override
        public boolean create(Classe obj) {
        return false;
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean update(Classe obj) {
        return false;
    }

    @Override
    public Classe find(int ID) {
        Classe classe = new Classe();
        return classe;
    }
}
