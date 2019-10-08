package DesignProject;

import java.util.*;

public class Menu { // This class function as a controller
    Scanner scan = new Scanner(System.in); // this scanner is used in the menu
    List<Activity> activitylist = new ArrayList<Activity>(); // Activity list
    List<Activity> bookingList = new ArrayList<Activity>(); // Booking list
    Employee[] employeeArray = new Employee[5]; //creates an array of employee object, so that we can see all employees
    private boolean isEditBackTriggered = false;


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
                        activityMenu();
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
                        bookingMenu();
                    } else if (answer == 4){
                        answer = 0;
                        searchByDate();
                    }else if (answer == 9){
                        System.exit(1);
                    }else {
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
    public void bookActivity () {
        System.out.println("Type name of activity");
        scan.nextLine();
        String name = scan.nextLine();
        previousBooking(name);
        System.out.println("When is the booking for? (YYYY)");
        String dateTime = scan.nextLine();
        previousBooking(dateTime);
        System.out.println("What equipment is needed to bring?");
        String equipment = scan.nextLine();
        previousBooking(equipment);
        System.out.println("What is the age req?");
        String ageReq = scan.nextLine();
        previousBooking(ageReq);
        System.out.println("What is the height req?");
        String heightReq = scan.nextLine();
        previousBooking(heightReq);
        System.out.println("How many participants?");
        String participants = scan.nextLine();
        previousBooking(participants);
        System.out.println("Which instructor will be assigned?");
       for (int i = 0; i < employeeArray.length; i++){
           System.out.println("[" + i + "] " + employeeArray[i]);
       }
        int input = scan.nextInt();

       int intAge = Integer.parseInt(ageReq);
       int intHeight = Integer.parseInt(heightReq);
       int intParticipants = Integer.parseInt(participants);

        bookingList.add(new Activity(name, dateTime, equipment, intAge, intHeight, intParticipants, employeeArray[input]));

    }

    //Cancels a booking based on index number
    public void cancelBooking() {
        String input = "";
        for (int i = 0; i <bookingList.size(); i++) {
            System.out.println("[" + i + "] " + bookingList.get(i));
        }
        System.out.println();
        System.out.println("Choose what activity to delete by entering number: ");
        scan.nextLine();
        input = scan.nextLine();
        previousBooking(input);
        System.out.println("This booking has been cancelled:");

        //Checks string input, to make sure it's not equal to 'Back'
        if (!input.equalsIgnoreCase("Back")){
            int intInput = Integer.parseInt(input);
            System.out.println(bookingList.get(intInput) + "\n");
            bookingList.remove(intInput);
        }

    }
    //Edits an existing activity
    public void editActivity() {
        String input;
        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-10s", "Name of activity", "Date", "Equipment", "Age requirement", "Height requirement", "Participants", "Instructor\n");

        for (int i = 0; i < activitylist.size(); i++) {
            System.out.println("[" + i + "]" + activitylist.get(i));
        }

        System.out.println("Choose which activity you want to edit");
        if (isEditBackTriggered == false){
            scan.nextLine();
        }
        isEditBackTriggered = false;
        input = scan.nextLine();
        int intInput = 0;
        previousActivity(input);
        if (!input.equalsIgnoreCase("Back")){
            intInput = Integer.parseInt(input);
        }

        //Shows menu for edit options
        System.out.println("You have chosen to edit : " + activitylist.get(intInput).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Name : " + activitylist.get(intInput).getName()
                + "\n" + "[2] Equipment : " + activitylist.get(intInput).getEquipment()
                + "\n" + "[3] Age : " + activitylist.get(intInput).getAgeRequirement()
                + "\n" + "[4] Height : " + activitylist.get(intInput).getHeightRequirement()
                + "\n");

        int intintput2= 0;
        String input2 = scan.nextLine();
        previousEditActivity(input2);
        if (!input2.equalsIgnoreCase("Back")){
            intintput2 = Integer.parseInt(input2);
        }

        if (intintput2 == 1)
        {
            System.out.println("What do you wish to change the activity name to?");
            String input3 = scan.nextLine();
            previousEditActivity(input3);
            activitylist.get(intInput).setName(input3);
            System.out.println(activitylist.get(intInput));
        }
        else if (intintput2 == 2){
            System.out.println("What do you wish to change the activity equipment requirement to?");
            String input4 = scan.nextLine();
            previousEditActivity(input4);
            activitylist.get(intInput).setEquipment(input4);
            System.out.println(activitylist.get(intInput));}

        else if (intintput2 == 3){
            System.out.println("What do you wish to change the activity age requirement to?");
            int intInput5 = 0;
            String input5 = scan.nextLine();
            previousEditActivity(input5);
            if (!input5.equalsIgnoreCase("Back")){
                intInput5 = Integer.parseInt(input5);
            }
            activitylist.get(intInput).setAgeRequirement(intInput5);
            System.out.println(activitylist.get(intInput));}

        else if (intintput2 == 4){
            System.out.println("What do you wish to change the activity height requirement to?");
            int intInput6 = 0;
            String input6 = scan.nextLine();
            previousEditActivity(input6);
            if (!input6.equalsIgnoreCase("Back")){
                intInput6 = Integer.parseInt(input6);
            }
            activitylist.get(intInput).setHeightRequirement(intInput6);
            System.out.println(activitylist.get(intInput));}

        activityMenu();

    }
    //Edits an existing booking
    public void editBooking() {

        String input;
        System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-10s", "Name of activity", "Date", "Equipment", "Age requirement", "Height requirement", "Participants", "Instructor\n");

        for (int i = 0; i < bookingList.size(); i++) {
            System.out.println("[" + i + "]" + bookingList.get(i));
        }

        System.out.println("Choose which booking you want to edit");
        //If our previousBooking method has been triggered
        if (isEditBackTriggered == false){
            scan.nextLine();
        }
        //Resets our isEditBackTriggered boolean
        isEditBackTriggered = false;
        input = scan.nextLine();
        int intInput = 0;
        previousBooking(input);
        if (!input.equalsIgnoreCase("Back")) {
            intInput = Integer.parseInt(input);
        }

        //Shows menu for edit options
        System.out.println("You have chosen to edit : " + bookingList.get(intInput).getName());
        System.out.println("Which element do you which to edit?");
        System.out.println("[1] Instructor : " + bookingList.get(intInput).getEmployee()
                + "\n" + "[2] Participants : " + bookingList.get(intInput).getParticipants()
                + "\n" + "[3] Date & time : " + bookingList.get(intInput).getDateTime()
                + "\n");

        int intInput2 = 0;
        String input2 = scan.nextLine();
        previousEditBooking(input2);
        if (!input2.equalsIgnoreCase("Back")){
            intInput2 = Integer.parseInt(input2);
        }
        if (intInput2 == 1) {

            System.out.println("Which instructor do you wish to assign this booking?");

            for(int i = 0; i < employeeArray.length; i++){
                System.out.println("[" + i + "]" + employeeArray[i]);
            }
            int intInput3 = 0;
            String input3 = scan.nextLine();
            previousEditBooking(input3);
            if (!input3.equalsIgnoreCase("Back")){
                intInput3 = Integer.parseInt(input3);
            }

            bookingList.get(intInput).setEmployee(employeeArray[intInput3]);
            System.out.println();

        }

        else if (intInput2 == 2){
            System.out.println("How many participants do you wish to change to?");
            int intInput4 = 0;
            String input4 = scan.nextLine();
            previousEditBooking(input4);
            if (!input4.equalsIgnoreCase("Back")){
                intInput4 = Integer.parseInt(input4);
            }
            bookingList.get(intInput).setParticipants(intInput4);
            System.out.println(bookingList.get(intInput));
        }

        else if (intInput2 == 3){
            System.out.println("What date and time do you wish to change to?");
            String input5 = scan.nextLine();
            previousEditBooking(input5);
            bookingList.get(intInput).setDateTime(input5);
            System.out.println(bookingList.get(intInput));

            }
        bookingMenu();
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

    //Method for going back to our activityMenu method
    public void previousActivity(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            activityMenu();
        }

    }
    //Method for going back to our editActivity method
    public void previousEditActivity(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            isEditBackTriggered = true;
            editActivity();
        }

    }

    //Method for going back to our bookingMenu method
    public void previousBooking(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            bookingMenu();
        }

    }
    //Method for going back to our editBooking method
    public void previousEditBooking(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            isEditBackTriggered = true;
            editBooking();
        }

    }

    //Method for going back to our menu method
    public void previousCalender(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            menu();
        }

    }

    //Method for going back to our SearchByDate method
    public void previousEditCalender(String string){

        if (string.equalsIgnoreCase("Back")){
            System.out.println("You typed keyword 'Back', you've been redirected to previous menu\n");
            isEditBackTriggered = true;
            searchByDate();
        }

    }


    //Method for getting access to the booking menu
    public void bookingMenu(){
        int answer;
        System.out.println("Press 0 to go back to previous menu\nPress 1 to add a booking\nPress 2 to view bookings\nPress 3 to search by instructor\nPress 4 for cancel a booking\nPress 5 to edit a booking\n\nPRESS 9 TO EXIT PROGRAM\n");
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
        else if (answer == 0){
            menu();
        }else if (answer == 9){
            System.exit(1);
        }
    }

    public void activityMenu(){
        int answer;
        System.out.println("Press 0 to go back to previous menu\nPress 1 to edit activities\nPress 2 to view activities\n\nPRESS 9 TO EXIT PROGRAM\n");
        answer = scan.nextInt();

        if (answer == 1){
            editActivity();
        }else if (answer == 2){
            System.out.printf("%-25s %-25s %-25s %-25s %-25s", "Name", "Date", "Equipment", "Age requirement", "Height requirement\n");
            outputActivity();
            activityMenu();
        }else if (answer == 0){
            menu();
        }else if (answer == 9){
            System.exit(1);
        }
    }

    public void searchByDate(){
        System.out.println("Press 0 to go back to previous menu\nDo you wish to see a calender by\n1: Specific day \n2: Specific month \n3: Specific year\n\nPRESS 9 TO EXIT PROGRAM\n");


        int intinput = 0;
        if (isEditBackTriggered == false){
            scan.nextLine();
        }
        isEditBackTriggered = false;
        String input = scan.nextLine();
        previousCalender(input);
        if (!input.equalsIgnoreCase("Back")){
            intinput = Integer.parseInt(input);
        }

        if (intinput == 1){
            System.out.println("Enter date (DD/MM/YYYY");

            String stringA= null; //saves the input information so that its possible to compare
            stringA=scan.nextLine();
            previousEditCalender(stringA);



            System.out.println("---------------------------- Calendar Date" + " " + stringA + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                if (stringA.equalsIgnoreCase(bookingList.get(i).getDateTime())){
                    System.out.println(bookingList.get(i));
                }

            }
        }

        else if (intinput==2){

            System.out.println("Enter month (MM)");

            String answer = null;
            answer = scan.nextLine();
            previousEditCalender(answer);

            System.out.println("---------------------------- Calendar month" + " " + answer + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                String Temp1 = bookingList.get(i).getDateTime().substring(3, 5);

                if (answer.equals(Temp1)){
                    System.out.println(bookingList.get(i));
                }
            }
        }
        else if (intinput==3){
            System.out.println("Enter year (YYYY)");

            String answer = null;
            answer = scan.nextLine();
            previousEditCalender(answer);

            System.out.println("---------------------------- Calendar year" + " " + answer + " ----------------------------");
            for (int i = 0; i < bookingList.size(); i++){

                String Temp1 = bookingList.get(i).getDateTime().substring(6, 10);

                if (answer.equals(Temp1)){
                    System.out.println(bookingList.get(i));

                }
            }
        } else if (intinput == 9){
            System.exit(1);
        }
    }

}