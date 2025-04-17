<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Spring Project</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 
 
	 	<style>
	        .outer {
	            background-color: #e7e7e7;
	            width: 80%;
	            margin: auto;
	        }
	        .inner-area {
	            border: 1px solid #000025;
	            width: 80%;
	            margin: auto;
	            padding: 5% 15%;
	            background: #e7ecf7;
	        }
	        
	        table {width:100%;}
	        table * {margin:5px;}
	    </style>    
 
 
	</head>
	
	<body>
	
			<%-- <h2>Hello, Spring</h2> --%>
			
			<%-- 헤더 영역 포함 (common/header.jsp) --%>
			<jsp:include page="common/header.jsp"/>
			
			<main class="outer">
					<br><br>
					<div class="inner-area">
						<h4>게시글 Top 5</h4>
				          <br>
				          <table id="top5-board-list" class="table table-hover" align="center">
				              <thead>
				                  <tr>
				                      <th>글번호</th>
				                      <th>제목</th>
				                      <th>작성자</th>
				                      <th>조회수</th>
				                      <th>작성일</th>
				                      <th>첨부파일</th>
				                  </tr>
				              </thead>
				              <tbody align="center">
				                  <tr>
				                      <td colspan="6" rowspan="4" align="center">
				                          <div class="spinner-border text-primary"></div>
				                      </td>
				                  </tr>
				              </tbody>
				          </table>			
					</div>		
				</main>
			
			<%-- 푸터 영역 포함 (common/footer.jsp) --%>
			<jsp:include page="common/footer.jsp"/>
	</body>
	
	
	<script>
	
	
	
		window.addEventListener('load', function() {
    
    	function selectBoardTop5() {
    	   // * 자유게시판 TOP5 목록 조회 요청 => 비동기 통신(ajax)
    	     $.ajax({
    	     	url : '/api/board/top5',
    	     	success: function(list) {
    	     		// * 조회 결과를 화면에 표시
    	     		let top5List = "";
    	     		for(const board of list) {
    	     		   top5List += "<tr>"
    	     		   			   + "<td>" + board.boardNo + "</td>"
    	     		   			   + "<td>" + board.boardTitle + "</td>"
    	     		   			   + "<td>" + board.boardWriter + "</td>"
    	     		   			   + "<td>" + board.count + "</td>"
    	     		   			   + "<td>" + board.createDate +"</td>";
    	     		   			   
    	     		   	 if (board.originName != null) {
    	     		   	 	top5List += "<td>■</td>";
    	     		   	 	
    	     		   	 } else {
    	     		   	 	top5List += "<td></td>";    	     		   	     	     		   			   
    	     		   	}
    	     		   	
    	     		   	    top5List += "</tr>";
    	     		}
    	     		 	$("#top5-board-list tbody").html(top5List);
    	     	
    	     	},
    	     	error: function(err) {
    	     	   console.log("**자유 게시판 TOP5 조회 요청 실패 **");
    	     	   console.log(err);
    	     	}
    	     	
    	     })
    	};
    	
    	});
    
   
    </script>
	
</html>