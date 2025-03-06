package com.Library.repository;

import com.Library.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberRepository implements MemberInterface{

    private List<Member> members;

    public MemberRepository () {
        this.members = new ArrayList<>();

        // Add some dummy data
        members.add(new StudentMember("Alice", "M001"));
        members.add(new FacultyMember("Bob", "M002"));
    }

    // Add Member
    public void addMember(Member member) {
        members.add(member);
    }

    // Remove Member
    public void removeMember(Member member) {
        members.remove(member);
    }

    // getAll Members
    public List<Member> getMembers() {
        return members;
    }

    // Find By Id
    @Override
    public Member findById(String memberId) {
        return members.stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }
}
