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
                            <textarea name="" id="content" cols="55" rows="2" class="form-control" style="resize: none;"></textarea>
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
</body>
</html>