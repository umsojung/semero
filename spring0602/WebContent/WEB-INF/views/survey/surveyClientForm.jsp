<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- article ���� ���� -->
    <div id="article">
        <div id="header2">
            <h1>surveyClient ����</h1>
            <p id="time">Oct 1th, 2020</p>
        </div>
     <div id="section2">
            <div id="header4">
                <h2>���� ���� �ۼ� �� ����</h2>
            </div>     
 <%-- Content ������ ���ڸ� --%>   
    <form method="post" action="surveyUpdate">
 <table id="surveyclient">
  <thead>
   <tr><th colspan="2">���� ���� �ۼ� ��</th></tr>
  </thead>
  <tbody>
  <c:forEach var="e" items="${list }" varStatus="i">
  <c:if test="${i.index==0 }">
   <tr><th>����</th><td><input type="text" name="sub" id="sub" value="${e.sub }">
   <input type="hidden" name="subcode" value="${e.num }"></td></tr>
   
   </c:if>
   <tr><th>${i.index+1 }�� �������� ${e.surveytype }</th>
   <td><input type="radio" name="surveytype" class="surveytitle" value="${e.surveytype }">${e.surveytitle }</td></tr>
   
  </c:forEach>
  </tbody>
  <tfoot>
  <tr><th colspan="2"><input type="submit" value="send" id="listBtn"></th></tr>
  </tfoot>
 </table>
 </form>    
 <%-- Content ������ ���ڸ� --%> 
 <p>�������ؽ�Ʈ�� �� �������� �Ҹ��� ���α׷��� ���� �� �������� "����"�� �� ���������� ���� ������ �о�鿩 ��ǻ�� ����Ϳ� ����ϴ� ���·� ���̰� �ȴ�. �׷��� ���� ����ڴ� �� �������� �ִ� �����۸�ũ�� ���� �ٸ� ������ �̵��ϰų�, �� �������� �����ϰ� �ִ� ������ �Ϸ��� ������ ���� ���� �ִ�. �����۸�ũ�� ���� �̵��ϴ� ������ ���� �� ����(web surfing, ��ȭ��: ������) �Ǵ� �� ����¡�̶� �Ѵ�. �׸��� ���õ� ������� ���ִ� �� ���������� ������ �� ����Ʈ�� �Ѵ�.</p>
            <div id="footer2">
                <p>���� ���̵� ���� ������ ������ ������� ����� �� �ְڴ�. ù��° ���ϵ� �� �ڿ��� ��ġ ���� ��� ���� ��� URL. �ι�° ���� �ڿ� �̸��� �����ϴ� ��������(protocol) ���� ��� HTTP, �ڿ��� ���̸� ���� ���� �� �� �ִ� ��� ���� ��� HTML.</p>
            </div>
        </div>
        <div id="footer3">
            Article Footer
        </div>
    </div>
    <!-- article ���� �� -->
    <div id="aside">
        <div id="header5">
            <h1>Siderbar Heading</h1>
        </div>
        <p>������ �� ������ �ƴ� ���ü��� ���� ������� aside�� ǥ���� �� �ִ�.
  ������ ���������� ����� ���� ���� ����Ʈ ��ũ�� �ȳ���,
   nav ����� �׷� ���� aside ��ҷ� ��� �� �� �ִ�.
  ���� ��α׿��� �¿��� ���̵�ٸ� �ǹ��ϴ� �����μ� ���̵���� Ư������ 
  ���� �ʼ������� �ʾƼ� ǥ�ø� �ص� �ǰ� �� �ص� �Ǵ� ����� �Ǵ� ��������
   ������� �ڸ��� �� �ִ�.</p>
    </div>