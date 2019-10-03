package DesignProject;

import java.util.*;

public class Menu { // This class function as a controller
    Scanner scan = new Scanner(System.in); // this scanner is used in the menu
    Employee em = new Employee("Torben");
    List<Activity> activitylist = new ArrayList<Activity>(); // Activity list
    List<Activity> bookingList = new ArrayList<Activity>(); // Activity list
    Employee[] employeeArray = new Employee[5]; //creates an array of employee object, so that we can see all employees


    public void outputActivity() {
        for (Object o : activitylist) {
            System.out.println(o);
        }
    }

    public void outputBooking() {
        for (Object o : bookingList) {
            System.out.println(o);
        }
    }

    //method that adds employees, aswell as dummy activities and bookings.
    public void addToList() {

        employeeArray[0] = new Employee("Lene");
        employeeArray[1] = new Employee("Kirsten");
        employeeArray[2] = new Employee("Mikkel");
        employeeArray[3] = new Employee("Jesper");
        employeeArray[4] = new Employee("Hanne");
        activitylist.add(new Activity("Gocart", "24/09-19 - 11:30", "No equipment required", 14, 155));
        activitylist.add(new Activity("Minigolf", "25/09-19 - 12:30", "A good mood!", 70, 000));
        activitylist.add(new Activity("Paintball", "26/09-19 - 13:30", "Walking shoes", 16, 160));
        activitylist.add(new Activity("Sumo wrestling", "27/09-19 - 14:30", "Used clothes", 10, 160));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 5, employeeArray[0]));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 2, employeeArray[1]));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 1500, employeeArray[2]));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 1500, employeeArray[2]));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 1500, employeeArray[2]));
        bookingList.add(new Activity("Sumo wrestling", "27/09-1999 - 14:30", "Used clothes", 10, 160, 1500, employeeArray[2]));

    }

    //Menu
    public void menu() {
        int answer;

        try {
            while (true) {
                System.out.println("Press 1 for Activities\nPress 2 for Employees\nPress 3 for Bookings \nPress 4 for calendar\n\nPRESS 9 TO EXIT PROGRAM\n");
                answer = scan.nextInt();
                while (true) {
                    if (answer == 1) {
                        System.out.printf("%-25s %-25s %-25s %-25s %-25s", "Name", "Date", "Equipment", "Age requirement", "Height requirement\n");
                        outputActivity();
                        break;
                    }
                    else if (answer == 2) {
                        System.out.println("List of Employees");
                        for (int e = 0; e <= employeeArray.length - 1; e++) {
                            System.out.println(employeeArray[e]);

                        }
                        break;

                    }
                    else if (answer == 3) {

                        System.out.println("Press 1 for add a booking\nPress 2 for view bookings\nPress 3 to search by instructor\nPress 4 for cancel a booking\nPress 5 for edit a booking\n\nPRESS 9 TO EXIT PROGRAM\n");
                        answer = scan.nextInt();

                        if(answer == 1){bookActivity();}
                        else if (answer == 2){
                            System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-10s", "Name", "Date", "Equipment", "Age requirement", "Height requirement", "Participants", "Instructor\n");
                            outputBooking();
                        }
                        else if (answer == 3){
                            scan.nextLine();
                            searchByInstructor();}
                        else if (answer == 4) {cancelBooking();}
                        else if (answer == 5) {editBooking();}
                        else if (answer == 9) {
                            System.exit(1);
                        }
                        else {break;}
                        break;
                    }
                    else if (answer == 4){
                        answer = 0;
                        searchByDate();
                    }

                    else if (answer == 9) {
                        System.exit(1);
                    } else {
                        break; }


                }

            }
        } catch (InputMismatchException g) {

            scan.nextLine();
            menu();

        }

    }
    //Adds a new activity, based on following input, to the already existing list of activities
    public void bookActivity () {
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
       for (int i = 0; i < employeeArray.length; i++){
           System.out.println("[" + i + "] " + employeeArray[i]);
       }
        int input = scan.nextInt();

        bookingList.add(new Activity(name, dateTime, equipment, ageReq, heightReq, participants, employeeArray[input]));

    }

    //Cancels a booking based on index number
    public void cancelBooking() {
        int input;
        for (int i = 0; i <bookingList.size(); i++) {
            System.out.println("[" + i + "] " + bookingList.get(i));
        }
        System.out.println();
        System.out.println("Choose what activity to delete by entering number: ");
        input = scan.nextInt();
        System.out.println("This booking has been cancelled:");
        System.out.println(bookingList.get(input) + "\n");
        bookingList.remove(input);

    }
    //Edits an existing activity
    public void editActivity() {

        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-10s", "Name of activity", "Date", "Equipment", "Age requirement", "Height requirement", "Participants", "Instructor\n");

        int input;
        for (int i = 0; i < activitylist.size(); i++) {
            System.out.println("[" + i + "]" + activitylist.get(i));
        }

        System.out.println("Choose which activity you want to edit");
        input = scan.nextInt();

        //Shows menu for edit options
        System.out.println("You have chosen to edit : " + activitylist.get(input).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Name : " + activitylist.get(input).getName()
                + "\n" + "[2] Equipment : " + activitylist.get(input).getEquipment()
                + "\n" + "[3] Age : " + activitylist.get(input).getAgeRequirement()
                + "\n" + "[4] Height : " + activitylist.get(input).getHeightRequirement()
                + "\n");

        int input2= 0;
        input2 = scan.nextInt();

        if (input2 == 1)
        {
            System.out.println("What do you wish to change the activity name to?");
            scan.nextLine();
            activitylist.get(input).setName(scan.nextLine());
            System.out.println(activitylist.get(input));
        }
        else if (input2 == 2){
            System.out.println("What do you wish to change the activity equipment requirement to?");
            scan.nextLine();
            activitylist.get(input).setEquipment(scan.nextLine());
            System.out.println(activitylist.get(input));}

        else if (input2 == 3){
            System.out.println("What do you wish to change the activity age requirement to?");

            activitylist.get(input).setAgeRequirement(scan.nextInt());
            scan.nextLine();
            System.out.println(activitylist.get(input));}

        else if (input2 == 4){
            System.out.println("What do you wish to change the activity height requirement to?");

            activitylist.get(input).setHeightRequirement(scan.nextInt());
            scan.nextLine();
            System.out.println(activitylist.get(input));}

    }
    //Edits an existing booking
    public void editBooking() {



        int input;
        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-10s", "Name of activity", "Date", "Equipment", "Age requirement", "Height requirement", "Participants", "Instructor\n");

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }

        System.out.println("Choose which booking you want to edit");
        input = scan.nextInt();

        //Shows menu for edit options
        System.out.println("You have chosen to edit : " + bookingList.get(input).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Instructor : " + bookingList.get(input).getEmployee()
                + "\n" + "[2] Participants : " + bookingList.get(input).getParticipants()
                + "\n" + "[3] Date & time : " + bookingList.get(input).getDateTime()
                + "\n");

        int input2 = 0;
        input2 = scan.nextInt();

        if (input2 == 1) {

            int input3 = 0;

            System.out.println("Which instructor do you wish to assign this booking?");

            for(int i = 0; i < employeeArray.length; i++){
                System.out.println("[" + i + "]" + employeeArray[i]);
            }

            input3 = scan.nextInt();

            bookingList.get(input).setEmployee(employeeArray[input3]);
            System.out.println();
            scan.nextLine();

        }

        else if (input2 == 2){
            System.out.println("How many participants do you wish to change to?");
            scan.nextLine();
            bookingList.get(input).setParticipants(scan.nextInt());
            System.out.println(bookingList.get(input));
            scan.nextLine();
        }

        else if (input2 == 3){
            System.out.println("What date and time do you wish to change to?");
            scan.nextLine();
            bookingList.get(input).setDateTime(scan.nextLine());
            System.out.println(bookingList.get(input));

            }
    }
    //Method for searching by instructor, and view their bookings
    public void searchByInstructor() {

        System.out.println("Which instructor would you like to see the current bookings for?");
        String tempAnswer = null;

        tempAnswer = scan.nextLine();

        //Loops through the bookingList
        for (int i = 0; i < bookingList.size(); i++){
            //Executes if conditions are fulfilled
            if (tempAnswer.equalsIgnoreCase(bookingList.get(i).getEmployee().toString())){
                System.out.printf("%-25s %s", "Name:" , "Date:\n");
                System.out.printf("%-25s %-10s", bookingList.get(i).getName(), bookingList.get(i).getDateTime()+ "\n");
            }

        }

    }
    public void searchByDate(){
        System.out.println("Do you wish to see a calender by\n1: Specific day \n2: Specific month \n3: Specific year");

        int input = 0;
        input = scan.nextInt();
        scan.nextLine();

        if (input == 1){
            System.out.println("Enter date (DD/MM/YYYY");

            String stringA= null; //saves the input information so that its possible to compare
            stringA=scan.nextLine();


            System.out.println("---------------------------- Calendar Date" + " " + stringA + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                if (stringA.equalsIgnoreCase(bookingList.get(i).getDateTime())){
                    System.out.println(bookingList.get(i));
                }

            }
        }

        else if (input==2){

            System.out.println("Enter month (MM)");

            String answer = null;
            answer = scan.nextLine();

            System.out.println("---------------------------- Calendar month" + " " + answer + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                String Temp1 = bookingList.get(i).getDateTime().substring(3, 5);

                if (answer.equals(Temp1)){
                    System.out.println(bookingList.get(i));
                }
            }
        }
        else if (input==3){
            System.out.println("Enter year (YYYY)");

            String answer = null;
            answer = scan.nextLine();

            System.out.println("---------------------------- Calendar year" + " " + answer + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                String Temp1 = bookingList.get(i).getDateTime().substring(6, 10);

                if (answer.equals(Temp1)){
                    System.out.println(bookingList.get(i));

                }
            }
        }
    }

}
