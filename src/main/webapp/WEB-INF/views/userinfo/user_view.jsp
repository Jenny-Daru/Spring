﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- ViewModel 에서 저장된 회원정보를 반환받아 클라이언트에게 전달하는 JSP 문서 --%>
<%--  => [수정]을 클릭한 경우 회원정보 변경 입력페이지(/userinfo/modify) 요청 --%>
<%--  => [삭제]를 클릭한 경우 회원정보 삭제 처리페이지(/userinfo/remove) 요청 --%>
<%--  => [목록]을 클릭한 경우 회원목록 출력 페이지(/userinfo/list) 요청 --%>
<%-- 
<%
		//출력할지 말지 정해야 하니까 얘가 필요함
		UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
		
		//Userinfo 라는 이름으로 저장된 속성값을 반환받아 다시 저장
		UserinfoDTO userinfo=(UserinfoDTO)request.getAttribute("userinfo");
		
%>
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="${pageContext.request.contextPath }/css/user.css" type="text/css">
<script language="JavaScript">
function userRemove(userid) {
	if (confirm("정말로 삭제 하시겠습니까?") ) {
		location.href='${pageContext.request.contextPath }/userinfo/remove?userid='+userid;
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 상세정보</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%--<%=userinfo.getUserid() --%>
				${userinfo.userid }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%--<%=userinfo.getName() --%>
				${userinfo.name }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%--<% if(userinfo.getEmail()!=null) { --%>
				<%--<%=userinfo.getEmail()--%>
				<%--<% } --%>
					${userinfo.email }				
			</td>
		  </tr>		  
	  </table>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<%--<% if(loginUserinfo.getStatus()==9 || loginUserinfo.getUserid().equals(userinfo.getUserid()) ) { --%>
			<%--<% } --%>
			<c:if test="${loginUserinfo.status==9 || loginUserinfo.userid==userinfo.userid}">
			<input type="button" value="수정" onClick="location.href='${pageContext.request.contextPath }/userinfo/modify?userid=${userinfo.userid}';">
			</c:if>
			<%--<% if(loginUserinfo.getStatus()==9) { --%>
			<%--<% } --%>
			<c:if test="${loginUserinfo.status==9 }">
			<input type="button" value="삭제" onClick="userRemove('${userinfo.userid}');">
			<input type="button" value="목록" onClick="location.href='${pageContext.request.contextPath }/userinfo/list';"> 
			</c:if>
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
</body>
</html>















