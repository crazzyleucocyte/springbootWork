package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.doain.Member;

@Repository												// 		여기는 @Id가 붙은 필드의 자료형
public interface MemberRepository extends JpaRepository<Member,Long>{
	//JpaRepository<Member,Long> 에서 제네릭은 객체와 primary key의 자료형을 적어주었다.
	//이 인터페이스를 구현만 하면 편하게 sql을 할 수 있다.
	//JPA를 쓸때 여기는 따로 적을 코드가 없고 그냥 인터페이스만 구현하면 된담
}
