<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../basis/alto.html" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inserisci password</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<link href="${contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script> 
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	 
	<style>
		tr {
			vertical-align: middle;
		}
	</style>
	<script>
		function checkPass() {
			var pass1 = document.getElementById('pass1');
			var pass2 = document.getElementById('pass2');
			var message = document.getElementById('confirmMessage');
			var goodColor = "#66cc66";
			var badColor = "#ff6666";
			if (pass1.value == pass2.value) {
				pass2.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "OK!"
			} else {
				pass2.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "Password errata!"
			}
		};
		
	</script>
</head>
<body>
<div id="container" style="margin: auto !important;"> 
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
      <h1>Cambia password</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
		<form:form method="POST" modelAttribute="cambioPassword" class="form-signin" action="${contextPath}/changePassword" >
			<h2 class="form-signin-heading" align=center>Inserisci la nuova password</h2>
			<br>
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="Password" id="pass1"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="passwordConfirm">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="passwordConfirm"
						class="form-control" placeholder="Confirm password" id="pass2"
						onkeyup="checkPass(); return false;"></form:input>
					<form:errors path="passwordConfirm"></form:errors>
					<span id="confirmMessage" class="confirmMessage"></span>
				</div>
			</spring:bind>
			
			<spring:bind path="username">
				<form:input type="hidden" path="username" id="username"></form:input>
			</spring:bind>
			
			<spring:bind path="link">
				<form:input type="hidden" path="link" id="link"></form:input>
			</spring:bind>
		
			<button class="btn btn-lg btn-primary btn-block" type="submit">Change</button>
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
		</form:form>
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