public class Main {

    public static void checkOut(LibraryManager manager, String title) {
        try {
            manager.checkOutBook(title);
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (BookCheckedOutException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (UserMaxLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        System.out.println("Attempting to check out 'The Hobbit'...");
        checkOut(manager, "The Hobbit");
        System.out.println("\nAttempting to check out 'The Hobbit'...");
        checkOut(manager, "The Hobbit");
        System.out.println("\nAttempting to check out 'Invalid Book Title'...");
        checkOut(manager, "Invalid Book Title");
        System.out.println("\nAttempting to check out '1984'...");
        checkOut(manager, "1984");
        System.out.println("\nAttempting to check out 'To Kill a Mockingbird'...");
        checkOut(manager, "To Kill a Mockingbird");
        System.out.println("\nAttempting to check out 'The Great Gatsby'...");
        checkOut(manager, "The Great Gatsby");
        System.out.println("\nExecution complete: Library system closed safely.");
    }
}
