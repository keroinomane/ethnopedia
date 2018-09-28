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
	
	    <title>Sezione donatori</title>
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
			width:50%;
		}
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#peopleClade').DataTable( {
			    	"paging": false,
			    	"filter": false,
			    	"bInfo" : false
			    } );
				$('#peopleMtdna').DataTable( {
			    	"paging": false,
			    	"bInfo" : false
			    } );
			});
		</script>
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
		      <h1>Sezione donatori</h1>
			</div>
		    <!-- End Intro --> 
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
			        <c:if test="${personeClade != null }">
			        
				        Questi sono gli utenti che hanno il tuo stesso clade Y-DNA.<br>
				        Per questione di privacy, al posto del nome troverai un numero identificativo univoco.
				        
				        <br><br>
				        
						<table id ="peopleClade" width="50%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Clade</th>
									<th>Subclade</th>
									<th>Deepest known clade</th>
									<th>Provincia</th>
									<th>Contatta</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${personeClade}" var="people">
									<tr>
										<td>${people.id}</td>
										<td>${people.ydnaId.aplogruppo}-${people.clade}</td>
										<td>${people.subclade}</td>
										<td>${people.downstream}</td>
										<td>${people.ydnaId.provincia}</td>
										<td>
											<a href="<c:url value='contatta/${people.id}' />" >
													<span class="glyphicon glyphicon-envelope"></span>
												</button>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table> 
					</c:if>
					
					<br><br>
					
					<c:if test="${personeMtdna != null }">
			        
				        Questi sono gli utenti che hanno il tuo stesso aplogruppo mtDNA.<br>
				        Per questione di privacy, al posto del nome troverai un numero identificativo univoco.<br>
				        A destra, puoi digitare nella casella di ricerca una parola chiave<c:if test="${cladeMtdnaUtente != null}">, ad esempio il tuo clade specifico: <b>${cladeMtdnaUtente}</b></c:if>.
				        
				        <br><br>
				        
						<table id ="peopleMtdna" width="50%">
							<thead>
								<tr>
									<th>ID</th>
									<th>Aplogruppo</th>
									<th>Clade</th>
									<th>Provincia</th>
									<th>Contatta</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${personeMtdna}" var="peopleMtdna">
									<tr>
										<td>${peopleMtdna.id}</td>
										<td>${peopleMtdna.mtdnaId.aplogruppo}</td>
										<td>${peopleMtdna.clade}</td>
										<td>${peopleMtdna.mtdnaId.provincia}</td>
										<td>
											<a href="<c:url value='contatta/${peopleMtdna.id}' />" >
													<span class="glyphicon glyphicon-envelope"></span>
												</button>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table> 
					</c:if>
					
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
		        <p>� Copyright 2018 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
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