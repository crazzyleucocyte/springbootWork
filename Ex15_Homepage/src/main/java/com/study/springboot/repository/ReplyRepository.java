package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

	@Query(value="select * from REPLY where ref_bno= :refBno", nativeQuery=true)
	List<Reply> findByRefBno(@Param("refBno") Long refBno);

}
