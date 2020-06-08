package com.steadyman.todo.service;

import com.steadyman.todo.dto.Member;
import com.steadyman.todo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getList() {
        return memberRepository.findAll().stream()
                .map(Member::from)
                .collect(Collectors.toList());
    }

}
