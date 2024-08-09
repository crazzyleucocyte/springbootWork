package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.doain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	public Member insert(Member member) {
		// save() : insert할떄의 메소드(JPA에 API)
//		memberRepository.save(member); 의 반환형은 객체이다.
		Member rMember = memberRepository.save(member);
		return rMember;
	}
	
	/*
		Optional<T> : NullpointerException 발생을 방지하기 위해 사용
					  기존의 반환 값에 타입 T를 Optional<T> 로 Wrapping하여, null 대신 optional안에 빈 타입 객체를 돌려주는 기법
				ex) Member member = memberRepository.findById(id)
				 	member.getId();	  => NullpointerException 발생
	*/
	public Optional<Member> select(Long id) {
		// findById() : Id는 @Id를 의미(primary key)
		// Optional<Member>는 검색 결과가 없을떄 nullpointException을 방지하고자 비어있는 빈을 반환한다.
		Optional<Member> member =memberRepository.findById(id);
		return member;
	}

	public List<Member> selectAll() {
		
		return memberRepository.findAll();
	}

	public Member update(Member member) {
		//save는 해당primary key가 있으면 변경 없으면 추가를 한다.
		return memberRepository.save(member);
	}

	public void delete(Long id) {
		memberRepository.deleteById(id);
		
	}

	public Optional<Member> selectByName(String name) {
		Optional<Member> member = memberRepository.findByUsername(name);
		return member;
	}

	public Optional<Member> selectByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public List<Member> selectByNameLike(String username) {
		return memberRepository.findByUsernameLike(username);
	}

	public List<Member> selectByNameLikeDesc(String username) {
		// TODO Auto-generated method stub
		return memberRepository.findByUsernameLikeOrderByUsernameDesc(username);
	}

	public List<Member> selectByNameLikeDesc(String username, Sort sort) {
		return memberRepository.findByUsernameLike(username,sort);
	}
	
	
}
