package com.Library.model;

import java.util.List;

public class FacultyMember extends Member{
    public FacultyMember(String name, String memberId, List<Book> borrowedBooks) {
        super(name, memberId, borrowedBooks);
    }

    public FacultyMember(String name, String memberId) {
        super(name, memberId);
    }
}
