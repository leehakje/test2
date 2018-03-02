<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	header nav ul { list-style: none; }
	header nav ul li {
		float: left;
		width: 200px;
		height: 25px;
		background-color: #ccff00;
		margin-right: 10px;
		text-align: center;		
	}
	header nav ul li a {
		display: block;
		color: navy;
		text-decoration: none;
		font-weight: bold;
	}
	header nav ul li a:hover {
		background-color: #ffcc00;
		font-size: 12pt;
	}
</style>
</head>
<body>
<header>
<nav>
<ul>
	<li><a href="home.do">home</a></li>
	<li><a href="nlist.do">공지사항</a></li>
	<li><a href="blist.do?page=1">게시글</a></li>
	<li><a>자료실</a></li>
	<li><a>QnA</a></li>
</ul>
</nav>
<c:if test="${empty sessionScope.loginUser }">
<form action="login.do" method="post">
<table width="250" height="80" cellspacing="5" border="0" bgcolor="#99ccff">
<tr><th>아이디</th><th><input type="text" name="member_id" required></th></tr>
<tr><th>암 호</th><th><input type="password" name="member_pwd" required></th></tr>
<tr><th colspan="2"><input type="submit" value="로그인"> &nbsp;
<a href="enrollForm.do">회원가입</a> &nbsp; 
<a>아이디/암호 분실시</a></th></tr>
</table>
</form>
</c:if>
<c:if test="${!empty sessionScope.loginUser }">
<table width="250" height="80" cellspacing="5" border="0" bgcolor="#99ccff">
<tr><th>${loginUser.member_name } 님</th>
   <th><a href="logout.do">로그아웃</a></th></tr>
<c:url var="mi" value="/myinfo.do">
	<c:param name="member_id" value="${loginUser.member_id }" />
</c:url>
<tr><th><a href="${mi }">내 정보보기</a></th>
<th>&nbsp;</th></tr>
</table>
</c:if>
</header>
</body>
</html>