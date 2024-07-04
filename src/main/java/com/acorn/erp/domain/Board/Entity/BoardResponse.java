package com.acorn.erp.domain.Board.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardResponse {
	private Long id;
	private String name;
	private String description;
}
