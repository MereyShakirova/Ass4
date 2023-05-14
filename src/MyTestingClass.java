class MyTestingClass {
    private int id;
    private String name;
    // constructor, getters, setters
    public MyTestingClass() {
        //generates a random id and assigns it to the id field
        this.id = (int)(Math.random()*10000);
        this.name = "Test-" + id;//creates a name string by concatenating the id with the string "Test-"
    }
    // custom hashCode method
    @Override
    public int hashCode() {
        //returns the remainder of the id field divided by 11
        return id % 11;
    }
}

class Student {
    private String name;//field
    private int age;//field
    // constructor, getters, setters
    public Student() {
        //assigns a random age between 10 and 30 to the age field and a default name "Dimash Kudaibergen" to the name field
        this.name = "Dimash Kudaibergen";
        this.age = (int)(Math.random()*20 + 10);
    }
}


