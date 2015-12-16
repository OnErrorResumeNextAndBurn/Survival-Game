/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import BattleEngine.Battle;
import Entities.Enemy;
import ReworkedEntities.Player;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class BattleMenu {
    public static Player BattleMenu(Enemy enemy, Player player) {
       String i = "ano";
        Scanner scan = new Scanner(System.in);
        do {
        enemy = enemy.choose();
        Battle battle = new Battle(player, enemy);
        battle.result(battle.BattleEngine());
        battle.GiveDrop();
        player.setPostHP(battle.returnHP());
        player.setSCORE(battle.giveScore());
        player.setGOLD(battle.giveGold());
        System.out.println();
            System.out.println("Pokračovat? ANO/NE");
            i = scan.nextLine();
        } while (!i.equalsIgnoreCase("ne"));
        return player;
    }    
}
