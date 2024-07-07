package com.acorn.erp.domain.Board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acorn.erp.domain.Board.Entity.BoardPost;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long>{
	List<BoardPost> findByTitleContaining(String keyword);
	
	@Query(value = "SELECT * FROM board_post ORDER BY post_date DESC LIMIT ?1, ?2", nativeQuery = true)
    List<BoardPost> findPageOfBoardPosts(int offset, int size);
}
