/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnemyGenerators;

import Entities.Beast;
import Entities.Enemy;

/**
 *
 * @author Jura
 */
public class BeastGenerator {

    public static Enemy generateBeast(String difficulty) {
        final int a;
        if (difficulty.equalsIgnoreCase("easy")) {
            a = Dice.rollDice(49);
        } else if (difficulty.equalsIgnoreCase("medium")) {
            a = Dice.rollDice(84);
        } else {
            a = Dice.rollDice(100);
        }

        Enemy enemy;
        if (a > 85) {
            enemy = new Beast().drak();
        } else if (a > 50) {
            enemy = new Beast().medved();

        } else {
            enemy = new Beast().divokyVlk();
        }
        return enemy;
    }
}
