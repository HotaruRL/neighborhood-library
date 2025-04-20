import java.util.Scanner;

public class Inventory {
    Book[] books;

    public Inventory(){
        this.books = new Book[20];
        books[0] = new Book(1, "978-0061120084", "\"To Kill a Mockingbird\" by Harper Lee");
        books[1] = new Book(2, "978-0451524935", "\"1984\" by George Orwell");
        books[2] = new Book(3, "978-0743273565", "\"The Great Gatsby\" by F. Scott Fitzgerald");
    }


    // Create Scanner instance named in
    Scanner in = new Scanner(System.in);


    public void showAvailableBooks(){

        // Placeholder variables
        int command = -1;
        String patronName = "";

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
                    continue;
                }

                if (command == b.getId()) {
                    if (!b.getIsCheckedOut()) {
                        System.out.println("\nPlease enter your name: ");
                        patronName = in.nextLine().trim();
                        b.checkOut(patronName);
                        System.out.println(b.getCheckedOutTo() + ", you have successfully checked out " + b.getTitle()
                                + "\nWe hope you will enjoy it.");
                        break;
                    }else {
                        System.out.println("\nSorry this book is not available!\nPlease try another book.");
                        break;
                    }
                }
            }
        }
        mainMenu();
    } // END OF showAvailableBooks FUNCTION



    public void showCheckedOutBooks(){

        // Create an empty command variable
        int checkedOutBooks = 0;
        String command = "";
        int returnBookID = -1;

        for(Book b : this.books) {
            if (b == null || !b.getIsCheckedOut()) {
                continue;
            } else {
                checkedOutBooks++;
                System.out.println("\nThe following books are checked out:");
                System.out.printf("\nID: %d\nTitle: %s\nISBN: %s\nChecked out by: %s",
                        b.getId(), b.getTitle(), b.getIsbn(), b.getCheckedOutTo());
            }
        }
        if (checkedOutBooks == 0) {
            System.out.println("Be the first one to check out a book!");
        }
         // END OF SHOWING LIST FOR LOOP

        while(!command.equalsIgnoreCase("X")) {
            System.out.println("""
                \nPlease enter either

                C - to Check In a book
                X - to go back to the Main menu

                """);
            command = in.next();
            if (command.equalsIgnoreCase("C")) {
                System.out.println("\nPlease enter the book's ID to check it in: ");
                // consume the leftover newline from in.nextInt above
                in.nextLine();
                returnBookID = in.nextInt();
                for (Book b : this.books) {
                    if (b == null) {
                        continue;
                    }

                    if (returnBookID == b.getId()) {
                        if (b.getIsCheckedOut()) {
                            b.checkIn();
                            System.out.println("\nThis book" + b.getTitle() + "has been successfully checked in. Thank you!");
                            break;
                        }else {
                            System.out.println("This book's ID is not valid to check in. Please try again");
                        }
                    }
                }
            } else {
                System.out.println("\nPlease enter either C or X: ");
            } // END OF CHECK IN IF
        }// END OF CHECK IN MENU WHILE LOOP
       mainMenu();
    }// END OF showCheckedOutBooks FUNCTION



    public void mainMenu() {

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
                showAvailableBooks();
                break;
            } else if (command == 2) {
                showCheckedOutBooks();
                break;
            } else if (command == 3) {
                break;
            } else {
                System.out.println("\nThere is no such task numbered " + command
                        +"\nPlease try again.\n");
            } //END OF IF
        } // END OF WHILE LOOP
        System.out.println("\nThank you for using our inventory!\nHave a good day!");
    } // END OF MENU FUNCTION

} // END OF TASK CLASS