package com.acorn.erp.domain.Board.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoardPost {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String title;
	private String author;
	private String postDate;
	private int views;
	private int comments; // 댓글
	private String commentContent; // 댓글 내용
	private String content; // 게시글 내용 
	private String lastModifiedDate; // 수정일
	private String status; // 상태 
	private String userId;

}
  