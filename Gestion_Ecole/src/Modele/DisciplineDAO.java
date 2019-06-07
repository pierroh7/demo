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
public class DisciplineDAO extends DAO<Discipline> {

    public DisciplineDAO(Connection conn) {
        super(conn);
    }
    
    @Override
        public boolean create(Discipline obj) {
        return false;
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean update(Discipline obj) {
        return false;
    }

    @Override
    public Discipline find(int ID) {
        Discipline discipline = new Discipline();
        return discipline;
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Discipline> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
