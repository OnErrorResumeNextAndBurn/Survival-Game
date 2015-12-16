/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Jura
 */
public class BeastSkills {
    public int bite(int atk){
        double biteDMG = atk *3.25;
    return (int) biteDMG;
    }
    
    public int harden (int def){
        System.out.println("Nepřítel používá ztvrdnutí kůže! Dostává bonus k obraně!");
        double tempDEF = ((double)def * 1.7785);  
        return (int)tempDEF;
    }
    public int howl(int damage){
        System.out.println("Nepřítel používá zavití! Dostává dvojnásobné poškození!");
        double tempDMG =  ((double)damage * 1.29);
        
        return (int)tempDMG;
    }
    
}
