package Day_08;

class Book {
    String title;
    String author;
    double price;
    String isbn;

    
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
        this.isbn = "N/A";
        System.out.println("Default Constructor called.");
    }


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.isbn = "N/A";
        System.out.println("Constructor with 2 parameters (Title, Author) called.");
    }

    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = "N/A";
        System.out.println("Constructor with 3 parameters (Title, Author, Price) called.");
    }

    
    public Book(String title, String author, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        System.out.println("Constructor with 4 parameters (Title, Author, Price, ISBN) called.");
    }

    
    public void displayDetails() {
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Price:  $" + price);
        System.out.println("ISBN:   " + isbn);
        System.out.println("----------------------------------------");
    }
}

public class practical_804 {
    public static void main(String[] args) {
        System.out.println("=== Instantiating using Default Constructor ===");
        Book book1 = new Book();
        book1.displayDetails();

        System.out.println("=== Instantiating with Title and Author ===");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");
        book2.displayDetails();

        System.out.println("=== Instantiating with Title, Author, and Price ===");
        Book book3 = new Book("Atomic Habits", "James Clear", 15.99);
        book3.displayDetails();

        System.out.println("=== Instantiating with Title, Author, Price, and ISBN ===");
        Book book4 = new Book("Java: The Complete Reference", "Herbert Schildt", 45.50, "978-1260440232");
        book4.displayDetails();
    }
}
