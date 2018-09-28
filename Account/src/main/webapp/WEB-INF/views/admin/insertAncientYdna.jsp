<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../basis/alto.html" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inserisci Y-DNA antico</title>
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
		<style>
			td {
			   vertical-align: middle !important;
			}
			table {
				width: 35%;
				text-align: center;
			}
			.sinistra {
				width: 25%;
				text-align: right;
			}
			.destra {
				text-align: left;
			}
			input[type="text"] {
				height: 25px;
			}
			select {
				height: 25px;
			}
		</style>
		<script>
			$(document).ready(function () {
				$("#clade").chainedTo("#aplogruppo");
			});
			function abilitaAltroClade() {
				if ($('input[name="cladeRadio"]:checked').val() == 'altro') {
					$('#altroClade').show();
					$('#altroClade').val('');
					$('#clade').find('option').remove().end();
				} else {
					if ($('input[name="cladeRadio"]:checked').val() == 'non si sa')
						$('#clade').find('option').remove().end();
					else
						viewCladi();
					$('#altroClade').hide();
					$('#altroClade').val('null');
				}
		    };
		    function viewCladi() {
	            $.ajax({
	            	type: 'get', 
	            	dataType: 'json',
	            	url: "${contextPath}/getCladiByAploForAdna",
	            	data:'aplo='+ $('#aplogruppo').val(),
	            	success: function (data) {
	            		$('#clade').find('option').remove().end();
				        $.each(data, function (i, item) {
				           	$('#clade').append($('<option>', { 
				           		value: item.clade,
				           	    text : item.testo
				           	}));
				        });
			        }
	           	});
			}

		</script>
</head>
<body>
	<div id="container">

		<c:import url="WEB-INF/views/basis/alto.html" />

		<!-- Begin Slider -->
		<div id="cycle-wrapper">
			<div id="sliderholder-cycle">
				<img src="${contextPath}/resources/img/header.jpg" width="100%" />
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
						<c:set var="nick" scope="session" value="${pageContext.request.userPrincipal.name}"/>
						<c:if test="${nick eq 'kerosene' || nick eq 'vinniepassa' || nick eq 'MarMar81' || nick eq 'Timoleonte'}">
					        <form id="logoutForm" method="POST" action="${contextPath}/logout">
					            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					        </form>
					        <h4>Ciao ${nick} | <a href="${contextPath}/welcome">Profilo</a> | 
					        <a href="${contextPath}/admin">Pannello di amministrazione</a> | 
					        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
					        <br>
					        
							<div align=center width=100%>
								Mi raccomando controllate sempre quello che copiate.<br>
								Preferisco che inseriate pochi campioni ma che sia inserito tutto giusto.<br>
								Un minimo errore (esempio, uno spazio finale copiato per sbaglio) potrebbe influire nelle statistiche che faremo.
								<br><br>
								<form:form action="${contextPath}/saveAncientYdna" method="post" modelAttribute="ancientYdna">
									<table>
										<tr>
											<td class="sinistra">Id campione:</td>
											<td class="destra">
												<form:input path="id" /><br>
												Inserisci tutto il contenuto tra le parentesi quadre (escluse)
											</td>
										</tr>
										<tr>
											<td class="sinistra">Età:</td>
											<td class="destra">
												<form:select path="eta" id="eta">
													<form:option value="Paleolitico">Paleolitico</form:option>
													<form:option value="Mesolitico">Mesolitico</form:option>
													<form:option value="Neolitico">Neolitico</form:option>
													<form:option value="Età del rame">Età del rame</form:option>
													<form:option value="Età del bronzo">Età del bronzo</form:option>
													<form:option value="Età del ferro">Età del ferro</form:option>
													<form:option value="Età romana">Età romana</form:option>
													<form:option value="Medioevo">Medioevo</form:option>
												</form:select>
											</td>
										</tr>
										<tr>
											<td class="sinistra">Aplogruppo:</td>
											<td class="destra">
												<form:select path="aplogruppo" id="aplogruppo" onchange="viewCladi()">
													<form:option value="BT">BT</form:option>
													<form:option value="CT">CT</form:option>
													<form:option value="C1a">C1a</form:option>
													<form:option value="C1a2">C1a2</form:option>
													<form:option value="C1b">C1b</form:option>
													<form:option value="E">E</form:option>
													<form:option value="E1b1b">E1b1b</form:option>
													<form:option value="F">F</form:option>
													<form:option value="GHIJK">GHIJK</form:option>
													<form:option value="HIJK">HIJK</form:option>
													<form:option value="IJK">IJK</form:option>
													<form:option value="IJ">IJ</form:option>
													<form:option value="G2a">G2a</form:option>
													<form:option value="H">H</form:option>
													<form:option value="I">I</form:option>
													<form:option value="I1">I1</form:option>
													<form:option value="I2">I2</form:option>
													<form:option value="J1">J1</form:option>
													<form:option value="J2">J2</form:option>
													<form:option value="K">K</form:option>
													<form:option value="K2a">K2a</form:option>
													<form:option value="P">P</form:option>
													<form:option value="Q">Q</form:option>
													<form:option value="Q1a">Q1a</form:option>
													<form:option value="Q1b">Q1b</form:option>
													<form:option value="R">R</form:option>
													<form:option value="R1a">R1a</form:option>
													<form:option value="R1b">R1b</form:option>
													<form:option value="T">T</form:option>
												</form:select>
											</td>
										</tr>	
										<tr>
											<td class="sinistra">Clade:</td>
											<td class="destra">
												<input type="radio" name="cladeRadio" value="ok" onChange="abilitaAltroClade()" checked />
												<form:select path="clade" id="clade">
													<form:option value="L278" class="R1b">R1b1 (L278)</form:option>
												</form:select>
												<br>
												<input type="radio" name="cladeRadio" value="altro" onChange="abilitaAltroClade()" />
												Nessuno dei cladi nella lista 
												<input id="altroClade" type="text" name="altroClade" style="width:20%; display:none;" />
												<br>
												<input type="radio" name="cladeRadio" value="non si sa" onChange="abilitaAltroClade()" />
												Non si conosce il clade
											</td>
										</tr>
										<tr>
											<td class="sinistra">Deepest known clade:</td>
											<td class="destra">
												<form:input path="terminalsnp" style="width:15%;" /> 
												Lasciare vuoto se è identico al clade sopra
											</td>
										</tr>
										<tr>
											<td class="sinistra">Cultura:</td>
											<td class="destra">
												<form:input path="cultura" />
												<br>
												es. LBK o Bell Beaker o Corded Ware o Cardial Pottery
											</td>
										</tr>
										<tr>
											<td class="sinistra">Stato:</td>
											<td class="destra">
												<form:select path="stato" id="stato">
													<form:option value="Albania">Albania</form:option>
													<form:option value="Andorra">Andorra</form:option>
													<form:option value="Armenia">Armenia</form:option>
													<form:option value="Austria">Austria</form:option>
													<form:option value="Azerbaigian">Azerbaigian</form:option>
													<form:option value="Bielorussia">Bielorussia</form:option>
													<form:option value="Belgio">Belgio</form:option>
													<form:option value="Bosnia-Erzegovina">Bosnia-Erzegovina</form:option>
													<form:option value="Bulgaria">Bulgaria</form:option>
													<form:option value="Cipro">Cipro</form:option>
													<form:option value="Croazia">Croazia</form:option>
													<form:option value="Danimarca">Danimarca</form:option>
													<form:option value="Estonia">Estonia</form:option>
													<form:option value="Finlandia">Finlandia</form:option>
													<form:option value="Francia">Francia</form:option>
													<form:option value="Galles">Galles</form:option>
													<form:option value="Georgia">Georgia</form:option>
													<form:option value="Germania">Germania</form:option>
													<form:option value="Grecia">Grecia</form:option>
													<form:option value="Inghilterra">Inghilterra</form:option>
													<form:option value="Irlanda">Irlanda</form:option>
													<form:option value="Irlanda del nord">Irlanda del nord</form:option>
													<form:option value="Islanda">Islanda</form:option>
													<form:option value="Italia">Italia</form:option>
													<form:option value="Lettonia">Lettonia</form:option>
													<form:option value="Liechtenstein">Liechtenstein</form:option>
													<form:option value="Lituania">Lituania</form:option>
													<form:option value="Lussemburgo">Lussemburgo</form:option>
													<form:option value="Macedonia">Macedonia</form:option>
													<form:option value="Malta">Malta</form:option>
													<form:option value="Moldavia">Moldavia</form:option>
													<form:option value="Monaco">Monaco</form:option>
													<form:option value="Montenegro">Montenegro</form:option>
													<form:option value="Norvegia">Norvegia</form:option>
													<form:option value="Paesi Bassi">Paesi Bassi</form:option>
													<form:option value="Polonia">Polonia</form:option>
													<form:option value="Portogallo">Portogallo</form:option>
													<form:option value="Repubblica ceca">Repubblica ceca</form:option>
													<form:option value="Romania">Romania</form:option>
													<form:option value="Russia">Russia</form:option>
													<form:option value="San Marino">San Marino</form:option>
													<form:option value="Scozia">Scozia</form:option>
													<form:option value="Serbia">Serbia</form:option>
													<form:option value="Slovacchia">Slovacchia</form:option>
													<form:option value="Slovenia">Slovenia</form:option>
													<form:option value="Spagna">Spagna</form:option>
													<form:option value="Svezia">Svezia</form:option>
													<form:option value="Svizzera">Svizzera</form:option>
													<form:option value="Turchia">Turchia</form:option>
													<form:option value="Ucraina">Ucraina</form:option>
													<form:option value="Ungheria">Ungheria</form:option>
												</form:select>
											</td>
										</tr>
										<tr>
											<td class="sinistra">Città:</td>
											<td class="destra">
												<form:input path="location" />
												<br>
												Cercala su Google per vedere se è corretta
											</td>
										</tr>
										<tr>
											<td class="sinistra">Datazione:</td>
											<td class="destra">
												<input type="radio" name="datazione" value="ybp" checked /> ybp/BP 
												<input type="radio" name="datazione" value="bce" /> bce/BC 
												<input type="radio" name="datazione" value="ce" /> ce/AD
												<br><br>
												Da <form:input path="fromybp" style="width:10%" /> a <form:input path="toybp" style="width:10%" />
												<br>
												Rimuovi le virgole se presenti
											</td>
										</tr>
										<tr>
											<td class="sinistra">Ultimo paper in cui è stato analizzato:</td>
											<td class="destra">
												<form:input path="lastpaper" />
												<br>
												es. Fu 2016
											</td>
										</tr>
									</table>
									<br>
									<table style="border:none;">
										<tr style="border:none;">
											<td style="border:none;">
												<c:if test="${modifica == null}">
													<input class="btn btn-primary" type="submit" value="Inserisci" />
													<input type="hidden" name="modifica" value="false"/>
												</c:if>
												<c:if test="${modifica != null}">
													<input class="btn btn-primary" type="submit" value="Modifica" />
													<input type="hidden" name="modifica" value="true"/>
												</c:if>
											</td>
											<td style="border:none;">
												<a href="<c:url value='/ancientDNA' />" >
													<button type="button" class="btn">Mostra gli altri</button>
												</a>
											</td>
										</tr>
									</table>
								</form:form>
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
						<p>
							© Copyright 2018 Ethnopedia| <a
								href="https://www.facebook.com/ethnopedia/"> <img
								src="resources/style/images/icon-facebook.png"
								alt="" /></a>
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