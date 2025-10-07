package LibrarySD;

public class Main {

    public static void main(String[] args) {
        BookStore store = new BookStore();

        Book b1 = new Book("Harry Potter","JK" ,"Harry went to Hogwarts. Harry met Ron and Hermione.");
        Book b2 = new Book("Lord of the Rings", "JK","Frodo carried the ring to Mordor.");

        store.addBook(b1);
        store.addBook(b2);


        System.out.println("Count of 'Harry' in Harry Potter: " +
                store.getWordCountFromBook("Harry Potter", "Harry"));
        System.out.println("Count of 'ring' in Lord of the Rings: " +
                store.getWordCountFromBook("Lord of the Rings", "ring"));

        try {
            System.out.println(store.getWordCountFromBook("JK", "Harry"));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
