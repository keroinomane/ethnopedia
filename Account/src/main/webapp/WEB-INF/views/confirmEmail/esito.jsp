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
	<title>Inserisci email</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<style>
		tr {
			vertical-align: middle;
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
      <h1>Conferma e-mail</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
    	<c:if test="${message != null}">
    		<br><br>
    		${message}
		</c:if>
	
<br><br><br>
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
        <p>© Copyright 2018 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
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