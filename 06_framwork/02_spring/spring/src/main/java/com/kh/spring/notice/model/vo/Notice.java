package com.kh.spring.notice.model.vo;



import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor

@Data //@AllArgsConstructor @Getter @Setter @ToString 등이 합쳐진 어노테이션


public class Notice {

	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private Date  createDate;
	
}
