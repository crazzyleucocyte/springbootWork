package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;

	public boolean idCheck(String id) {

		//id가 존재하는지 db검색하여 반환 결과 true of false반환
		return memberRepository.existsById(id);
	}

	public Member memberInsert(Member m) {
		return memberRepository.save(m);
		
	}

	public Optional<Member> login(Member m) {
		return memberRepository.findById(m.getId());
	}
}
