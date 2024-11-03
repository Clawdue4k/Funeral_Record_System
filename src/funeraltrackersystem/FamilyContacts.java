
package funeraltrackersystem;
import java.util.Scanner;

public class FamilyContacts {
    
    public void fcTransaction(){
        String response;

        do {
            System.out.println("\n -------------------------");
            System.out.println("|     BURIAL DETAILS PANEL    |");
            System.out.println(" -------------------------");
            System.out.println("| 1.    ADD BURIAL DETAILS    |");
            System.out.println(" -------------------------");
            System.out.println("| 2.    VIEW BURIAL DETAILS   |");
            System.out.println(" -------------------------");
            System.out.println("| 3.   UPDATE BURIAL DETAILS  |");
            System.out.println(" -------------------------");
            System.out.println("| 4.   DELETE BURIAL DETAILS  |");
            System.out.println(" -------------------------");
            System.out.println("| 5.       EXIT               |");
            System.out.println(" -------------------------");

            System.out.print("Enter selection: ");
            int act = sc.nextInt();
            sc.nextLine(); 

            switch (act) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.nextLine();

        } while (response.equalsIgnoreCase("yes"));
    }
    public void addFamilyContacts() {
        Scanner sc = new Scanner(System.in);
        ClientsDeceased cd = new ClientsDeceased();
        cd.viewClientsDeceased();
        
        System.out.print("Enter names and phone numbers of next of kin: ");
        String boc = sc.nextLine();
        sc.nextLine(); 

        String qry = "INSERT INTO tbl_fc (fc_nap) VALUES ( ? )";
        config confi = new config();
        confi.addRecord(qry, nap);
    }
}
