package com.Library.utils;

import com.Library.model.Book;

import java.util.Date;

public class FineCalculator {

    public static double calculateFine(Book book, double ratePerDay) {

        if (book.getDueDate() != null && book.getDueDate().before(new Date())) {

            long daysLate = (System.currentTimeMillis() - book.getDueDate().getTime()) / 24 * 60 * 60 * 1000;

            return daysLate * ratePerDay;
        }

        return 0.0;
    }
}
