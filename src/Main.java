public class Main {

    public static void main(String[] args) {
        // Create an array named books to hold 20 Book's objects
        Book[] books = new Book[20];

        books[0] = new Book(1, "978-0061120084", "\"To Kill a Mockingbird\" by Harper Lee");
        books[1] = new Book(2, "978-0451524935", "\"1984\" by George Orwell");
        books[2] = new Book(3, "978-0743273565", "\"The Great Gatsby\" by F. Scott Fitzgerald");

        Menu.menu();
    } // END OF MAIN FUNCTION
} // END OF MAIN CLASS