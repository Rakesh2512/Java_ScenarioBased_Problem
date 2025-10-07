package LibrarySD;

import java.util.HashMap;
import java.util.Map;

public class Book {

    private String BookId;
    private String BookTitle;
    private String BookAuthor;
    private String Content;
    private Map<String,Integer>wordCache = new HashMap<>();

    public Book(String title,String author,String content){
        this.BookTitle = title;
        this.BookAuthor = author;
        this.Content = content;
    }

    public int getWordCount(String word){
        if(wordCache.containsKey(word)){
            return wordCache.get(word);
        }
        int count = 0;
        for(String w : Content.split("\\W+")){
            if(w.equalsIgnoreCase(word)){
                count++;
            }
        }
        wordCache.put(word, count);
        return count;
    }

    public String getTitle(){
        return BookTitle;
    }
}
