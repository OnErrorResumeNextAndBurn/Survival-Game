/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Random;
import Entities.Beast;

/**
 *
 * @author Jura
 */
public class EnemyAI {

    private Enemy enemyInstance;
    private int diceRoll;
    private boolean usedSpecial = false;
    private boolean firstTurn = true;
    private boolean usedOneTurnAtkSkill = false;
    private boolean usedHPSkill = false;
    private int startingHP, startingDMG, startingDEF;
    private String currentBuff;
    private int currentTurn, specialUsedOnTurn;
    private BeastSkills eSkills = new BeastSkills();
    private HumanoidSkills hSkills = new HumanoidSkills();

    public EnemyAI(Enemy enemy) {
        enemyInstance = enemy;
        startingHP = enemy.getHP();
        startingDMG = enemy.getDAMAGE();
        startingDEF = enemy.getDEF();

    }

    public void getTurn(int turn) {
        currentTurn = turn;
    }

    public void resolveAI() {
        if (usedOneTurnAtkSkill) {
            enemyInstance.setDAMAGE(startingDMG);
            usedOneTurnAtkSkill = false;
        }
        if (enemyInstance instanceof Beast) {
            beastTurnLogic();

        } else if (enemyInstance instanceof Humanoid) {
            humanoidTurnLogic();
        }
        checkDebuff();
    }

    private int rollDice(int a) {
        Random random = new Random();
        return random.nextInt(a) + 1;
    }

    void beastTurnLogic() {
        diceRoll = rollDice(100);
        BeastSkillEval(diceRoll);

    }

    void humanoidTurnLogic() {
        diceRoll = rollDice(100);
        humanoidSkillEval(diceRoll);

    }

    private void BeastSkillEval(int diceRoll) {
        this.diceRoll = diceRoll;
        int chance = rollDice(2);
        switch (chance) {
            case 1:
                if (diceRoll < 40 && usedSpecial == false && currentTurn > 1) {
                    enemyInstance.setDAMAGE(eSkills.howl(enemyInstance.getDAMAGE()));
                    specialUsedOnTurn = currentTurn;
                    currentBuff = "zavití";
                    usedSpecial = true;
                } else if (enemyInstance.getHP() < (startingHP / 2) && usedSpecial == false && diceRoll < 60 && currentTurn > 1) {
                    enemyInstance.setDAMAGE(eSkills.howl(enemyInstance.getDAMAGE()));
                    specialUsedOnTurn = currentTurn;
                    currentBuff = "zavití";
                    usedSpecial = true;
                } else if (diceRoll < 65) {
                    enemyInstance.setDAMAGE(eSkills.bite(enemyInstance.getATK()));
                    System.out.println("Nepřítel používá kousnutí!");
                    usedOneTurnAtkSkill = true;
                }
                break;

            case 2:
                if (enemyInstance.canUseTypeSpecial() && usedSpecial == false && diceRoll < 99 && currentTurn > 1) {
                    enemyInstance.setDEF(eSkills.harden(enemyInstance.getDEF()));
                    specialUsedOnTurn = currentTurn;
                    currentBuff = "ztvrdnutí kůže";
                    usedSpecial = true;
                } else if (enemyInstance.canUseTypeSpecial() && diceRoll < 40 && usedSpecial == false) {
                    currentBuff = "ztvrdnutí kůže";
                    enemyInstance.setDEF(eSkills.harden(enemyInstance.getDEF()));
                    usedSpecial = true;
                    specialUsedOnTurn = currentTurn;
                } else if (diceRoll < 40 && usedSpecial == false) {
                    enemyInstance.setDAMAGE(eSkills.howl(enemyInstance.getDAMAGE()));
                    currentBuff = "zavití";
                    specialUsedOnTurn = currentTurn;
                    usedSpecial = true;
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    private void humanoidSkillEval(int diceRoll) {
        this.diceRoll = diceRoll;
        int chance = 1;
        switch (chance) {
            case 1:
                if (diceRoll < 35 && enemyInstance.canUseTypeSpecial() && usedSpecial == false && currentTurn > 1) {
                    enemyInstance.setDAMAGE(hSkills.throwBoulder(enemyInstance.getATK()));
                    usedOneTurnAtkSkill = true;
                } else if (diceRoll < 60 && enemyInstance.getHP() < startingHP / 3 && usedHPSkill == false && currentTurn > 1) {
                    enemyInstance.setHP(hSkills.endure(startingHP));
                    usedHPSkill = true;
                } else if (enemyInstance.getHP() < (startingHP / 2) && usedHPSkill == false && diceRoll < 35 && currentTurn > 1) {
                    enemyInstance.setHP(hSkills.endure(startingHP));
                    usedHPSkill = true;
                } else if (diceRoll < 65 && usedSpecial == false && currentTurn > 1) {
                    enemyInstance.setDAMAGE(hSkills.rage(enemyInstance.getDAMAGE()));
                    usedSpecial = true;
                    specialUsedOnTurn = currentTurn;
                }
                break;

            default:
                throw new AssertionError();
        }
    }

    private void checkDebuff() {
        if (currentTurn - 2 > specialUsedOnTurn && usedSpecial) {
            System.out.format("Účinky nepřítelova %s skončily!", currentBuff);
            enemyInstance.setDAMAGE(startingDMG);
            enemyInstance.setDEF(startingDEF);
            usedSpecial = false;
        }
    }

    public Enemy turnResult() {
        return enemyInstance;
    }
}
