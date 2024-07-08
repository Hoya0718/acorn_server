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
	    
	    public BoardPost addCommentToPost(Long postId, String commentContent) {
	        BoardPost post = boardPostRepository.findById(postId).orElse(null);
	        if (post != null) {
	            int currentComments = post.getComments();
	            post.setComments(currentComments + 1); // 댓글 수 증가
	            post.setCommentContent(commentContent); // 댓글 내용 설정
	            return boardPostRepository.save(post);
	        }
	        return null;
	    }
	    
	    public List<BoardPost> searchBoardPosts(String keyword) {
	        // 제목에 키워드가 포함된 게시물을 검색
	        return boardPostRepository.findByTitleContaining(keyword);
	    }
	    
	    // 특정 페이지의 게시물 목록 조회
	    public List<BoardPost> getPageOfBoardPosts(int page, int size) {
	        // 페이지 번호를 0부터 시작하므로 실제 조회할 페이지 번호는 (page - 1)
	        return boardPostRepository.findPageOfBoardPosts((page - 1) * size, size);
	    }
}
