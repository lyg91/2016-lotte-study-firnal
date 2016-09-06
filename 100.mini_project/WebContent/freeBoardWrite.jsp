<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>FreeBoard</title>

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
function moveEntryPage() {
	if(confirm('게시글을 등록하시겠습니까?')) {
		document.entryForm.action = "Controller?action=boardEntry";
		document.entryForm.submit();
	}
}

function moveListPage() {
	if(confirm('글 작성을 취소시겠습니까?')) {
		document.entryForm.action = "Controller?action=boardList&pageNum=1";
		document.entryForm.submit();
	}
}
</script>
</head>
<body>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-list-alt"></span> FreeBoard & Vote</h1><br/><br/>
<h5 class="text-center">주제에 상관없이 자유롭게 대화해주세요</h5><br/>
<form class="form-horizontal" name="entryForm" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="bTitle" class="col-sm-2 control-label">제목</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name="bTitle" id="bTitle" placeholder="Input Title">
    </div>
  </div>
  <div class="form-group">
    <label for="bPw" class="col-sm-2 control-label">암호</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" name="bPw" id="bPw" placeholder="Input Password">
    </div>
  </div>
  <div class="form-group">
    <label for="bContent" class="col-sm-2 control-label">내용</label>
    <div class="col-sm-8">
   		<textarea class="form-control" name="bContent" rows="7"></textarea>   
    </div>
  </div>
  
  <div class="form-group">
    <label for="bFile1" class="col-sm-2 control-label">사진 업로드</label>
    <div class="col-sm-3">
    	<input type="file" class="form-control" name="bFile1" id="bFile1">
    </div>
    <div class="col-sm-3">
    	<input type="file" class="form-control" name="bFile2" id="bFile2">
    </div>
    <div class="col-sm-offset-2 col-sm-3">
    	<input type="file" class="form-control" name="bFile3" id="bFile3">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-6">
      <button type="button" onclick="moveEntryPage()" class="col-sm-2 btn btn-info">글쓰기</button>
      <button type="button" onclick="moveListPage()" class="col-sm-2 btn btn-info">취소</button>
    </div>
  </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>