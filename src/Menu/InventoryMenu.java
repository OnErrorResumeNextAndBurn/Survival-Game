/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Inventory.Inventory;
import ReworkedEntities.Player;
import java.util.Scanner;

/**
 *
 * @author Jura
 */
public class InventoryMenu {

    private Player playerInstance;
    private Inventory playerInventory;
    private Scanner scan;

    public InventoryMenu(Player currentPlayer) {
        playerInstance = currentPlayer;
        playerInventory = playerInstance.getpInventory();
        scan = new Scanner(System.in, "Windows-1250");
    }

    public void chooseInventoryAction() {
        int choice;
        do {
            System.out.println("<1> Prohlédnout si inventář");
            System.out.println("<2> Zahodit položku z inventáře");
            System.out.println("<3> Použít položku z inventáře");
            System.out.println("<4> Konec");
            choice = InputValidator.validate(4);
            switch (choice) {
                case 1:
                    playerInventory.showInv();
                    break;
                case 2:
                    System.out.println("Který předmět chcete smazat?");
                    int toDelete = Integer.parseInt(scan.nextLine());
                    playerInventory.delete(toDelete - 1);
                    if (toDelete > playerInstance.getInvSize()) {
                        System.out.format("Položka %d neexistuje!", toDelete);
                    } else {
                        System.out.format("Předmět byl úspěšně smazán.\n");
                    }
                    break;
                case 3:
                    System.out.println("Který předmět chcete použít?");
                    int toEquip = Integer.parseInt(scan.nextLine()) - 1;
                    if (playerInventory.equipItem(toEquip).equalsIgnoreCase("armor")) {
                        playerInstance.setArmor(playerInventory.getArmor());
                        playerInstance.setCurrentArmor(playerInventory.getCurrentArmor());
                        System.out.format("Brnění %s bylo použito\n", playerInstance.getCurrentArmor());
                        playerInventory.delete(toEquip);
                    } else if (playerInventory.equipItem(toEquip).equalsIgnoreCase("weapon")) {
                        playerInstance.setDAMAGE(playerInventory.getDamage());
                        playerInstance.setCurrentWeapon(playerInventory.getCurrentWeapon());
                        System.out.format("zbraň %s byla použita\n", playerInstance.getCurrentWeapon());
                        playerInventory.delete(toEquip);

                    }
                    break;
            }

        } while (choice != 4);
    }

    public Inventory updatePlayerInventory() {
        return playerInventory;
    }

    public Player updatePlayer() {
        return playerInstance;
    }
}
