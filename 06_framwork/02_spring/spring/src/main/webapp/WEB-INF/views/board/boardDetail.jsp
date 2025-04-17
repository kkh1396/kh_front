<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList
				 , com.kh.spring.member.model.vo.Member
				 , com.kh.spring.board.model.vo.Board
				 , com.kh.spring.board.model.vo.Reply" %>
<%
	ArrayList<Reply> rlist = (ArrayList<Reply>)request.getAttribute("rlist");
	Member loginUser = (Member)session.getAttribute("loginUser");
	Board board = (Board)request.getAttribute("board");
%>
  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 상세보기</title>
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
    <%-- header --%>
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <br><br>
        <div class="inner-area">
            <h2>게시글 상세보기</h2>
            <br>
            <a href="/board/list" class="btn btn-secondary" style="float:right;">목록보기</a>
            <br><br>

            <table align="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">
                        ${ board.boardTitle }
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>
                         ${ board.boardWriter }
                    </td>
                    <th>작성일</th>
                    <td>
                         ${ board.createDate }
                    </td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
                         <a href="${ board.changeName }" download>${ board.originName }</a>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <p style="height:150px;">
                             ${ board.boardContent }
                        </p>
                    </td>
                </tr>
            </table>
            <br>

			<!-- 작성자(board.boardwriter)와 
					로그인한 계정(loginUser.userId)이 동일한 경우만 작성 -->
			<% if ( board != null && loginUser != null &&
					 board.getBoardWriter().equals(loginUser.getUserId())) { %>
            <div align="center">
                <!-- 작성자와 로그인한 계정이 동일한 경우만 표시 -->
                <a href="/board/updateForm?bno=${ board.boardNo} " class="btn btn-primary">수정</a>
                <a href="/board/delete?bno=<%= board.getBoardNo() %>" class="btn btn-danger">삭제</a>
            </div>
            <% } %>
            <br><br>

            <table id="replyArea" class="table" align="center">
                <thead>
                    <tr>
                        <th colspan="2">
                            <textarea name="boardContent" id="content" cols="55" rows="2" class="form-control" style="resize: none; "></textarea>
                        </th>
                        <th style="vertical-align:middle;">
                            <button class="btn btn-secondary">등록</button>
                        </th>
                    </tr>
                    <tr>
                        <td colspan="3">댓글 (<span id="rcount"><%= rlist.size() %></span>)</td>
                    </tr>
                </thead>
                <tbody>
                   <%for (Reply r : rlist) { %>
                    <tr>
                        <th><%= r.getReplyWriter() %></th>
                        <td><%= r.getReplyContent()%></td>
                        <td><%= r.getCreateDate() %></td>
                    </tr>
                    <% } %>                      
                </tbody>
            </table>     
            <br><br>
        </div>


    </div>

    <%-- footer --%>
    <jsp:include page="../common/footer.jsp" />    
    
    <script>
    
 
    	window.addEventListener('load', function() {
    			// [등록] 버튼 클릭 이벤트 => 비동기 통신 
    			$("#replyArea button").click(function() {
						// 입력된 댓글 내용을 추가 요청 => 비동기 통신(ajax)
						  addReply();
    			});
    	});
    
    
    	function addReply(){
    	
    		// 입력된 값이 없을 경우 메시지 표시하고 요청하지 않도록 처리
    		if ($("#replayArea #content").val() == "") {
    		 alert("댓그 내용 작성후 등록 가능합니다.");
    		  return
    		}
    	
    		
    		// 비동기 통신 => ajax 
    		 $.ajax({
    		 	url : '/api/board/reply' ,   								// 요청 주소
    		 	method: 'post',											// method 아니면  type: 가능
    		 	data: {
    		 			replyContent: $("#replyArea #content").val(),   // 댓글 사용
    		 			replyWriter : '${ loginUser.userId }'	,		// 로그인 사용자의 아이디(세션 영역에 'loginUser' 키값으로 저장) 
    		 			refBno		:  ${ board.boardNo}				// 게시글 번호 
    		 			
    		 			
    		 			
    		 	},		// { 키: 데이터..}
    		 	success: function(result) {
    		 		// * result => 응답 데이터(결과)
    		 		//console.log(" 댓글 작성 성공 **");
    		 		//console.log(result);
    		 		
    		 		// * 응답 결가가 "success"일 경우 댓글 표시되는 부분을 변경
    		 		// => 댓글 목록을 조회하여 표시 
    		 		
    		 		if (result = "success") {
    		 			selectReplyList();
    		 			
    		 			$("#replyArea #content").val("");
    		 		}
    		 		
    		 	},
    		 	error: function(err) {
    		 	    // * err => 오류 내용
    		 	    console.log(" 댓글 작성 실패 **");
    		 		console.log(err);
    		 	}
    		 	    		
    		 });    		 
    	} 
    	
    	
    	function selectReplyList(){
    	
    		$.ajax({
    			url: '/api/board/reply',   
    			// 요청방식 :get. 생략가능
    			data: { boardNo: ${board.boardNo}},
    			success: function(list) {
    				// console.log("댓글 목록 조회 성공 **");
    				// console.log(list);
    				
    				// * 댓글 개수 업데이트 
    				$("#replyArea #rcount").text(list.length);
    				
    				// * 댓글 목록 업데이트 
    				let replyData = "";
    				
    				for (const reply of list) {
    				     replyData += "<tr>"
    				     			  + "<th>" + reply.replyWriter + "</th>"
    				     			  + "<td>" + reply.replyContent + "</td>"
    				     			  + "<td>" + reply.createDate + "</td>"
    				     			  + "</tr>";
    				}
    				
    				$("#replyArea tbody").html(replyData);
    			},
    			
    			error: function(err) {
    				console.log("댓글 목록 조회 실패 **");
    				console.log(err);
    			}
    			
    			
    		});    	
    	}
    	
    </script>
    
    
</body>
</html>