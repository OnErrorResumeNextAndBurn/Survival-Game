/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnemyGenerators;

import java.util.Random;

/**
 *
 * @author Jura
 */
public class Dice {
    public static int rollDice(int a) {
        Random random = new Random();
        return random.nextInt(a) + 1;
    }    
}
