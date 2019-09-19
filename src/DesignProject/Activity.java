package DesignProject;

public class Activity {
    private String name;
    private Object Employee; //the  Employee object is used variable so its usable in constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getEmployee() {
        return Employee;
    }

    public void setEmployee(Object employee) {
        Employee = employee;
    }

    public Activity(String name, Object employee) {
        this.name = name;
        Employee = employee;
    }

    public Activity(String name) {
        this.name = name;
    }

    public Activity() {
    }
}
