package library_system;

public class Book {
    private String bookId;
    private String name;
    private String author;
    private String subject;
    private String status; //borrowed, reserved, available
    private Member renter;

    public Book(String name, String author, String subject) {
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.status = "available"; //default status
    }

    public String getStatus() {
       return status;
   }

   public String getName() {
        return name;
   }

   public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                '}';
   }

    public void setRenter(Member renter) {
        this.renter = renter;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
       return subject;
    }

    public String  getAuthor() {
        return author;
    }
}
