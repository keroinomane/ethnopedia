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
<title>Inserisci i dati di Eurogenes K13</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
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
      <h1>Inserisci i tuoi risultati di Eurogenes K13</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
    
	<form action="${contextPath}/eurogenes" method="post">
		<br><br>
				<table style="width:75%; border:none;">
					<tr style="border:none;"><td style="width:40%;" align=center>
						<fieldset>
						  <legend>Macroregione di origine dei nonni:</legend><br>
							  <select name="macroregione" >
							   <option value="nord" selected="selected">Italia settentrionale</option>
							   <option value="centro">Italia centrale</option>
							   <option value="sud">Italia meridionale</option>
							   <option value="sicilia">Sicilia</option>
							   <option value="sardegna">Sardegna</option>
							  </select>
						 </fieldset>
						 <br><br>
					</td><td style="border:none;" align=right>
					
						Regione del nonno paterno:<br>
						Regione della nonna paterna:<br>
						Regione del nonno materno:<br>
						Regione della nonna materna:<br>
					
					</td><td style="border:none;">
							  <select name="nonnoP" >
							  <option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo">Abruzzo</option>
							   <option value="Basilicata">Basilicata</option>
							   <option value="Calabria">Calabria</option>
							   <option value="Campania">Campania</option>
							   <option value="Emilia - Romagna">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia">Friuli - Venezia Giulia</option>
							   <option value="Lazio">Lazio</option>
							   <option value="Liguria">Liguria</option>
							   <option value="Lombardia">Lombardia</option>
							   <option value="Marche">Marche</option>
							   <option value="Molise">Molise</option>
							   <option value="Piemonte">Piemonte</option>
							   <option value="Puglia">Puglia</option>
							   <option value="Sardegna">Sardegna</option>
							   <option value="Sicilia">Sicilia</option>
							   <option value="Toscana">Toscana</option>
							   <option value="Trentino - Alto Adige">Trentino - Alto Adige</option>
							   <option value="Umbria">Umbria</option>
							   <option value="Valle d'Aosta">Valle d'Aosta</option>
							   <option value="Veneto">Veneto</option>
							  </select>

						 <br>
						<select name="nonnaP" >
							<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo">Abruzzo</option>
							   <option value="Basilicata">Basilicata</option>
							   <option value="Calabria">Calabria</option>
							   <option value="Campania">Campania</option>
							   <option value="Emilia - Romagna">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia">Friuli - Venezia Giulia</option>
							   <option value="Lazio">Lazio</option>
							   <option value="Liguria">Liguria</option>
							   <option value="Lombardia">Lombardia</option>
							   <option value="Marche">Marche</option>
							   <option value="Molise">Molise</option>
							   <option value="Piemonte">Piemonte</option>
							   <option value="Puglia">Puglia</option>
							   <option value="Sardegna">Sardegna</option>
							   <option value="Sicilia">Sicilia</option>
							   <option value="Toscana">Toscana</option>
							   <option value="Trentino - Alto Adige">Trentino - Alto Adige</option>
							   <option value="Umbria">Umbria</option>
							   <option value="Valle d'Aosta">Valle d'Aosta</option>
							   <option value="Veneto">Veneto</option>
							  </select>
							  <br>
						<select name="nonnoM" >
								<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo">Abruzzo</option>
							   <option value="Basilicata">Basilicata</option>
							   <option value="Calabria">Calabria</option>
							   <option value="Campania">Campania</option>
							   <option value="Emilia - Romagna">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia">Friuli - Venezia Giulia</option>
							   <option value="Lazio">Lazio</option>
							   <option value="Liguria">Liguria</option>
							   <option value="Lombardia">Lombardia</option>
							   <option value="Marche">Marche</option>
							   <option value="Molise">Molise</option>
							   <option value="Piemonte">Piemonte</option>
							   <option value="Puglia">Puglia</option>
							   <option value="Sardegna">Sardegna</option>
							   <option value="Sicilia">Sicilia</option>
							   <option value="Toscana">Toscana</option>
							   <option value="Trentino - Alto Adige">Trentino - Alto Adige</option>
							   <option value="Umbria">Umbria</option>
							   <option value="Valle d'Aosta">Valle d'Aosta</option>
							   <option value="Veneto">Veneto</option>
							  </select>
							  <br>
							  <select name="nonnaM" >
							  	<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo">Abruzzo</option>
							   <option value="Basilicata">Basilicata</option>
							   <option value="Calabria">Calabria</option>
							   <option value="Campania">Campania</option>
							   <option value="Emilia - Romagna">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia">Friuli - Venezia Giulia</option>
							   <option value="Lazio">Lazio</option>
							   <option value="Liguria">Liguria</option>
							   <option value="Lombardia">Lombardia</option>
							   <option value="Marche">Marche</option>
							   <option value="Molise">Molise</option>
							   <option value="Piemonte">Piemonte</option>
							   <option value="Puglia">Puglia</option>
							   <option value="Sardegna">Sardegna</option>
							   <option value="Sicilia">Sicilia</option>
							   <option value="Toscana">Toscana</option>
							   <option value="Trentino - Alto Adige">Trentino - Alto Adige</option>
							   <option value="Umbria">Umbria</option>
							   <option value="Valle d'Aosta">Valle d'Aosta</option>
							   <option value="Veneto">Veneto</option>
							  </select>
							  <br>
					</td></tr>
				</table>
				<br>
						<table align=center style="font-size:11px;table-layout: fixed;">
					    	<tr>
					    		<td align=center><b>North Atlantic</b></td>
					    		<td align=center><b>Baltic</b></td>
					    		<td align=center><b>West Med</b></td>
					    		<td align=center><b>West Asian</b></td>
								<td align=center><b>East Med</b></td>
								<td align=center><b>Red Sea</b></td>
								<td align=center><b>South Asian</b></td>
								<td align=center><b>East Asian</b></td>
								<td align=center><b>Siberian</b></td>
								<td align=center><b>Amerindian</b></td>
								<td align=center><b>Oceanian</b></td>
								<td align=center><b>Northeast African</b></td>
								<td align=center><b>Sub-Saharan</b></td>
								
								
					    	</tr>
					    	<tr>
					    		<td align=center><input type="text" name="noratl" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" name="bal" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" name="wesmed" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" name="wesasi" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="easmed" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="red" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="souasi" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="easasi" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="sib" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="ame" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="oce" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="norafr" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" name="ssa" style="width: 38px;" width=5>&nbsp%</td>
					    	</tr>
			    		</table>
			    		Inserire 0 nelle admixtures nulle.
			    		<br><br>
			    		<div align=center>
			    			<button class="btn btn-lg btn-primary btn-block" type="submit">Invia</button>
			    		</div>
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
</body>
</html>