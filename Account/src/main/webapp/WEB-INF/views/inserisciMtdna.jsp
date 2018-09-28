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
	<title>Inserisci aplogruppo mtDNA</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/resources/style/style.css" media="all" />
	<link rel="stylesheet" media="all" href="${contextPath}/resources/style/type/folks.css" />
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<style>
		tr {
			vertical-align: middle;
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
      <h1>Inserisci i tuoi dati</h1>
	</div>
    <!-- End Intro --> 
    <!-- Begin About -->
    <div id="about" align=center>
	<form action="${contextPath}/insertMtDNA" method="post">
		<br><br><br>
		<table style="width:50%">
			<tr>
				<td>Sesso:<br>
					<i>Sex:</i></td><td><input type="radio" name="sesso" value="maschio" checked> Maschio / <i>Male</i><br>
					<input type="radio" name="sesso" value="femmina"> Femmina / <i>Female</i>
				</td>
			</tr>
						
			<tr><td style="width:50%">Aplogruppo materno (inserire il subclade se si conosce): </td><td align=center><input type="text" placeholder="Maternal haplogroup" name="aplogruppoM" style="width: 180px;" /></td></tr>
			<tr><td>Provincia di origine della nonna materna: </td>
			<td align=center><input type="text" placeholder="Mother's mother's city of birth" name="provinciaM" style="width: 180px;"/><br><i>(o meglio ancora<br> della bisnonna)</i></td></tr>
		</table>
		<table style="width:40%;border:0">
			<tr style="border:0"><td align=right style="border:0"><input type="submit" value="Invia"/></td></tr>
		</table>
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