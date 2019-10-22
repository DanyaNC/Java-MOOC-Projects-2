/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if(this.owners.get(plate)==null) {
            this.owners.put(plate, owner);
            return true;
        }
        return false;
    }
    
    public String get(RegistrationPlate plate) {
        return this.owners.get(plate);
    }
    
    public boolean delete(RegistrationPlate plate) {
        if(this.owners.get(plate)==null) {
            return false;
        }
        this.owners.remove(plate);
        return true;
    }
    
    public void printRegistrationPlates() {
        for(RegistrationPlate plate : this.owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> uniqueOwners = new ArrayList<String>();
        
        for(RegistrationPlate plate: this.owners.keySet()) {
            if(!uniqueOwners.contains(this.owners.get(plate))) {
                uniqueOwners.add(this.owners.get(plate));
            }
        }
        for(String owner : uniqueOwners) {
            System.out.println(owner);
        }
    }
    
}
