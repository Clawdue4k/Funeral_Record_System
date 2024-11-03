package funeraltrackersystem;

import java.util.Scanner;

public class FuneralTrackerSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        do {
            System.out.println("\n-----------------------------------------");
            System.out.println("|   WELCOME TO FUNERAL RECORD SYSTEM    |");
            System.out.println("-----------------------------------------");
            System.out.println("1. CLIENTS DECEASED INFORMATION");
            System.out.println("2. FUNERAL DETAILS");
            System.out.println("3. BURIAL DETAILS");
            System.out.println("4. FAMILY CONTACTS");
            System.out.println("5. VIEW REPORTS");
            System.out.println("6. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch(action) {
                case 1:
                    ClientsDeceased cd = new ClientsDeceased();
                    cd.cdTransaction();
                    break;
                case 2:
                    FuneralDetails fd = new FuneralDetails();
                    fd.fdTransaction();
                    break;
                case 3:
                    BurialDetails bd = new BurialDetails();
                    bd.bdTransaction();
                    break;
                case 4:
                    System.out.println("Family Contacts feature is not implemented yet.");
                    break;
                case 5:
                    System.out.println("View Reports feature is not implemented yet.");
                    break;
                case 6:
                    System.out.print("Exit Selected... Type 'yes' to confirm: ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("yes")) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (running);

        sc.close();
        System.out.println("Exiting Funeral Record Tracker. Goodbye!");
    }
}
