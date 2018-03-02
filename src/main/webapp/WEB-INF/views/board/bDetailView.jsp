<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDetailView</title>
</head>
<body>
<c:import url="../header.jsp" />
<hr style="clear:both;">
<h1 align="center">${board.board_num }번 글 상세보기</h1>
<br>
<hr>
<table align="center" width="600" cellspacing="0" border="1">

   <tr><th>제 목</th><td>${ board.board_title }</td></tr>
   <tr><th>작성자</th><td>${ board.board_writer }</td></tr>

   <c:if test="${ board.board_level == 0 }">
      <tr><th>첨부파일</th>
         <td>
            <c:if test="${empty board.board_original_filename }">
               첨부파일 없음
            </c:if>
            <c:if test="${!empty board.board_original_filename }">
            <c:url var="downfile" value="bdownfile.do">
            <c:param name="rfile" value="${board.board_rename_filename }" />
            <c:param name="ofile" value="${board.board_original_filename }" />
            </c:url>
            <a href="${downfile }">${board.board_original_filename }</a>
            </c:if>   
         </td>
      </tr>   
   </c:if>
   
   <tr><th>내 용</th><td>${ board.board_content }</td></tr>

   <c:if test="${ board.board_level lt 2 }">
      <tr align="center">
         <td colspan="2">
            <a href="#this">[댓글달기]</a>
         </td>
      </tr>
   </c:if>
   <tr><th colspan="2">
      <c:if test="${ loginUser.member_id eq board.board_writer }" >
         <a href="#this">수정페이지로 이동</a> &nbsp;
         <a href="bdelete.do">글 삭제</a>
      </c:if>
   </th></tr>
</table>
<c:import url="../footer.jsp" />
</body>
</html>