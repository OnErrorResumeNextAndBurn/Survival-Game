/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Inventory.Inventory;
import ReworkedEntities.Player;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Jura
 */
public class ShopMenu {

    private Player playerInstance;
    private Inventory playerInventory;
    Scanner scan = new Scanner(System.in);

    public ShopMenu(Player currentPlayer) {
        playerInstance = currentPlayer;
        playerInventory = currentPlayer.getpInventory();
    }

    public void sellAll() {
        double value = 0;
        String itemToSell;
       

            for (int i = 0; i < playerInstance.getInvSize(); i++) {
                if (playerInventory.search(i) == null) {
                    break;
                }

                itemToSell = playerInventory.search(i);

                String[] itemElements;
                if (itemToSell.contains("Obrana")) {
                    Pattern pattern = Pattern.compile(":|\\n");
                    itemElements = pattern.split(itemToSell);
                    itemElements[5] = itemElements[5].trim();
                    value += Double.parseDouble(itemElements[5]) * 0.65;

                } else {
                    Pattern pattern = Pattern.compile(":|\\n");
                    itemElements = pattern.split(itemToSell);
                    itemElements[5] = itemElements[5].trim();
                    value += Double.parseDouble(itemElements[5]) * 0.47;

                }

            }
         

        System.out.format("Všechny předměty je možné prodat za %d zlatých. Prodat? ANO/NE\n", (int) value);
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("ano")) {
            playerInstance.setGOLD(playerInstance.getGOLD() + (int) value);
            for (int i = 0; i < playerInstance.getInvSize(); i++) {
                playerInventory.delete(i);
            }
            System.out.println("Všechny předměty byly prodány!");

        } else {
            System.out.println("Předměty nebyly prodány");
        }

    }

    public void sellItem() {
        String continueSelling;
        do {
            if (playerInventory.search(0) == null) {
                System.out.println("Všechny předměty byly prodány!");
                break;
            }
            System.out.println("Který přemět chcete prodat?");
            int index = Integer.parseInt(scan.nextLine()) - 1;
            String itemToSell = playerInventory.search(index);
            double value;
            String[] itemElements;
            if (itemToSell.contains("Obrana")) {
                Pattern pattern = Pattern.compile(":|\\n");
                itemElements = pattern.split(itemToSell);
                itemElements[5] = itemElements[5].trim();
                value = Double.parseDouble(itemElements[5]) * 0.4;

                System.out.format("Předmět %s má hodnotu %d zlatých. Prodat? ANO/NE\n", itemElements[1].trim(), (int) value);
            } else {
                Pattern pattern = Pattern.compile(":|\\n");
                itemElements = pattern.split(itemToSell);
                itemElements[5] = itemElements[5].trim();
                value = Double.parseDouble(itemElements[5]) * 0.29;

                System.out.format("Předmět %s má hodnotu %d zlatých. Prodat? ANO/NE\n", itemElements[1].trim(), (int) value);
            }
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("ano")) {
                playerInstance.setGOLD(playerInstance.getGOLD() + (int) value);
                System.out.format("Předmět %s byl prodán za %d zlatých, máš %d zlata\n", itemElements[1], (int) value, playerInstance.getGOLD());
                playerInventory.delete(index);

            } else {
                System.out.println("Předmět nebyl prodán.");

            }

            System.out.println("Prodat další předmět? ANO/NE");
            continueSelling = scan.nextLine();
        } while (!continueSelling.equalsIgnoreCase("ne"));
    }

    public Player updatePlayer() {
        return playerInstance;
    }

    public Inventory updateInventory() {
        return playerInventory;
    }
}
