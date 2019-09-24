package DesignProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu { // This class function as a controller

    Scanner scan = new Scanner(System.in);

    List<Activity> activityList = new ArrayList<>();
    Employee em = new Employee("Torben");

    public void Menu() {
        activityList.add(new Activity("Gocart", "24/09-19 - 11:30","Tøj der kan tåle at blive beskidt", 14, 155));
        activityList.add(new Activity("Minigolf", "25/09-19 - 12:30","Bare det goe humør", 70, 000));
        activityList.add(new Activity("Paintball", "26/09-19 - 13:30","Gode sko at gå i, som må blive beskidte - Tøj der kan tåle farve", 16, 160));
        activityList.add(new Activity("Sumo wrestling", "27/09-19 - 14:30","Brugt tøj", 10, 160));
    }

    public void menuskrivmand() {
        for (Object o : activityList) {
            System.out.println(o);
        }
    }

    public void skriven() {
       // activityList.set(1, ).setParticipants(5);
    }

    public void bookAktivitet(){
        System.out.println("Type name of activity");
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
        Object employee = scan.nextLine();

        activityList.add(new Activity(name, dateTime, equipment, ageReq, heightReq, participants, employee));

      //  activityList.add(new Activity("Vandski", "29/10-19 . 16:15", "Intet medbragt", 15, 165, 10, "Torben"));

    }


}
