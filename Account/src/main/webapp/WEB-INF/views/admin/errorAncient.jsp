<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../basis/alto.html" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Amministrazione Ethnopedia</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
		<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
		<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
		<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
		<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
		<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
		<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.0.0.min.js"></script> 
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>	
		<script type="text/javascript" src="${contextPath}/resources/js/jquery.chained.min.js"></script>
		<style type="text/css">
			table, td, tr {
			   border:0 !important;
			   vertical-align:middle !important; 
			   
			} 
			input[type="text"] {
				width:100%;
				height: 25px;
			}
			select {
				height: 25px;
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
		      <h1>Errore</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
		
		    <c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
			<c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				<h4>Ciao ${nick} | <a href="${contextPath}/welcome">Profilo</a> | 
				<a href="${contextPath}/admin">Pannello di amministrazione</a> | 
				<a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
		        <br>
		  
				<div align=center width=100%>
				
					Attenzione!<br><br>
					Il campione da te inserito è già esistente.<br><br><br><br>
					
					<a href="${contextPath}/insertAncientYdna" class="btn btn-default">
					Indietro
					</a>
								
					
				</div>	 
			</c:if>
		</div>
		<!-- End About --> 
		    
		  </div>
		  
		  <!-- End Wrapper -->
		  <div class="clearfix"></div>
		  <div class="push"></div>
		</div>
		
		<!-- Begin Footer -->
		<div id="footer-wrapper" style="padding-top: 335px;">
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