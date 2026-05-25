public class Book {

    //add properties
    int Id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    //add constructor

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        Id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    //add get/ set

    public int getId() {
        return Id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }


    // add methods derived
    public void checkOut (String name){
        isCheckedOut = true;
        checkedOutTo = name;
        }
    public void checkIn() {
        isCheckedOut = false;
        checkedOutTo = "";
    }
}
