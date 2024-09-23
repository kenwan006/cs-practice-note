package libray;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    Catalog catalog;
    private List<Book> books;
    private List<Member> members;
    private Admin admin;

    public Library(String name, String address, Catalog catalog) {
        this.name = name;
        this.address = address;
        this.catalog = catalog;
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void register(Member member) {
        members.add(member);
    }

    public void register(Admin admin) {
        this.admin = admin;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addNewBook(Book book) {
        addBook(book);
        catalog.addToCatalog(book);
    }

    public void removePermanently(Book book) {
        removeBook(book);
        catalog.removeFromCatalog(book);
    }

    public List<String> getBooksByAuthor(String author) {
        return catalog.getBooksByAuthor(author);
    }

    public List<String> getBooksBySubject(String subject) {
        return catalog.getBooksBySubject(subject);
    }

    }
