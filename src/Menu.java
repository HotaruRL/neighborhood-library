import java.util.Scanner;

public class Menu {
    public static void menu() {

        // Create Scanner instance named in
        Scanner in = new Scanner(System.in);

//        1. Show Available Books
//        2. Show Checked Out Books
//        3. Exit - closes out of the application

        int command = -1;
        while (command != 3) {
            System.out.print("""
                    ---------------------------------------
                    -------------- Main Menu --------------
                    ---------------------------------------
                    
                    1. Show Available Books
                    2. Show Checked Out Books
                    3. Exit - closes out of the application
                    
                    Please enter the correspondent number for the task you want to do
                    e.g. 1 to show all available books:
                    """);
            command = in.nextInt();
            if (command == 1) {
                Task.showAvailableBooks();
                break;
            } else if (command == 2) {
                Task.showCheckedOutBooks();
                break;
            } else if (command == 3) {
                break;
            } else {
                System.out.println("\nThere is no such task numbered " + command
                +"\nPlease try again.\n");
            } //END OF IF
        } // END OF WHILE LOOP
        System.out.println("\nThank you for using our library!\nHave a good day!");
    } // END OF MENU FUNCTION
}
