package ir.maktab58.homework2.part2;

public class Book {
    private String bookTitle;
    private int bookId;

    public Book(String bookTitle, int bookId) {
        this.bookTitle = bookTitle;
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
