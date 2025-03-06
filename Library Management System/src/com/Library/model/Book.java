package com.Library.model;

import java.util.Date;

public class Book {

    private String title;
    private String author;
    private String ISBN;
    private BookCategory category;
    private boolean isAvailable;
    private Date dueDate;

    public Book(String title, String author, String ISBN, BookCategory category, boolean isAvailable, Date dueDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.category = category;
        this.isAvailable = isAvailable;
        this.dueDate = dueDate;
    }

    public Book(String title, String author, String ISBN, BookCategory category) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.category = category;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", category=" + category +
                ", isAvailable=" + isAvailable +
                ", dueDate=" + dueDate +
                '}';
    }
}
