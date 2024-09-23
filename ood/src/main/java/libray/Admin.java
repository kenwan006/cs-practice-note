package libray;

import java.sql.Array;
import java.util.*;

public class Admin {
    private String id;
    private String name;
    private String contact; //phone number
    private Library library;
    private Map<Member, List<Reservation>> allReservations; // open reservation for each member
    private Map<Member, List<BorrowRecord>> allRecords; //borrow records for each member


    public Admin(String name, String contact, Library library) {
        this.name = name;
        this.contact = contact;
        this.library = library;
        allReservations = new HashMap<>();
        allRecords = new HashMap<>();
    }

    //check with the admin if a book is available
    private boolean isAvailable(Book book) {
        if (book.getStatus().equals("available")) {
            return true;
        } else {
            System.out.println(book.getName() + " is not available, please check later");
            return false;
        }
    }

    //issue a book to a member
    public void issueBook(Book book, Member member) {
        if (!isAvailable(book)) return;
        member.borrowBook(book);
        library.removeBook(book);
        BorrowRecord borrowRecord = new BorrowRecord(book, member);
        allRecords.putIfAbsent(member, new ArrayList<>());
        allRecords.get(member).add(borrowRecord);
    }

    //add a book returned by member
    public void returnBook(Book book, Member member) {
        for (BorrowRecord record : allRecords.get(member)) {
            if (record.getBook() == book) {
                record.setReturnDate(new Date()); //update the return date for this borrow record
            }
        }
        member.returnBook(book); //update the status
        library.addBook(book);
    }

    //reserve a book for a member
    public void reserveBook(Book book, Member member) {
        if (!isAvailable(book)) return;
        member.reserveBook(book);
        Reservation reservation = new Reservation(book, member, new Date());
        allReservations.putIfAbsent(member, new ArrayList<>());
        allReservations.get(member).add(reservation);
    }

    //cancel a reservation on a book
    public void cancelReservation(Book book, Member member) {
        for (Reservation reservation : allReservations.get(member)) {
            if (reservation.getBook() == book) {
                allReservations.remove(reservation);
            }
        }
        member.cancelReservation(book);
    }

    //add a new book
    public void addBook(Book book) {
        library.addNewBook(book);
    }

    //remove a book from library permanently
    public void removeBook(Book book) {
        library.removePermanently(book);
    }

    public List<Reservation> getReservationsByMember(Member member) {
        return allReservations.get(member);
    }

    public List<BorrowRecord> getRecordsByMember(Member member) {
        return allRecords.get(member);
    }
}
