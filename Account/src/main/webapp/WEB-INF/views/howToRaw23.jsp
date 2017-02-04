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

     <title>Come scaricare i raw data del cromosoma Y</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script> 

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
      <h1>Come scaricare i raw data del cromosoma Y dal sito di 23andMe</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
    <table style="border:none; width:100%;">
    	<tr style="border:none;">
    		<td style="border:none; text-align:justify; vertical-align:middle;">
				Accedi su <a href="https://www.23andme.com/cas/signin/" onclick="window.open(this.href);return false">23andMe.</a><br><br>
				Una volta effettuato l'accesso, clicca sul tuo nome e cognome in alto a destra.<br> 
				Dovrebbe apparirti questo menu a tendina, clicca su "<strong>browse your data</strong>".
			</td>
			<td style="border:none;">
				<img src="${contextPath}/resources/img/howto/23/1.png" width=20%/>
			</td>
		</tr>	
		<tr style="border:none;">
			<td style="border:none; text-align:justify; vertical-align:middle;">
				Tornando in alto a destra, clicca su "<strong>download</strong>".<br><br>
				Apparirà una schermata in cui dovrai:<br>
					1) inserire la tua password<br>
					2) inserire la risposta alla tua domanda segreta<br>
					3) selezionare il profilo interessato (se ne hai più di uno)<br>
					4) selezionare "<strong>Y Chromosome</strong>"<br>
				e infine cliccare su "<strong>download data</strong>".<br>
			</td>
			<td style="border:none;">
				<img src="${contextPath}/resources/img/howto/23/2.png" width=95%/>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>