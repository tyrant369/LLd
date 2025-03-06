package com.Library.repository;

import com.Library.model.Member;

public interface MemberInterface {

    Member findById(String memberId);
}
