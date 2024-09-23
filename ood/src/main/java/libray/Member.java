package libray;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String Id;
    private String name;
    private String contact;

    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void borrowBook(Book book) {
        book.setRenter(this);
        book.setStatus("borrowed");
        System.out.println(name + " has borrowed the book: " + book.getName());
    }

    public void reserveBook(Book book) {
        book.setStatus("reserved");
        System.out.println(name + " has reserved the book: " + book.getName());
    }

    public void cancelReservation(Book book) {
        book.setStatus("available");
        System.out.println(name + " has cancelled his reservation for book: " + book.getName());
    }

    public void returnBook (Book book) {
        book.setStatus("available");
        book.setRenter(null);
        System.out.println(name + " has returned the book: " + book.getName());
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
