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
    
    // 댓글 추가
    @PostMapping("/posts/{postId}/comments")
    public BoardPost addCommentToPost(@PathVariable("postId") Long postId, @RequestBody String commentContent) {
        return boardPostService.addCommentToPost(postId, commentContent);
    }
    
    // 특정 페이지의 게시물 조회 (페이지네이션)
    @GetMapping("/posts")
    public List<BoardPost> getPageOfBoardPosts(@RequestParam("page") int page, @RequestParam("size") int size) {
        return boardPostService.getPageOfBoardPosts(page, size);
    }
    
    @GetMapping("/search")
    public List<BoardPost> searchBoardPosts(@RequestParam("keyword") String keyword) {
        return boardPostService.searchBoardPosts(keyword);
    }

}
