package DesignProject;

public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    //this toString method is used in our menu to see all our employees in our array
    public String toString(){
        return ""+getName();
    }
}