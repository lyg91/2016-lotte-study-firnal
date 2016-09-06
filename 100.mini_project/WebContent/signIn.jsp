<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
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
<script>
function moveSignPage() {
	if(confirm('정말로 회원 가입을 하시겠습니까?')) {
	document.signInForm.target="_self";
	document.signInForm.action="Controller?action=signIn";
	document.signInForm.submit();
	}
}
</script>
</head>
<body>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-user"></span>Sign - In</h1><br>
<form class="form-horizontal" name="signInForm" method="post">
  <div class="form-group">
    <label for="userId" class="col-sm-offset-1 col-sm-2 control-label">ID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="uId" id="userId" placeholder="ID">
    </div>
  </div>
  
  <div class="form-group">
    <label for="userPw" class="col-sm-offset-1 col-sm-2 control-label">Password</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" name="uPw" id="userPw" placeholder="Password">
    </div>
  </div>
  
  <div class="form-group">
    <label for="name" class="col-sm-offset-1 col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="name" id="name" placeholder="Name">
    </div>
  </div>
  
  <div class="form-group">
    <label for="email" class="col-sm-offset-1 col-sm-2 control-label">Email</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="email1" id="email1" placeholder="Email">   
    </div>
    <div class="col-sm-2">
	    <select name="email2" class="form-control">
			  <option value="@naver.com">@ naver.com</option>
			  <option value="@hanmail.net">@ hanmail.com</option>
			  <option value="@google.com">@ google.com</option>  
		</select>
	</div>
	
  </div>
  
  <div class="form-group">
  	<label for="mobile1" class="col-sm-offset-1 col-sm-2 control-label">Mobile</label>
    <div class="col-sm-2">
	    <select name="mobile1" id="mobile1" class="form-control">
			  <option value="010">010</option>
			  <option value="016">016</option>
			  <option value="018">018</option>
			  <option value="019">018</option>
		</select>
	</div>
	<div class="col-sm-2">
      <input type="text" class="form-control" name="mobile2">
    </div>
    <div class="col-sm-2">
      <input type="text" class="form-control" name="mobile3">
    </div>
  </div>
  
  <div class="form-group">
  	<label for="birth1" class="col-sm-offset-1 col-sm-2 control-label">Birth</label>
    <div class="col-sm-2">
	    <select name="birth1" id="birth1" class="form-control">
			  <option value="1990">1990년</option>
			  <option value="1991">1991년</option>
			  <option value="1992">1992년</option>
			  <option value="1993">1993년</option>
			  <option value="1994">1994년</option>
			  <option value="1995">1995년</option>
			  <option value="1996">1996년</option>
			  <option value="1997">1997년</option>
			  <option value="1998">1998년</option>
			  <option value="1999">1999년</option>
			  <option value="2000">2000년</option>
		</select>
	</div>
	<div class="col-sm-2">
	    <select name="birth2" class="form-control">
			  <option value="01">1월</option>
			  <option value="02">2월</option>
			  <option value="03">3월</option>
			  <option value="04">4월</option>
			  <option value="05">5월</option>
			  <option value="06">6월</option>
			  <option value="07">7월</option>
			  <option value="08">8월</option>
			  <option value="09">9월</option>
			  <option value="10">10월</option>
			  <option value="11">11월</option>
			  <option value="12">12월</option>
		</select>
	</div>
	<div class="col-sm-2">
	    <select name="birth3" class="form-control">
			  <option value="01">1일</option>
			  <option value="02">2일</option>
			  <option value="03">3일</option>
			  <option value="04">4일</option>
			  <option value="05">5일</option>
			  <option value="06">6일</option>
			  <option value="07">7일</option>
			  <option value="08">8일</option>
			  <option value="09">9일</option>
			  <option value="10">10일</option>
			  <option value="11">11일</option>
			  <option value="12">12일</option>
			  <option value="13">13일</option>
			  <option value="14">14일</option>
			  <option value="15">15일</option>
			  <option value="16">16일</option>
			  <option value="17">17일</option>
			  <option value="18">18일</option>
			  <option value="19">19일</option>
			  <option value="20">20일</option>
			  <option value="21">21일</option><option value="1">1990</option>
			  <option value="22">22일</option>
			  <option value="23">23일</option>
			  <option value="24">24일</option>
			  <option value="25">25일</option>
			  <option value="26">26일</option>
			  <option value="27">27일</option>
			  <option value="28">28일</option>
			  <option value="29">29일</option>
			  <option value="30">30일</option>
			  <option value="31">31일</option>
		</select>
	</div>
  </div>
  
  <div class="form-group">
  <label for="gender" class="col-sm-offset-1 col-sm-2 control-label">Gender</label>  
      <div class="col-sm-8" id="gender">
	      <input type="radio" name="gender" value="M">남자 &nbsp &nbsp &nbsp
	      <input type="radio" name="gender" value="F">여자
      </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-4">
      <button onclick="moveSignPage()" class="col-sm-2 btn btn-info">Sign in</button>
      <span class="col-sm-1"></span>
      <button type="reset" class="col-sm-2 btn btn-info">Reset</button>
    </div>
  </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
    
