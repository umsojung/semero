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
	<form method="post" action="memberIn">
		<table>
			<tr>
			<td>���̵�</td>
			<td><input type="text" name="id" maxlength="10" id="id">
				<input type="button" value="�ߺ�Ȯ��" id="idChkBtn" style="width: 150px; font-size: 15px; height: 30px">
			</td>
			</tr>
			<tr><td colspan="2" id="target"></td></tr>
			<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="pwd" maxlength="10"></td>
			</tr>
			<tr>
			<td>��й�ȣ Ȯ��</td>
			<td><input type="password" name="pwd" maxlength="10"></td>
			</tr>
			<tr>
			<td>�̸�</td>
			<td><input type="text" name="name"></td>
			</tr>
			<tr>
			<td colspan="2"> <input type="submit" value="����"></td>
			</tr>
			
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
<script>
 $(function () {
	$('#idChkBtn').click(function() {
		$.ajax({
			url:'idChk?id='+$('#id').val(),
			success: function(data){
				if(data === 0){
					$('#target').html("<p style='color:blue'>��� ����</p>");
				}else{
					$('#target').html("<p style='color:red'>�̹� ���� �մϴ�.</p>");
					$('#id').val("");
				}
			}		
		});
	/* 	var id = $('#id').val();
		location='idChk?id='+id; */
	});
});
 </script>