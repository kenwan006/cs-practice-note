package libray;

import java.util.Date;

public class Reservation {
    private Book book;
    private Member member;
    private Date reservationDate;

    public Reservation( Book book, Member member, Date reservationDate) {
        this.book = book;
        this.member = member;
        this.reservationDate = reservationDate;
    }

    public Book getBook() {
        return book;
    }

    public String toString() {
        return "Reservation{" +
                "book=" + book +
                ", member=" + member +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
