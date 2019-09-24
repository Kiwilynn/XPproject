package DesignProject;

public class Activity {
    private String name;
    private String dateTime;
    private String equipment;
    private int ageRequirement;
    private int heightRequirement;
    private Object Employee; //the  Employee object is used variable so its usable in constructor

    public String getName() {
        return name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    public int getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public int getHeightRequirement() {
        return heightRequirement;
    }

    public void setHeightRequirement(int heightRequirement) {
        this.heightRequirement = heightRequirement;
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
