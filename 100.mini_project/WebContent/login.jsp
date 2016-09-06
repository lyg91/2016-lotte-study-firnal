<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hello, Login</title>

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
<h1 class="text-center"><span class="glyphicon glyphicon-paperclip"></span>Login</h1><br>
<form name="loginForm" method="post" action="Controller?action=login" class="form-horizontal">
  <div class="form-group">
    <label for="userId" class="col-sm-offset-1 col-sm-2 control-label">ID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="userId" name="uId" placeholder="Input your ID">
    </div>
  </div>
  <div class="form-group">
    <label for="userPw" class="col-sm-offset-1 col-sm-2 control-label">Password</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="userPw" name="uPw" placeholder="Input your Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-7 col-sm-2">
      &nbsp&nbsp&nbsp&nbsp<b><a onclick="open('findId.jsp','ID 찾기', 'width=700,height=300,resizable=no')">ID 찾기</a></b>&nbsp&nbsp/&nbsp&nbsp<b><a onclick="open('findPw.jsp','패스워드 찾기', 'width=700,height=400,resizable=no')">비밀번호 찾기</a></b>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-7 col-sm-5">
      <button type="submit" class="col-sm-2 btn btn-info">Login</button>
      <button type="reset" class="col-sm-2 btn btn-info">Cancel</button>
    </div>
  </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
