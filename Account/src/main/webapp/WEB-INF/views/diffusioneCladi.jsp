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
		<style type="text/css">
			#seleziona {
				width: 75%;
			}
			.bordi {
				border:none;
			}
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
			    $('#cladeRegioni').DataTable( {
			    	"sDom": 'rt',
			    	paging: false
			    } );
			    viewCladi();
			});
			
			function viewCladi() {
				reset();
	            $.ajax({
	            	type: 'get', 
	            	dataType: 'json',
	            	url: "${contextPath}/getCladiByAplo",
	            	data:'aplo='+ $('#aplogruppi').val(),
	            	success: function (data) {
	            		$('#cladi').find('option').remove().end();
				        $.each(data, function (i, item) {
				           	$('#cladi').append($('<option>', { 
				           		value: item,
				           	    text : item
				           	}));
				        });
			        }
	           	});
			}
			
			function viewSubcladi() {
				
				if ($('#checkSubclade').is(':checked')) {
		            $.ajax({
		            	type: 'get', 
		            	dataType: 'json',
		            	url: "${contextPath}/getSubcladiByClade",
		            	data:'clade='+ $('#cladi').val(),
		            	success: function (data) {
		            		$('#subcladi').find('option').remove().end();
					       	$.each(data, function (i, item) {
					           	$('#subcladi').append($('<option>', { 
					           		value: item,
					           	    text : item
					           	}));
					       	});
					       	$('#fClade').html("Frequenza "+$("#subcladi option:first").val());
				        }
		           	});
				} else {
					reset();
				}
			};
			
			function reset() {
				$('#checkSubclade').prop('checked', false);
				$('#subcladi').find('option').remove().end();
			}
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
		      <h1>Diffusione di un clade</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
			<c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
			<c:if test="${nick != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		        <h4>Ciao ${nick} | <a href="${contextPath}/welcome">Profilo</a> |
			   	<c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
			    	<a href="${contextPath}/admin">Pannello di amministrazione</a> | 
			    </c:if>
			    <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
				<br>
				<div>
					<h4>
					Seleziona il clade desiderato:
				   	</h4>
				   	<form action="${contextPath}/calcolaFrequenzaClade" method="get">
					   	<table id="seleziona" class="bordi">
					   		<tr class="bordi">
					   			<td class="bordi">
								   	<label>Aplogruppo:</label>
								   	<select name="aplogruppi" id ="aplogruppi" onchange="viewCladi()">
										<option value="E1b1b">E1b1b</option>
										<option value="G2a">G2a</option>
										<option value="I1">I1</option>
										<option value="I2">I2</option>
										<option value="J1">J1</option>
										<option value="J2">J2</option>
										<option value="R1a">R1a</option>
										<option value="R1b">R1b</option>
										<option value="T">T</option>
								   	</select>
								</td>
								<td class="bordi">
								   	<label>Clade:</label>
								   	<select name="cladi" id ="cladi" onchange="viewSubcladi()">
								   	</select>
								</td>
								<td class="bordi">
								   	<input type="checkbox" id="checkSubclade" name ="checkSubclade" onchange="viewSubcladi()"></input>
								   	<label>Subclade:</label>
								   	<select name="subcladi" id ="subcladi">
								   	</select>
								</td>
								<td class="bordi">
									<button id="invia" type="submit">
			    						Cerca
			    					</button>
								</td>
							</tr>
					   	</table>
				   	</form>
				</div>
			    
			    <br>
			    
			    <c:if test="${cfr != null}">
				    <table id="cladeRegioni" style="width:50%">
						<thead>
							<tr>
								<th width="50%">Regione</th>
								<th>${cfr.nome}</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cfr.frequenzePerOgniRegione}" var="fr">
								<c:if test="${fr.campioni > 15}">
									<tr>
										<td>${fr.regione}</td>
										<td>${fr.frequenza}%</td>
									</tr>
								</c:if>
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