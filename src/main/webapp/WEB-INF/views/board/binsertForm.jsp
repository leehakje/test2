<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsertForm</title>
</head>
<body>
<c:import url="../header.jsp" />
<hr style="clear:both;">
<h1 align="center">게시글쓰기</h1>
<br>
<form action="binsert.do" method="post" enctype="multipart/form-data">
	<table align="center" width="500">
	<tr><td>작성자</td>
	<td><input type="text" name="board_writer" value="${loginUser.member_id }" readonly></td></tr>
	<tr><td>제 목</td>
	<td><input type="text" name="board_title"></td></tr>
	<tr><td>첨부파일</td>
	<td><input type="file" name="upFile"></td></tr>
	<tr><td>내 용</td>
	<td><textarea rows="5" cols="50" name="board_content"></textarea></td></tr>
	<tr><td colspan="2"><input type="submit" value="등록하기"></td></tr>
	</table>
	</form>
<br>
<c:import url="../footer.jsp" />
</body>
</html>