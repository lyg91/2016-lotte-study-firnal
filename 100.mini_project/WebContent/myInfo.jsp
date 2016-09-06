<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import ="work.model.dto.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script>
function moveUpdatePage() {
	if(confirm('정보변경 하시겠습니까?')) {
	document.updateInfoForm.target="_self";
	document.updateInfoForm.action="Controller?action=updateInfo";
	document.updateInfoForm.submit();
	}
}
function moveIndexPage() {
	if(confirm('메인 페이지로 이동하시겠습니까?')) {
	document.updateInfoForm.target="_self";
	document.updateInfoForm.action="index.jsp";
	document.updateInfoForm.submit();
	}
}
</script>
<body>
<% User dto = (User)request.getAttribute("dto"); %>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-user"></span>Account Infomation</h1><br>
<form class="form-horizontal" name="updateInfoForm" method="post">
  <div class="form-group">
    <label for="userId" class="col-sm-offset-1 col-sm-2 control-label">ID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="uId" id="userId" value="<%=dto.getuId() %>" readonly>
    </div>
  </div>
  
  <div class="form-group">
    <label for="userPw" class="col-sm-offset-1 col-sm-2 control-label">Password</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="uPw" id="userPw" value="<%=dto.getuPw() %>">
    </div>
  </div>
  
  <div class="form-group">
    <label for="name" class="col-sm-offset-1 col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" value="<%=dto.getuName() %>">
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-offset-1 col-sm-2 control-label">Email</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="email" id="email" value="<%=dto.getuEmail() %>">   
    </div>	
  </div>
  
  <div class="form-group">
    <label for="mobile" class="col-sm-offset-1 col-sm-2 control-label">Mobile</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="mobile" id="mobile" value="<%=dto.getuMobile()%>">   
    </div>	
  </div>
  
  <div class="form-group">
    <label for="birth1" class="col-sm-offset-1 col-sm-2 control-label">Birth</label>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="birth1" id="birth1" value="<%=dto.getuBirthYear()%>">
    </div>
    <div class="col-sm-3">
      <input type="text" class="form-control" name="birth2" id="birth2" value="<%=dto.getuBirthMonday()%>">        
    </div>	
  </div>
  
  <div class="form-group">
  <label for="grade" class="col-sm-offset-1 col-sm-2 control-label">Grade</label>  
      <div class="col-sm-6">
	      <input type="text" class="form-control" name="grade" id="grade" value="<%=dto.getuGrade()%>" readonly>
      </div>
  </div>
  
  <div class="form-group">
  <label for="entryDate" class="col-sm-offset-1 col-sm-2 control-label">가입일</label>  
      <div class="col-sm-6">
	      <input type="text" class="form-control" name="entryDate" id="entryDate" value="<%=dto.getuEntryDate()%>" readonly>
      </div>
  </div>
  
  <div class="form-group">
  <label for="gender" class="col-sm-offset-1 col-sm-2 control-label">Gender</label>  
      <div class="col-sm-6">
	      <input type="text" class="form-control" name="gender" id="gender" value="<%=dto.getuGender()%>" readonly>
      </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-4">
      <button onclick="moveUpdatePage()" class="col-sm-2 btn btn-info">정보변경</button>
      <span class="col-sm-1"></span>
      <button onclick="moveIndexPage()" class="col-sm-2 btn btn-info">메인 화면으로</button>
    </div>
  </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>