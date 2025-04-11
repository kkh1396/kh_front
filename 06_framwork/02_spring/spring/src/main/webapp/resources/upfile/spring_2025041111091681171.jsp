<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis project</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<style>
	 #mypage-area table { margin: auto}
</style>
</head>
<body>
	<%-- menubar.jsp 회원가입 --%>
	<jsp:include page="../common/menubar.jsp" />
		
		
		<div class="outer">
			<br>

			<h2 align="center">마이페이지</h2>

			<form action="update.me" method="post" id="mypage-area" >
				 <table>
					<tr>
					  <td>* 아이디</td>
					  <td>
						  <input type="text" class="form-control " name="userId" value="${loginUser.userId }"
						  				maxlength="30" readonly />			
					  </td>					  
					</tr>
					<tr>
						<td>* 이름</td>
						<td>
							<input type="text" class="form-control" name="userName" value="${ loginUser.name }" readonly>
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;이메일</td>
						<td>
							<input type="email" class="form-control" value="${ loginUser.email }"name="email" >
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;성별</td>
						<td>
							<div class="form-check from-check-inline">
								<input class="form-check-input" type="radio" name="gender" value="M" id="genderM" >
								<label class="form-check-label" for="genderM"> 남
								</label>
							</div>
							  <div class="form-check from-check-inline">
								<input class="form-check-input" type="radio" name="gender" value="F" id="genderF" >
								<label class="form-check-label" for="genderF"> 여
								</label>
							</div>
						</td>
					</tr>			
					<tr>		
						 <td>&nbsp;&nbsp;생년월일</td>
						 <td>
							<input type="date" class="form-control" id="birth" value="${ loginUser.birthday }" readonly>
							<input type="hidden" name="birthday"  /> 								
						 </td>
					</tr>
					<tr> 
						<td>&nbsp;&nbsp;연락처</td>
						<td>
							<input type="tel" class="form-control" name="phone" value="${ loginUser.phone }" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="- 포함해서 입력" >
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;주소</td>
						<td>
							<input type="text" class="form-control"  name="address" value="${ loginUser.address }">
						</td>
					</tr>
				 </table>
				 <br><br>

				  <div align="center">
						<button type="submit" class="btn btn-sm btn-primary">정보 수정</button>
						<button type="button" class="btn btn-sm btn-secondary"
						data-bs-toggle="modal" data-bs-target="#pwdUpdateMemModal"
						>비밀번호 변경</button>
						<button type="button" class="btn btn-sm btn-danger" 
						 data-bs-toggle="modal" data-bs-target="#deleteMemModal"
						 >회원탈퇴</button>						
				 </div>

			</form>
		</div>
		
		
		<!--  비밀번호 변경 모달 -->
			<div class="modal fade" id="pwdUpdateMemModal" tabindex="-1" aria-labelledby="pwdUpdateMemModal" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="pwdUpdateMemModal">비밀번호 수정</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      
			      <div class="modal-body">
			        <form action="updatePwd.me" method="post">

						  <input type="hidden" name="userId" value="${ loginUser.userId }" />

			              <%-- 회원PWD : 입력받기  --%>
			              <div class="mb-3">
			                  <label for="password" class="col-form-label">현재 비밀번호 : </label>
			                  <input type="password" class="form-control"  id="password" name="userPwd" required/>			                  
			              </div>
			              
			               <div class="mb-3">
			                  <label for="newPwd" class="col-form-label">변경할 비밀번호 : </label>
			                  <input type="password" class="form-control"  id="newPwd" name="newPwd" required/>			                  
			              </div>	
			              
			              <div class="mb-3">
			                  <label for="newPwdCheck" class="col-form-label">변경할 비밀번호 확인 : </label>
			                  <input type="password" class="form-control"  id="newPwdCheck" required/>			                  
			              </div>			              
			              

			              <button type="submit" class="btn btn-sm btn-secondary float-end"
			                       onclick="return pwdCheck();">변경하기</button>

			        </form>
			      </div>			      
			  </div>
			</div>
			</div>
		
		
		
		<!--  회원 탈퇴 모달 -->
			<div class="modal fade" id="deleteMemModal" tabindex="-1" aria-labelledby="deleteMemModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="deleteMemModalLabel">회원 탈퇴</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      
			      <div class="modal-body">
			        <form action="delete.me" method="post">
			              <%-- 회원ID : 입력받지 x --%>
			              <input type="hidden" name="userId" value="${ loginUser.userId }" />
			              <p>
			              	   탈퇴 후 복구가 불가능합니다. <br>
			              	   그래도 탈퇴하시겠습니까?
			              </p>
			              <%-- 회원PWD : 입력받기  --%>
			              <div class="mb-3">
			                  <label for="password" class="col-form-label">비밀번호 : </label>
			                  <input type="password" class="form-control"  id="password" name="userPwd" required/>			                  
			              </div>			              
			              
			              <button type="submit" class="btn btn-sm btn-danger float-end">탈퇴하기</button>
			        </form>
			      </div>			      
			  </div>
			</div>
		   </div>				
		
		
		

		<script>
		   // * 모든 요소들이 로드되었을 때(화면에 표시되었을 때)
		   onload = function() {
			    // * ---- 성별 항목을 적용 ---- *
			    const gender = "${ loginUser.gender }"; // 로그인한 사용자의 성별 정보 
			    console.log(gender);
			    
			    
			    // 성별(name=gender) 입력 요소들에 접근
			    const gArr = document.querySelectorAll("input[name=gender]");
			    // => [E, E]
			    for (let gEle of gArr) {
			    	console.log(gEle.value);
			    	if (gEle.value == gender) {
			    		 // 로그인 사용자의 성별 정보와 해당 요소(gender)의 value 속성값이 같은 경우
			    		gEle.checked = true;	// 체크되도록 처리
			    		break;
			    	}
			    	// * -- 생년월일 데이터 가공 -- *
				    
			    }  
			    
			    makeBirth();    
		   }
		  
		   
		   function makeBirth(target) {
		
			   //  * 생년월일 변경 허용을 하지 않는 경우 => DB 조회한 데이터 사용
			   // const data = "${ loginUser.birthday }";
			   
			   //  * 생년월일 변경 허용 경우 => 입력요소의 저장된 값을 사용
			   //   + onchange 이벤트도 사용 가능!
			   const data = document.getElementById("birth").value;
			   
			   console.log(data)
				
				// (2) String 객체 메소드 사용 => split 메소드
				const dArr = data.split('-');  //['yyyy', 'mm', 'dd']
				yy = dArr[0].slice(-2);
				mm = dArr[1];
				dd = dArr[2];
				
				console.log(yy,mm,dd)
				
				// yy,mm,dd를 하나로 합쳐서
				// name 속성이 birthday인 요소에 값을 저장
				document.querySelector("#mypage-area input[name=birthday]").value = yy+mm+dd;
		   }
		   
		   function pwdCheck() {
			    // * {변경할 비밀번호} 값과 {변경할 비밀번호 확인} 값이
			    //   일치하지 않을 경우 요청하지 않도록 처리
			    
			    const newPwd = document.querySelector("#pwdUpdateMemModal #newPwd").value;
			    const newPwdCheck = document.querySelector("#pwdUpdateMemModal #newPwdCheck").value;
			    
			    // * 입력 값이 모두 없을 때 변경 요청하지 않도록 처리
			    const userPwd = document.querySelector("#pwdUpdateMemModal #password").value;
			    
			    <!-- 
			    if ( newPwd == "" || newPwdCheck == "" || userPwd == "" ) {
			    	 alert("입력되지 않은 값이 있습니다. 확인해주세요");
			    	 return false;
			    }
			    -->
			    
			    	

			    if ( newPwd != newPwdCheck ) {
			    	 alert("변경할 비밀번호 값이 다릅니다. 다시 확인해주세요");
			    	 return false;
			    	
			    }
		   }
		   
		</script>
		
</body>
</html>