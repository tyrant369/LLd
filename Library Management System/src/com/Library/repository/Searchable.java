package com.Library.repository;

import com.Library.model.Book;
import com.Library.model.BookCategory;

import java.util.List;

public interface Searchable {

    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    List<Book> filterByCategory(BookCategory category);

}
