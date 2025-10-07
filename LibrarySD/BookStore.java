package LibrarySD;

import java.util.ArrayList;
import java.util.List;

public class BookStore {
    List<Book>books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public Book getByTitile(String title){

        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title)){
                return b;
            }
        }
        return null;
    }

    public int getWordCountFromBook(String title,String word){
        Book book = getByTitile(title);
        return (book != null) ? book.getWordCount(word):0;
    }
}
