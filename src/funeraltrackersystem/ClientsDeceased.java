package funeraltrackersystem;

import java.util.Scanner;

public class ClientsDeceased {

    private Scanner sc = new Scanner(System.in); 

    public void cdTransaction() {
        String response;

        do {
            System.out.println("\n ----------------------");
            System.out.println("|    CLIENTS PANEL     |");
            System.out.println(" ----------------------");
            System.out.println("| 1.   ADD CLIENTS     |");
            System.out.println(" ----------------------");
            System.out.println("| 2.   VIEW CLIENTS    |");
            System.out.println(" ----------------------");
            System.out.println("| 3.  UPDATE CLIENTS   |");
            System.out.println(" ----------------------");
            System.out.println("| 4.  DELETE CLIENTS   |");
            System.out.println(" ----------------------");
            System.out.println("| 5.      EXIT         |");
            System.out.println(" ----------------------");

            System.out.print("Enter selection: ");
            int act = sc.nextInt();
            sc.nextLine();  // Clear the newline character after nextInt()
            FuneralDetails fd = new FuneralDetails();
            switch (act) {
                case 1:
                    addClients();
                    viewClients();
                    break;
                case 2:
                    viewClients();
                    break;
                case 3:
                    viewClients();
                    updateClients();
                    viewClients();
                    break;
                case 4:
                    viewClients();
                    deleteClients();
                    viewClients();
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

    public void addClients() {
        System.out.print("Client's Name: ");
        String cname = sc.nextLine();
        System.out.print("Date of Birth: ");
        String dob = sc.nextLine();
        System.out.print("Date of Death: ");
        String dod = sc.nextLine();
        System.out.print("Place of Death: ");
        String pod = sc.nextLine();
        System.out.print("Cause of Death: ");
        String cod = sc.nextLine();

        String qry = "INSERT INTO tbl_clientsdeceased (c_name, c_dateofbirth, c_dateofdeath, c_placeofdeath, c_causeofdeath) VALUES (?, ?, ?, ?, ?)";
        config confi = new config();
        confi.addRecord(qry, cname, dob, dod, pod, cod);
    }

    public void viewClients() {
        String qry = "SELECT * FROM tbl_clientsdeceased";
        String[] headers = {"ID", "Name", "Date of Birth", "Date of Death", "Place of Death", "Cause of Death"};
        String[] columns = {"c_id", "c_name", "c_dateofbirth", "c_dateofdeath", "c_placeofdeath", "c_causeofdeath"};
        config confi = new config();
        confi.viewRecords(qry, headers, columns);
    }

    public void updateClients() {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  
        
        config confi = new config();
        while (confi.getSingleValue("SELECT c_id FROM tbl_clientsdeceased WHERE c_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Clients ID Again: ");
            id = sc.nextInt();
            sc.nextLine();  
        }

        System.out.print("Update Client's Name: ");
        String cname = sc.nextLine();
        System.out.print("Update Date of Birth: ");
        String dob = sc.nextLine();
        System.out.print("Update Date of Death: ");
        String dod = sc.nextLine();
        System.out.print("Update Place of Death: ");
        String pod = sc.nextLine();
        System.out.print("Update Cause of Death: ");
        String cod = sc.nextLine();

        String qry = "UPDATE tbl_clientsdeceased SET c_name = ?, c_dateofbirth = ?, c_dateofdeath = ?, c_placeofdeath = ?, c_causeofdeath = ? WHERE c_id = ?";
        confi.updateRecord(qry, cname, dob, dod, pod, cod, id);
    }
    
    public void deleteClients(){
        Scanner sc = new Scanner(System.in);
        config confi = new config();
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        while (confi.getSingleValue("SELECT c_id FROM tbl_clientsdeceased WHERE c_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Clients ID Again: ");
            id = sc.nextInt();
            sc.nextLine();
        }
        
        String qry = "DELETE FROM tbl_clientsdeceased WHERE c_id = ?";
        confi.deleteRecord(qry, id);
        
    }
}
