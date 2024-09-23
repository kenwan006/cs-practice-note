
## classes and relationship

### Library
- properties: name, address, books, members, admin, catalog
- behavior: addBook(), removeBook(), registerMember(), searchBook()..

### Book
- properties: bookId, name, author, subject, status, renter
- behavior: getDetails(), checkStatus()

### Member
- properties: memberId, name, contactInfo, borrowedBooks
- behavior: borrowBook(), reserveBook(), returnBook(), cancelReservation()

### Admin
- properties: Id, name, contact
- behavior: 
  - for member: issueBook(), returnBook(), reserveBook()
  - addBook(new book), removePermanently()

### Borrow Record
- properties: book, member, borrow date, return date
- behavior:

### Reservation
- properties: book, member, reservation date
- cancelReservation()

### Catalog
- properties: books by subject,  books by author
- getBySubject(), getByAuthor(), addToCatalog(), removeFromCatalog()
