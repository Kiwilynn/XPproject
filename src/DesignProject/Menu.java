package DesignProject;

import java.util.ArrayList;
import java.util.List;

public class Menu { // This class function as a controller
    Employee em = new Employee("Torben");
    List <Activity> activitylist = new ArrayList<Activity>();



    public void addToList(){
        activitylist.add(new Activity("Gokart","29-09-10","sko",12,150,1,em));
    }





}
