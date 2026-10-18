// Book.java - Model Class - Java + Java Swing Project
// By Riya Chavan 3121 - Library Management
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private String department;
    private String status;
    private String issuedTo;
    private String issueDate;
    private String isbn;

    public Book(String bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "Available";
        this.issuedTo = "-";
        this.issueDate = "-";
        this.isbn = "ISBN-" + bookId;
        this.department = "Computer Science";
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public String getIssuedTo() { return issuedTo; }
    public void setStatus(String status) { this.status = status; }
    public void setIssuedTo(String issuedTo) { this.issuedTo = issuedTo; }
    public String toString() {
        return bookId + " | " + title + " by " + author + " | " + status;
    }
    }
