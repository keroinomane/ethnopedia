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
    
	<form action="${contextPath}/eutestPlebe" method="post">
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
        <p>© Copyright 2018 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
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