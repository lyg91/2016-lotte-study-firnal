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
	if(confirm('������ ȸ�� ������ �Ͻðڽ��ϱ�?')) {
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
			  <option value="1990">1990��</option>
			  <option value="1991">1991��</option>
			  <option value="1992">1992��</option>
			  <option value="1993">1993��</option>
			  <option value="1994">1994��</option>
			  <option value="1995">1995��</option>
			  <option value="1996">1996��</option>
			  <option value="1997">1997��</option>
			  <option value="1998">1998��</option>
			  <option value="1999">1999��</option>
			  <option value="2000">2000��</option>
		</select>
	</div>
	<div class="col-sm-2">
	    <select name="birth2" class="form-control">
			  <option value="01">1��</option>
			  <option value="02">2��</option>
			  <option value="03">3��</option>
			  <option value="04">4��</option>
			  <option value="05">5��</option>
			  <option value="06">6��</option>
			  <option value="07">7��</option>
			  <option value="08">8��</option>
			  <option value="09">9��</option>
			  <option value="10">10��</option>
			  <option value="11">11��</option>
			  <option value="12">12��</option>
		</select>
	</div>
	<div class="col-sm-2">
	    <select name="birth3" class="form-control">
			  <option value="01">1��</option>
			  <option value="02">2��</option>
			  <option value="03">3��</option>
			  <option value="04">4��</option>
			  <option value="05">5��</option>
			  <option value="06">6��</option>
			  <option value="07">7��</option>
			  <option value="08">8��</option>
			  <option value="09">9��</option>
			  <option value="10">10��</option>
			  <option value="11">11��</option>
			  <option value="12">12��</option>
			  <option value="13">13��</option>
			  <option value="14">14��</option>
			  <option value="15">15��</option>
			  <option value="16">16��</option>
			  <option value="17">17��</option>
			  <option value="18">18��</option>
			  <option value="19">19��</option>
			  <option value="20">20��</option>
			  <option value="21">21��</option><option value="1">1990</option>
			  <option value="22">22��</option>
			  <option value="23">23��</option>
			  <option value="24">24��</option>
			  <option value="25">25��</option>
			  <option value="26">26��</option>
			  <option value="27">27��</option>
			  <option value="28">28��</option>
			  <option value="29">29��</option>
			  <option value="30">30��</option>
			  <option value="31">31��</option>
		</select>
	</div>
  </div>
  
  <div class="form-group">
  <label for="gender" class="col-sm-offset-1 col-sm-2 control-label">Gender</label>  
      <div class="col-sm-8" id="gender">
	      <input type="radio" name="gender" value="M">���� &nbsp &nbsp &nbsp
	      <input type="radio" name="gender" value="F">����
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
    
