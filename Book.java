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



