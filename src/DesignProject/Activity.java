package DesignProject;

public class Activity {
    private String name;
    private String dateTime;
    private String equipment;
    private int ageRequirement;
    private int heightRequirement;
    private int participants;
    private Object Employee; //the  Employee object is used variable so its usable in constructor

    public Activity() {
    }

    public Activity(String name) {
        this.name = name;
    }

    public Activity(String name, String dateTime, String equipment, int ageRequirement, int heightRequirement) {
        this.name = name;
        this.dateTime = dateTime;
        this.equipment = equipment;
        this.ageRequirement = ageRequirement;
        this.heightRequirement = heightRequirement;
    }

    public Activity(String name, String dateTime, String equipment, int ageRequirement, int heightRequirement, int participants, Object employee){
        this.name = name;
        this.dateTime = dateTime;
        this.equipment = equipment;
        this.ageRequirement = ageRequirement;
        this.heightRequirement = heightRequirement;
        this.participants = participants;
        Employee = employee;
    }

    public Activity(String name, Object employee) {
        this.name = name;
        Employee = employee;
    }

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

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String toString() {
        return name + dateTime + equipment + ageRequirement + heightRequirement + participants + Employee;
    }

    //this to string method is used to see activities in our arrayList
    public String toString() {

        System.out.printf("%-25s %-25s %-25s %-25d %-25d\n",name,dateTime, equipment, ageRequirement, heightRequirement);
        return "";  }
}
