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
public class DisciplineDAO extends DAO<Discipline> {

    public DisciplineDAO(Connection conn) {
        super(conn);
    }
        public boolean create(Discipline obj) {
        return false;
    }

    public boolean delete(int ID) {
        return false;
    }

    public boolean update(Discipline obj) {
        return false;
    }

    @Override
    public Discipline find(int ID) {
        Discipline discipline = new Discipline();
        return discipline;
    }
    
}
