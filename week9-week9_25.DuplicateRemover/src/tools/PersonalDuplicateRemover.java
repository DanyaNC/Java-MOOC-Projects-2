/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private List<String> characterStrings;
    private int numberOfDuplicates;
    
    
    public PersonalDuplicateRemover() {
        this.characterStrings = new ArrayList<String>();
        this.numberOfDuplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        if(this.characterStrings.contains(characterString)) {
            numberOfDuplicates++;
            return;
        }
        this.characterStrings.add(characterString);
    }
    
    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniqueStrings = new HashSet<String>();
        if(characterStrings.isEmpty()) {
            return uniqueStrings;
        }
        for(String characterString : characterStrings) {
            uniqueStrings.add(characterString);
        }
        return uniqueStrings;
    }
    
    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.numberOfDuplicates;
    }
    
    @Override
    public void empty() {
        this.characterStrings.clear();
        this.numberOfDuplicates = 0;
    }
    
}
