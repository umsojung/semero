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
   <div id="wrap">
	<h2>Survey Admin List ����</h2>
	<table>
		<thead>
			<tr>
				<th colspan="2">SurveyDatail</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${list}" varStatus="i">
			<c:if test="${i.index==0}">
			<tr><th>����</th>
			<td><input type="text" name="sub" id="sub" value="${e.sub}" readonly="readonly">
			<input type="hidden" name="num" value="${e.num}" id="num">
			</td></tr>
			</c:if>
			<tr>
			<th>${i.index+1}�� �������� ${e.surveytype}</th>
			<td>${e.surveytitle} => ${e.surveycnt}</td>			
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="8">
					<input type="button" value="list" onclick="location='surveyList'">
					<!-- jQuery�� ����ؼ� url�� �ѱ�� -->
					<input type="button" value="delete" id="delete">
				</th>				
			</tr>
		</tfoot>
	</table>
</div>
<div>
<div id="piechart"></div>
</div>  
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
<script src="https://d3js.org/d3.v3.min.js"></script>     
<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(function(){
	$.ajax({
		url: "surveyClientJson2?num="+$('#num').val(),
		success: function(data){
			var chartDonut = c3.generate({
				bindto: "#piechart",
				data: {
					json: [data],
					keys: { value: Object.keys(data),},
					type: "donut",
					},
				donut:{title:"���� ���� ����"},		
				});
		}	
	});
});
	
</script>
    