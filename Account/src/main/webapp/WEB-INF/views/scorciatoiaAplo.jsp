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
		<script>
			$(document).ready(function () {
				$("#regione").chainedTo("#macroregione");
				$("#regionem").chainedTo("#macroregionem");
			});
			
			function showYdna() {
				$("#ask").hide();
				$("#ydnaDiv").fadeIn("slow");
			}
			function showMtdna() {
				$("#ask").hide();
				$("#mtdnaDiv").fadeIn("slow");
			}
			function dunnon() {
				if ($('#dunnoname').is(':checked')) {
					$('#nome').val('null');
					$('#nome').prop('readonly', true);
				} else {
					$('#nome').val('');
					$('#nome').prop('readonly', false);
				}
				control();
			};
			function dunnoc() {
				if ($('#dunnoclade').is(':checked')) {
					$('#clade').val('null');
					$('#clade').prop('readonly', true);
					$('#subclade').val('null');
					$('#subclade').prop('readonly', true);
					$('#downstream').val('null');
					$('#downstream').prop('readonly', true);
					$('#dunnosub').prop('checked', true);
					$('#dunnodown').prop('checked', true);
				} else {
					$('#clade').val('');
					$('#clade').prop('readonly', false);
				}
				control();
			};
			function dunnos() {
				if ($('#dunnosub').is(':checked')) {
					$('#subclade').val('null');
					$('#subclade').prop('readonly', true);
					$('#downstream').val('null');
					$('#downstream').prop('readonly', true);
					$('#dunnodown').prop('checked', true);
				} else {
					$('#subclade').val('');
					$('#subclade').prop('readonly', false);
					$('#clade').val('');
					$('#clade').prop('readonly', false);
					$('#dunnoclade').prop('checked', false);
				}
				control();
			};
			function dunnod() {
				if ($('#dunnodown').is(':checked')) {
					$('#downstream').val('null');
					$('#downstream').prop('readonly', true);
				} else {
					$('#downstream').val('');
					$('#downstream').prop('readonly', false);
					$('#subclade').val('');
					$('#subclade').prop('readonly', false);
					$('#dunnosub').prop('checked', false);
					$('#clade').val('');
					$('#clade').prop('readonly', false);
					$('#dunnoclade').prop('checked', false);
				}
				control();
			};
			function dunnomtc() {
				if ($('#dunnocladem').is(':checked')) {
					$('#cladem').val('null');
					$('#cladem').prop('readonly', true);
				} else {
					$('#cladem').val('');
					$('#cladem').prop('readonly', false);
				}
				control();
			};
			function viewimg() {
				 $('#image').attr("src", '${contextPath}/resources/img/cladi/'+$('#aplogruppo').val()+'.png');
			};
			function enlarge() {
				window.open('${contextPath}/resources/img/cladi/'+$('#aplogruppo').val()+'.png', 'newwindow', 'width=1000, height=700'); 
				return false;
			};	
			function control() {
				if ($('#cognome').val() == '' || $('#downstream').val() == '' || $('#clade').val() == '' || $('#subclade').val() == '' || $('#provincia').val() == '')
					$('#bottoney').prop('disabled', true);
				else
					$('#bottoney').prop('disabled', false);
				if ($('#cognomem').val() == '' || $('#nomem').val() == '' || $('#cladem').val() == '' || $('#provinciam').val() == '')
					$('#bottonem').prop('disabled', true);
				else
					$('#bottonem').prop('disabled', false);
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
		      <h1>Inserisci aplogruppo</h1>
			</div>
		    <!-- End Intro --> 
		<div class="container">
		
		    <c:if test="${pageContext.request.userPrincipal.name != null}">
		        <form id="logoutForm" method="POST" action="${contextPath}/logout">
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        </form>
		        <h4>Ciao ${pageContext.request.userPrincipal.name} | 
		        <a href="${contextPath}/welcome">Profilo</a> | 
		        <a href="${contextPath}/admin">Pannello di amministrazione</a> | 
		        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
		        <br>
		  
				<div align=center width=100%>
				
					<div id="ask">
						<table style="width:50%">
							<tr>
								<td align="center">
									<button class="btn btn-default" onclick="showYdna()">
									Inserisci Y-DNA
									</button>
								</td>
								<td align="center">
									<button class="btn btn-default" onclick="showMtdna()">
									Inserisci mtDNA
									</button>
								</td>
							</tr>
						</table>
					</div>
					
					<div id="ydnaDiv" style="display:none">
						<form:form action="${contextPath}/saveYdnaManual" method="post" modelAttribute="ydna">
							<table>
								<tr>
									<td align="right">Cognome: </td><td align=center><form:input path="ydnaId.cognome" value="${ydna.ydnaId.cognome}" id="cognome" onKeyUp="control()" /></td>
									<td align="center"><br><i>Clicca sull'immagine per ingrandirla.</i></td>
								</tr>
								<tr><td align="right">Nome: </td><td><form:input id="nome" path="nome" value="${ydna.nome}" style="width:40%" />
								<input type="checkbox" id='dunnoname' onChange="dunnon()" /> non si sa</td>
									<td rowspan=8 align="center">
										<img id="image" src="${contextPath}/resources/img/cladi/${ydna.ydnaId.aplogruppo}.png" height="310px" onclick="enlarge()"/>
									</td>
								</tr>
								<tr>
									<td align="right">Aplogruppo: </td><td>
										<form:select path="ydnaId.aplogruppo" value="${ydna.ydnaId.aplogruppo}" id="aplogruppo" onchange="viewimg()">
											<form:option value="E1b1b">E1b1b</form:option>
											<form:option value="G2a">G2a</form:option>
											<form:option value="I1">I1</form:option>
											<form:option value="I2">I2</form:option>
											<form:option value="J1">J1</form:option>
											<form:option value="J2">J2</form:option>
											<form:option value="R1a">R1a</form:option>
											<form:option value="R1b">R1b</form:option>
											<form:option value="T">T</form:option>
										</form:select>
									</td>
								</tr>
								<tr><td align="right">Clade: </td><td>
									<form:input path="clade" id="clade" value="${ydna.clade}" style="width:25%;" onKeyUp="control()" />
									<input type="checkbox" id='dunnoclade' onChange="dunnoc()" /> non si sa
								</td></tr>
								<tr><td align="right">Subclade: </td><td>
									<form:input path="subclade" value="${ydna.subclade}" style="width:25%;" onKeyUp="control()" />
									<input type="checkbox" id='dunnosub' onChange="dunnos()" /> non si sa
								</td></tr>
								<tr><td align="right">Deepest known clade: </td><td>
									<form:input path="downstream" value="${ydna.downstream}" style="width:25%;" onKeyUp="control()"/>
									<input type="checkbox" id='dunnodown' onChange="dunnod()" /> non si sa
								</td></tr>
								<tr><td align="right">Macroregione: </td><td>
									<form:select path="macroregione" value="${ydna.macroregione}" id="macroregione">
										<form:option value="nord" selected="selected">Italia settentrionale</form:option>
									    <form:option value="centro">Italia centrale</form:option>
									    <form:option value="sud">Italia meridionale</form:option>
									    <form:option value="sicilia">Sicilia</form:option>
									    <form:option value="sardegna">Sardegna</form:option>
									</form:select>
								</td></tr>
								<tr><td align="right">Regione: </td><td>
									<form:select path="regione" value="${ydna.regione}" id="regione">
									   <form:option value="Abruzzo" class="centro">Abruzzo</form:option>
									   <form:option value="Basilicata" class="sud">Basilicata</form:option>
									   <form:option value="Calabria" class="sud">Calabria</form:option>
									   <form:option value="Campania" class="sud">Campania</form:option>
									   <form:option value="Emilia - Romagna" class="nord">Emilia - Romagna</form:option>
									   <form:option value="Friuli - Venezia Giulia" class="nord">Friuli - Venezia Giulia</form:option>
									   <form:option value="Lazio" class="centro">Lazio</form:option>
									   <form:option value="Liguria" class="nord">Liguria</form:option>
									   <form:option value="Lombardia" class="nord">Lombardia</form:option>
									   <form:option value="Marche" class="centro">Marche</form:option>
									   <form:option value="Molise" class="sud">Molise</form:option>
									   <form:option value="Piemonte" class="nord">Piemonte</form:option>
									   <form:option value="Puglia" class="sud">Puglia</form:option>
									   <form:option value="Sardegna" class="sardegna">Sardegna</form:option>
									   <form:option value="Sicilia" class="sicilia">Sicilia</form:option>
									   <form:option value="Toscana" class="centro">Toscana</form:option>
									   <form:option value="Trentino - Alto Adige" class="nord">Trentino - Alto Adige</form:option>
									   <form:option value="Umbria" class="centro">Umbria</form:option>
									   <form:option value="Valle d'Aosta" class="nord">Valle d'Aosta</form:option>
									   <form:option value="Veneto" class="nord">Veneto</form:option>
									</form:select>
								</td></tr>
								<tr><td align="right">Provincia: </td><td align=center><form:input id="provincia" path="ydnaId.provincia" value="${ydna.ydnaId.provincia}" onKeyUp="control()" /></td></tr>
							</table>
		
							<table style="width:40%;">
								<tr>
									<td align="center"><a href="${contextPath}/admin" class="btn btn-default">Indietro</a></td>
									<td align="center"><input id="bottoney" class="btn btn-primary" type="submit" value="Inserisci" disabled /></td>
								</tr>
							</table>
						</form:form>
					</div>
					<div id="mtdnaDiv" style="display:none">
						<form:form action="${contextPath}/saveMtdnaManual" method="post" modelAttribute="mtdna">
							<table style="width:50%;">
								<tr>
									<td align="right">Cognome: </td><td align=center><form:input path="mtdnaId.cognome" value="${mtdna.mtdnaId.cognome}" id="cognomem" onKeyUp="control()" /></td>
								</tr>
								<tr><td align="right">Nome: </td><td align=center><form:input path="mtdnaId.nome" value="${mtdna.mtdnaId.nome}" id="nomem" onKeyUp="control()" /></td>
								</tr>
								<tr><td align="right">Aplogruppo: </td><td>
									<form:select path="mtdnaId.aplogruppo" value="${mtdna.mtdnaId.aplogruppo}" id="aplogruppo">
										<form:option value="H">H</form:option>
										<form:option value="H1">H1</form:option>
										<form:option value="H2">H2</form:option>
										<form:option value="H3">H3</form:option>
										<form:option value="H4">H4</form:option>
										<form:option value="H5">H5</form:option>
										<form:option value="HV">HV</form:option>
										<form:option value="I">I</form:option>
										<form:option value="J">J</form:option>
										<form:option value="K">K</form:option>
										<form:option value="L">L</form:option>
										<form:option value="M">M</form:option>
										<form:option value="N">N</form:option>
										<form:option value="R">R</form:option>
										<form:option value="T">T</form:option>
										<form:option value="T1">T1</form:option>
										<form:option value="T2">T2</form:option>
										<form:option value="U1">U1</form:option>
										<form:option value="U2">U2</form:option>
										<form:option value="U3">U3</form:option>
										<form:option value="U4">U4</form:option>
										<form:option value="U5">U5</form:option>
										<form:option value="U6">U6</form:option>
										<form:option value="U8">U8</form:option>
										<form:option value="V">V</form:option>
										<form:option value="W">W</form:option>
										<form:option value="X">X</form:option>
									</form:select>
								</td></tr>
								<tr><td align="right">Aplogruppo completo: </td><td>
									<form:input path="clade" id="cladem" value="${mtdna.clade}" style="width:25%;" onKeyUp="control()" />
									<input type="checkbox" id='dunnocladem' onChange="dunnomtc()"/> non si sa
								</td></tr>
								<tr><td align="right">Macroregione: </td><td>
									<form:select path="macroregione" value="${mtdna.macroregione}" id="macroregionem">
										<form:option value="nord" selected="selected">Italia settentrionale</form:option>
									    <form:option value="centro">Italia centrale</form:option>
									    <form:option value="sud">Italia meridionale</form:option>
									    <form:option value="sicilia">Sicilia</form:option>
									    <form:option value="sardegna">Sardegna</form:option>
									</form:select>
								</td></tr>
								<tr><td align="right">Regione: </td><td>
									<form:select path="regione" value="${mtdna.regione}" id="regionem">
									   <form:option value="Abruzzo" class="centro">Abruzzo</form:option>
									   <form:option value="Basilicata" class="sud">Basilicata</form:option>
									   <form:option value="Calabria" class="sud">Calabria</form:option>
									   <form:option value="Campania" class="sud">Campania</form:option>
									   <form:option value="Emilia - Romagna" class="nord">Emilia - Romagna</form:option>
									   <form:option value="Friuli - Venezia Giulia" class="nord">Friuli - Venezia Giulia</form:option>
									   <form:option value="Lazio" class="centro">Lazio</form:option>
									   <form:option value="Liguria" class="nord">Liguria</form:option>
									   <form:option value="Lombardia" class="nord">Lombardia</form:option>
									   <form:option value="Marche" class="centro">Marche</form:option>
									   <form:option value="Molise" class="sud">Molise</form:option>
									   <form:option value="Piemonte" class="nord">Piemonte</form:option>
									   <form:option value="Puglia" class="sud">Puglia</form:option>
									   <form:option value="Sardegna" class="sardegna">Sardegna</form:option>
									   <form:option value="Sicilia" class="sicilia">Sicilia</form:option>
									   <form:option value="Toscana" class="centro">Toscana</form:option>
									   <form:option value="Trentino - Alto Adige" class="nord">Trentino - Alto Adige</form:option>
									   <form:option value="Umbria" class="centro">Umbria</form:option>
									   <form:option value="Valle d'Aosta" class="nord">Valle d'Aosta</form:option>
									   <form:option value="Veneto" class="nord">Veneto</form:option>
									</form:select>
								</td></tr>
								<tr><td align="right">Provincia: </td><td align=center><form:input id="provinciam" path="mtdnaId.provincia" value="${mtdna.mtdnaId.provincia}" onKeyUp="control()" /></td></tr>
							</table>
		
							<table style="width:40%;">
								<tr>
									<td align="center"><a href="${contextPath}/admin" class="btn btn-default">Indietro</a></td>
									<td align="center"><input id="bottonem" class="btn btn-primary" type="submit" value="Inserisci" disabled /></td>
								</tr>
							</table>
						</form:form>
					</div>
					
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