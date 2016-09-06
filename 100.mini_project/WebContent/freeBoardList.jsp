<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import="java.util.ArrayList"
    import="work.model.dto.Board"%>
<!DOCTYPE html>
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
<script>
<% if (request.getAttribute("message") != null) {%>
	alert('<%=request.getAttribute("message")%>');
<% } %>
</script>
<jsp:include page="menuBar.jsp"/>
<h1 class="text-center"><span class="glyphicon glyphicon-list-alt"></span> FreeBoard & Vote</h1><br/><br/>
<form method="post" action="Controller?action=boardListSearch&pageNum=1">
<div class="col-sm-offset-7">
	 <select class="col-sm-4" name="sType">
	 <option value="b_title">제목</option>
	 <option value="b_author">작성자</option>
	 </select>
	 <input type="text" class="col-sm-4" name="sTitle" id="bTitle">
	 <button type="submit" class="col-sm-2">검색</button>
</div>
</form>
<table class="table table-hover">
<tr>
<th class="col-sm-1" align="center">구분</th>
<th align="center">제목</th>
<th align="center">작성자</th>
<th align="center">작성일</th>
<th align="center">조회수</th>
</tr>
<%
	ArrayList list = (ArrayList)request.getAttribute("list");
	Board dto = null;
	for(int i = 0; i < list.size(); i++) {
		dto = (Board)list.get(i);
	
%>
<%if(dto.getbNotice()==1) { %>
<tr class="danger">
<td><span class="glyphicon glyphicon-bell"></span>[공지]</td>
<td><a href="Controller?action=boardSearch&boardNum=<%=dto.getbNumber()%>"><%=dto.getbTitle() %></a></td>
<td><%=dto.getbAuthor() %></td>
<td><%=dto.getbDate() %></td>
<td><%=dto.getbHit() %></td>
</tr>
<%} else { %>
<tr>
<td><span class="glyphicon glyphicon-thumbs-up"></span>[일반]</td>
<td><a href="Controller?action=boardSearch&boardNum=<%=dto.getbNumber()%>"><%=dto.getbTitle() %></a></td>
<td><%=dto.getbAuthor() %></td>
<td><%=dto.getbDate() %></td>
<td><%=dto.getbHit() %></td>
</tr>
<%}%>
<%}%>
</table>
<%if(session.getAttribute("uId") != null) { %>
<div class="col-sm-offset-10">
     <button type="button" onclick="document.location.href='freeBoardWrite.jsp'" class="col-sm-4 btn btn-info">글쓰기</button>
</div>
<%} %>
<br/><br/>
<nav align="center">
  <ul class="pagination">
    <li>
      <a href="Controller?action=boardList&pageNum=<%=Integer.parseInt(request.getParameter("pageNum"))-1%>" aria-label="Next">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <%for(int i = 0; i < dto.getbCount(); i++) { %>
    	<li><a href="Controller?action=boardList&pageNum=<%=i+1%>"><%=i+1%></a></li>
    <%} %>
    <li>
      <a href="Controller?action=boardList&pageNum=<%=Integer.parseInt(request.getParameter("pageNum"))+1%>" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<jsp:include page="footer.jsp"/>
</body>
</html>