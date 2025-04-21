import java.time.LocalDate;
import java.util.ArrayList;

import SystemControl.*;
import SystemCore.SysModel;
import SystemView.AdminView;
import SystemView.CustView;

import SystemControl.AdminController;
import Transport.ModeTransport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        SysModel model = new SysModel();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        // Should Call the Main menu for the user to choose [Admin or Client]
        // Then this should loop until the user chooses to exit

        /*
        ArrayList<String[]> csvLines = DATABASE.readCSV();
        for (String[] line : csvLines)
        {
            for (String element : line)
            {
                System.out.print(element + " - ");
            }
            System.out.print("\n");
        }
        String[] a = {"allo", "bye"};
        String[] b = {"woop", "sloop"};
        ArrayList<String[]> test = new ArrayList<>();
        test.add(a);
        test.add(b);
        DATABASE.writeCSV(test);
        */
        while (!exit) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (choice) {
                case 1:
                    model.setCurrUserRole(true);
                    AdminView adminView = new AdminView(model);
                    adminView.adminInput();
                    break;

                case 2:
                    model.setCurrUserRole(false);
                    CustView custView = new CustView(model);
                    custView.custInput();
                    break;

                case 3:
                    exit = true;
                    input.close();
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

//        model.updateDB();
    }

}