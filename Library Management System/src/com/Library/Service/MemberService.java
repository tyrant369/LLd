package com.Library.Service;

import com.Library.model.Book;
import com.Library.model.Member;
import com.Library.model.StudentMember;
import com.Library.utils.FineCalculator;

import java.util.Date;

public class MemberService {

    // Borrow a Book
    public void borrowBook(Member member, Book book) {

        if (book.isAvailable()) {
            member.addBorrowedBook(book);
            book.setAvailable(false);
            long twoWeeksInMillis = 14 * 24 * 60 * 60 * 1000L;
            book.setDueDate(new Date(System.currentTimeMillis() + twoWeeksInMillis));

            System.out.println(member.getName() + " borrowed the book: " + book.getTitle());
        }

        else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is not available.");
        }
    }

    // Return Book
    public void returnBook (Member member, Book book) {

        if (member.getBorrowedBooks().contains(book)) {
            member.removeBorrowedBook(book);
            book.setAvailable(true);
            book.setDueDate(null);

            System.out.println(member.getName() + " returned the book: " + book.getTitle());

            double fine = FineCalculator.calculateFine(book, member instanceof StudentMember ? 0.25 : 0.10);

            if (fine > 0) System.out.println("Fine for late return: $" + fine);

            else System.out.println("You did not borrow this book.");
        }
    }
}
