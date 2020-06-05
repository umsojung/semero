<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="urlPath" value="${pageContext.request.contextPath}/resources"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>surveyList</title>
<style>
#wrap {width: 600px; margin: auto;}
table {border-collapse: collapse; width: 100%}
th {background-color: #c0c0c0;}
tbody img {width: 100px;}
th, td {padding: 8px; text-align: left; border-bottom: 1px solid #ddd;}
tr:hover {background: #f5f5f5;}
</style>
</head>
<body>
<div id="wrap">
	<h2>Survey Admin List 예제</h2>
	<table>
		<thead>
			<tr>
				<th colspan="2">SurveyDatail</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${list}" varStatus="i">
			<c:if test="${i.index==0}">
			<tr><th>제목</th>
			<td><input type="text" name="sub" id="sub" value="${e.sub}" readonly="readonly">
			<input type="hidden" name="num" value="${e.num}" id="num">
			</td></tr>
			</c:if>
			<tr>
			<th>${i.index+1}번 설문문항 ${e.surveytype}</th>
			<td>${e.surveytitle}</td>			
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="8">
					<input type="button" value="list" onclick="location='surveyList'">
					<!-- jQuery를 사용해서 url로 넘기기 -->
					<input type="button" value="delete" id="delete">
				</th>				
			</tr>
		</tfoot>
	</table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
 $(function () {
	$('#delete').click(function() {
		if(confirm('정말로 삭제 하시겠습니까?')){
			var numv = $('#num').val();
			alert("삭제 처리로 이동하기"+numv);			
			location="surveydelete?num="+numv;
		}
	});
});
</script>
</body>
</html>