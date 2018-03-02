<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원 가입 페이지</h1>
<form action="minsert.do" method="post">
<table width="500">
<tr><th colspan="2">회원 가입 양식</th></tr>
<tr><th>아이디</td>
   <td><input type="text" name="member_id"> <button>중복확인</button></td></tr>
<tr><th>암 호</th>
   <td><input type="password" name="member_pwd"></td></tr>
<tr><th>암호 확인</th>
   <td><input type="password" name="member_pwd2"></td></tr>
<tr><th>이 름</th>
   <td><input type="text" name="member_name"></td></tr>
<tr><th>성 별</th>
   <td><input type="radio" name="gender" value="M"> 남 
      <input type="radio" name="gender" value="F"> 여 </td></tr>
<tr><th>나 이</th><td><input type="number" name="age"></td></tr>
<tr><th>이메일</th><td><input type="email" name="email"></td></tr>
<tr><th>전화번호</th><td><input type="tel" name="phone"></td></tr>
<tr><th>주 소</th><td><input type="text" name="address"></td></tr>
<tr><th>취 미</th>
   <td><input type="text" name="hobby">
   </td></tr>
<tr><th><input type="submit" value="가입하기"></th></tr>
</table>
</form>
</body>
</html>