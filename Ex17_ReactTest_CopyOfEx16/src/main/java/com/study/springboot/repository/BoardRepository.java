package com.study.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

	
	Page<Board> findByTitleLike(PageRequest page, String keyWord);
	
	Page<Board> findByWriterLike(PageRequest page, String keyWord);

	Page<Board> findByContentLike(PageRequest page, String keyWord);

}
