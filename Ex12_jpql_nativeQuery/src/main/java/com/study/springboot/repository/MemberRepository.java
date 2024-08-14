package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.doain.Member;

@Repository												// 		여기는 @Id가 붙은 필드의 자료형
public interface MemberRepository extends JpaRepository<Member,Long>{

	/*
	 * JPQL(Java Persistence Query Language)
	 	: JPA의 QUERY Methods만으로는 조회가 불가능한 경우
	 	  JPQL을 이용하여 SQL과 비슷한 형태의 쿼리를 작성하여 조회
	 	  
	 * nativeQuery
	 	: SQL문을 직접 덩의하여 사용하는 방식
		
	*/
	//JPQL 쿼리 : from뒤에는 영속성에 있는 엔티티명(DB테이블이 아님. 영속성 테이블명은 반드시 대문자로)
	//				:name가 넘어온 값을 받는 곳
	@Query("select j  from JPAPAGING j where j.name like :name order by j.name desc")
	//"select j.id, j,name, j  from JPAPAGING j where m.name like :name order by j.id desc"
	//여기에서 항상 테이블명에 별칭을 붙여서 사용해야하고 where절에서 :뒤에 쓰는 변수명은 매개변수가 아닌 파라미터로 받는 값을 써줘야 한다. 
	List<Member> findByNameLike(@Param("name") String search);

	@Query("select j  from JPAPAGING j where j.name like :name ")
	List<Member> findMembers(@Param("name") String search, Sort sort);

	
	@Query("select j  from JPAPAGING j where j.name like :name ")
	Page<Member> findMembers(@Param("name") String search, Pageable pageable);

	//일반 sql쿼리 : 테이블명 등 대소문자 가리지 않음
	//nativeQuery=true의 뜻은 sql쿼리문과 똑같이 쓰겠다는 뜻
	@Query(value="select * from jpapaging where name like :name order by id desc", nativeQuery=true)
	List<Member> findMembers(@Param("name") String search);

	
	
	

}










