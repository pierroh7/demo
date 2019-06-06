/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;

/**
 *
 * @author pierr
 */
public class Notes_Manip {
    private ArrayList math_s1;
    private ArrayList math_s2;
    private double moyenne_math_s1;
    private double moyenne_math_s2;
    
    private ArrayList elec_s1;
    private ArrayList elec_s2;
    private double moyenne_elec_s1;
    private double moyenne_elec_s2;
    
    private ArrayList info_s1;
    private ArrayList info_s2;
    private double moyenne_info_s1;
    private double moyenne_info_s2;
    
    private ArrayList lfh_s1;
    private ArrayList lfh_s2;
    private double moyenne_lfh_s1;
    private double moyenne_lfh_s2;
        
    private double moyenne_ge_s1;
    private double moyenne_ge_s2;
    private double moyenne_annuelle;
    
    public double moyenne(String matiere, String semestre, int ds1, int ds2, int ns1, int ns2){
        double result = 0;
        
        if(semestre.equals("1")){
            switch(matiere){
                case "math":
                    this.math_s1.add(ds1);
                    this.math_s1.add(ds2);
                    this.math_s1.add(ns1);
                    this.math_s1.add(ns2);
                    
                    this.moyenne_math_s1 = (double)this.math_s1.get(0)*2 + (double)this.math_s1.get(1)*2 + (double)this.math_s1.get(2) + (double)this.math_s1.get(3);                    
                    result = this.moyenne_math_s1/=6;
                break;
                
                case "elec":
                    this.elec_s1.add(ds1);
                    this.elec_s1.add(ds2);
                    this.elec_s1.add(ns1);
                    this.elec_s1.add(ns2);
                    
                   this.moyenne_elec_s1 = (double)this.elec_s1.get(0)*2 + (double)this.elec_s1.get(1)*2 + (double)this.elec_s1.get(2) + (double)this.elec_s1.get(3);
                    result = this.moyenne_elec_s1/=6;
                break;
                
                case "info":
                    this.info_s1.add(ds1);
                    this.info_s1.add(ds2);
                    this.info_s1.add(ns1);
                    this.info_s1.add(ns2);
                    
                    this.moyenne_info_s1 = (double)this.info_s1.get(0)*2 + (double)this.info_s1.get(1)*2 + (double)this.info_s1.get(2) + (double)this.info_s1.get(3);
                    result = this.moyenne_info_s1/=6;
                break;
                
                case "lfh":
                    this.lfh_s1.add(ds1);
                    this.lfh_s1.add(ds2);
                    this.lfh_s1.add(ns1);
                    this.lfh_s1.add(ns2);
                    
                    this.moyenne_lfh_s1 = (double)this.lfh_s1.get(0)*2 + (double)this.lfh_s1.get(1)*2 + (double)this.lfh_s1.get(2) + (double)this.lfh_s1.get(3);
                    result = this.moyenne_lfh_s1/=6;
                break;                        
            }
        }else if(semestre.equals("2")){
            switch(matiere){
                case "math":
                    this.math_s2.add(ds1);
                    this.math_s2.add(ds2);
                    this.math_s2.add(ns1);
                    this.math_s2.add(ns2);
                    
                    this.moyenne_math_s2 = (double)this.math_s2.get(0)*2 + (double)this.math_s2.get(1)*2 + (double)this.math_s2.get(2) + (double)this.math_s2.get(3);
                    result = this.moyenne_math_s2/=6;
                break;
                
                case "elec":
                    this.elec_s2.add(ds1);
                    this.elec_s2.add(ds2);
                    this.elec_s2.add(ns1);
                    this.elec_s2.add(ns2);
                    
                    this.moyenne_elec_s2 = (double)this.elec_s2.get(0)*2 + (double)this.elec_s2.get(1)*2 + (double)this.elec_s2.get(2) + (double)this.elec_s2.get(3);
                    result = this.moyenne_elec_s2/=6;
                break;
                
                case "info":
                    this.info_s2.add(ds1);
                    this.info_s2.add(ds2);
                    this.info_s2.add(ns1);
                    this.info_s2.add(ns2);
                    
                    this.moyenne_info_s2 = (double)this.info_s2.get(0)*2 + (double)this.info_s2.get(1)*2 + (double)this.info_s2.get(2) + (double)this.info_s2.get(3);
                    result = this.moyenne_info_s2/=6;
                break;
                
                case "lfh":
                    this.lfh_s2.add(ds1);
                    this.lfh_s2.add(ds2);
                    this.lfh_s2.add(ns1);
                    this.lfh_s2.add(ns2);
                    
                    this.moyenne_lfh_s2 = (double)this.lfh_s2.get(0)*2 + (double)this.lfh_s2.get(1)*2 + (double)this.lfh_s2.get(2) + (double)this.lfh_s2.get(3);
                    result = this.moyenne_lfh_s2/=6;
                break;
            }
        } 
        
        return result;
    }
    
}
