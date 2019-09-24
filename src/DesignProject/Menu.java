package DesignProject;

import java.util.ArrayList;
import java.util.*;

public class Menu { // This class function as a controller
    Scanner scan = new Scanner(System.in); // this scanner is used in the menu
    Employee em = new Employee("Torben");
    List <Activity> activitylist = new ArrayList<Activity>(); // Activity list
    Employee[] employeeArray = new Employee[5]; //creates an array of employee object, so that we can see all employees




    //method that adds to the activity list
    public void addToList(){
        activitylist.add(new Activity("Gokart","29-09-10","sko",12,150,1,em));
        employeeArray[0] = new Employee("Lene");
        employeeArray[1] = new Employee("Kirsten");
        employeeArray[2] = new Employee("Mikkel");
        employeeArray[3] = new Employee("Jesper");
        employeeArray[4] = new Employee("Hanne");

    }


    //Menu
    public void menu(){
        int answer;

        try {
        while(true) {
            System.out.println("Press 1 for Activities\nPress 2 for Employees\nPress 3 for Bookings \n");
            answer = scan.nextInt();
            while (true) {
                if (answer == 1) {
                    System.out.printf("\t  %-25s %-25s %-25s %-25s %-25s", "Name", "Date", "Equipment", "Age requirement", "Height requirement\n");
                    System.out.println(activitylist.get(0));
                    break;
                }
                if (answer == 2) {
                    System.out.println("List of Employees");
                    for (int e = 0; e <= employeeArray.length - 1; e++) {
                        System.out.println(employeeArray[e]);

                    }
                    break;

                }
                if (answer == 3) {
                    System.out.println("List of Bookings");
                    break;
                } else {
                    menu();
                }
            }

            }
        } catch (InputMismatchException g){

            scan.nextLine();
            menu();

        }
    }





}
