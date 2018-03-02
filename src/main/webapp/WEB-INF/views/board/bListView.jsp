<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<c:import url="../header.jsp" />
<hr>
<h2 align="center">게시판 목록</h2>
	<table align="center" border="1" cellspacing="0">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="15%"/>
			<col width="20%"/>
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">첨부파일</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(blist) > 0}">
					<c:forEach items="${blist }" var="row">
						<tr>
							<td>${row.board_num }</td>
							<td class="title">
								<a href="bDetailView.do?board_num=${row.board_num }" name="title">${row.board_title }</a>
							</td>
							<td align="center">
							<c:if test="${!empty row.board_original_filename }">
							@
							</c:if>
							<c:if test="${empty row.board_original_filename }">
							&nbsp;
							</c:if>
							</td>
							<td>${row.board_readcount }</td>
							<td>${row.board_date }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<a href="binsertForm.do" align="center">글 쓰기</a>
</body>
</html>