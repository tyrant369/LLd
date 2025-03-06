package com.Library.repository;

import com.Library.model.Book;
import com.Library.model.BookCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository implements Searchable {

    private List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();

        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", BookCategory.FICTION));

        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", BookCategory.FICTION));

        books.add(new Book("Sapiens", "Yuval Noah Harari", "9780062316097", BookCategory.NON_FICTION));
    }

    //add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // remove a book
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Get All Books
    public List<Book> getBooks() {
        return books;
    }

    // Implement Searchable Interface's method
    @Override
    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> filterByCategory(BookCategory category) {
        return books.stream()
                .filter(book -> book.getCategory() == category)
                .collect(Collectors.toList());
    }
}
