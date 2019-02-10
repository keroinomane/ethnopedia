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
		
		<script type="text/javascript">
			function deleteYdna(id) {
				var contextPath = "${contextPath}";
				$.ajax({
					url: contextPath + '/deleteYdna',
					data: {'id':id},
					success: function() {
			    	    window.location.reload(true);
			    	},
			    	error: function() {
			    		$("#errorModal").modal();
			    	}
			    });
			};
			function deleteMtdna(id) {
				var contextPath = "${contextPath}";
				$.ajax({
					url: contextPath + '/deleteMtdna',
					data: {'id':id},
					success: function() {
			    	    window.location.reload(true);
			    	},
			    	error: function() {
			    		$("#errorModal").modal();
			    	}
			    });
			};
		</script>
		<style>
			.scrivania {
				border: none;
				text-align:center;
			    vertical-align:middle;
			    height: 150;
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
		      <h1>Amministrazione</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
		
		    <c:if test="${user.ruolo eq 'admin'}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		        <h4>Ciao ${pageContext.request.userPrincipal.name} | <a href="${contextPath}/welcome">Profilo</a> | 
		        <a href="${contextPath}/statistiche">Statistiche</a> | 
		        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
		        <br>

		        <table style="border:none;">
		        	<tr style="border:none;">
		        		<td style="border:none;">
		        			<h4>Y-DNA da approvare:</h4>
		        			<br>
					        <table style="width:90%;">
						        <tr>
						        	<td><b>Cognome</b></td>
						        	<td><b>Nome</b></td>
						        	<td><b>Aplogruppo</b></td>
						        	<td><b>Clade</b></td>
						        	<td><b>Provincia</b></td>
						        </tr>
						        <c:forEach items="${ydnaBozza}" var="yb">
						        	<tr>
						        		<td>${yb.cognome}</td>
						        		<td>${yb.nome}</td>
						        		<td>${yb.aplogruppo}</td>
						        		<td>${yb.clade}</td>
						        		<td>${yb.provincia}</td>
						        		
						        		<td>
											<a href="<c:url value='/insertYdna/${yb.id}' />" >
												<span class="glyphicon glyphicon-floppy-disk" ></span>
											</a>
										</td>
						        		<td>
											<button type="button" class="btn btn-default btn-xs btn-danger" onclick="deleteYdna(${yb.id})">
												<span class="glyphicon glyphicon-trash"></span>
											</button>
										</td>
						        	</tr>
								</c:forEach>
							</table>
		        		</td>
		        		<td style="border:none;">
		        			<h4>mtDNA da approvare:</h4>
		        			<br>
					        <table style="width:90%;">
						        <tr>
						        	<td><b>Cognome</b></td>
						        	<td><b>Nome</b></td>
						        	<td><b>Aplogruppo</b></td>
						        	<td><b>Provincia</b></td>
						        </tr>
						        <c:forEach items="${mtdnaBozza}" var="mb">
						        	<tr>
						        		<td>${mb.cognome}</td>
						        		<td>${mb.nome}</td>
						        		<td>${mb.aplogruppo}</td>
						        		<td>${mb.provincia}</td>
						        		<td>
											<a href="<c:url value='/insertMater/${mb.id}' />" >
												<span class="glyphicon glyphicon-floppy-disk" ></span>
											</a>
										</td>
						        		<td class="td-right-bordered pdfIgnore" style="text-align: center;">
											<button type="button" class="btn btn-default btn-xs btn-danger" onclick="deleteMtdna(${mb.id})">
												<span class="glyphicon glyphicon-trash"></span>
											</button>
										</td>
						        	</tr>
								</c:forEach>
							</table>
		        		</td>
		        	</tr>
		        </table>
		        <table class="scrivania">
		        	<tr class="scrivania">
		        		<td class="scrivania">
		        			<h4>
		        			<a style="text-decoration: none" href="<c:url value='/scorciatoiaAplo' />" >
		        			<button type="button" class="btn btn-success">
								<span class="glyphicon glyphicon-pencil"></span>
							</button>
							</a>&nbsp
							Inserisci aplogruppi utenti manualmente
							</h4>
		        		</td>
		        		<td class="scrivania">
		        			<h4>
		        			<a style="text-decoration: none" href="<c:url value='/autosomalPuri' />" >
						        <button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-stats"></span>
								</button>
							</a>&nbsp
					        Medie autosomiche regionali
					        </h4>
		        		</td>
		        		<td class="scrivania">
		        			<h4>
		        			<a style="text-decoration: none" href="<c:url value='/aggiornaYdnaProvinceConPiuDi10Campioni' />" >
						        <button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-stats"></span>
								</button>
							</a>&nbsp
					        Medie Y-DNA provinciali
					        </h4>
		        		</td>
		        		<td class="scrivania">
		        			<h4>
		        			<a style="text-decoration: none" href="<c:url value='/insertAncientYdna' />" >
		        			<button type="button" class="btn btn-success">
								<span class="glyphicon glyphicon-plus"></span>
							</button>
							</a>&nbsp
		        			Inserisci DNA antico
		        			</h4>
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