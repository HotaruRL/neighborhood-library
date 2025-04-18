import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Task {

    // Create Scanner instance named in
    static Scanner in = new Scanner(System.in);

    public static void showAvailableBooks(){

        // Create an empty command variable
        String command = "";

        System.out.println("\nThe following books are available:");
        for(Book b : books){
            if (b == null || b.isCheckedOut){
                continue;
            }
            System.out.printf("\nID: %d\nTitle: %s\nISBN: %s", b.id, b.title, b.isbn);
        }// END OF SHOWING LIST FOR LOOP

        while (!command.equals("X")) {
            System.out.println("""
                Please enter either
                
                [Book's ID] - to Check Out a Book
                X - to go back to the Main menu
                
                """);
            if (command.equals(b.id) && !b.isCheckedOut){

            }else {
                System.out.println("\nPlease enter either C or X: ");
            }// END OF CHECK OUT IF
        }// END OF CHECK OUT MENU WHILE LOOP
        Menu.menu();
    } // END OF showAvailableBooks FUNCTION

    public static void showCheckedOutBooks(){

        // Create an empty command variable
        String command = "";

        System.out.println("\nThe following books are checked out:");
        for(Book b : Main.books){
            if (b == null || !b.isCheckedOut){
                continue;
            }
            System.out.printf("\nID: %d\nTitle: %s\nISBN: %s\nChecked out by: %s",
                    b.id, b.title, b.isbn, b.checkedOutTo);
        } // END OF SHOWING LIST FOR LOOP

        while(!command.equals("X")) {
            System.out.println("""
                Please enter either
                
                C - to Check In a book
                X - to go back to the Main menu
                
                """);
            command = in.next();
            if (command.equals("C")) {
                System.out.println("checkIn");
//            checkIn();
                break;
            } else {
                System.out.println("\nPlease enter either C or X: ");
            } // END OF CHECK IN IF
        }// END OF CHECK IN MENU WHILE LOOP
        Menu.menu();
    }// END OF showCheckedOutBooks FUNCTION
} // END OF TASK CLASS
