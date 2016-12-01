<!DOCTYPE html>
<%@ include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<link href="${rootURL}resources/css/Login.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/app.js"></script>
</head>
<body>
		<div class="col-md-6 col-md-offset-2 errorContainer">
		<c:if test="${param.error != null}">
             <div class="alert alert-danger">
                 Invalid UserName and Password.
             </div>
         </c:if>
         <c:if test="${param.logout != null}">
             <div class="alert alert-success">
                 You have been logged out.
             </div>
         </c:if>
         </div>

     <div class="row loginBlockWrapper">
		<div class="col-md-6 col-md-offset-2 loginContainerWrapper">
			<h2 class = "labelNameForm">User Login Form</h2>
			<form:form id="loginForm" method="post" action="${rootURL}login" modelAttribute="user"
		class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
		  <div class="form-group">
		    <div class="col-sm-4 width100">
		      <input type="text" id="username" name="username" class="form-control usernametextbox" placeholder="Enter Username" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-4 width100">
		      <input type="password" id="password" name="password" class="form-control passwordtextbox" placeholder="Enter Password" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4 buttonWrapper">
		      <input type="submit" class="btn btn-primary" value="Login">
		    </div>
		  </div>

		</form:form>
	</div>
</div>


</body>
</html>
