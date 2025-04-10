<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.kh.spring.notice.model.vo.Notice" %>
<%@ page import="com.kh.spring.member.model.vo.Member" %>
<%@ page import="com.kh.spring.common.PageInfo" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");
	PageInfo pi     = (PageInfo)request.getAttribute("pi");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 목록</title>
    <!-- 부트 스트랩 header.jsp에 포함되어잇어 주석표시 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    -->
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

        #noticeList {text-align: center;}
        #noticeList>tbody>tr:hover{cursor:pointer;}

        #pagingArea {width:fit-content; margin:auto;}

        #searchForm {width:80%; margin: auto;}
        #searchForm>* {float:left; margin:5px;}
        
        .text {width:75%;}
        .searchBtn{width:20%;}
    </style>
</head>
<body>
    <%-- header --%>
    <jsp:include page="../common/header.jsp" />

    <div class="outer">
        <br><br>
        <div class="innerOuter" style="padding: 5% 10%">
            <h2>공지사항</h2>
            <br>

            <%-- admin 계정일때만 글쓰기 버튼 표시 --%>
            <% if (	loginUser != null &&
            		loginUser.getUserId().equals("admin")) { %>
	            <a href="/notice/enrollForm" class="btn btn-secondary" style="float:right">글쓰기</a>
	            <br>
            <% } %>
            
            <br>
            <table id="noticeList" class="table table-hover" align="center">
                <thead>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </thead>

                <tbody>
                	<% for(Notice n : list) { %>                
                    <tr>                    	
                        <td><%= n.getNoticeNo() %></td>
                        <!--
                        <td>
                            <a href="/notice/detil?no=<%= n.getNoticeNo() %>"> 
                                <%= n.getNoticeTitle() %>
                            </a>
                        </td>
                        -->
                        <td> <%= n.getNoticeTitle() %></td>
                        <td><%= n.getNoticeWriter() %></td>
                        <td><%= n.getCreateDate() %></td>
                    </tr>
                    <% } %>                                                           
                </tbody>
            </table>
            <br>


			<%
				int currPage = 0, startPage = 0, endPage =0, maxPage =0;
			
			if ( pi != null ){
				currPage = pi.getCurrPage();
				startPage = pi.getStartPage();
				endPage  = pi.getEndPage();
				maxPage = pi.getMaxPage();
			}
			
			%>
			<div id="pagingArea">
                <ul class="pagination">
                	<%-- 현재 페이지가 1일 떄 비활성화 --%>
                	<% if (currPage == 1)  {%>
                	<li class="page-item disabled"><a class="page-link">Prev</a></li>
                    <% } else { %>
                    <li class="page-item">
                    	<%-- <a href="/notice/list?cpage=<%= currPage - 1 %>" class="page-link">Prev</a> --%>
                    	<a class="page-link" data-curr="<%= currPage-1 %>">Prev</a>
                    </li>
                     <% } %>
                    <%-- 반복문을 사용하여 페이징 바 개수만큼 시작번호, 끝번호 활용하여 표시 --%>
                    <% for (int p = startPage; p <= endPage; p++ ) { %>
                    <li class="page-item" <% if (currPage == p ){ %>active<%}  %>>
                    <%-- <a href="/notice/list?cpage=<%= p %>" class="page-link"><%= p %></a>--%>
                    <a class="page-link" data-curr="<%= p %>"><%= p %> </a>
                    </li>                    
                    <% } %>
                    
                    <%-- 현재 페이지가 마지막 번호일 때 비활성화 --%>
                    <% if (currPage == maxPage)  {%>
                    <li class="page-item disabled"><a class="page-link">Next</a></li>
                    <%}else { %>
                    <li class="page-item">
                    <%-- <a href="/notice/list?cpage=<%= currPage + 1 %>" class="page-link">Next</a>--%>
                    <a class="page-link" data-curr="<%= currPage + 1 %>">next </a>
                    </li>
                    <% } %>
                </ul>
            </div>

            <br clear="both">

            <form action="/notice/list" id="searchForm">
                <div class="text">
                    <input type="text" class="form-control" name="keyword" value="${keyword}" placeholder="검색할 제목을 입력하세요.">
                </div>
                <button class="searchBtn btn btn-secondary">검색</button>
            </form>
        </div>
        <br><br>
    </div>

    <%-- footer --%>
    <jsp:include page="../common/footer.jsp" />

    <script>
    
    window.addEventListener('load', function() {
         //onload = function(){
        
        
	        	// * 공지사항 목록 클릭 시 상세피이지 이동 
	            const noticeTr = document.querySelectorAll("#noticeList tbody tr")
	
	            for(const ele of noticeTr){
	                ele.onclick = function() {
	                    location.href = "/notice/detail?no="+ ele.children[0].innerText;
	                    
	                }
	            }
            
            	// * 페이징바 클릭 시 해당 페이지로 이동
             	const pagingArr = document.querySelectorAll("#pagingArea a");
             
	    		for(const ele of pagingArr) {
	    			ele.onclick = function() {
	    			
	    				const keyword = "${keyword}";
	    				
	    				let requestUrl = "/notice/list?cpage=" + ele.getAttribute("data-curr");
	    				
	    				if (keyword != "") {
	    					requestUrl += "&keyword=" + keyword;
	    				}
	    				ele.href = requestUrl;
	    			}
	    		}
        })

    </script>
</body>
</html>