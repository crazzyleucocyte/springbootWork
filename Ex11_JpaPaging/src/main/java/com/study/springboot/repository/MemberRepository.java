package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.doain.Member;

@Repository												// 		여기는 @Id가 붙은 필드의 자료형
public interface MemberRepository extends JpaRepository<Member,Long>{


	Page<Member> findByNameLike(String search, Pageable pr);

}
