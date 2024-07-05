package com.acorn.erp.domain.Board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.acorn.erp.domain.Board.Entity.BoardPost;
import com.acorn.erp.domain.Board.Service.BoardPostService;

@RestController
@RequestMapping("/api/board")
public class BoardPostController {

    private final BoardPostService boardPostService;

    @Autowired
    public BoardPostController(BoardPostService boardPostService) {
        this.boardPostService = boardPostService;
    }

    // 모든 게시물 조회
    @GetMapping("/list")
    public List<BoardPost> getAllBoardPosts() {
        return boardPostService.getAllBoardPosts();
    }

    // 특정 ID의 게시물 조회
    @GetMapping("/posts/{id}")
    public BoardPost getBoardPostById(@PathVariable("id") Long id) {
        return boardPostService.getBoardPostById(id);
    }

    // 게시물 등록
    @PostMapping("/posts")
    public BoardPost createBoardPost(@RequestBody BoardPost boardPost) {
        return boardPostService.saveBoardPost(boardPost);
    }

}
