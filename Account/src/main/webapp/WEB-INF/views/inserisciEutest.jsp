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
	<title>Inserisci i dati di Eurogenes EUtest</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<script type="text/javascript" src="${contextPath}/resources/js/jquery.chained.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript">
			$(document).ready(function () {
				$("#nonnop").chainedTo("#macro");
				$("#nonnap").chainedTo("#macro");
				$("#nonnom").chainedTo("#macro");
				$("#nonnam").chainedTo("#macro");
				$('.percentuali, #gedmatch').keyup(function() {

			        var empty = false;
			        $('.percentuali, #gedmatch').each(function() {
			            if ($(this).val().length == 0) {
			                empty = true;
			            }
			        });

			        if (empty) {
			            $('#invia').prop('disabled', true);
			        } else {
			        	$('#invia').prop('disabled', false);
			        }
			    });
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
      <h1>Inserisci i tuoi risultati di Eurogenes EUtest</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
    
	<form action="${contextPath}/eutest" method="post">
		<br>
				<table style="width:100%; border:none;">
					<tr style="border:none;">
					<td width="20%" align=center style="vertical-align:middle;">
						<fieldset>
						  <legend>Macroregione di origine dei nonni:<br>
						  <i>My grandparents are from:</i>
						  </legend><br>
							  <select name="macroregione" id ="macro">
							   <option value="nordovest" selected="selected">Italia nordoccidentale (green)</option>
							   <option value="nordest">Italia nordorientale (red)</option>
							   <option value="centro">Italia centrale (light blue)</option>
							   <option value="sud">Italia meridionale (orange)</option>
							   <option value="sicilia">Sicilia (purple)</option>
							   <option value="sardegna">Sardegna (brown)</option>
							  </select>
						 </fieldset>
						 <br><br>
					</td>
					<td width="20%" align=center style="padding:0px 0px;">
						<img src="${contextPath}/resources/img/macroregioni.png" width="90%"/>
					</td>
					<td style="border:none; vertical-align:top;" align=right width="17%">
					
						Regione del nonno paterno:<br>
						<em>My father's father is from:</em><br><br>
						Regione della nonna paterna:<br>
						<em>My father's mother is from:</em><br><br>
						Regione del nonno materno:<br>
						<em>My mother's father is from:</em><br><br>
						Regione della nonna materna:<br>
						<em>My mother's mother is from:</em>
					
					</td>
					<td style="border:none; vertical-align:top;" width="18%">
						<select name="nonnoP" id="nonnop">
							  <option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo" class="centro">Abruzzo</option>
							   <option value="Basilicata" class="sud">Basilicata</option>
							   <option value="Calabria" class="sud">Calabria</option>
							   <option value="Campania" class="sud">Campania</option>
							   <option value="Emilia - Romagna" class="nordovest">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia" class="nordest">Friuli - Venezia Giulia</option>
							   <option value="Lazio" class="centro">Lazio</option>
							   <option value="Liguria" class="nordovest">Liguria</option>
							   <option value="Lombardia" class="nordovest">Lombardia</option>
							   <option value="Marche" class="centro">Marche</option>
							   <option value="Molise" class="sud">Molise</option>
							   <option value="Piemonte" class="nordovest">Piemonte</option>
							   <option value="Puglia" class="sud">Puglia</option>
							   <option value="Sardegna" class="sardegna">Sardegna</option>
							   <option value="Sicilia" class="sicilia">Sicilia</option>
							   <option value="Toscana" class="centro">Toscana</option>
							   <option value="Trentino - Alto Adige" class="nordest">Trentino - Alto Adige</option>
							   <option value="Umbria" class="centro">Umbria</option>
							   <option value="Valle d'Aosta" class="nordovest">Valle d'Aosta</option>
							   <option value="Veneto" class="nordest">Veneto</option>
						</select>

						 <br><br><br>
						<select name="nonnaP" id="nonnap" >
							<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo" class="centro">Abruzzo</option>
							   <option value="Basilicata" class="sud">Basilicata</option>
							   <option value="Calabria" class="sud">Calabria</option>
							   <option value="Campania" class="sud">Campania</option>
							   <option value="Emilia - Romagna" class="nordovest">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia" class="nordest">Friuli - Venezia Giulia</option>
							   <option value="Lazio" class="centro">Lazio</option>
							   <option value="Liguria" class="nordovest">Liguria</option>
							   <option value="Lombardia" class="nordovest">Lombardia</option>
							   <option value="Marche" class="centro">Marche</option>
							   <option value="Molise" class="sud">Molise</option>
							   <option value="Piemonte" class="nordovest">Piemonte</option>
							   <option value="Puglia" class="sud">Puglia</option>
							   <option value="Sardegna" class="sardegna">Sardegna</option>
							   <option value="Sicilia" class="sicilia">Sicilia</option>
							   <option value="Toscana" class="centro">Toscana</option>
							   <option value="Trentino - Alto Adige" class="nordest">Trentino - Alto Adige</option>
							   <option value="Umbria" class="centro">Umbria</option>
							   <option value="Valle d'Aosta" class="nordovest">Valle d'Aosta</option>
							   <option value="Veneto" class="nordest">Veneto</option>
							  </select>
							  <br><br><br>
						<select name="nonnoM" id="nonnom" >
								<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo" class="centro">Abruzzo</option>
							   <option value="Basilicata" class="sud">Basilicata</option>
							   <option value="Calabria" class="sud">Calabria</option>
							   <option value="Campania" class="sud">Campania</option>
							   <option value="Emilia - Romagna" class="nordovest">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia" class="nordest">Friuli - Venezia Giulia</option>
							   <option value="Lazio" class="centro">Lazio</option>
							   <option value="Liguria" class="nordovest">Liguria</option>
							   <option value="Lombardia" class="nordovest">Lombardia</option>
							   <option value="Marche" class="centro">Marche</option>
							   <option value="Molise" class="sud">Molise</option>
							   <option value="Piemonte" class="nordovest">Piemonte</option>
							   <option value="Puglia" class="sud">Puglia</option>
							   <option value="Sardegna" class="sardegna">Sardegna</option>
							   <option value="Sicilia" class="sicilia">Sicilia</option>
							   <option value="Toscana" class="centro">Toscana</option>
							   <option value="Trentino - Alto Adige" class="nordest">Trentino - Alto Adige</option>
							   <option value="Umbria" class="centro">Umbria</option>
							   <option value="Valle d'Aosta" class="nordovest">Valle d'Aosta</option>
							   <option value="Veneto" class="nordest">Veneto</option>
							  </select>
							  <br><br><br>
							  <select name="nonnaM" id="nonnam">
							  	<option value=null selected="selected">regioni miste</option>
							   <option value="Abruzzo" class="centro">Abruzzo</option>
							   <option value="Basilicata" class="sud">Basilicata</option>
							   <option value="Calabria" class="sud">Calabria</option>
							   <option value="Campania" class="sud">Campania</option>
							   <option value="Emilia - Romagna" class="nordovest">Emilia - Romagna</option>
							   <option value="Friuli - Venezia Giulia" class="nordest">Friuli - Venezia Giulia</option>
							   <option value="Lazio" class="centro">Lazio</option>
							   <option value="Liguria" class="nordovest">Liguria</option>
							   <option value="Lombardia" class="nordovest">Lombardia</option>
							   <option value="Marche" class="centro">Marche</option>
							   <option value="Molise" class="sud">Molise</option>
							   <option value="Piemonte" class="nordovest">Piemonte</option>
							   <option value="Puglia" class="sud">Puglia</option>
							   <option value="Sardegna" class="sardegna">Sardegna</option>
							   <option value="Sicilia" class="sicilia">Sicilia</option>
							   <option value="Toscana" class="centro">Toscana</option>
							   <option value="Trentino - Alto Adige" class="nordest">Trentino - Alto Adige</option>
							   <option value="Umbria" class="centro">Umbria</option>
							   <option value="Valle d'Aosta" class="nordovest">Valle d'Aosta</option>
							   <option value="Veneto" class="nordest">Veneto</option>
							  </select>
							  <br>
						</td>
					</tr>
				</table>
				<br>
						<table align=center style="font-size:11px;table-layout: fixed;">
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
					    		<td align=center><input type="text" class = "percentuali" name="baltic" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" class = "percentuali" name="easteuro" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" class = "percentuali" name="northcentraleuro" style="width: 38px;" width=5>&nbsp%</td>
					    		<td align=center><input type="text" class = "percentuali" name="atlantic" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="westmed" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="eastmed" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="westasian" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="middleastern" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="southasian" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="eastafrican" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="eastasian" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="siberian" style="width: 38px;" width=5>&nbsp%</td>
								<td align=center><input type="text" class = "percentuali" name="westafrican" style="width: 38px;" width=5>&nbsp%</td>
					    	</tr>
			    		</table>
			    		<div align=left>
			    			<em>Scrivi le percentuali in questo formato: 23.42 (no virgola). &nbsp&nbsp Inserire</em> <i>0</i> <em>in caso di valore nullo.</em>
			    		</div>
			    		<table align=center style="width:100%; border:none;">
				    		<tr style="border:none;">
					    		<td align=right style="border:none; width:90%">
					    			Inserisci il tuo codice di GEDmatch:<br>
					    			<em>Insert your GEDmatch kit number</em><br>
					    		</td>
					    		<td style="border:none; vertical-align:middle;"><input type="text" id="gedmatch" name="gedmatch" style="width: 60px;" width=10 />
					    		</td>
				    		</tr>
				    		<tr style="border:none;">
				    			<td align=center style="border:none;" width=50%>
				    				<br>
			    					<button id="indietro" type="button" onclick="window.history.back();">Indietro</button>
			    					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			    					<button id="invia" type="submit" disabled >
			    						Inserisci
			    					</button>
			    					<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
			    				</td>
			    			</tr>
			    		</table>
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