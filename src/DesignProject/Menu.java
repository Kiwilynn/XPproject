package DesignProject;

import java.util.*;

public class Menu { // This class function as a controller
    Scanner scan = new Scanner(System.in); // this scanner is used in the menu
    Employee em = new Employee("Torben");
    List<Activity> activitylist = new ArrayList<Activity>(); // Activity list
    Employee[] employeeArray = new Employee[5]; //creates an array of employee object, so that we can see all employees


    public void outputlist() {
        for (Object o : activitylist) {
            System.out.println(o);
        }
    }


    //method that adds to the activity list
    public void addToList() {
        activitylist.add(new Activity("Gocart", "24/09-19 - 11:30", "No equipment required", 14, 155));
        activitylist.add(new Activity("Minigolf", "25/09-19 - 12:30", "A good mood!", 70, 000));
        activitylist.add(new Activity("Paintball", "26/09-19 - 13:30", "Walking shoes", 16, 160));
        activitylist.add(new Activity("Sumo wrestling", "27/09-19 - 14:30", "Used clothes", 10, 160));
        activitylist.add(new Activity("Gokart", "29-09-10", "Shoes", 12, 15));
        employeeArray[0] = new Employee("Lene");
        employeeArray[1] = new Employee("Kirsten");
        employeeArray[2] = new Employee("Mikkel");
        employeeArray[3] = new Employee("Jesper");
        employeeArray[4] = new Employee("Hanne");

    }


    //Menu
    public void menu() {
        int answer;

        try {
            while (true) {
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
                        System.out.println("Press 1 for add a booking\nPress 2 for view bookings\nPress 3 for cancel a booking");
                        answer = scan.nextInt();

                        if(answer == 1){bookAktivitet();}
                        else if (answer == 2){outputlist();}
                        else if (answer == 3){cancelBooking();}
                        else {break;}
                        break;
                    } else {
                        menu();
                    }
                }

            }
        } catch (InputMismatchException g) {

            scan.nextLine();
            menu();

        }

    }
    //Adds a new activity, based on following input, to the already existing list of activities
    public void bookAktivitet () {
        System.out.println("Type name of activity");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("When is the booking for?");
        String dateTime = scan.nextLine();
        System.out.println("What equipment is needed to bring?");
        String equipment = scan.nextLine();
        System.out.println("What is the age req?");
        int ageReq = scan.nextInt();
        System.out.println("What is the height req?");
        int heightReq = scan.nextInt();
        System.out.println("How many participants?");
        int participants = scan.nextInt();
        System.out.println("Which instructor will be assigned?");
        for (int i = 0; i < employeeArray.length; i++) {
            System.out.println("[" + i + "] " + employeeArray[i]);
        }
        int input = scan.nextInt();

        activitylist.add(new Activity(name, dateTime, equipment, ageReq, heightReq, participants, employeeArray[input]));

    }
    //Cancels a booking based on index number
    public void cancelBooking() {
        int input;
        for (int i = 0; i <activitylist.size(); i++) {
            System.out.println("[" + i + "] " + activitylist.get(i));
        }
        System.out.println();
        System.out.println("Choose what activity to delete by entering number: ");
        input = scan.nextInt();
        System.out.println("This booking has been cancelled:");
        System.out.println(activitylist.get(input) + "\n");
        activitylist.remove(input);

    }
    public void editActivity() {

        int input;
        for (int i = 0; i < activitylist.size(); i++) {
            System.out.println("[" + i + "]" + activitylist.get(i));
        }
        System.out.println("Choose which activity you want to edit");
        input = scan.nextInt();
        System.out.println("You have chosen to edit : " + activitylist.get(input).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Name : " + activitylist.get(input).getName()
                + "\n" + "[2] Equipment : " + activitylist.get(input).getEquipment()
                + "\n" + "[3] Age : " + activitylist.get(input).getAgeRequirement()
                + "\n" + "[4] Height : " + activitylist.get(input).getHeightRequirement()
                + "\n");

        input = scan.nextInt();

        if (input == 1)
        {
            System.out.println("What do you wish to change the activity name to?");
            scan.nextLine();
            activitylist.get(input).setName(scan.nextLine());
            System.out.println(activitylist.get(input));
        }
        else if (input == 2){
            System.out.println("What do you wish to change the activity equipment requirement to?");
            scan.nextLine();
            activitylist.get(input).setEquipment(scan.nextLine());
            System.out.println(activitylist.get(input));}

        else if (input == 3){
            System.out.println("What do you wish to change the activity age requirement to?");

            activitylist.get(input).setAgeRequirement(scan.nextInt());
            System.out.println(activitylist.get(input));}

        else if (input == 4){
            System.out.println("What do you wish to change the activity height requirement to?");

            activitylist.get(input).setHeightRequirement(scan.nextInt());
            System.out.println(activitylist.get(input));}

    }
    public void editBooking() {

        int input;
        for (int i = 0; i < activitylist.size(); i++) {
            System.out.println("[" + i + "]" + activitylist.get(i));
        }
        System.out.println("Choose which activity you want to edit");
        input = scan.nextInt();
        System.out.println("You have chosen to edit : " + activitylist.get(input).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Name : " + activitylist.get(input).getName()
                + "\n" + "[2] Equipment : " + activitylist.get(input).getEquipment()
                + "\n" + "[3] Age : " + activitylist.get(input).getAgeRequirement()
                + "\n" + "[4] Height : " + activitylist.get(input).getHeightRequirement()
                + "\n");

        input = scan.nextInt();

        if (input == 1)
        {
            System.out.println("What do you wish to change the activity name to?");
            scan.nextLine();
            activitylist.get(input).setName(scan.nextLine());
            System.out.println(activitylist.get(input));
        }
        else if (input == 2){
            System.out.println("What do you wish to change the activity equipment requirement to?");
            scan.nextLine();
            activitylist.get(input).setEquipment(scan.nextLine());
            System.out.println(activitylist.get(input));}

        else if (input == 3){
            System.out.println("What do you wish to change the activity age requirement to?");

            activitylist.get(input).setAgeRequirement(scan.nextInt());
            System.out.println(activitylist.get(input));}

        else if (input == 4){
            System.out.println("What do you wish to change the activity height requirement to?");

            activitylist.get(input).setHeightRequirement(scan.nextInt());
            System.out.println(activitylist.get(input));}

    }
}
