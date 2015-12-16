/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survivalgame;

import ReworkedEntities.Player;
import Entities.Enemy;
import BattleEngine.Battle;
import BattleEngine.BattleArena;
import Entities.Beast;
import Inventory.Inventory;

import Menu.*;
import ReworkedEntities.PlayerInfo;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class SurvivalGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player;
        int goldToHeal = 100;
        Scanner scan = new Scanner(System.in, "Windows-1250");
        NewGame start = new NewGame();
        start.newGame();
        int menu;
        player = new Player();
        player.Player();
        Enemy enemy = new Beast();
        int maxHP = player.getHP();
        do {
            PlayerInfo playerInfo = new PlayerInfo(player);
            System.out.println("Menu");
            System.out.println("---------");
            System.out.println("<1> Jit bojovat");
            System.out.println("<2> Doplnit zivoty");
            System.out.println("<3> Inventář");
            System.out.println("<4> Zobrazit skóre");
            System.out.println("<5> Prodat předměty");
            System.out.println("<6> Mapy");
            menu = InputValidator.validate(6);
            switch (menu) {
                case 1:
                    player = BattleMenu.BattleMenu(enemy, player);
                    break;
                case 2:
                    System.out.format("Doplnit životy na maximum za %d zlatých? ANO/NE\n", goldToHeal);
                    String choice = scan.nextLine();
                    if (choice.equalsIgnoreCase("ano") && player.getGOLD() >= goldToHeal) {
                        player.setPostHP(maxHP);
                        System.out.println("Zdraví bylo doplněno!");
                        player.setGOLD((player.getGOLD() - goldToHeal));
                        goldToHeal = goldToHeal * 3;

                    } else if (!choice.equalsIgnoreCase("ano")) {
                        System.out.println("Neplatná volba!");
                        break;
                    } else {
                        System.out.println("Nemáš dostatek zlata!");
                    }
                    break;
                case 3:
                    InventoryMenu inventoryMenu = new InventoryMenu(player);
                    inventoryMenu.chooseInventoryAction();
                    //player.setpInventory(inventoryMenu.updatePlayerInventory());
                    //player = inventoryMenu.updatePlayer();
                    break;
                case 4:
                    System.out.format("Tvé současné skóre je %d bodů\n", player.getSCORE());
                    break;
                case 5:
                    ShopMenu shopMenu = new ShopMenu(player);
                    shopMenu.sellAll();
                    player = shopMenu.updatePlayer();
                    break;
                case 6:
                    MapMenu mapMenu = new MapMenu(player);
                    mapMenu.goToTile();
                   
                    break;
            }

        } while (menu != 7);
        System.out.println("Konec" + player.getCurrentWeapon());
        System.out.println(player.getCurrentArmor());
        scan.nextLine();

    }

}
