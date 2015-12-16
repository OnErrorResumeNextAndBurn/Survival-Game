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
public abstract class Skills implements Entity {
    protected int HP;
    protected int ATK;
    protected int DEF;
    protected int DAMAGE;
    protected int DROP;

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getATK() {
        return ATK;
    }

    @Override
    public int getDEF() {
        return DEF;
    }

    @Override
    public int getDAMAGE() {
        return DAMAGE;
    }

    @Override
    public int getDrop() {
        return DROP;
    }
    
}
