/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class PhoneSystem {

    private Map<String, List<String>> personToNumbers;
    private Map<String, List<String>> personToAddress;

    public PhoneSystem() {
        this.personToNumbers = new HashMap<String, List<String>>();
        this.personToAddress = new HashMap<String, List<String>>();
    }

    public void addNumber(String person, String number) {
        //If our map doesn't contain the person, create a 
        // new list for the 'value'
        if (!this.personToNumbers.containsKey(person)) {
            this.personToNumbers.put(person, new ArrayList<String>());
        }
        //Retrieve ArrayList at the specified person, then add number to list
        //Remember to call the get method to receive the reference first
        this.personToNumbers.get(person).add(number);
    }

    public void addAddress(String person, String address) {
        //If our map doesn't contain the person, create a
        //new list for the 'value'
        if (!this.personToAddress.containsKey(person)) {
            this.personToAddress.put(person, new ArrayList<String>());
        }

        this.personToAddress.get(person).add(address);
    }

    public void searchByPerson(String person) {
        if (!this.personToNumbers.containsKey(person)) {
            System.out.println(" not found");
            return;
        }
        if(this.personToNumbers.get(person).isEmpty()) {
            System.out.println(" not found");
            return;
        }

        for (String key : this.personToNumbers.keySet()) {
            if (person.equals(key)) {
                for (String number : this.personToNumbers.get(key)) {
                    System.out.println(" " + number);
                }
            }
        }
    }

    public void searchByNumber(String number) {
        for (String key : this.personToNumbers.keySet()) {
            for (String phoneNumber : this.personToNumbers.get(key)) {
                if (phoneNumber.equals(number)) {
                    System.out.println(" " + key);
                    return;
                }
            }
        }
        System.out.println(" not found");
    }

    public void searchForPersonalInfo(String name) {
        if(!personToAddress.containsKey(name) && !personToNumbers.containsKey(name)) {
            System.out.println(" not found");
            return;
        }
        searchAddress(name);
        searchNumber(name);
    }

    private void searchAddress(String name) {
        if (!this.personToAddress.containsKey(name)) {
            System.out.println("  address unknown");
            return;
        }
        if (this.personToAddress.get(name).isEmpty()) {
            System.out.println("  address unknown");
        } else {
            System.out.print("  address: ");
            //Retreive Address(es) of individual
            for (String address : this.personToAddress.get(name)) {
                System.out.println(address);
            }
        }
    }

    private void searchNumber(String name) {
        if (!this.personToNumbers.containsKey(name)) {
            System.out.println("  phone number not found");
            return;
        }
        if (this.personToNumbers.get(name).isEmpty()) {
            System.out.println("  phone number not found");
            return;
        }
        System.out.println("  phone numbers:");
        //If individual has phone numbers, print each one
        for (String number : personToNumbers.get(name)) {
            System.out.println("  " + number);
        }
    }

    private List<String> createFilteredSetOfNames() {
        Set<String> alphabeticalNameSetl = new HashSet<String>();
        List<String> alphabeticalList = new ArrayList<String>();
        for(String name : this.personToAddress.keySet()) {
            alphabeticalNameSetl.add(name);
        }
        for(String name : this.personToNumbers.keySet()) {
            alphabeticalNameSetl.add(name);
        }
        for(String name : alphabeticalNameSetl) {
            alphabeticalList.add(name);
        }
        Collections.sort(alphabeticalList);
        return alphabeticalList;
    }

    public void filteredListInfo(String keyword) {
        List <String> alphabeticalList = createFilteredSetOfNames();
        if (keyword.isEmpty()) {
            for (String name : alphabeticalList) {
                System.out.println(" " + name);
                searchAddress(name);
                searchNumber(name);
                System.out.println();
            }
            return;
        }
        if (!checkNamesForKeyWord(keyword, alphabeticalList)) {
            if (!checkAddressesForKeyWord(keyword, alphabeticalList)) {
                System.out.println(" keyword not found");
            }
        }
    }

    private boolean checkNamesForKeyWord(String keyword, List<String> alphabeticalNameSet) {
        int flag = 0;
        for (String abcName : alphabeticalNameSet) {
            if (abcName.contains(keyword)) {
                System.out.println(" " + abcName);
                searchForPersonalInfo(abcName);
                System.out.println();
                flag = 1;
            }
        }
        return flag == 1;
    }

    private boolean checkAddressesForKeyWord(String keyword, List<String> alphabeticalNameSet) {
        int flag = 0;
        for (String key : this.personToAddress.keySet()) {
            for (String address : this.personToAddress.get(key)) {
                if (address.contains(keyword)) {
                    System.out.println(" " + key);
                    searchForPersonalInfo(key);
                    System.out.println();
                    flag = 1;
                }
            }
        }
        return flag == 1;
    }

    public void removeInfo(String name) {
        this.personToNumbers.put(name, new ArrayList<String>());
        this.personToAddress.put(name, new ArrayList<String>());
    }

}
