<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link rel="stylesheet" media="all" href="${contextPath}/resources/css/jquery-ui.css" />
	<script type="text/javascript" src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/scripts.js"></script>  
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-3.0.0.min.js"></script> 
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
	<style>
		.eutest {
			text-align:center;
		}
		td {
			text-align:center;
		}
		.custom-tooltip-styling { max-width: 420px;}
		.askDonations {
			border: 2px red solid;
		}
	</style>
	<script type="text/javascript">
	$( function() {
	    $( "#datepicker" ).datepicker({
	      changeMonth: true,
	      changeYear: true,
	      yearRange: '1900:2002',
	      dateFormat: 'dd/mm/yy',
	      dayNamesMin: ['Do','Lu','Ma','Me','Gi','Ve','Sa'],
	      monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
	    	    'Lug','Ago','Set','Ott','Nov','Dic'],
	    	    defaultDate: new Date('1 January 1980')
	    });
	    
	    $( "#baltic" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "Baltic è più presente tra gli estoni.<img width='400px' src='https://nationalvanguard.org/wp-content/uploads/2016/09/estonians.jpg'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#nordic" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "Nordic è più presente tra i norvegesi.<img width='400px' src='http://www.ethnopedia.info/account_img/nordic.png'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#atlantic" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "Atlantic è più presente tra i baschi.<img width='400px' src='http://i.telegraph.co.uk/multimedia/archive/03320/basques_3320429k.jpg'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#westmed" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "West Med è più presente tra i sardi.<img width='400px' src='https://farm5.static.flickr.com/4120/4897681109_6f67793726_b.jpg'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#eastmed" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "East Med è più presente tra i drusi.<img width='400px' src='https://electronicintifada.net/sites/default/files/styles/original_800w/public/2014-05/140514-omar-saad.jpg?itok=jTemVH48&timestamp=1448949295'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#westasian" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "West Asian è più presente tra i georgiani.<img width='400px' src='http://s1.ibtimes.com/sites/www.ibtimes.com/files/2015/03/21/2015-03-21t154334z1600933612gf10000034274rtrmadp3georgia-protest.JPG'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#mena" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "MENA è più presente tra i beduini.<img width='400px' src='http://www.ilovemuslims.net/wp-content/uploads/2012/10/IMG_2169.-a-jpg-600x411.jpg'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#asian" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "Asian è più presente tra gli asiatici.<img width='400px' src='http://www.ethnopedia.info/genitaly/autosomal/china.png'/>", position: {my: "center bottom", at: "center top"} });
	    $( "#ssa" ).tooltip({ tooltipClass: "custom-tooltip-styling", content: "SSA è più presente tra gli africani subsahariani.<img width='400px' src='http://www.ethnopedia.info/account_img/ssa.png'/>", position: {my: "center bottom", at: "center top"} });
	
	    $('input:radio[name="autosomal"]').change(function(){
			if ($(this).is(':checked')) {
				$('#bottoneNonni').prop('disabled', false);
			} else {
				$('#bottoneNonni').prop('disabled', true);
			}
		});
	
	} );
	
	
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
        <c:if test="${user.ruolo eq 'admin'}">
        	<a href="${contextPath}/admin">Pannello di amministrazione</a> | 
        </c:if>
        <a href="${contextPath}/impostazioni">Impostazioni</a> | 
        <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
        <c:if test="${userDati != null && userDati.genproject != null}">
        	<br>
			<table style="border: none;">
				<tr style="border: none;">
					<td style="border: none;" width=25%>
						<table>
							<tr><td width=50%>Cognome</td><td><c:out value="${userDati.cognome}" /></td></tr>
							<tr><td>Nome</td><td><c:out value="${userDati.nome}" /></td></tr>
							
						</table>
					</td>
					<td style="border: none;" width=40% rowspan="3">
						<table>
							<tr><td colspan=2 style="text-align:center"><b>Y-DNA</b></td></tr>
							<tr><td>Aplogruppo</td><td><a data-balloon="${infoaplo}" data-balloon-length="xlarge" data-balloon-pos="up"><b><u><c:out value="${ydna.ydnaId.aplogruppo}"/></u></b></a></td></tr>
							<tr><td>Clade</td>
								<td>
									<c:if test="${ydna.clade != null}">
										<c:if test="${infoclade != null}">
											<a data-balloon="${infoclade}" data-balloon-length="xlarge" data-balloon-pos="up"><b><u><c:out value="${ydna.clade}" /></u></b></a>
										</c:if>
										<c:if test="${infoclade == null}">
											<c:out value="${ydna.clade}" />
										</c:if>
									</c:if>
									<c:if test="${ydna != null && ydna.clade == null}">
										<a href="http://www.ethnopedia.info/contatti.html">Scrivici per maggiori informazioni</a>
									</c:if>
								</td>
							</tr>
							<tr>
								<td>Subclade</td>
								<td>
									<c:if test="${ydna.subclade != null}">
										<c:if test="${infosubclade != null}">
											<a data-balloon="${infosubclade}" data-balloon-length="xlarge" data-balloon-pos="up"><b><u><c:out value="${ydna.subclade}" /></u></b></a>
										</c:if>
										<c:if test="${infosubclade == null}">
											<c:out value="${ydna.subclade}" />
										</c:if>
									</c:if>
									<c:if test="${ydna != null && ydna.subclade == null}">
										<a href="http://www.ethnopedia.info/contatti.html">Scrivici per maggiori informazioni</a>
									</c:if>
								</td>
							</tr>
							<tr>
								<td>Deepest known clade</td>
								<td>
									<c:if test="${ydna.downstream != null}">
										<c:out value="${ydna.downstream}" />
									</c:if>
									<c:if test="${ydna != null && ydna.downstream == null}">
										<a href="http://www.ethnopedia.info/contatti.html">Scrivici per maggiori informazioni</a>
									</c:if>
								</td>
							</tr>
							<tr><td>Provincia</td><td><c:out value="${ydna.ydnaId.provincia}" /></td></tr>
						</table>
						<br>
						Hai fatto qualche altro test di approfondimento e<br>
						vuoi aggiornare i risultati nel tuo profilo?<br>
						<a href="http://www.ethnopedia.info/contatti.html">Scrivici.</a>
					</td>
					<td style="border: none;" width=35% rowspan="2">
						<c:if test="${mtdna == null}">
							<table>
								<tr><td style="text-align:center"><b>mtDNA</b></td></tr>
								<tr><td>
									<div align=center>
									Non hai inserito i tuoi dati genetici materni.<br>
									<a href="/account/inserisciMtdna">Inseriscili!</a><br>
									Se li hai già inseriti, li stiamo elaborando.<br>
									Torna più tardi!
									<br><br>
									<em>
										You haven't inserted your maternal haplogroup yet.<br>
										<a href="/account/inserisciMtdna">Insert it!</a><br>
										If you already inserted it, we're elaborating it.<br>
										Come back later!
									</em>
									</div>
								</td></tr>
							</table>
						</c:if>
						<c:if test="${mtdna != null}">
							<table>
							<tr><td colspan=2 style="text-align:center"><b>mtDNA</b></td></tr>
							<tr><td>Aplogruppo</td><td>
								<a data-balloon="${infoMtdna}" data-balloon-length="xlarge" data-balloon-pos="up">
									<b><u><c:out value="${mtdna.mtdnaId.aplogruppo}" /></u></b>
								</a>
							</td></tr>
							<tr><td>Aplogruppo completo</td><td><c:out value="${mtdna.clade}" /></td></tr>
							<tr><td>Provincia</td><td><c:out value="${mtdna.mtdnaId.provincia}" /></td></tr>
							</table>
						</c:if>
					</td>
				</tr>
				<tr style="border: none;">
					<td style="border: none;">
						<c:if test="${userDati.nascita == null}">
							<form id="nascitaForm" method="POST" action="${contextPath}/insertNascita">
						    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								<table style="border:0;">
									<tr style="border:0;">
										<td colspan="2">
											Inserisci la tua data di nascita:<br>
											<i>Insert your birth date:</i>
										</td>
									</tr>
									<tr>
										<td style="border:0;">
											<input type="text" name="nascita" id="datepicker" style="width: 80px;">
										</td>
										<td align="right" style="border:0;">
											<input type="submit" />
										</td>
									</tr>
								</table>
							</form>
						</c:if>
						<c:if test="${userDati.nascita != null}">
							<table>
								<tr>
									<td width=50%>Data di nascita</td>
									<td>
										<fmt:formatDate value="${userDati.nascita}" pattern="dd/MM/yyyy" />
									</td>
								</tr>
							</table>
						</c:if>
					</td>
				</tr>
								
				<tr style="border: none;">
					<td style="border: none;">
						<c:if test="${fasciaEtaOK == true && (nonniStessaRegione == true || userDati.phenproject == true)}">
							<c:if test="${altezza == null}">
								<form id="altezzaForm" method="POST" action="${contextPath}/insertAltezza">
						            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						            <table style="border:0;">
									<tr style="border:0;">
										<td colspan="2">
											Inserisci la tua altezza<br>
											<i>Insert your height</i>
										</td>
									</tr>
									<tr>
										<td style="border:0;">
											<input type="text" name="centimetri" style="width: 30px;" /> cm
										</td>
										<td align="right" style="border:0;">
											
											<input type="submit" />
										</td>
									</tr>
								</table>
						        </form>
							</c:if>
							<c:if test="${altezza != null}">
								<table>
									<tr><td width=50%>Altezza</td><td><c:out value="${altezza.centimetri}" /> cm</td></tr>
								</table>
							</c:if>
						</c:if>
					</td>
					<td style="border: none;" align="center">
						<h4>
					        <a style="text-decoration: none" href="<c:url value='/statistiche' />" >
						        <button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-stats"></span>
								</button>
							</a>&nbsp
					        Statistiche
					        &nbsp&nbsp
					        <a style="text-decoration: none" href="<c:url value='/ancientDNA' />" >
				        		<button type="button" class="btn btn-success">
									<span class="glyphicon glyphicon-tower"></span>
								</button>
							</a>&nbsp
				        	DNA antico
					    </h4>
					</td>
				</tr>
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
							I tuoi nonni erano TUTTI e 4 provenienti da regioni dello stesso colore in questa mappa?<br>
							<em>Are all your grandparents from regions with the same color in this map?</em>
							<br><br>
							
							<input type="radio" name="autosomal" value="true"> Sì, ho tutti e 4 nonni originari di regioni dello stesso colore<br>
							<em>Yes, my grandparents are from regions with the same color</em><br><br>
							
							<input type="radio" name="autosomal" value="false"> No, ho 4 nonni provenienti da regioni di colore diverso<br>
							<em>No, my grandparents are from regions with different colors</em>
							<br><br>
							
							<input id="bottoneNonni" type="submit" value="Invia" disabled />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
						</td>
					</tr>
					</table>
					</div>
				</form>
				
			</c:if>
			<!-- Se ha già inserito l'autosomal -->
			<c:if test="${eutest != null}">
				<br>
				<table id="fissato">
				    <tr>
				    	<th align=center class="eutest"><b><a id="baltic" title="">Baltic</a></b></th>
					 	<th align=center class="eutest"><b><a id="nordic" title="">Nordic</a></b></th>
					 	<th align=center class="eutest"><b><a id="atlantic" title="">Atlantic</a></b></th>
					 	<th align=center class="eutest"><b><a id="westmed" title="">West Med</a></b></th>
						<th align=center class="eutest"><b><a id="eastmed" title="">East Med</a></b></th>
						<th align=center class="eutest"><b><a id="westasian" title="">West Asian</a></b></th>
						<th align=center class="eutest"><b><a id="mena" title="">MENA</a></b></th>
						<th align=center class="eutest"><b><a id="asian" title="">Asian</a></b></th>
						<th align=center class="eutest"><b><a id="ssa" title="">SSA</a></b></th>
				    </tr>
				    <tr>
				    	<c:set var="baltico"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${eutest.baltic + eutest.easteuro}" /></c:set>
				    	<c:set var="asian"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${eutest.southasian + eutest.eastasian + eutest.siberian}" /></c:set>
				    	<c:set var="ssa"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${eutest.westafrican + eutest.eastafrican}" /></c:set>
				    	<td align=center>${fn:replace(baltico, ",", ".")}%</td>
						<td align=center>${eutest.northcentraleuro}%</td>
						<td align=center>${eutest.atlantic}%</td>
						<td align=center>${eutest.westmed}%</td>
						<td align=center>${eutest.eastmed}%</td>
						<td align=center>${eutest.westasian}%</td>
						<td align=center>${eutest.middleastern}%</td>
						<td align=center>${fn:replace(asian, ",", ".")}%</td>
						<td align=center>${fn:replace(ssa, ",", ".")}%</td>
				    </tr>
		    	</table>
		    	<br>
		    	<div align="right">La popolazione a te più vicina geneticamente sono <b><u>${closestPop}.</u></b>
		    	<c:if test="${regionalResult == true}">
		    	<br>
		    	Popolazioni regionali (stima sperimentale!): <b><u>${pureClosestPop}.</u></b>
		    	</c:if>
		    	</div>	
		    	
    		</c:if>
    		
    		<!-- Se non ha inserito l'autosomal -->
    		<c:if test="${eutest == null}">
    			<!--  Se utente con 4 nonni della stessa macroregione -->
    			<c:if test="${userDati.autosomal == true}">
					<div align="center">
    					Inserisci i tuoi dati di <a href="https://www.gedmatch.com">GEDmatch</a> per avere maggiori informazioni sul tuo DNA.<br>
    					Al momento puoi inviarci i tuoi risultati del calcolatore <b>Eurogenes EUtest.</b><br>
						<a href="/account/inserisciEutest"><b>Inseriscili!</b></a>
						<br>
						Non conosci GEDmatch? È gratuito, segui queste <a href="/account/howToGedmatch"><b>istruzioni.</b></a>
						<br><br>
						
						<small>
						We're gathering also autosomal DNA data, like the <a href="https://www.gedmatch.com">GedMatch</a>'s calculators results.<br>
    					You can insert your Eurogenes EUtest's results right now.<br>
						<a href="/account/inserisciEutest"><b>Insert them!</b></a>
						</small>
					</div>
    			</c:if>
    			<!--  Se utente con 4 nonni misti -->
    			<c:if test="${userDati.autosomal == false}">
    				<div align="center">
    					Inserisci i tuoi dati di <a href="https://www.gedmatch.com">GedMatch</a> per avere maggiori informazioni sul tuo DNA.<br>
    					Al momento puoi inviarci i tuoi risultati del calcolatore <b>Eurogenes EUtest.</b><br>
						<a href="/account/inserisciEutestPlebe"><b>Inseriscili!</b></a>
						<br>
						Non sai come fare? È gratuito, segui queste <a href="/account/howToGedmatch"><b>indicazioni.</b></a>
						<br><br>
						
						<small>
						We're gathering also autosomal DNA data, like the <a href="https://www.gedmatch.com">GedMatch</a>'s calculators results.<br>
    					You can insert your Eurogenes EUtest's results right now.<br>
						<a href="/account/inserisciEutestPlebe"><b>Insert them!</b></a>
						</small>
					</div>
    			</c:if>
    			<br><br>
    		</c:if>
    		<c:choose>
				<c:when test="${user.donatore}">
					<a style="text-decoration: none" href="<c:url value='/donatori' />" >
						<button type="button" class="btn btn-warning">
						<span class="glyphicon glyphicon-gift"></span>
						&nbsp <b>Sezione donatori</b>
						</button>
					</a>
				</c:when>
				<c:otherwise>
					<br>
					<div class="askDonations">Sostieni il nostro lavoro e aiutaci a mandare avanti il sito con una 
				    	<a href="http://www.ethnopedia.info/donazioni.html">
				    		donazione!
				    	</a>
				    	<br>
					    Se doni almeno <b><u>1 euro</u></b> tramite <b>donazione mensile ricorrente</b> (occorre avere un account PayPal), ti sarà abilitata la sezione "donatori" con altre nuove funzionalità utili.
				    </div>
			    </c:otherwise>
			</c:choose>
		</c:if>
		<c:if test="${userDati == null || userDati.genproject == null}">
			<br>
			<c:if test="${userDati != null && userDati.phenproject != null}">
				<div align=center>
					<table style="border: none; width:75%; text-align:center">
						<tr style="border: none;">
							<td style="border: none; width:33%;">
								<table>
									<tr><td width=50%>Cognome</td><td><c:out value="${userDati.cognome}" /></td></tr>
									<tr><td>Nome</td><td><c:out value="${userDati.nome}" /></td></tr>
								</table>
							</td>
							<td style="border: none; width:33%">
								<c:if test="${userDati.nascita == null}">
									<form id="nascitaForm" method="POST" action="${contextPath}/insertNascita">
								    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										<table style="border:0;">
											<tr style="border:0;">
												<td colspan="2">
													Inserisci la tua data di nascita:<br>
													<i>Insert your birth date:</i>
												</td>
											</tr>
											<tr>
												<td style="border:0;">
													<input type="text" name="nascita" id="datepicker" style="width: 80px;">
												</td>
												<td align="right" style="border:0;">
													<input type="submit" />
												</td>
											</tr>
										</table>
									</form>
								</c:if>
								<c:if test="${userDati.nascita != null}">
									<table>
										<tr>
											<td width=50%>Data di nascita</td>
											<td>
												<fmt:formatDate value="${userDati.nascita}" pattern="dd/MM/yyyy" />
											</td>
										</tr>
									</table>
								</c:if>
								<br><br>
								<c:if test="${fasciaEtaOK == true && (nonniStessaRegione == true || userDati.phenproject == true)}">
									<c:if test="${altezza == null}">
										<form id="altezzaForm" method="POST" action="${contextPath}/insertAltezzaPhenProject">
							        	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									        <table style="border:0;">
												<tr style="border:0;">
													<td style="text-align:left; border:0;">
														Altezza:
													</td>
													<td style="text-align:left">
														<input type="text" name="centimetri" style="width: 40px;" /> cm
													</td>
												</tr>
												<tr style="border:0;">
													<td style="text-align:left; border:0;">
														Regione:
													</td>
													<td style="text-align:left">
														<select name="regione">
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
													</td>
												</tr>
												<tr>
													<td style="border:0; text-align:right" colspan="2">					
														<input type="submit" value="Aggiorna" />
													</td>
												</tr>
											</table>
								        </form>
									</c:if>
									<c:if test="${altezza != null}">
										<table>
											<tr><td width=50%>Altezza</td><td><c:out value="${altezza.centimetri}" /> cm</td></tr>
										</table>
									</c:if>
								</c:if>
							</td>
							<td style="border: none;">
								<h4>
							        <a style="text-decoration: none" href="<c:url value='/statistiche' />" >
								        <button type="button" class="btn btn-success">
											<span class="glyphicon glyphicon-stats"></span>
										</button>
									</a>&nbsp
							        Statistiche
							   	    <br><br>
							       	<a style="text-decoration: none" href="<c:url value='/ancientDNA' />" >
							       		<button type="button" class="btn btn-success">
											<span class="glyphicon glyphicon-tower"></span>
										</button>
									</a>&nbsp
							       	DNA antico
							    </h4>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<c:choose>
					<c:when test="${user.donatore}">
						<a style="text-decoration: none" href="<c:url value='/donatori' />" >
							<button type="button" class="btn btn-warning">
							<span class="glyphicon glyphicon-gift"></span>
							&nbsp <b>Sezione donatori</b>
							</button>
						</a>
					</c:when>
					<c:otherwise>
						<div>Sostieni il nostro lavoro e aiutaci a mandare avanti il sito con una 
					    	<a href="http://www.ethnopedia.info/donazioni.html">
					    		donazione!
					    	</a>
					    	<br>
					    	Se doni almeno 1 euro tramite donazione mensile ricorrente (occorre avere un account PayPal), ti sarà abilitata la sezione "donatori" con altre nuove funzionalità utili.
					    </div>
				    </c:otherwise>
				</c:choose>
			</c:if>	
			
			<!-- SE NON SONO STATI INSERITI I DATI -->
			
			<c:if test="${hasBozza}">
				<div align=center>	
					<br>
					<table style="width:60%; border:none">
						<tr style="border:none">
							<td width="50%" style="border:none">
								<h5>
								I tuoi aplogruppi sono in fase di approvazione.<br>
								Torna fra un po'.
								</h5>
							</td>
							<td style="border:none">
								Your haplogroups are in pending approval.<br>
								Come back later.
							</td>
						</tr>
					</table>
				</div>
			</c:if>	
			<c:if test="${!hasBozza}">
				<div align=center>	
					<br>
					<table style="width:60%; border:none">
						<tr style="border:none">
							<td width="50%" style="border:none">
								<h5>
								Non hai inserito i tuoi dati genetici.<br>
								<a href="/account/inserisci">Inseriscili!</a>
								</h5>
							</td>
							<td style="border:none">
								You haven't inserted your genetic data yet.<br>
								<a href="/account/inserisci">Insert them!</a>
							</td>
						</tr>
						<tr style="border:none">
							<td colspan="2" style="border:none">
								<h5>
								Stai riscontrando dei problemi?<br>
								<a href="https://www.ethnopedia.info/contatti.html">Contattaci!</a>
								</h5>
							</td>
						</tr>
					</table>
				</div>
			</c:if>	
			
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
        <p>© Copyright 2019 Ethnopedia| <a href="https://www.facebook.com/ethnopedia/">
		<img src="https://www.ethnopedia.info/account/resources/style/images/icon-facebook.png" alt="" /></a>
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