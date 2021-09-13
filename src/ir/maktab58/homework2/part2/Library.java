package ir.maktab58.homework2.part2;

public class Library {
    private Book[] books = new Book[50];
    private int[] countOfEachBook = new int[50];
    private int currentIndexOfBook = 0;
    private Member[] members = new Member[50];
    private int currentMemberIndex = 0;
    static int initMemberId = 20;
    private int currentMemberId = initMemberId;
    static int initBookId = 1000;
    private int currentBookId = initBookId;

    public void addBook(String name, int count) {
        for (int i = 0; i < currentIndexOfBook; i++) {
            if (name.equals(books[i].getBookTitle())) {
                countOfEachBook[i] += count;
                return;
            }
        }

        if (currentIndexOfBook >= 50) {
            System.out.println("Sorry! " + "current index of books is: " + currentIndexOfBook);
            System.out.println("Unable to add new book.");
            return;
        }

        books[currentIndexOfBook] = new Book(name, currentBookId);
        countOfEachBook[currentIndexOfBook] = count;
        currentBookId++;
        currentIndexOfBook++;
    }

    public void addMember(String name, int birthDate) {
        for (int i = 0; i < currentMemberIndex; i++)
            if (name.equals(members[i].getFullName()) && members[i].getBirthDate() == birthDate) {
                System.out.println("This member with id = " +
                        members[i].getMemberId() + " is already existed!");
                return;
            }

        if (currentMemberIndex >= 50) {
            System.out.println("Sorry! " + "current index of members is: " + currentMemberIndex);
            System.out.println("Unable to add new member.");
            return;
        }

        members[currentMemberIndex] = new Member(name, birthDate, currentMemberId);
        currentMemberId++;
        currentMemberIndex++;
    }

    public void get(int memberId, int bookId) {
        if ((bookId >= currentBookId) || (bookId < initBookId)) {
            System.out.println("This bookId: " + bookId + " is not existed!");
            return;
        }

        if ((memberId >= currentMemberId) || (memberId < initMemberId)) {
            System.out.println("This memberId: " + memberId + " is not existed!");
            return;
        }

        if (countOfEachBook[bookId - initBookId] == 0){
            System.out.println("NotAvailable: " + books[bookId - initBookId].getBookTitle() + " " + bookId );
            return;
        }

        if (members[memberId - initMemberId].addNewBorrowedBook(books[bookId - initBookId]))
            countOfEachBook[bookId - initBookId] -= 1;
    }

    public void returnBook(int memberId, int bookId){
        if ((bookId >= currentBookId) || (bookId < initBookId)) {
            System.out.println("This bookId: " + bookId + " is not existed!");
            return;
        }

        if ((memberId >= currentMemberId) || (memberId < initMemberId)) {
            System.out.println("This memberId: " + memberId + " is not existed!");
            return;
        }

        boolean checker = members[memberId-initMemberId].removeBorrowedBook(books[bookId - initBookId]);
        if (checker)
            countOfEachBook[bookId - initBookId] += 1;
        else
            System.out.println("This memberId: " + memberId + " has not borrowed this bookId: " + bookId);
    }

    public void bookStat(){
        for (int i = 0; i < currentIndexOfBook; i++)
            System.out.println(books[i].getBookTitle() + " " + books[i].getBookId() + " " + countOfEachBook[i]);
    }

    public void memberStat(){
        for (int i = 0; i < currentMemberIndex; i++){
            System.out.println(members[i].getFullName() + " " + members[i].getMemberId()
                    + " " + members[i].listOfBorrowedBooks());
        }
    }
}
