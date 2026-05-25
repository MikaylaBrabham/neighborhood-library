package com.pluralsight;

import java.util.Scanner;


public class NeighborhoodLibrary {

        static Scanner scanner = new Scanner(System.in);

        // ARRAY OF BOOKS
        static Book[] books = new Book[20];

        public static void main(String[] args) {

            loadBooks();

            boolean running = true;

            while (running) {

                System.out.println("\n=== Neighborhood Library ===");

                System.out.println("1 - Show Available Books");

                System.out.println("2 - Show Checked Out Books");

                System.out.println("3 - Exit");

                System.out.print("Choose an option: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        showAvailableBooks();
                        break;

                    case 2:
                        showCheckedOutBooks();
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            }

            System.out.println("Goodbye!");
        }

        // LOAD BOOKS
        public static void loadBooks() {

            books[0] = new Book(1, "111", "Harry Potter");
            books[1] = new Book(2, "222", "The Hobbit");
            books[2] = new Book(3, "333", "Percy Jackson");
            books[3] = new Book(4, "444", "Pride and Prejudice");
            books[4] = new Book(5, "555", "The Hunger Games");
            books[5] = new Book(6, "666", "Dune");
            books[6] = new Book(7, "777", "The Great Gatsby");
            books[7] = new Book(8, "888", "The Catcher in the Rye");
            books[8] = new Book(9, "999", "Jane Eyre");
            books[9] = new Book(10, "1010", "Little Women");
            books[10] = new Book(11, "1111", "1984");
            books[11] = new Book(12, "1212", "Fahrenheit 451");
            books[12] = new Book(13, "1313", "Twilight");
            books[13] = new Book(14, "1414", "The Maze Runner");
            books[14] = new Book(15, "1515", "Divergent");
            books[15] = new Book(16, "1616", "Dracula");
            books[16] = new Book(17, "1717", "Frankenstein");
            books[17] = new Book(18, "1818", "The Odyssey");
            books[18] = new Book(19, "1919", "To Kill a Mockingbird");
            books[19] = new Book(20, "2020", "Moby Dick");
        }

        // SHOW AVAILABLE
        public static void showAvailableBooks() {

            System.out.println("\nAvailable Books:");

            for (Book book : books) {

                if (!book.isCheckedOut()) {

                    System.out.println(
                            book.getId() + " | "
                                    + book.getIsbn() + " | "
                                    + book.getTitle()
                    );
                }
            }

            System.out.print("\nEnter book ID to check out or 0 to exit: ");

            int id = Integer.parseInt(scanner.nextLine());

            if (id == 0) {
                return;
            }

            Book selectedBook = findBookById(id);

            if (selectedBook != null && !selectedBook.isCheckedOut()) {

                System.out.print("Enter your name: ");

                String name = scanner.nextLine();

                selectedBook.checkOut(name);

                System.out.println("com.pluralsight.Book checked out!");
            }
        }

        // SHOW CHECKED OUT
        public static void showCheckedOutBooks() {

            System.out.println("\nChecked Out Books:");

            for (Book book : books) {

                if (book.isCheckedOut()) {

                    System.out.println(
                            book.getId() + " | "
                                    + book.getIsbn() + " | "
                                    + book.getTitle() + " | "
                                    + book.getCheckedOutTo()
                    );
                }
            }

            System.out.println("\nC - Check In com.pluralsight.Book");

            System.out.println("X - Exit");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("C")) {

                System.out.print("Enter com.pluralsight.Book ID to check in: ");

                int id = Integer.parseInt(scanner.nextLine());

                Book selectedBook = findBookById(id);

                if (selectedBook != null && selectedBook.isCheckedOut()) {

                    selectedBook.checkIn();

                    System.out.println("com.pluralsight.Book checked in!");
                }
            }
        }

        // find the book
        public static Book findBookById(int id) {

            for (Book book : books) {

                if (book.getId() == id) {

                    return book;
                }
            }

            return null;
        }
    }




