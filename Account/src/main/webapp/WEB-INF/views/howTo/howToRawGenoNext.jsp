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

     <title>Come scaricare i raw data del cromosoma Y</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script> 
<style>
	#about {
		width:75%;
	}
	table, tr, td {
		border:none !important;
	}
	td {
		text-align:center;
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
      <h1>Come scaricare i raw data del cromosoma Y da Geno 2.0 Next Generation</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about">
    <table style="width:100%;">
    	<tr>
    		<td style="vertical-align:middle; text-align:right;">
				Trasferisci i tuoi dati di Geno su <strong>FTDna,</strong> se non l'hai gi� fatto.<br><br>
				Vai prima nel tuo profilo.
			</td>
			<td>
				<a href="${contextPath}/resources/img/howto/genoNext/1.PNG">
					<img src="${contextPath}/resources/img/howto/genoNext/1.PNG" width=80%/>
				</a>
			</td>
		</tr>
		<tr>
    		<td style="vertical-align:middle; text-align:center;">
				Copiati il codice GPID e clicca su <b>Click here to start the transfer.</b><br>
				Dopodich� incolla il codice nella schermata che apparir� e crea un nuovo account FTDna (se ne hai gi� uno, accedi con quello).
			</td>
			<td>
				<a href="${contextPath}/resources/img/howto/genoNext/2.PNG">
					<img src="${contextPath}/resources/img/howto/genoNext/2.PNG" width=80%/>
				</a>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">
				Una volta effettuato l'accesso su FTDna, clicca su <b>myFTDna</b> e poi <b>myDashboard.</b><br>
				Dovrebbe apparirti la pagina con i tuoi dati e i test che hai effettuato.<br><br>
				Sotto <strong>Genographic transfer</strong>, trovi <strong>Download Y-DNA SNPs as CSV</strong>.<br><br>
				Cliccalo e allega il documento quando inserisci i tuoi dati nel nostro sito.
			</td>
			<td>
				<a href="${contextPath}/resources/img/howto/genoNext/9.png">
					<img src="${contextPath}/resources/img/howto/genoNext/9.png" width=80%/>
				</a>
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
        <p>� Copyright 2019 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
		<img src="${contextPath}/resources/style/images/icon-facebook.png" alt="" /></a>
		</p>
      </div>
      <!-- End Copyright -->  
      
    </div>
  </div>
</div>
<!-- End Footer -->
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>