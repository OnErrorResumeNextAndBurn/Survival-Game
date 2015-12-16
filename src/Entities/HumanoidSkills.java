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
public class HumanoidSkills {

    public int rage(int damage) {
        double tempDamage = (double) damage * 1.4854;
        System.out.println("Nepřítel dostává vztek! Dostává bonus k poškození!");
        return (int) tempDamage;
    }

    public int endure(int hp) {
        double tempHP = (double) hp * 0.455;
        tempHP = Math.floor(tempHP);
        System.out.println("Nepřítel používá Endure! Dostava část svých životů zpět!");
        return (int) tempHP;
    }

    public int throwBoulder(int atk) {
       double tempDMG = atk * 3.757;
        System.out.println("Nepřítel po tobě hodil balvan!");
        return (int)tempDMG;
    }
}
