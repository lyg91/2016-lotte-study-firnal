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
<h4>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-arrow-right"></span>사이트 목적</h4>
<ul>
<li><h4>대부분의 사람들은 선택장애를 갖고 있습니다.</h4></li>
<li><h4>혼자 결정하기 힘든 문제를 다른 사람과 공유하며 해결하도록 돕는 것이 본 사이트의 목적입니다.</h4></li>
<li><h4>따라서 사이트 이용자들의 많을수록 각자의 문제를 객관적으로 판단하여 해결할 가능성이 높으므로 도움이 되었다면 사이트 홍보부탁드립니다.</h4></li>
</ul>
<br/><br/><br/>

<h4>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="glyphicon glyphicon-globe"></span>사이트 제공 서비스</h4>
<ul>
<li><h4><span class="glyphicon glyphicon-bullhorn"></span> Information : 사이트 소개</h4></li>
<li><h4><span class="glyphicon glyphicon-user"></span> Sign - In : 회원가입</h4></li>
<li><h4><span class="glyphicon glyphicon-thumbs-up"></span> Board & Vote : 문제 공유 및 추천</h4></li>
<li><h4><span class="glyphicon glyphicon-zoom-in"></span> My Info : 회원정보 변경 및 탈퇴</h4></li>
<li><h4><span class="glyphicon glyphicon-plus"></span> 추후 제공 예정 서비스 : 댓글 & 수치 통계 </h4></li>
</ul>

<jsp:include page="footer.jsp"/>
</body>
</html>