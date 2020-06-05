<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="content">
	<p>����� ����������</p>
	<div id="cont">
		<table style="width: 950px;">
			<thead>
				<tr>
					<th colspan="4">����Ʈ</th>
				</tr>
				<tr>
					<td>��ȣ</td>
					<td>���̵�</td>
					<td>�̸�</td>
					<td>��¥</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="listv" items="${list}">
					<tr>
					<td>${listv.num}</td>
					<td>${listv.id}</td>
					<td>${listv.name}</td>
					<td>${listv.rdate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4" id="pageTd">
						<%--page ó�� --%>
						<%@include file="pageProcess.jsp" %>
					</td>
				</tr>
				<tr>
					<th colspan="6">
						<form action="memberSearch" method="post">
							<input type="hidden" name="page" value="${param.page}">
							<select>
								<option value="1">���̵�</option>
								<option value="2">�̸�</option>
							</select>&nbsp; <input name="searchValue">
							<input type="submit" value="Search">
						</form>
					</th>
				</tr>
				<tr>
					<th colspan="4"><input type="button" value="writer" onclick="location='memberForm'"></th>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
</body>
</html>