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

    <title>Profilo</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/balloon.css">
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-3.0.0.min.js"></script> 
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>

<body>
<div id="container"> 
  
  <c:import url="basis/alto.html" />
  
  <!-- Begin Slider -->
  <div id="cycle-wrapper">
    <div id="sliderholder-cycle"> <img src="${contextPath}/resources/img/header.jpg" width="960"/>
  </div>
  <!-- End Slider --> 
  
  <!-- Begin Wrapper -->
  <div id="wrapper"> 
    <!-- Begin Intro -->
    <div class="intro">
      <h1>Profilo</h1>
	</div>
    <!-- End Intro --> 
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
		<c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
        <h4>Ciao ${nick} | 
        <c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
        <a href="${contextPath}/admin">Pannello di amministrazione</a> | 
        </c:if>
        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
        <c:if test="${userDati != null}">
        	<br>
			<table style="border: none;">
			<tr style="border: none;">
				<td style="border: none;" width=25%>
				<table>
					<tr><td width=50%>Cognome</td><td><c:out value="${userDati.cognome}" /></td></tr>
					<tr><td>Nome</td><td><c:out value="${userDati.nome}" /></td></tr>
				</table>
				</td>
				<td style="border: none;" width=40%>
					<table>
						<tr><td colspan=2 style="text-align:center"><b>Y-DNA</b></td></tr>
						<tr><td>Aplogruppo</td><td><a data-balloon="${infoaplo}" data-balloon-length="xlarge" data-balloon-pos="up"><b><u><c:out value="${ydna.ydnaId.aplogruppo}"/></u></b></a></td></tr>
						<tr><td>Clade</td>
							<td>
								<c:if test="${infoclade != null}">
									<a data-balloon="${infoclade}" data-balloon-length="xlarge" data-balloon-pos="up"><b><u><c:out value="${ydna.clade}" /></u></b></a>
								</c:if>
								<c:if test="${infoclade == null}">
									<c:out value="${ydna.clade}" />
								</c:if>
							</td>
						</tr>
						<tr><td>Subclade</td><td><c:out value="${ydna.subclade}" /></td></tr>
						<tr><td>Deepest known clade</td><td><c:out value="${ydna.downstream}" /></td></tr>
						<tr><td>Provincia</td><td><c:out value="${ydna.ydnaId.provincia}" /></td></tr>
					</table>
				</td>
				<td style="border: none;" width=35%>
					<c:if test="${mtdna == null}">
						<table>
							<tr><td style="text-align:center"><b>mtDNA</b></td></tr>
							<tr><td>
								<div align=center>
								Non hai inserito i tuoi dati genetici materni.<br>
								<a href="/account/inserisciMtdna">Inseriscili!</a><br><br>
								Se li hai già inseriti, li stiamo elaborando.<br>
								Ti manderemo una mail quando l'elaborazione è finita.
								</div>
							</td></tr>
						</table>
					</c:if>
					<c:if test="${mtdna != null}">
						<table>
						<tr><td colspan=2 style="text-align:center"><b>mtDNA</b></td></tr>
						<tr><td>Aplogruppo</td><td>
						<c:out value="${mtdna.mtdnaId.aplogruppo}" />
						</td></tr>
						<tr><td>Aplogruppo completo</td><td><c:out value="${mtdna.clade}" /></td></tr>
						<tr><td>Provincia</td><td><c:out value="${mtdna.mtdnaId.provincia}" /></td></tr>
						</table>
					</c:if>
				</td></tr>
			</table>
			<c:if test="${userDati.autosomal == null}">
				<form action="${contextPath}/aggiorna" method="post">
					<div align=center>
					<table style="border: none;">
					<tr style="border: none;">
						<td align=center width="26%" style="border: none;">
							<img src="${contextPath}/resources/img/macroregioni.png" width="80%"/>
						</td>
						<td style="border: none; vertical-align:middle;">
							I tuoi nonni erano TUTTI e 4 provenienti da regioni dello stesso colore in questa mappa?
							<br><br><br>
							<input type="radio" name="autosomal" value="true"> Sì, ho tutti e 4 nonni originari di regioni dello stesso colore<br>
							<input type="radio" name="autosomal" value="false"> No, ho 4 nonni provenienti da regioni di colore diverso
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<input type="submit" value="Invia"/>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
						</td>
					</tr>
					</table>
					</div>
				</form>
				
			</c:if>
			<c:if test="${userDati.autosomal == true}">
				<c:if test="${eutest != null}">
					<br><br>
					<table>
				    	<tr>
				    		<td align=center><b>South Baltic</b></td>
					    		<td align=center><b>East Euro</b></td>
					    		<td align=center><b>North Central Euro</b></td>
					    		<td align=center><b>Atlantic</b></td>
					    		<td align=center><b>West Med</b></td>
								<td align=center><b>East Med</b></td>
								<td align=center><b>West Asian</b></td>
								<td align=center><b>Middle Eastern</b></td>
								<td align=center><b>South Asian</b></td>
								<td align=center><b>East African</b></td>
								<td align=center><b>East Asian</b></td>
								<td align=center><b>Siberian</b></td>
								<td align=center><b>West African</b></td>
				    	</tr>
				    	<tr>
				    		<td align=center>${eutest.baltic}%</td>
							<td align=center>${eutest.easteuro}%</td>
							<td align=center>${eutest.northcentraleuro}%</td>
							<td align=center>${eutest.atlantic}%</td>
							<td align=center>${eutest.westmed}%</td>
							<td align=center>${eutest.eastmed}%</td>
							<td align=center>${eutest.westasian}%</td>
							<td align=center>${eutest.middleastern}%</td>
							<td align=center>${eutest.southasian}%</td>
							<td align=center>${eutest.eastafrican}%</td>
							<td align=center>${eutest.eastasian}%</td>
							<td align=center>${eutest.siberian}%</td>
							<td align=center>${eutest.westafrican}%</td>
				    	</tr>
		    		</table>
    			</c:if>
    			<c:if test="${eutest == null}">
    				<br><br>
    				<div align="center">
    					Raccogliamo anche i dati sul DNA autosomico, come i risultati dei calcolatori di 
    						<a href="https://www.gedmatch.com">GedMatch.</a><br>
    					Al momento puoi inviarci i tuoi risultati del calcolatore Eurogenes EUtest.<br>
    					<br>
						<a href="/account/inserisciEutest">Inseriscili!</a>
					</div>
    			</c:if>
    		</c:if>
		</c:if>
		<c:if test="${userDati == null}">
			<br><br><br>
			<div align=center>
					Non hai inserito i tuoi dati genetici.<br>
					<a href="/account/inserisci">Inseriscili!</a>
					<br>
					<br>
					Se li hai già inseriti, li stiamo elaborando.<br>
					Ti manderemo una mail quando l'elaborazione è finita.
			</div>
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
        <p>© Copyright 2016 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
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