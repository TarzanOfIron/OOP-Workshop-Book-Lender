package se.lexicon.model;


import java.util.Arrays;

/**
 * This class represents a Person model with properties and methods
 * to manage personal details and interactions with the library system.
 */
public class Person {

    // Fields
    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private Book[] borrowedBooks = new Book[0];


    // Constructors
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setId();
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getPersonalInformation () {
        return  "First name: " + getFirstName() +
                "\nLast name: " + getLastName() +
                "\nId: " + getId() +
                "\nBorrowed books: " + Arrays.toString(getBorrowedBooks());
    }


    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId() {
        this.id = getNextId();
        sequencer++;
    }


    // Methods
    private static int getNextId() {
        return sequencer;
    }

    public void loanBook(Book book) {
        Book[] borrowedBooksPlus = Arrays.copyOf(borrowedBooks, borrowedBooks.length + 1);
        borrowedBooksPlus[borrowedBooksPlus.length - 1] = book;
        borrowedBooks = borrowedBooksPlus;
        book.setBorrower(this);
    }

    public void returnBook(Book book) {
        Book[] borrowedBooksMinus = new Book[borrowedBooks.length - 1];
        for (int i = 0, j = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == book) {
                continue;
            }
            borrowedBooksMinus[j++] = borrowedBooks[i];
        }
        borrowedBooks = borrowedBooksMinus;
        book.setBorrower(null);
    }

}