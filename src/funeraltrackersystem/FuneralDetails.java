package funeraltrackersystem;

import java.util.Scanner;

public class FuneralDetails {
    
    private Scanner sc = new Scanner(System.in); // Reuse the same Scanner instance

    public void fdTransaction() {
        String response;

        do {
            System.out.println("\n -------------------------");
            System.out.println("|  FUNERAL DETAILS PANEL    |");
            System.out.println(" -------------------------");
            System.out.println("| 1.    ADD FUNERAL DETAILS       |");
            System.out.println(" -------------------------");
            System.out.println("| 2.    VIEW FUNERAL DETAILS      |");
            System.out.println(" -------------------------");
            System.out.println("| 3.   UPDATE FUNERAL DETAILS     |");
            System.out.println(" -------------------------");
            System.out.println("| 4.   DELETE FUNERAL DETAILS     |");
            System.out.println(" -------------------------");
            System.out.println("| 5.       EXIT           |");
            System.out.println(" -------------------------");

            System.out.print("Enter selection: ");
            int act = sc.nextInt();
            sc.nextLine(); // Clear newline character after nextInt()

            switch (act) {
                case 1:
                    addFuneralDetails();
                    viewFuneralDetails();
                    break;
                case 2:
                    viewFuneralDetails();
                    break;
                case 3:
                    viewFuneralDetails();
                    updateFuneralDetails();
                    viewFuneralDetails();
                    break;
                case 4:
                    viewFuneralDetails();
                    deleteFuneralDetails();
                    viewFuneralDetails();
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
    
    public void addFuneralDetails(){
        System.out.print("Date of Funeral: ");
        String dof = sc.nextLine();
        System.out.print("Location of the funeral: ");
        String lotf = sc.nextLine();
        System.out.print("Name of funeral service provider: ");
        String nofsp = sc.nextLine();

        String qry = "INSERT INTO tbl_fd (fd_dof, fd_lotf, fd_namefunserprov) VALUES (?, ?, ?)";
        config confi = new config();
        confi.addRecord(qry, dof, lotf, nofsp);
    }
    public void viewFuneralDetails() {
        String qry = "SELECT * FROM tbl_fd";
        String[] headers = {"ID", "Date of Funeral", "Location of the Funeral", "Name of funeral service provider"};
        String[] columns = {"fd_id", "fd_dof", "fd_lotf", "fd_namefunserprov"};
        config confi = new config();
        confi.viewRecords(qry, headers, columns);
    }
    public void updateFuneralDetails() {
        System.out.print("Enter ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  
        
        config confi = new config();
        while (confi.getSingleValue("SELECT fd_id FROM tbl_fd WHERE fd_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Details ID Again: ");
            id = sc.nextInt();
            sc.nextLine();  
        }

        System.out.print("Update Date of Funeral: ");
        String dof = sc.nextLine();
        System.out.print("Update Location of Funeral: ");
        String lotf = sc.nextLine();
        System.out.print("Update Name of Funeral Service Provider: ");
        String nofsp = sc.nextLine();

        String qry = "UPDATE tbl_fd SET fd_dof = ?, fd_lotf = ?, fd_namefunserprov = ? WHERE fd_id = ?";
        confi.updateRecord(qry, dof, lotf, nofsp, id);
    }
    public void deleteFuneralDetails(){
        Scanner sc = new Scanner(System.in);
        config confi = new config();
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        
        while (confi.getSingleValue("SELECT fd_id FROM tbl_fd WHERE fd_id = ?", id) == 0) {
            System.out.println("Selected ID does not exist.");
            System.out.print("Select Details ID Again: ");
            id = sc.nextInt();
            sc.nextLine();
        }
        
        String qry = "DELETE FROM tbl_fd WHERE fd_id = ?";
        confi.deleteRecord(qry, id);
        
    }
}
    