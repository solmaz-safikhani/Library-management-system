import java.util.ArrayList;
import java.util.List;
public class Book {
    private String title;
    private String author;
    private int bookId;
    private boolean isAvailable;

    // سازنده
    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
        this.isAvailable = true;
    }

    // getter ها
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // setter برای تغییر وضعیت کتاب
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}


public class Member {
    // نام عضو رو ذخیره میکنه
    private String name;
    // ممبر ای دی
    private int memberId;
    // نشون میده هر عضو چه کتاب هایی رو امانت گرفته 
    private List<Book> borrowedBooks = new ArrayList<>();

    // سازنده
    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    //دسترسی به اسم عضو
    public String getName() {
        return name;
    }
// دسترسی به ای دی ممبر
    public int getMemberId() {
        return memberId;
    }
// لیست کتابای امانت گرفته شده
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    // متد برای اضاقه کردت کتاب 
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
     // برای حدف کتاب
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}


