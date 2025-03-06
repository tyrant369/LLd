package com.Library;


import com.Library.Service.LibraryService;
import com.Library.Service.MemberService;
import com.Library.controller.LibraryController;
import com.Library.model.*;
import com.Library.repository.BookRepository;
import com.Library.repository.MemberRepository;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        BookRepository bookRepository = new BookRepository();
        MemberRepository memberRepository = new MemberRepository();

        // Initialize services
        MemberService memberService = new MemberService();
        LibraryService libraryService = new LibraryService(memberRepository, memberService, bookRepository);

        // Initialize controller
        LibraryController libraryController = new LibraryController(libraryService);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Member");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search for a Book by Title");
            System.out.println("6. Filter Books by Category");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a Book
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter book category (FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY): ");
                    String categoryInput = scanner.nextLine().toUpperCase();
                    BookCategory category = BookCategory.valueOf(categoryInput);

                    Book newBook = new Book(title, author, ISBN, category);
                    libraryController.addBook(newBook);
                    break;

                case 2:
                    // Add a Member
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberID = scanner.nextLine();
                    System.out.print("Enter member type (STUDENT/FACULTY): ");
                    String memberType = scanner.nextLine().toUpperCase();

                    if (memberType.equals("STUDENT")) {
                        StudentMember studentMember = new StudentMember(memberName, memberID);
                        libraryController.addMember(studentMember);
                    } else if (memberType.equals("FACULTY")) {
                        FacultyMember facultyMember = new FacultyMember(memberName, memberID);
                        libraryController.addMember(facultyMember);
                    } else {
                        System.out.println("Invalid member type. Please try again.");
                    }
                    break;

                case 3:
                    // Issue a Book
                    System.out.print("Enter member ID: ");
                    String issueMemberID = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String issueBookISBN = scanner.nextLine();

                    Member issueMember = memberRepository.findById(issueMemberID);
                    Book issueBook = bookRepository.getBooks().stream()
                            .filter(book -> book.getISBN().equals(issueBookISBN))
                            .findFirst()
                            .orElse(null);

                    if (issueMember != null && issueBook != null) {
                        libraryController.issueBook(issueMember, issueBook);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    break;

                case 4:
                    // Return a Book
                    System.out.print("Enter member ID: ");
                    String returnMemberID = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String returnBookISBN = scanner.nextLine();

                    Member returnMember = memberRepository.findById(returnMemberID);
                    Book returnBook = bookRepository.getBooks().stream()
                            .filter(book -> book.getISBN().equals(returnBookISBN))
                            .findFirst()
                            .orElse(null);

                    if (returnMember != null && returnBook != null) {
                        libraryController.returnBook(returnMember, returnBook);
                    } else {
                        System.out.println("Member or book not found.");
                    }
                    break;

                case 5:
                    // Search for a Book by Title
                    System.out.print("Enter book title: ");
                    String searchTitle = scanner.nextLine();
                    libraryController.searchByTitle(searchTitle);
                    break;

                case 6:
                    // Filter Books by Category
                    System.out.print("Enter book category (FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY): ");
                    String filterCategoryInput = scanner.nextLine().toUpperCase();
                    BookCategory filterCategory = BookCategory.valueOf(filterCategoryInput);
                    libraryController.filterByCategory(filterCategory);
                    break;

                case 7:
                    // Exit
                    exit = true;
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}