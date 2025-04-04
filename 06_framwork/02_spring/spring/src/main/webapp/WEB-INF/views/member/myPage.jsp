<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.spring.member.model.vo.Member" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EnrollForm</title>   
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
    </style>
</head>
<body>
    <%-- header --%>

     <jsp:include page="../common/header.jsp"/>
     
     
     <% Member loginUser = (Member)session.getAttribute("loginUser"); %>


    <div class="outer">
        <br><br>
        <div class="inner-area">
            
            <h2>마이페이지</h2>
            <br>
            <form action="upDate" method="post">

                <div class="form-group">
                    <label for="userId"> ID </label>
                    <input type="text" class="form-control mb-3" name="userId" id="mpuserId" value="<%= loginUser.getUserId() %>" placeholder="Enter ID.." readonly>
                        
                    <label for="userName"> Name </label>
                    <input type="text" class="form-control mb-3" name="userName" id="mpuserName" value="<%= loginUser.getUserName() %>" placeholder="Enter Name.." readonly>

                    <label for="email"> &nbsp; Email </label>
                    <input type="email" class="form-control mb-3" name="email" id="email" value="<%= loginUser.getEmail()%>" placeholder="Enter Email..">  
                    
                    <label for="age"> &nbsp; Age </label>
                    <input type="number" class="form-control mb-3" name="age" id="age" value="<%= loginUser.getAge()%>" placeholder="Enter Age.." readonly>  
                    
                    <label for="phone"> &nbsp; Phone </label>
                    <input type="tel" class="form-control mb-3" name="phone" id="phone" value="<%= loginUser.getPhone() %>" placeholder="Enter Phone(-제외)..">  
                    
                    <label for="address"> &nbsp; Address </label>
                    <input type="text" class="form-control mb-3" name="address" id="address" value="<%= loginUser.getAddress() %>"  placeholder="Enter Address..">

                </div>
                <br>
                <div class="btns"  align="center">
                    <button type="submit" class="btn btn-primary">정보 수정</button>
                    <button type="button" class="btn btn-secondary"> 비밀번호 변경</button>
                    <button type="reset" class="btn btn-danger">탈퇴</button>
                </div>
            </form>
        </div>
        <br><br>
    </div>
    
    <%-- footer --%>
    <jsp:include page="../common/footer.jsp"/>

    <script>

    </script>


    
</body>
</html>