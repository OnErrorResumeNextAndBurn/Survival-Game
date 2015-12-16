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

abstract class Item{
abstract void setName(String s);
abstract void setType(String s);
abstract void setRarity(String s);
abstract String getName();
abstract String getType();
abstract String getRarity();
}
