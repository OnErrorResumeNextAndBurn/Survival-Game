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
public class Armor extends Item {

    private String name;
    private String type;
    private String rarity;

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the rarity
     */
    @Override
    public String getRarity() {
        return rarity;
    }

    /**
     * @param rarity the rarity to set
     */
    @Override
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

}
