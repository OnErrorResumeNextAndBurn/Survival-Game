/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReworkedMaps;

import EnemyGenerators.BeastGenerator;
import Entities.Enemy;

/**
 *
 * @author Jura
 */
public class TilePopulator {
public static Enemy generateEnemy(String difficulty){
return BeastGenerator.generateBeast(difficulty);
} 
}
