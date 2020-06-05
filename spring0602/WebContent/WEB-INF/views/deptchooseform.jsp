<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>surveyAddform</title>
</head>
<body>
<div id="container">
 <form method="post" action="deptlist" enctype="multipart/form-data">
 <table>
  <thead>
   <tr><th colspan="2">ResultMap 예제2</th></tr>
  </thead>
  <tbody>
   <tr><th>부서번호</th>
   <td><select name="deptno">
   <option value="0">--선택--</option>
   	<option>10</option>
   	<option>20</option>
   	<option>30</option>
   	<option>40</option>
   	<option>50</option>
   	<option>60</option>
   </select>
   </tr>
 
  </tbody>
  <tfoot>
  <tr><th colspan="2"><input type="submit" value="검색">
  </th></tr>
  </tfoot>
 </table>
 </form>
 </div>
</body>
</html>
