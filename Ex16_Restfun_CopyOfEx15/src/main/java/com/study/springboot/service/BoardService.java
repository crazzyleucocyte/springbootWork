package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public void insertBoard(Board b) {
		boardRepository.save(b);
	}

	public Page<Board> list(PageRequest page) {

		return boardRepository.findAll(page);
	}

	public Optional<Board> selectById(Long bno) {
		return boardRepository.findById(bno);
	}

	public Board updateCount(Board board) {
		board.setCount(board.getCount()+1);
		return boardRepository.save(board);
	}

	public void deleteBoard(Long bno) {
		boardRepository.deleteById(bno);
	}

	public Page<Board> searchListByTitleLike(PageRequest page,  String keyWord) {
		
		return boardRepository.findByTitleLike(page, keyWord);	
	}

	public Page<Board> searchListByWriterLike(PageRequest page,  String keyWord) {
		// TODO Auto-generated method stub
		return boardRepository.findByWriterLike(page, keyWord);		
		}

	public Page<Board> searchListByContentLike(PageRequest page, String keyWord) {
		// TODO Auto-generated method stub
		return boardRepository.findByContentLike(page, keyWord);	
		}

}
