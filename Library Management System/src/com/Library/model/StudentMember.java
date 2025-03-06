package com.Library.model;

import java.util.List;

public class StudentMember extends Member{
    public StudentMember(String name, String memberId, List<Book> borrowedBooks) {
        super(name, memberId, borrowedBooks);
    }

    public StudentMember(String name, String memberId) {
        super(name, memberId);
    }
}
