package com.kh.spring.board.dto;

import lombok.Data;

/**
 * * DTO (Data Transfer Object) : 통신/흐름 간에 저장되어야 할 데이터
 */
@Data
public class SearchDto {
	private String condition;	// 검색조건
	private String keyword;		// 검색어
}
