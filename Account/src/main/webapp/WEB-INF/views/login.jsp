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
	table, tr, td {
		border:0;
	}
	.form-signin {
    	margin: 0;
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
	<table style="border-left:0;
		border-top:0;border-right:0;">
		<tr style="border-left:0;
			border-top:0;">
			<td style="border-right:0;vertical-align:middle;" align="right">
				<form method="POST" action="${contextPath}/login" class="form-signin">
			        <div class="form-group ${error != null ? 'has-error' : ''}">
			            <span>${message}</span>
			            <input name="username" type="text" class="form-control" placeholder="Username"
			                   autofocus="true"/>
			            <input name="password" type="password" class="form-control" placeholder="Password"/>
			            <span>${error}</span>
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
			            <h4 class="text-center"><a href="${contextPath}/registration">Crea un nuovo account</a></h4>
			        </div>
			
			    </form>
		    </td>
			<td width=29% style="border-right:0;">
				<a href="http://www.dpbolvw.net/click-8289828-12899160" target="_top">
					<img src="http://www.awltovhc.com/image-8289828-12899160" width="100%" alt="" border="0"/>
				</a>
			</td>
		</tr>
	</table>	
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
        <p>© Copyright 2017 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
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