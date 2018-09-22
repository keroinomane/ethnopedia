<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="basis/alto.html" %>
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
	
	    <title>Statistiche Ethnopedia</title>
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
			table, tr, td {
				border: none !important;
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
		      <h1>Aplogruppi mtDNA per macroregione</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
			<c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
			<c:if test="${nick != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		        <h4>Ciao ${nick} | <a href="${contextPath}/welcome">Profilo</a> | <a href="${contextPath}/statistiche">Statistiche</a> |
			   	<c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
			    	<a href="${contextPath}/admin">Pannello di amministrazione</a> | 
			    </c:if>
			    <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
				<br>
				<c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
					<div>
				   		<h4>
				   		<a style="text-decoration: none" href="<c:url value='aggiornaAploMtdnaMacroregioni' />" >
						<button type="button" class="btn btn-success">
							<span class="glyphicon glyphicon-stats"></span>
						</button>
						</a>
				   		Aggiorna
				   		</h4>
				    </div>
				    <br>
			    </c:if>
			    <b>N.B.</b><br>
			    Con H* si intendono tutti gli aplogruppi discendenti da H ma negativi a H1, H2, H3, H4 e H5.
			    <br><br>
			    <table>
			    	<tr>
			    		<td>
			    			<img src="http://www.ethnopedia.info/account_img/graficiMtdna/nordovest.png" width="100%"/>
			    		</td>
			    		<td>
							<img src="http://www.ethnopedia.info/account_img/graficiMtdna/nordest.png" width="100%"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<img src="http://www.ethnopedia.info/account_img/graficiMtdna/centro.png" width="100%"/>
			    		</td>
			    		<td>
							<img src="http://www.ethnopedia.info/account_img/graficiMtdna/sud.png" width="100%"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td>
			    			<img src="http://www.ethnopedia.info/account_img/graficiMtdna/sicilia.png" width="100%"/>
			    		</td>
			    		<td>
			    			<img src="http://www.ethnopedia.info/account_img/graficiMtdna/sardegna.png" width="100%"/>
			    		</td>
			    	</tr>
			    	
			    </table>
		    </c:if>  	
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