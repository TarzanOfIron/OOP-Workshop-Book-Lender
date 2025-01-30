package se.lexicon.model;


import java.util.UUID;

/**
 * This class represents a Book model with properties and methods
 * to manage book-related information and operations.
 */
public class Book {

    // Fields
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;


    // Constructors

    public Book(String title, String author, Person borrower) {
        setTitle(title);
        setAuthor(author);
        setBorrower(borrower);
        setId();
    }

    public Book(String title, String author) {
        this(title, author, null);
    }


    // Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }

    public String getBookInformation() {
        return "Title: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nBook id " + getId() +
                "\nIs avaliable: " + isAvailable() +
                "\nBorrowed by " + getBorrower();

    }


    // Setters

    private void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setBorrower(Person borrower) {
        if (available){
            this.borrower = borrower;
        }
        setAvailable(borrower == null);
        borrower.loanBook(this);
    }
}