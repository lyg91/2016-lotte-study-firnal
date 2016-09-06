<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<style>
    .pageContainer {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
    }
    .navbar{
    	background-color: #B84D45;
    }
    
    #notice {
		color: #000;   
    }
    
    #service {
    	color: #000;
    }
    
	#vote {
		color: #000;
	}
	
	#free {
		color: #000;
	}
</style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home">Home</span></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="service.jsp" class="navbar-link"><span class="glyphicon glyphicon-bullhorn"></span> Information</a>
                    </li>
                    <li>
                        <a href="Controller?action=boardList&pageNum=1" class="navbar-link"><span class="glyphicon glyphicon-thumbs-up"></span> Board & Vote</a>
                    </li>
                    <%if (session.getAttribute("uId") != null && session.getAttribute("uGrade").equals("A")) {%>
                    <li>
                    	<a href="Controller?action=usersInfo" class="navbar-link"><span class="glyphicon glyphicon-zoom-out"></span> Admin Page</a>
                    </li>
                    <%}%>
                </ul>                
                <ul class="nav navbar-nav pull-right">
                	<%if (session.getAttribute("uId") == null) { %>
                	<li>
                		<a href="signIn.jsp" class="navbar-link"><span class="glyphicon glyphicon-user"></span> Sign In</a>
                	</li>             	
	                <li>
	                	<a href="login.jsp" class="navbar-link"><span class="glyphicon glyphicon-zoom-out"></span> Login</a>
	                </li>
                	<%} else { %>
                		<li>
	                		<a href="Controller?action=myInfo" class="navbar-link"><span class="glyphicon glyphicon-zoom-in"></span> My Info</a>
	                	</li>
	                	<li>
	                		<a href="Controller?action=logout" class="navbar-link"><span class="glyphicon glyphicon-remove"></span> Logout</a>
	                	</li>
                	<%} %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="pageContainer">
        <div class="row">
            <div class="col-sm-12 text-center">
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->