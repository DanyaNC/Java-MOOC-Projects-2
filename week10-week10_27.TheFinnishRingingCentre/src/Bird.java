
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }
    
    @Override
    public boolean equals(Object comparedBird) {
        if(comparedBird == null) {
            return false;
        }
        
        if(getClass() != comparedBird.getClass()) {
            return false;
        }
        
        Bird compBird = (Bird) comparedBird;
        return this.latinName.equals(compBird.latinName) 
                && this.ringingYear == compBird.ringingYear;
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public int getYear() {
        return this.ringingYear;
    }
    
    @Override
    public int hashCode() {
        return this.latinName.hashCode() + this.ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


