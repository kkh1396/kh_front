package com.kh.spring.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
public class Reply {

	private int    replyNo;
	private String replyContent;
	private int    refBno;
	private String replyWriter;
	private Date   createDate;
	private String status;
	
}
