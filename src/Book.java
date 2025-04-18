public class Book {
    public int id;
    public String isbn;
    public String title;
    public boolean isCheckedOut;
    public String checkedOutTo;

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public void checkOut(String name){
        isCheckedOut = true;
        checkedOutTo = name;
    }

    public void checkIn(){
        isCheckedOut = false;
        checkedOutTo = "";

    }
}
