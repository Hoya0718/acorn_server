package com.acorn.erp.domain.Board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Board.Entity.BoardPost;
import com.acorn.erp.domain.Board.Repository.BoardPostRepository;

@Service
public class BoardPostService {
	private final BoardPostRepository boardPostRepository;
	
	 @Autowired
	    public BoardPostService(BoardPostRepository boardPostRepository) {
	        this.boardPostRepository = boardPostRepository;
	    }

	    // 모든 게시물 가져오기
	    public List<BoardPost> getAllBoardPosts() {
	        return boardPostRepository.findAll();
	    }

	    // 게시물 저장하기
	    public BoardPost saveBoardPost(BoardPost boardPost) {
	        return boardPostRepository.save(boardPost);
	    }

	    // 게시물 상세 정보 가져오기
	    public BoardPost getBoardPostById(Long id) {
	        return boardPostRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("해당 ID의 게시물을 찾을 수 없습니다: " + id));
	    }
}
