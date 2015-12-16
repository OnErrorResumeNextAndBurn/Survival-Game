/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemPrototype;

/**
 *
 * @author Jura
 */
public class FinalItem {

    private String itemType;
    private String item;
    private WeaponDecorator wDecorator;
    private ArmorDecorator aDecorator;

    public FinalItem(WeaponDecorator decoratedWeapon) {
        itemType = "weapon";
        wDecorator = decoratedWeapon;
    }

    public FinalItem(ArmorDecorator decoratedArmor) {
        itemType = "armor";
        aDecorator = decoratedArmor;
    }

    public String getItem() {
        switch (itemType) {
            case "weapon":
                item = "Jméno:" + wDecorator.getWeaponName() + "\n" + "Typ: zbraň\n" + "Poškození: " + String.valueOf(wDecorator.getTotalDamage());
                break;
            case "armor":
                item = "Jméno: " + aDecorator.getArmorName() + "\n" + "Typ: brněnění\n" + "Obrana: " + String.valueOf(aDecorator.getTotalArmor());
                break;
        }
        return item;
    }
}
