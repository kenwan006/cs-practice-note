package library_system;

import java.util.List;

public class LibraryDemo {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Library library = new Library("LA library", "100 West Valley Blvd", catalog);

        Admin admin = new Admin("john", "213-284-8290", library);
        Member mike = new Member("mike", "213-284-8291");
        Member ken = new Member("ken", "213-284-8292");
        library.register(admin);
        library.register(mike);
        library.register(ken);

        //add new books to the library
        Book book1 = new Book("data structure", "robert chu", "cs");
        Book book2 = new Book("distributed system", "john doe", "cs");
        Book book3 = new Book("operating system", "robert chu", "cs");
        Book book4 = new Book("algebra basics", "hector rod", "math");
        Book book5 = new Book("linear geometry", "nancy james", "math");

        admin.addBook(book1);
        admin.addBook(book2);
        admin.addBook(book3);
        admin.addBook(book4);
        admin.addBook(book5);

        //check the catalog
        List<String> list1 = library.getBooksByAuthor("robert chu");
        System.out.println("books written by robert chu: " + list1);
        List<String> list2 = library.getBooksBySubject("cs");
        System.out.println("books related to cs: " + list2);


        //mike borrow a book
        admin.issueBook(book1, mike);
        admin.issueBook(book4, mike);

        //mike reserve a book
        admin.reserveBook(book2, mike);
        admin.reserveBook(book3, ken);

        //ken borrow a unavailable book
        admin.issueBook(book2, ken);

        //mike cancel reservation and ken borrow it again
        admin.cancelReservation(book2, mike);

        //mike return a book
        admin.returnBook(book4, mike);

        //admin check all the open reservations
        List<Reservation> reservations = admin.getReservationsByMember(ken);
        reservations.forEach(System.out::println);

        //admin check add the borrow records
        List<BorrowRecord> records = admin.getRecordsByMember(mike);
        records.forEach(System.out::println);



    }
}
