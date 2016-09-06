<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "work.model.dto.Board"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
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
function moveListPage() {
	document.entryForm.action = "Controller?action=boardList&pageNum=1";
	document.entryForm.submit();
}
</script>
</head>
<body>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-list-alt"></span> FreeBoard & Vote</h1><br/><br/>
<h5 class="text-center">주제에 상관없이 자유롭게 대화해주세요</h5><br/>
<hr/>
<% 
	String message = (String)request.getAttribute("message");
	if(message != null) {
%>
<script>
	alert('<%=message%>');
</script>
<%
	}
	Board dto = (Board)request.getAttribute("dto");
%>
<form class="form-horizontal" name="entryForm" method="post">
  <div class="form-group">
    <label for="bTitle" class="col-sm-2 control-label">제목</label>
    <div class="col-sm-8">
      <label class="text-center"><%=dto.getbTitle()%></label>
    </div>
  </div>
  <div class="form-group">
    <label for="bContent" class="col-sm-2 control-label">작성자</label>
    <div class="col-sm-8">
      <label class="text-center"><%=dto.getbAuthor()%></label>
    </div>
  </div>
  <div class="form-group">
    <label for="bDate" class="col-sm-2 control-label">작성일</label>
    <div class="col-sm-8">
      <label class="text-center"><%=dto.getbDate()%></label>
    </div>
  </div>
  <div class="form-group">
    <label for="bContent" class="col-sm-2 control-label">내용</label>
    <div class="col-sm-7">
   		<textarea class="form-control" name="bContent" rows="7" readonly><%=dto.getbContent()%></textarea>   
    </div>
  </div>
  <div class="form-group">
    <label for="bContent" class="col-sm-2 control-label">사진</label>&nbsp &nbsp &nbsp
  <%if(dto.getbFile1() != null) { %>
  <img src="<%=dto.getbFile1()%>" width="200px" height="150px" onclick="if(confirm('해당 항목을 추천하시겠습니까?')){document.location.href='Controller?action=boardRecommend&rNum=1&boardNum=<%=request.getParameter("boardNum")%>'}"/>
  <label><span class="glyphicon glyphicon-thumbs-up"></span>추천수<%=dto.getbRecommend1()%></label>
  <%}%>
  <%if(dto.getbFile2() != null) { %>
  <img src="<%=dto.getbFile2()%>" width="200px" height="150px" onclick="if(confirm('해당 항목을 추천하시겠습니까?')){document.location.href='Controller?action=boardRecommend&rNum=2&boardNum=<%=request.getParameter("boardNum")%>'}"/>
  <label><span class="glyphicon glyphicon-thumbs-up"></span>추천수<%=dto.getbRecommend2()%></label>
  <%}%>
  <%if(dto.getbFile3() != null) { %>
  <img src="<%=dto.getbFile3()%>" width="200px" height="150px" onclick="if(confirm('해당 항목을 추천하시겠습니까?')){document.location.href='Controller?action=boardRecommend&rNum=3&boardNum=<%=request.getParameter("boardNum")%>'}"/>
  <label><span class="glyphicon glyphicon-thumbs-up"></span>추천수<%=dto.getbRecommend3()%></label> 
  <%}%>
  </div>
 
  
  <div class="form-group">
    <label for="bDate" class="col-sm-2 control-label">조회수</label>
    <div class="col-sm-8">
      <label class="text-center"><%=dto.getbHit()%></label>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-8">
      <%if(session.getAttribute("uGrade") != null || session.getAttribute("uId") != null) {%>
      <%if(session.getAttribute("uGrade").equals("A") || (session.getAttribute("uId").equals(dto.getbAuthor()))) { %>
      <button type="button" onclick="if(confirm('게시글을 수정하시겠습니까?')){document.location.href='Controller?action=boardSearch&opt=update&boardNum=<%=request.getParameter("boardNum")%>'}" class="col-sm-2 btn btn-warning">수정</button>
      <button type="button" onclick="if(confirm('게시글을 삭제하시겠습니까?')){document.location.href='Controller?action=boardDelete&boardNum=<%=request.getParameter("boardNum")%>'}" class="col-sm-2 btn btn-warning">삭제</button>
      <%}
        }%> 
      <button type="button" onclick="moveListPage()" class="col-sm-2 btn btn-info">목록</button>
    </div>
  </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>