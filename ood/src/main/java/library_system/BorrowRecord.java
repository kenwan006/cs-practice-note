package library_system;

import java.util.Date;

public class BorrowRecord {
    private String id;
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;

    public BorrowRecord(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowDate = new Date();
    }

    public Book getBook() {
        return book;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String toString() {
        return "BorrowRecord{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", member=" + member +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
