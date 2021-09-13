package ir.maktab58.homework2.part2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library myLibrary = new Library();
        System.out.println("********** Welcome to our library! **********");
        while (true){
            String inputLine = input.nextLine();
            if (inputLine.length() == 0){
                System.out.println("Invalid Input! Please try again!");
                continue;
            }
            inputLine = deleteLastSpaces(inputLine);
            String[] splitInputLine = inputLine.split(" ");

            if (splitInputLine[0].equals("bookStat"))
                myLibrary.bookStat();

            else if (splitInputLine[0].equals("memberStat"))
                myLibrary.memberStat();

            else if (splitInputLine[0].equals("addBook")){
                if (splitInputLine.length != 3) {
                    System.out.println("Invalid Input! Please try again!");
                    System.out.println("Your input line must be like: addBook bookName count.");
                    continue;
                }
                boolean checker = isItInteger(splitInputLine[2]);
                if (checker){
                    myLibrary.addBook(splitInputLine[1], Integer.parseInt(splitInputLine[2]));
                    //System.out.println(splitInputLine[1] + " is successfully added.");
                } else {
                    System.out.println(splitInputLine[2] + " is not an integer!");
                    System.out.println("Please try again!");
                    continue;
                }
            }

            else if(splitInputLine[0].equals("addMember")) {
                if (splitInputLine.length != 3) {
                    System.out.println("Invalid Input! Please try again!");
                    System.out.println("Your input line must be like: addMember memberName memberBirthDate.");
                    continue;
                }
                boolean checker = isItInteger(splitInputLine[2]);
                if (checker){
                    int birthDate = Integer.parseInt(splitInputLine[2]);
                    if ((birthDate > 1300) && (birthDate < 1400)){
                        myLibrary.addMember(splitInputLine[1], birthDate);
                        //System.out.println(splitInputLine[1] + " is successfully added.");
                    } else
                        System.out.println("Birth Date: " + birthDate + " is not valid! Please try again!");
                } else {
                    System.out.println(splitInputLine[2] + " could not be a birthDate!");
                    System.out.println("Please try again!");
                    continue;
                }
            }

            else if(splitInputLine[0].equals("get")){
                if (splitInputLine.length != 3) {
                    System.out.println("Invalid Input! Please try again!");
                    System.out.println("Your input line must be like: get memberId bookId.");
                    continue;
                }
                boolean checker = isItInteger(splitInputLine[1]) && isItInteger(splitInputLine[2]);
                if (checker){
                    int memberId = Integer.parseInt(splitInputLine[1]);
                    int bookId = Integer.parseInt(splitInputLine[2]);
                    myLibrary.get(memberId, bookId);
                    } else {
                    System.out.println("Both " + splitInputLine[1] + " and " + splitInputLine[2] + " must be valid integers");
                    System.out.println("Please try again!");
                    continue;
                }
            }

            else if(splitInputLine[0].equals("return")){
                if (splitInputLine.length != 3) {
                    System.out.println("Invalid Input! Please try again!");
                    System.out.println("Your input line must be like: return memberId bookId.");
                    continue;
                }
                boolean checker = isItInteger(splitInputLine[1]) && isItInteger(splitInputLine[2]);
                if (checker){
                    int memberId = Integer.parseInt(splitInputLine[1]);
                    int bookId = Integer.parseInt(splitInputLine[2]);
                    myLibrary.returnBook(memberId, bookId);
                } else {
                    System.out.println("Both " + splitInputLine[1] + " and " + splitInputLine[2] + " must be valid integers");
                    System.out.println("Please try again!");
                    continue;
                }
            }

            else if(splitInputLine[0].equals("exit"))
                break;

            else {
                System.out.println("Invalid command");
                System.out.println("Please try again!");
                continue;
            }

        }
    }

    public static String deleteLastSpaces(String inputLine){
        if (inputLine.charAt(inputLine.length() - 1) != ' ')
            return inputLine;

        inputLine = inputLine.substring(0, inputLine.length() - 2);
        return deleteLastSpaces(inputLine);
    }

    public static boolean isItInteger(String tempToken){
        for (int i = 0; i < tempToken.length(); i++){
            if ((tempToken.charAt(i) < 48) || (tempToken.charAt(i) > 57))
                return false;
        }
        return true;
    }
}
