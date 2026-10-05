import java.util.*;

public class LibraryManager {
    private ArrayList<Book> books;
    int userCheckedOutCount;

    public LibraryManager() {
        this.books = new ArrayList<>(Arrays.asList(
                new Book("The Hobbit", false),
                new Book("1984", false),
                new Book("To Kill a Mockingbird", false),
                new Book("The Great Gatsby", false)));
        this.userCheckedOutCount = 0;
    }

    public void checkOutBook(String title)
            throws BookNotFoundException, BookCheckedOutException, UserMaxLimitExceededException {
        if (userCheckedOutCount >= 3) {
            throw new UserMaxLimitExceededException("User has reached the maximum checkout limit of 3 books.");
        }
        boolean bookFound = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                bookFound = true;
                if (b.isCheckedOut) {
                    throw new BookCheckedOutException(title + " is already checked out.");
                } else {
                    b.isCheckedOut = true;
                    userCheckedOutCount++;
                    System.out.println("Success: '" + title + "' has been checked out.");
                    return;
                }
            }
        }
        if (bookFound == false) {
            throw new BookNotFoundException(title + " could not be found in the catalog.");
        }
        return;
    }
}

class Book {
    String title;
    boolean isCheckedOut;

    public Book() {
        this("Undefined.", false);
    }

    public Book(String title, boolean isCheckedOut) {
        this.title = title;
        this.isCheckedOut = isCheckedOut;
    }
}