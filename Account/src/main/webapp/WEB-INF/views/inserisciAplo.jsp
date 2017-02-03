<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="basis/alto.html" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inserisci aplogruppo</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<script type="text/javascript" src="${contextPath}/resources/js/insertAplo.js"></script>   
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
      <h1>Inserisci i tuoi dati</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
	<form action="UploadDownloadFile" method="post" enctype="multipart/form-data">
	  <table style="border: none;">
		  <tr valign=top style="border: none;"><td style="border: none;">
			<table>
				<tr><td>Nome: </td><td><input type="text" name="nome" style="width: 130px;"/></td></tr>
				<tr><td>Cognome: </td><td><input type="text" name="cognome" style="width: 130px;"/></td></tr> 
				<tr><td>Sesso:</td><td><input type="radio" name="sesso" value="maschio" onChange="displayForm(this)" checked> Maschio<br>
				<input type="radio" name="sesso" value="femmina" onChange="displayForm(this)"> Femmina</td></tr>
				<tr><td>Test genetico effettuato:</td><td><input type="radio" name="test" value="23andMe" onChange="displayAplo(this)" checked> 23andMe
				<br><input type="radio" name="test" value="geno" onChange="displayAplo(this)"> Geno 2.0
				<br><input type="radio" name="test" value="genoNext" onChange="displayAplo(this)"> Geno 2.0 Next Generation</td></tr>
			</table>
		
			
		</td><td style="border: none;" width=37%>	
			<div id="ydna" style="display:none;">
				<table>
				
				<tr class="23" style="display:none;"><td>Aplogruppo<br>Y-DNA: </td><td>
				<select name="aplo23" >
				   <option value="e1b1b">E1b1b</option>
				   <option value="g2a">G2a</option>
				   <option value="i1">I1</option>
				   <option value="i2">I2</option>
				   <option value="j1">J1</option>
				   <option value="j2">J2</option>
				   <option value="r1a">R1a</option>
				   <option value="r1b">R1b</option>
				   <option value="t">T</option>
				  </select>
				</td></tr>
				<tr class="23" style="display:none;"><td>Inserisci l'aplogruppo completo: </td>
				<td align=center><input type="text" name="clade23" style="width: 155px;"/><i>(es. R1b1b2a1a2d)</i></td></tr>
				
				<tr class="gen" style="display:none;"><td>Aplogruppo<br>Y-DNA: </td><td>
				<select name="aplogen" >
				   <option value="e">E</option>
				   <option value="g">G</option>
				   <option value="i">I</option>
				   <option value="j">J</option>
				   <option value="r">R</option>
				   <option value="t">T</option>
				  </select></td></tr>
				<tr class="gen" style="display:none;">
					<td>Inserisci il clade: </td>
					<td align=center><input type="text" name="cladegen" style="width: 155px;"/><br><i>(es. Z36)</i></td>
				</tr>
			
				
				<tr><td>Provincia di origine del nonno paterno: </td>
				<td align=center><input type="text" name="provinciaP" style="width: 155px;"/><br><i>(o meglio ancora<br> del bisnonno)</i></td></tr>
				
				</table>
			</div>
		</td><td style="border: none;">
			<table>
				<tr><td>Aplogruppo mtDNA: </td><td align=center><input type="text" name="aplogruppoM" style="width: 155px;" /></td></tr>
				<tr><td>Provincia di origine della nonna materna: </td>
				<td align=center><input type="text" name="provinciaM" style="width: 155px;"/><br><i>(o meglio ancora<br> della bisnonna)</i></td></tr>
			</table>
		</td></tr>	
		
		<tr style="border: none; display:none;" class="raw"><td colspan=3 align=right style="border: none;">	
			<strong>Carica i raw data relativi al cromosoma Y</strong><br><br>
			<input type="file" name="rawdataY">
		</td></tr>
		<tr style="border: none; display:none;" class="exp23"><td colspan=3 align=right style="border: none;">
			Non sai dove prenderli? <a href="${contextPath}/howToRaw23" onclick="window.open(this.href);return false"><b>Clicca qui.</b></a>
		</td></tr>
		<tr style="border: none; display:none;" class="expGen"><td colspan=3 align=right style="border: none;">
			Non sai dove prenderli? <a href="${contextPath}/howToRawGeno" onclick="window.open(this.href);return false"><b>Clicca qui.</b></a>
		</td></tr>
		<tr style="border: none; display:none;" class="expGenNext"><td colspan=3 align=right style="border: none;">
			Non sai dove prenderli? <a href="${contextPath}/howToRawGenoNext" onclick="window.open(this.href);return false"><b>Clicca qui.</b></a>
		</td></tr>
	</table>
	
	<br>	
	
	<div align=right><input type="submit" value="Invia" width=100/></div>
	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	</form>	 
<br><br><br>
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