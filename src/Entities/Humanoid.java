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
public class Humanoid extends Enemy {
    boolean useThrowBoulder = false;
  public Humanoid obr() {
        name = "Obr";
        HP = 330;
        ATK = 25;
        DEF = 15;
        DAMAGE = setDAMAGE();
        DROPCHANCE = 90;
        CRITCHANCE = 70;
        rarityGrade = 2;
        SCORE = rand.nextInt(300) + 200;
        GOLD = rand.nextInt(70) + 15;
        useThrowBoulder = true;
        return this;
    }
    
    
    @Override
    public boolean canUseTypeSpecial() {
    return useThrowBoulder;
    }
    
}
