import java.util.Scanner;

public class Library {
    // Create an array named books to hold 20 Book's objects
    Book[] books = new Book[20];
    Menu menu;

    Library(Book[] books, Menu m){
        this.books = books;
        this.menu = m;
    }


    // Create Scanner instance named in
    static Scanner in = new Scanner(System.in);

    public void showAvailableBooks(){

        // Create an empty command variable
        int command = -1;

        System.out.println("\nThe following books are available:");
        for(Book b : this.books){
            if (b == null || b.isCheckedOut){
                continue;
            }
            System.out.printf("\nID: %d\nTitle: %s\nISBN: %s", b.id, b.title, b.isbn);
        }// END OF SHOWING LIST FOR LOOP

        while (command != 0) {
            System.out.println("""
                Please enter either
                
                [Book's ID] - to Check Out a Book
                0 - to go back to the Main menu
                
                """);
            command = in.nextInt();
            for (Book b : this.books) {
                if (command == b.id && !b.isCheckedOut) {
                    System.out.println("\nPlease enter your name: ");
                    b.checkedOutTo = in.nextLine();
                    b.isCheckedOut = true;
                    System.out.println("Congrats! You have checked out " + b.id + "-" + b.title);
                } else {
                    System.out.println("\nPlease enter either C or X: ");
                }// END OF CHECK OUT IF
            }// END OF CHECK OUT FOR LOOP
        }// END OF CHECK OUT MENU WHILE LOOP
        this.menu.mainMenu();
    } // END OF showAvailableBooks FUNCTION

    public void showCheckedOutBooks(){

        // Create an empty command variable
        String command = "";

        System.out.println("\nThe following books are checked out:");
        for(Book b : this.books){
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
        this.menu.mainMenu();
    }// END OF showCheckedOutBooks FUNCTION
} // END OF TASK CLASS
