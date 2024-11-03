package funeraltrackersystem;

import java.util.Scanner;

public class BurialDetails {
    
    private Scanner sc = new Scanner(System.in);

    public void bdTransaction() {
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
                    addBurialDetails();
                    viewBurialDetails();
                    break;
                case 2:
                    viewBurialDetails();
                    break;
                case 3:
                    viewBurialDetails();
                    updateBurialDetails();
                    viewBurialDetails();
                    break;
                case 4:
                    viewBurialDetails();
                    deleteBurialDetails();
                    viewBurialDetails();
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

    public void addBurialDetails() {
        System.out.print("Burial or Cremation: ");
        String boc = sc.nextLine();
        System.out.print("Burial plot location or cremation site: ");
        String bplocs = sc.nextLine();
        System.out.print("Costs: ");
        int costs = sc.nextInt();
        sc.nextLine(); 

        String qry = "INSERT INTO tbl_bd (bd_boc, bd_bplocs, bd_costs) VALUES (?, ?, ?)";
        config confi = new config();
        confi.addRecord(qry, boc, bplocs, costs);
    }

    public void viewBurialDetails() {
        String qry = "SELECT * FROM tbl_bd";
        String[] headers = {"ID", "Burial/Cremation", "Location", "Costs"};
        String[] columns = {"bd_id", "bd_boc", "bd_bplocs", "bd_costs"};
        config confi = new config();
        confi.viewRecords(qry, headers, columns);
    }
    
    public void updateBurialDetails() {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  
        
        config confi = new config();
        while (confi.getSingleValue("SELECT bd_id FROM tbl_bd WHERE bd_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Details ID Again: ");
            id = sc.nextInt();
            sc.nextLine();  
        }

        System.out.print("Update Burial or Cremation: ");
        String boc = sc.nextLine();
        System.out.print("Update plot location or cremation site: ");
        String bplocs = sc.nextLine();
        System.out.print("Update Costs: ");
        int costs = sc.nextInt();
        sc.nextLine(); 

        String qry = "UPDATE tbl_bd SET bd_boc = ?, bd_bplocs = ?, bd_costs = ? WHERE bd_id = ?";
        confi.updateRecord(qry, boc, bplocs, costs, id);
    }
    
    public void deleteBurialDetails() {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        config confi = new config();
        while (confi.getSingleValue("SELECT bd_id FROM tbl_bd WHERE bd_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Details ID Again: ");
            id = sc.nextInt();
            sc.nextLine();
        }

        String qry = "DELETE FROM tbl_bd WHERE bd_id = ?";
        confi.deleteRecord(qry, id);
    }
}
