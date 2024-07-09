package com.acorn.erp.domain.Board.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.acorn.erp.domain.Board.Entity.BoardPost;
import com.acorn.erp.domain.Board.Service.BoardPostService;
import com.acorn.erp.domain.Login.Entity.userInfo;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/board")
public class BoardPostController {

    private final BoardPostService boardPostService;
    private Map<Long, Set<Long>> userViews = new ConcurrentHashMap<>(); // 조회수 제한을 위한 사용자 조회 기록 Map

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
    public ResponseEntity<BoardPost> getBoardPostById(@PathVariable("id") Long id) {
        try {
            BoardPost post = boardPostService.getBoardPostById(id);
            if (post != null) {
                return ResponseEntity.ok(post);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 게시물 등록
    @PostMapping("/posts")
    public ResponseEntity<BoardPost> createBoardPost(@RequestBody BoardPost boardPost, HttpSession session) {
        userInfo userInfo = (userInfo) session.getAttribute("user");
        if (userInfo != null) {
            // 세션에서 사용자 정보 가져와서 게시물에 추가
            boardPost.setUserId(userInfo.getShopName());
            try {
                BoardPost savedPost = boardPostService.saveBoardPost(boardPost);
                return ResponseEntity.ok(savedPost);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // 댓글 추가
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<BoardPost> addCommentToPost(@PathVariable("postId") Long postId, @RequestBody String commentContent) {
        try {
            BoardPost updatedPost = boardPostService.addCommentToPost(postId, commentContent);
            return ResponseEntity.ok(updatedPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 특정 페이지의 게시물 조회 (페이지네이션)
    @GetMapping("/posts")
    public List<BoardPost> getPageOfBoardPosts(@RequestParam("page") int page, @RequestParam("size") int size) {
        return boardPostService.getPageOfBoardPosts(page, size);
    }

    // 게시물 검색
    @GetMapping("/search")
    public List<BoardPost> searchBoardPosts(@RequestParam("keyword") String keyword) {
        return boardPostService.searchBoardPosts(keyword);
    }

    // 조회수 증가 처리
    @PostMapping("/incrementViews/{postId}")
    public ResponseEntity<?> incrementViews(@PathVariable("postId") Long postId) {
        boardPostService.incrementViews(postId); // 게시물의 조회수 증가 메서드 호출
        return ResponseEntity.ok().build();
    }
}
