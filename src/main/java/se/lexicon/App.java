package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {
        // todo: needs completion
        // Initialize and display Book & Person instances
        // Simulate borrowing a book
        // Simulate returning a book

        // Create 3 Persons
        Person boti = new Person("Botond", "Medgyesi");
        System.out.println(boti.getPersonalInformation());
        System.out.println("=====================");
        Person melhem = new Person("Melhem", "Mohamed");
        System.out.println(melhem.getPersonalInformation());
        System.out.println("=====================");
        Person adam = new Person("Adam", "Karlsson");
        System.out.println(adam.getPersonalInformation());
        System.out.println("=====================");
        System.out.println("=====================");

        //Create 2 books
        Book book1 = new Book("Lord Of The Rings", "IDK Man");
        System.out.println(book1.getBookInformation());
        System.out.println("=====================");
        Book book2 = new Book("Moby-Dick", "IDK Man", melhem);
        System.out.println(book2.getBookInformation());
        System.out.println("=====================");
        book2.setBorrower(null);
        System.out.println(book2.getBookInformation());


        // Borrow a book
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println(melhem.getBorrowedBooks().length);
        System.out.println(book1.isAvailable());
        melhem.loanBook(book1);
        System.out.println(melhem.getBorrowedBooks().length);
        System.out.println(book1.isAvailable());


        // Return a book
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println(melhem.getBorrowedBooks().length);
        System.out.println(book1.isAvailable());
        melhem.returnBook(book1);
        System.out.println(melhem.getBorrowedBooks().length);
        System.out.println(book1.isAvailable());



    }

}
