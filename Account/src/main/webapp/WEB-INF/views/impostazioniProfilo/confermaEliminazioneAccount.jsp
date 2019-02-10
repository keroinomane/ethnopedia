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
		<title>Eliminazione account</title>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
		<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
		<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
		<link href="${contextPath}/resources/css/jquery.dataTables.min.css" rel="stylesheet">
		<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
		<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
		<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
		<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.0.0.min.js"></script> 
		<script type="text/javascript" src="${contextPath}/resources/js/jquery.dataTables.min.js"></script> 
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
		
		<style>
			table {
				width: 50% !important;
			}
			table, tr, td {
				border:none !important;
			}
			button {
				height:40px;
				width:120px;
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
		      <h1>Eliminazione account</h1>
			</div>
		    <!-- End Intro --> 
		    <!-- Begin container -->
		    <div class="container">
				<c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
				<c:if test="${nick != null}">
			        <form id="logoutForm" method="POST" action="${contextPath}/logout">
			            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        </form>
			        <h4>Ciao ${nick} | <a href="${contextPath}/welcome">Profilo</a> |
			        <c:if test="${user.ruolo eq 'admin'}">
			        <a href="${contextPath}/admin">Pannello di amministrazione</a> | 
			        </c:if>
			        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
			        
			        <br><br>
			        
			        <div align=center>
			        
						<h2>Sei sicuro di voler eliminare il tuo account?</h2>
						
						Proseguendo con questa tua decisione, non potrai più tornare indietro.
						
						<br><br>
						
						<table>
							<tr>
								<td align="center">
									<a href="${contextPath}/impostazioni">
									<button type="button" class="btn btn-default">
										Indietro
									</button>
									</a>
								</td>
								<td align="center">
									<a href="${contextPath}/eliminaAccount/${nick}">
									<button type="button" class="btn btn-danger">
										Elimina
									</button>
									</a>
								</td>
							</tr>
						</table> 
					
					</div>
				</c:if> 
			</div>
		
		    <!-- End Container --> 
		    
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