/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author Danya
 */
import java.util.Map;
import java.util.HashMap;

public class Person {
    private Map<String, String> personToAddress;
    private String name;
    
    public Person(String name, String address) {
        personToAddress = new HashMap<String, String>();
        personToAddress.put(name, address);
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name + "\n  " + personToAddress.get(name);
    }
    
}
