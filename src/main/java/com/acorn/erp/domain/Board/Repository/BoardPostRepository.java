package com.acorn.erp.domain.Board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acorn.erp.domain.Board.Entity.BoardPost;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long>{

}
