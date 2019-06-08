/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.HashMap;

/**
 * @author Nathan
 * @param <Objet>
 */
public abstract class DAO<Objet> {

    protected Connection co = null;

    /** Constructeur
     * @param connexion
     */
    public DAO(Connection connexion) {
        this.co = connexion;
    }

    /**
     * @param o
     * @return boolean
     */
    public abstract boolean create(Objet o);

    /**
     * @param ID
     * @return boolean
     */
    public abstract boolean delete(int ID);

    /**
     * @param o
     * @return boolean
     */
    public abstract boolean update(Objet o);

    /**
     * @param ID
     * @return Objet
     */
    public abstract Objet find(int ID);

    public abstract int getNbRows();
    
    public abstract HashMap<Integer, Objet> getTable();
    
    public abstract void deteleTable();
    
    public abstract int getMaxID();
}