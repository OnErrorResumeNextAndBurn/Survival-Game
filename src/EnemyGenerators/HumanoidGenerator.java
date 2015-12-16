/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnemyGenerators;

import Entities.Beast;
import Entities.Enemy;
import Entities.Humanoid;

/**
 *
 * @author Jura
 */
public class HumanoidGenerator {

    public static Enemy generateHumanoid(String difficulty) {
        return new Humanoid().obr();
    }
}
