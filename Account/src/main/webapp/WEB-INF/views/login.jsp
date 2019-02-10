<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="basis/alto.html" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accedi</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
<style>
	.container {
		text-align:center;
	}
</style>
</head>
<body>
<div id="container"> 
  
  <c:import url="basis/alto.html" />
  
  <!-- Begin Slider -->
  <div id="cycle-wrapper">
    <div id="sliderholder-cycle"> <img src="${contextPath}/resources/img/header.jpg" width="100%"/>
  </div>
  <!-- End Slider --> 
  
  <!-- Begin Wrapper -->
  <div id="wrapper"> 
    <!-- Begin Intro -->
    <div class="intro">
      <h1>Accedi</h1>
	</div>
    <!-- End Intro --> 
    <div class="container">
				<form method="POST" action="${contextPath}/login" class="form-signin">
			        <div class="form-group ${error != null ? 'has-error' : ''}">
			            <span>${message}</span>
			            <input name="username" type="text" class="form-control" placeholder="Username"
			                   autofocus="true"/>
			            <input name="password" type="password" class="form-control" placeholder="Password"/>
			            <span>${error}</span>
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
			            <br>
			            Non ricordi l'username o la password?&nbsp&nbsp<a href="${contextPath}/emailForPassword">Clicca qui</a><br>
			            Non sei registrato?&nbsp&nbsp<a href="${contextPath}/haiFattoIlTest">Crea un nuovo account</a>
			        </div>
			
			    </form>
		    <a href="http://www.anrdoezrs.net/click-8289828-12899164" target="_top">
				<img src="http://www.lduhtrp.net/image-8289828-12899164" width="728" height="90" alt="" border="0"/>
			</a>
	</div>
    <!-- End About --> 
    
  </div>
  
  <!-- End Wrapper -->
  <div class="clearfix"></div>
  <div class="push"></div>
</div>

<!-- Begin Footer -->
<div id="footer-wrapper">
  <div id="footer">
    <div id="footer-content"> 
      
      <!-- Begin Copyright -->
      <div id="copyright">
        <p>© Copyright 2019 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
		<img src="${contextPath}/resources/style/images/icon-facebook.png" alt="" /></a>
		</p>
      </div>
      <!-- End Copyright -->  
      
    </div>
  </div>
</div>
<!-- End Footer -->
</div>
</body>
</html>