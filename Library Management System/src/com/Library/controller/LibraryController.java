package com.Library.controller;

import com.Library.Service.LibraryService;
import com.Library.model.Book;
import com.Library.model.BookCategory;
import com.Library.model.Member;

public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // Add a book
    public void addBook(Book book) {
        libraryService.addBook(book);
    }

    // Remove a book
    public void removeBook(Book book) {
        libraryService.removeBook(book);
    }

    // Add a member
    public void addMember(Member member) {
        libraryService.addMember(member);
    }

    // Issue a book to a member
    public void issueBook(Member member, Book book) {
        libraryService.issueBook(member, book);
    }

    // Return a book from a member
    public void returnBook(Member member, Book book) {
        libraryService.returnBook(member, book);
    }

    // Search for a book by title
    public void searchByTitle(String title) {
        libraryService.searchByTitle(title);
    }

    // Search for a book by author
    public void searchByAuthor(String author) {
        libraryService.searchByAuthor(author);
    }

    // Filter books by category
    public void filterByCategory(BookCategory category) {
        libraryService.filterByCategory(category);
    }
}

