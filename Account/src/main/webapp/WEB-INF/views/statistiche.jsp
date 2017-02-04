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
			#scrivania {
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
		      <h1>Statistiche</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
		
			<table>
				<tr>
					<td id="scrivania" style="border:none;" align="center">
		        		<h4>
		        		<a style="text-decoration: none" href="<c:url value='/calcMediaAploRegioni' />" >
		       			<button type="button" class="btn btn-success">
							<span class="glyphicon glyphicon-stats"></span>
						</button>
						</a>&nbsp
		        		Calcola media aplogruppi per regione
		        		</h4>
		        	</td>
		        	<td>
		        	</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td><b>Regione</b></td>
								<td><b>Campioni</b></td>
								<td><b>E1b1b</b></td>
								<td><b>G2a</b></td>
								<td><b>I1</b></td>
								<td><b>I2</b></td>
								<td><b>J1</b></td>
								<td><b>J2</b></td>
								<td><b>R1a</b></td>
								<td><b>R1b</b></td>
								<td><b>T</b></td>
							</tr>
							<c:forEach items="${ydnaReg}" var="yr">
								<tr>
									<td>${yr.regione}</td>
									<td>${yr.campioni}</td>
									<td>${yr.e1b1b}</td>
									<td>${yr.g2a}</td>
									<td>${yr.i1}</td>
									<td>${yr.i2}</td>
									<td>${yr.j1}</td>
									<td>${yr.j2}</td>
									<td>${yr.r1a}</td>
									<td>${yr.r1b}</td>
									<td>${yr.t}</td>
								</tr>
							</c:forEach>
						</table>
		        	</td>
		        	<td>
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