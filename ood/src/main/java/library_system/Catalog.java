package library_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private Map<String, List<Book>> booksByAuthor;
    private Map<String, List<Book>> booksBySubject;

    public Catalog() {
        booksByAuthor = new HashMap<>();
        booksBySubject = new HashMap<>();
    }

    public List<String> getBooksByAuthor(String author) {
        List<String> res = new ArrayList<>();
        for (Book book : booksByAuthor.get(author)) {
            res.add(book.getName());
        }
        return res;
    }
    public List<String> getBooksBySubject(String subject) {
        List<String> res = new ArrayList<>();
        for (Book book : booksBySubject.get(subject)) {
            res.add(book.getAuthor());
        }
        return res;
    }
    //add the book to catalog
    public void addToCatalog (Book book) {
        String author = book.getAuthor();
        String subject = book.getSubject();

        booksByAuthor.putIfAbsent(author, new ArrayList<>());
        booksByAuthor.get(author).add(book);

        booksBySubject.putIfAbsent(subject, new ArrayList<>());
        booksBySubject.get(subject).add(book);
    }
    //remove the book from catalog
    public void removeFromCatalog(Book book) {
        String author = book.getAuthor();
        String subject = book.getSubject();
        booksByAuthor.get(author).remove(book);
        booksBySubject.get(subject).remove(book);
    }

}
