<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hello, Main</title>

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
<h1 class="text-center"><span class="glyphicon glyphicon-bullhorn"></span>Site Information</h1>
<hr>
<h4>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span>����Ʈ ����</h4>
<ul>
<li><h4>��κ��� ������� ������ָ� ���� �ֽ��ϴ�.</h4></li>
<li><h4>ȥ�� �����ϱ� ���� ������ �ٸ� ����� �����ϸ� �ذ��ϵ��� ���� ���� �� ����Ʈ�� �����Դϴ�.</h4></li>
<li><h4>���� ����Ʈ �̿��ڵ��� �������� ������ ������ ���������� �Ǵ��Ͽ� �ذ��� ���ɼ��� �����Ƿ� ������ �Ǿ��ٸ� ����Ʈ ȫ����Ź�帳�ϴ�.</h4></li>
</ul>
<br/><br/><br/>

<h4>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-globe"></span>����Ʈ ���� ����</h4>
<ul>
<li><h4><span class="glyphicon glyphicon-bullhorn"></span> Information : ����Ʈ �Ұ�</h4></li>
<li><h4><span class="glyphicon glyphicon-user"></span> Sign - In : ȸ������</h4></li>
<li><h4><span class="glyphicon glyphicon-thumbs-up"></span> Board & Vote : ���� ���� �� ��õ</h4></li>
<li><h4><span class="glyphicon glyphicon-zoom-in"></span> My Info : ȸ������ ���� �� Ż��</h4></li>
<li><h4><span class="glyphicon glyphicon-plus"></span> ���� ���� ���� ���� : ��� & ��ġ ��� </h4></li>
</ul>

<jsp:include page="footer.jsp"/>
</body>
</html>