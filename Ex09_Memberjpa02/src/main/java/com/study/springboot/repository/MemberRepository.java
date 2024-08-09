package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.doain.Member;

@Repository												// 		여기는 @Id가 붙은 필드의 자료형
public interface MemberRepository extends JpaRepository<Member,Long>{
	//JpaRepository<Member,Long> 에서 제네릭은 객체와 primary key의 자료형을 적어주었다.
	//이 인터페이스를 구현만 하면 편하게 sql을 할 수 있다.
	//JPA를 쓸때 여기는 따로 적을 코드가 없고 그냥 인터페이스만 구현하면 된담

	//findBy 뒤에 컬럼명을 붙여주면 컬럼에 해당되는것을 select해준다
	Optional<Member> findByUsername(String name);
	//primary key가 아닌 다른것으로 찾으려면 그냥 findBy---- 이렇게 메소드 이름을 정하면 얘가 알아서 찾아준다.

	Optional<Member> findByEmail(String email);

	List<Member> findByUsernameLike(String username);

	List<Member> findByUsernameLike(String username, Sort sort);

	List<Member> findByUsernameLikeOrderByUsernameDesc(String username);

}
