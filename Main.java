import java.util.ArrayList;
import java.util.Scanner;

// کلاس Book
class Book {
    private String title;        // عنوان کتاب
    private String author;       // نویسنده کتاب
    private String bookCode;     // کد منحصربه‌فرد کتاب
    private boolean isAvailable; // وضعیت کتاب (موجود یا امانت داده شده)

    // سازنده
    public Book(String title, String author, String bookCode) {
        this.title = title;
        this.author = author;
        this.bookCode = bookCode;
        this.isAvailable = true; // کتاب به طور پیش‌فرض موجود است
    }

    // متدهای دسترسی (Getter و Setter)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // نمایش اطلاعات کتاب
    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Book Code: " + bookCode);
        System.out.println("Status: " + (isAvailable ? "Available" : "Checked Out"));
    }
}

// کلاس Member
class Member {
    private String name;             // نام عضو
    private String membershipNumber; // شماره عضویت
    private ArrayList<Book> borrowedBooks; // لیستی از کتاب‌های امانت گرفته شده

    // سازنده
    public Member(String name, String membershipNumber) {
        this.name = name;
        this.membershipNumber = membershipNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // متدهای دسترسی (Getter و Setter)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // اضافه کردن کتاب به لیست کتاب‌های امانت گرفته شده
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false); // کتاب امانت داده شده و وضعیت آن تغییر می‌کند
    }

    // بازگرداندن کتاب
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true); // کتاب به کتابخانه باز می‌گردد و وضعیت آن تغییر می‌کند
    }
    
    // نمایش اطلاعات عضو
    public void displayMemberInfo() {
        System.out.println("Name: " + name + ", Membership Number: " + membershipNumber);
        System.out.println("Borrowed Books: ");
        for (Book book : borrowedBooks) {
            book.displayBookInfo();
        }
    }
}

// کلاس Library
class Library {
    private ArrayList<Book> books;       // لیست کتاب‌ها
    private ArrayList<Member> members;   // لیست اعضا

    // سازنده
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // متد اضافه کردن کتاب به کتابخانه
    public void addBook(Book book) {
        books.add(book);
    }

    // متد حذف کتاب از کتابخانه
    public void removeBook(Book book) {
        books.remove(book);
    }

    // متد اضافه کردن عضو جدید
    public void addMember(Member member) {
        members.add(member);
    }

    // متد نمایش کتاب‌های موجود
    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayBookInfo();
            }
        }
    }

    // متد قرض دادن کتاب به عضو
    public void borrowBook(String membershipNumber, String bookCode) {
        Member member = findMemberByMembershipNumber(membershipNumber);
        Book book = findBookByBookCode(bookCode);

        if (member != null && book != null && book.isAvailable()) {
            member.borrowBook(book);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Either the book is not available or member not found.");
        }
    }

    // متد برگشت دادن کتاب
    public void returnBook(String membershipNumber, String bookCode) {
        Member member = findMemberByMembershipNumber(membershipNumber);
        Book book = findBookByBookCode(bookCode);

        if (member != null && book != null) {
            member.returnBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Member or Book not found.");
        }
    }

    // متد پیدا کردن عضو بر اساس شماره عضویت
    private Member findMemberByMembershipNumber(String membershipNumber) {
        for (Member member : members) {
            if (member.getMembershipNumber().equals(membershipNumber)) {
                return member;
            }
        }
        return null;
    }

    // متد پیدا کردن کتاب بر اساس کد کتاب
    private Book findBookByBookCode(String bookCode) {
        for (Book book : books) {
            if (book.getBookCode().equals(bookCode)) {
                return book;
            }
        }
        return null;
    }
}

// کلاس Main برای آزمایش
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // افزودن چند کتاب به کتابخانه
        library.addBook(new Book("Java Programming", "Herbert Schildt", "B001"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "B002"));
        library.addBook(new Book("Design Patterns", "Erich Gamma", "B003"));

        // افزودن چند عضو به کتابخانه
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        // منوی ساده برای مدیریت کتابخانه
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // بررسی ورودی عددی و گرفتن ورودی عددی
            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // اینجا برای پاکسازی بافر ورودی از newline اضافی استفاده می‌کنیم.
            } else {
                scanner.nextLine(); // پاکسازی ورودی در صورت وارد کردن ورودی نامعتبر
                System.out.println("Invalid input. Please enter a valid number.");
                continue; // بازگشت به منو برای وارد کردن ورودی صحیح
            }

            if (choice == 1) {
                library.displayAvailableBooks();
            } else if (choice == 2) {
                System.out.print("Enter membership number: ");
                String membershipNumber = scanner.nextLine();
                System.out.print("Enter book code to borrow: ");
                String bookCode = scanner.nextLine();
                library.borrowBook(membershipNumber, bookCode);
            } else if (choice == 3) {
                System.out.print("Enter membership number: ");
                String membershipNumber = scanner.nextLine();
                System.out.print("Enter book code to return: ");
                String bookCode = scanner.nextLine();
                library.returnBook(membershipNumber, bookCode);
            } else if (choice == 4) {
                System.out.println("Exiting system.");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
