package ir.maktab58.homework2.part2;

public class Member {
    private String fullName;
    private int birthDate;
    private int memberId;
    private Book[] borrowedBooks = new Book[5];
    private int borrowedBooksIndex = 0;

    public Member(String fullName, int birthDate, int memberId) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.memberId = memberId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean addNewBorrowedBook(Book book){
        if (borrowedBooksIndex >= 5) {
            System.out.println("MaxReached: " + this.fullName + " " + this.memberId);
            return false;
        }
        borrowedBooks[borrowedBooksIndex] = new Book(book.getBookTitle(), book.getBookId());
        borrowedBooksIndex++;

        return true;
    }

    public boolean removeBorrowedBook(Book book){
        if (borrowedBooksIndex == 0) {
            return false;
        }

        Book[] newBorrowedBooks = new Book[5];
        boolean checker = false;
        for (int i = 0; i < borrowedBooksIndex; i++){
            if (checker) {
                newBorrowedBooks[i - 1] = new Book(borrowedBooks[i].getBookTitle(),
                            borrowedBooks[i].getBookId());
                continue;
            }

            if (book.getBookTitle().equals(borrowedBooks[i].getBookTitle())) {
                checker = true;
                continue;
            }

            newBorrowedBooks[i] =  new Book(borrowedBooks[i].getBookTitle(),
                        borrowedBooks[i].getBookId());
        }
        if (checker) {
            this.borrowedBooks = newBorrowedBooks;
            borrowedBooksIndex--;
        }
        if (!checker)
            System.out.println("This bookId: " + book.getBookId() + " has not borrowed!");
        return checker;
    }

    public String listOfBorrowedBooks(){
        String result = "";
        for (int i = 0; i < borrowedBooksIndex; i++)
            result += borrowedBooks[i].getBookTitle() + " " + borrowedBooks[i].getBookId() + " - ";
        if (result.length() == 0)
            return "[]";
        else
            return "[" + result.substring(0, result.length() - 3) + "]";
    }
}
