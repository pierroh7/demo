/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class DetailBulletin {
    private int ID;
    private int ID_Bulletin;
    private int ID_Enseignement;
    private HashMap<Integer, Evaluation> notes;
    private String appreciation;
    
    public DetailBulletin() {
        DAO<Evaluation> evaluationDAO = DAOFactory.getEvaluationDAO();
        this.notes = new HashMap<>(((EvaluationDAO) evaluationDAO).getTableSpecID(ID));
    }
}
