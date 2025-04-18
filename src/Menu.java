import java.util.Scanner;

public class Menu {
    public void mainMenu() {

        // Create Scanner instance named in
        Scanner in = new Scanner(System.in);

//        1. Show Available Books
//        2. Show Checked Out Books
//        3. Exit - closes out of the application
        Book[] books = new Book[20];
        books[0] = new Book(1, "978-0061120084", "\"To Kill a Mockingbird\" by Harper Lee");
        books[1] = new Book(2, "978-0451524935", "\"1984\" by George Orwell");
        books[2] = new Book(3, "978-0743273565", "\"The Great Gatsby\" by F. Scott Fitzgerald");

        Library library = new Library(books, this);

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
                library.showAvailableBooks();
                break;
            } else if (command == 2) {
                library.showCheckedOutBooks();
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
