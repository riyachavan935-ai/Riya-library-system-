// LibraryService.java - Bada Code - Business Logic - 150+ lines
// By Riya Chavan 3121 - Java + Java Swing - Library Management
import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> books;
    private int bookCounter;

    public LibraryService() {
        books = new ArrayList<>();
        bookCounter = 1001;
        // Sample data - 10 books
        addBook(new Book("BK1001", "Java Programming", "James Gosling", "CS"));
        addBook(new Book("BK1002", "Python Basics", "Guido van Rossum", "CS"));
        addBook(new Book("BK1003", "Data Structures", "Mark Weiss", "CS"));
        addBook(new Book("BK1004", "Clean Code", "Robert Martin", "SE"));
        System.out.println("LibraryService Started - " + books.size() + " books loaded");
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("OUTPUT AAYA - BOOK ADDED: " + book.getBookId() + " | " + book.getTitle());
    }

    public boolean issueBook(String bookId, String studentName) {
        for (Book b : books) {
            if (b.getBookId().equals(bookId) && b.getStatus().equals("Available")) {
                b.setStatus("Issued");
                b.setIssuedTo(studentName);
                System.out.println("BOOK ISSUED: " + bookId + " to " + studentName);
                return true;
            }
        }
        System.out.println("BOOK ISSUE FAILED: " + bookId);
        return false;
    }

    public boolean returnBook(String bookId) {
        for (Book b : books) {
            if (b.getBookId().equals(bookId) && b.getStatus().equals("Issued")) {
                b.setStatus("Available");
                b.setIssuedTo("-");
                System.out.println("BOOK RETURNED: " + bookId);
                return true;
            }
        }
        return false;
    }

    public Book searchBook(String keyword) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("BOOK FOUND: " + b.getBookId());
                return b;
            }
        }
        System.out.println("BOOK NOT FOUND: " + keyword);
        return null;
    }

    public ArrayList<Book> getAllBooks() { return books; }
    public int getTotalBooks() { return books.size(); }
    public int getAvailableBooks() {
        int c=0; for(Book b:books) if(b.getStatus().equals("Available")) c++; return c;
    }
    public int getIssuedBooks() {
        int c=0; for(Book b:books) if(b.getStatus().equals("Issued")) c++; return c;
    }
    public String generateId() { return "BK" + (bookCounter++); }
                           }
