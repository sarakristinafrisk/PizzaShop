/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author emmarangert
 */
public class IngredientBean {
    
    private int stock;
    private String name;
    private double price;
    
    /** Creates a new instance of BookBean */
    public IngredientBean() {
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(int _price) {
        price = _price;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name=_name;
    }
    
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int _stock) {
        stock=_stock;
    }
}
