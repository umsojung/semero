<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="display: block; text-align: center;">
<!-- ���� ������ < -->
<c:if test="${paging.startPage != 1 }">
<a href="memlist?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}"><</a>
</c:if>
<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
<c:choose>
<c:when test="${p == paging.nowPage }">
<b>${p }</b> <%-- ���� ������ �� ��� ��ũ ���� --%>
</c:when>
<c:when test="${p != paging.nowPage }">
<%-- �ٸ� ������ ��ũ --%>
<a href="memlist?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
</c:when>
</c:choose>
</c:forEach>
<!-- ���� ������ > -->
<c:if test="${paging.endPage != paging.lastPage}">
<a href="memlist?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">></a>
</c:if>
</div>