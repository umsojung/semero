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
   <tr><th colspan="2">ResultMap ����2</th></tr>
  </thead>
  <tbody>
   <tr><th>�μ���ȣ</th>
   <td><select name="deptno">
   <option value="0">--����--</option>
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
  <tr><th colspan="2"><input type="submit" value="�˻�">
  </th></tr>
  </tfoot>
 </table>
 </form>
 </div>
</body>
</html>
