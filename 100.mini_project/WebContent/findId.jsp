<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>아이디 찾기</title>
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
<h3 class="text-center"><span class="glyphicon glyphicon-zoom-out">Forget your ID?</span></h3>
<% if(request.getAttribute("message") != null) { %>
<script>
	alert('<%=request.getAttribute("message")%>');
</script>
<% } %>
<form name="findIdForm" method="post" action="Controller?action=findId" class="form-horizontal">
  <div class="form-group">
    <label for="userName" class="col-sm-offset-1 col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="userName" name="uName" placeholder="Input your Name">
    </div>
  </div>
  <div class="form-group">
    <label for="userMobile" class="col-sm-offset-1 col-sm-2 control-label">Mobile</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="userMobile" name="uMobile" placeholder="Input your Mobile">
    </div>
  </div>
  <div align="right">
  <div class="form-group">
    <div class="col-sm-offset-1 col-sm-4">
      <button type="submit" class="col-sm-2 btn btn-info">아이디 찾기</button>
      <button onclick="window.close()" class="col-sm-2 btn btn-info">취소</button>
    </div>
  </div>
  </div>
</form>
</body>
</html>