package com.Library.model;

import java.util.List;

public class Member {

    private String name;
    private String memberId;
    List<Book> borrowedBooks;

    public Member(String name, String memberId, List<Book> borrowedBooks) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = borrowedBooks;
    }

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Add a borrowed book
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    // Remove a borrowed book
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

}
