package com.Library.Service;

import com.Library.model.Book;
import com.Library.model.BookCategory;
import com.Library.model.Member;
import com.Library.repository.BookRepository;
import com.Library.repository.MemberRepository;

import java.util.List;

public class LibraryService {

    private MemberRepository memberRepository;
    private MemberService memberService;
    private BookRepository bookRepository;

    public LibraryService(MemberRepository memberRepository, MemberService memberService, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.memberService = memberService;
        this.bookRepository = bookRepository;
    }

    // Add a book
    public void addBook(Book book) {
        bookRepository.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Remove a book
    public void removeBook(Book book) {
        bookRepository.removeBook(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    // Add a member
    public void addMember(Member member) {
        memberRepository.addMember(member);
        System.out.println("Member added: " + member.getName());
    }

    // Issue a book to a member
    public void issueBook(Member member, Book book) {
        if (bookRepository.getBooks().contains(book) && memberRepository.getMembers().contains(member)) {
            memberService.borrowBook(member, book);
        } else {
            System.out.println("Book or member not found.");
        }
    }

    // Return a book from a member
    public void returnBook(Member member, Book book) {
        if (memberRepository.getMembers().contains(member)) {
            memberService.returnBook(member, book);
        } else {
            System.out.println("Member not found.");
        }
    }

    // Search for a book by title
    public void searchByTitle(String title) {
        List<Book> result = bookRepository.searchByTitle(title);
        if (result.isEmpty()) {
            System.out.println("No books found with title: " + title);
        } else {
            result.forEach(System.out::println);
        }
    }

    // Search for a book by author
    public void searchByAuthor(String author) {
        List<Book> result = bookRepository.searchByAuthor(author);
        if (result.isEmpty()) {
            System.out.println("No books found by author: " + author);
        } else {
            result.forEach(System.out::println);
        }
    }

    // Filter books by category
    public void filterByCategory(BookCategory category) {
        List<Book> result = bookRepository.filterByCategory(category);
        if (result.isEmpty()) {
            System.out.println("No books found in category: " + category);
        } else {
            result.forEach(System.out::println);
        }
    }
}
