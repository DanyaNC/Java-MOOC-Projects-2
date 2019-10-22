package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length()>40) {
            throw new IllegalArgumentException("The name has to be a string"
                    + " and no longer than 40 characters.");
        }
        this.name = name;
        if(age < 0 || age > 120) {
            throw new IllegalArgumentException("The age has to be between"
                    + " 0 and 120.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
