package beans;

/*
 * ShoppingBean.java
 *
 * Created on den 12 december 2002, 09:49
 */

import java.util.*;
/**
 *
 * @author  Fredrik �lund, Olle Eriksson
 */
public class CartBean {
    private ArrayList<Object> cart;
    int index;
    /** Creates a new instance of ShoppingBean */

    public CartBean() {
        cart = new ArrayList();
    }
    
    // add some copies of a book to the shopping cart

    public void addPizza(ArrayList<IngredientBean> pizza) {
        Object newPizzaItem[] = new Object[2];
        newPizzaItem[0] = index;
        index++;
        newPizzaItem[1] = pizza;
        cart.add(newPizzaItem); 
        int i;
    }    

    // remove some copies of a book from the cart

    public void removePizza(int id) {

	// if must not be empty
        if(!cart.isEmpty()){
            
            for (int i=0; i<cart.size(); i++) {
                Object pizza[] = (Object[]) cart.get(i);
                Integer pizzaId = (Integer) pizza[0];
                
                if (pizzaId == id) {
                    cart.remove(i);
                }   
            }
        }
    }     
    
    // clear the cart
    void clear() {
        cart.clear();
    }


    // get the cart
    public ArrayList<Object> getCart(){
        return cart;
    }
    
}
