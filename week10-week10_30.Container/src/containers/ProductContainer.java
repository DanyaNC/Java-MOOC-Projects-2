/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Danya
 */
public class ProductContainer extends Container {
    private String productName;
    
    public ProductContainer(String name, double capacity) {
        super(capacity);
        productName = name;
    }
    
    public String getName() {
        return this.productName;
    }
    
    public void setName(String newName) {
        productName = newName;
    }
    
    @Override
    public String toString() {
        return this.productName + ": " + super.toString();
    }
    
}
