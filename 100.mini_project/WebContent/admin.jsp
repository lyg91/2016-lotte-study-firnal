<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "java.util.ArrayList"
    import = "work.model.dto.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>������ ������</title>

    <!-- Bootstrap Core CSS -->
	<link href="dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Bootstrap Core JS -->
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="dist/js/jquery.js"></script>
	<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-user"></span>ȸ�� ��ü ����</h1><br>
<table class="col-sm-12 table table-hover">
<tr>
<th>ID</th>
<th>��й�ȣ</th>
<th>�̸�</th>
<th>����ó</th>
<th>�̸���</th>
<th>���</th>
<th>������</th>
<th>���ϸ���</th>
<th>����</th>
<th>�������</th>
<th>ȸ��Ż��</th>
</tr>
<% 
	ArrayList list = (ArrayList)request.getAttribute("list"); 
	
	for(int i = 0; i< list.size(); i++) {   
		User dto = (User)list.get(i);
	
%>
<tr>
<td><a href="Controller?action=myInfo&uId=<%=dto.getuId()%>"><%=dto.getuId()%></a></td>
<td><%=dto.getuPw() %></td>
<td><%=dto.getuName() %></td>
<td><%=dto.getuMobile() %></td>
<td><%=dto.getuEmail() %></td>
<td><%=dto.getuGrade() %></td>
<td><%=dto.getuEntryDate() %></td>
<td><%=dto.getuMileage() %></td>
<td><%=dto.getuGender() %></td>
<td><%=dto.getuBirthYear()+"��"+dto.getuBirthMonday()%></td>
<td><button onclick="if(confirm('�ش� ȸ���� ���� Ż���Ű�ڽ��ϱ�?')){location.href='Controller?action=deleteUser&uId=<%=dto.getuId()%>'}">ȸ��Ż��</button></td>
</tr>
<%
}
%>
</table>
<jsp:include page="footer.jsp"/>
</body>
</html>
