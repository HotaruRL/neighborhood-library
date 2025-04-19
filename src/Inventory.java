import java.util.Scanner;

public class Inventory {
    // Create an array named books to hold 20 Book's objects
    Book[] books;
    Menu menu;

    Inventory(Book[] books, Menu m){
        this.books = books;
        this.menu = m;
    }


    // Create Scanner instance named in
    Scanner in = new Scanner(System.in);

    public void showAvailableBooks(){

        // Placeholder variables
        int command = -1;
        String patronName = "";
        int bookSlot = 0;

        System.out.println("\nThe following books are available:");
        for(Book b : this.books){
            if (b == null || b.getIsCheckedOut()){
                continue;
            }
            System.out.printf("\nID: %d\nTitle: %s\nISBN: %s\n", b.getId(), b.getTitle(), b.getIsbn());
        }

        while (command != 0) {
            System.out.println("""
                \nPlease enter either
                
                [Book's ID] - to Check Out a Book
                0 - to Go Back to the Main Menu
                
                """);
            command = in.nextInt();
            // consume the leftover newline from in.nextInt above
            in.nextLine();
            for (Book b : this.books) {
                if (b == null) {
                    bookSlot++;
                    continue;
                }

                if (command == b.getId()) {
                    if (!b.getIsCheckedOut()) {
                        System.out.println("\nPlease enter your name: ");
                        patronName = in.nextLine();
                        b.checkOut(patronName);
                        System.out.println(b.getCheckedOutTo() + ", you have successfully checked out " + b.getTitle()
                                + "\nWe hope you will enjoy it.");
                        break;
                    }else {
                        System.out.println("\nSorry this book is not available!\nPlease try another book.");
                        break;
                    }
                }

                if (bookSlot == this.books.length) {
                    System.out.println("\nThat is not an valid option! Please try again.");
                    break;
                }
            }

        }
        this.menu.mainMenu();
    } // END OF showAvailableBooks FUNCTION



    public void showCheckedOutBooks(){

        // Create an empty command variable
        String command = "";
        int returnBookID = -1;

        for(Book b : this.books){
            if (b != null & b.getIsCheckedOut()) {
                System.out.println("\nThe following books are checked out:");
                System.out.printf("\nID: %d\nTitle: %s\nISBN: %s\nChecked out by: %s",
                        b.getId(), b.getTitle(), b.getIsbn(), b.getCheckedOutTo());
            }else {
                System.out.println("Be the first one to check out a book!");
            }
        }
         // END OF SHOWING LIST FOR LOOP

        while(!command.equalsIgnoreCase("X")) {
            System.out.println("""
                Please enter either

                C - to Check In a book
                X - to go back to the Main menu

                """);
            command = in.next();
            // consume the leftover newline from in.nextInt above
            in.nextLine();
            if (command.equalsIgnoreCase("C")) {
                System.out.println("\nPlease enter the book's ID to check it in: ");
                returnBookID = in.nextInt();
                for (Book b : books) {
                    if (returnBookID == b.getId() && b.getIsCheckedOut()) {
                        b.checkIn();
                        System.out.println("\nThis book" + b.getTitle() + "has been successfully checked in. Thank you!");
                    } else {
                        System.out.println("This book's ID is not valid to check in. Please try again");
                        break;
                    }
                }
            } else {
                System.out.println("\nPlease enter either C or X: ");
            } // END OF CHECK IN IF
        }// END OF CHECK IN MENU WHILE LOOP
        this.menu.mainMenu();
    }// END OF showCheckedOutBooks FUNCTION
} // END OF TASK CLASS
