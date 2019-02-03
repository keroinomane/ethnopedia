<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../basis/alto.html"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Istruzioni per GEDmatch</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/style/style.css" media="all" />
<link rel="stylesheet" media="all"
	href="${contextPath}/resources/style/type/folks.css" />
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<script type="text/javascript"
	src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/style/js/ddsmoothmenu.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/style/js/scripts.js"></script>
<style>
#about {
	width: 75%;
}

td {
	text-align: center;
	width: 50%;
}
</style>
<script type="text/javascript">
	$(function() {
		$('.tutorial23').hide();
		$('.tutorial23gedmatch').hide();
		$("input[name='rawDataConservati']").change(function(){
			$('.tutorial23gedmatch').show();
			if ($(this).val() === 'no')
			    $('.tutorial23').show();
			else
				$('.tutorial23').hide();
		});
	});
</script>
</head>

<body>
	<div id="container">

		<c:import url="basis/alto.html" />

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
					<h1>Istruzioni per GEDmatch</h1>
				</div>
				<!-- End Intro -->
				<!-- Begin About -->
				<div id="about">
					<h3>Quale test hai fatto?</h3>
					<ul class="tabs">
						<li><a href="#23">23andMe</a></li>
						<li><a href="#geno">Geno 2.0 Next Generation</a></li>
						<li><a href="#living">Living DNA</a></li>
					</ul>
					<div class="tab_container">
						<div style="display: none;" id="23" class="tab_content">
							<table style="border: none;">
								<tr style="border: none;">
									<td style="border: none;" colspan=2>
										Hai ancora conservato da qualche parte i raw data di 23andMe che hai scaricato 
										precedentemente?
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none; text-align:right">
										<input type="radio" name="rawDataConservati" value="sì" checked />Sì
									</td>
									<td style="border: none; text-align:left">
										<input type="radio" name="rawDataConservati" value="no" />No
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;" colspan=2>
										<br>
									</td>
								</tr>
								<tr style="border: none;" class="tutorial23">
									<td style="border: none;">Accedi su <a
										href="https://you.23andme.com/"
										onclick="window.open(this.href);return false"><b>23andMe.</b></a><br>
									<br> Una volta entrato nel tuo profilo, clicca in alto a destra
										sul tuo nome e seleziona dal menu a tendina <b>Browse Raw Data.</b>
									</td>
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/23/1.png"
										width=100% />
									</td>
								</tr>
								<tr style="border:none;" class="tutorial23">
									<td style="border:none;">
										<img src="${contextPath}/resources/img/howto/23/2.png" width=75%/>
									</td>
						    		<td style="border:none; text-align:left; vertical-align:middle;">
										Tornando in alto, clicca su <strong>download</strong>.
									</td>
								</tr>
								<tr style="border:none;" class="tutorial23">
									<td style="border:none; text-align:right; vertical-align:middle;">
										Apparirà una nuova pagina, vai in basso e clicca <strong>Submit request</strong>.<br><br>
										Ti arriverà dopo qualche minuto un'email, aprila e clicca su <strong>Download raw data</strong>.<br><br>
										Una volta che hai scaricato il file, <strong>devi decomprimerlo</strong> (unzipparlo) e caricarlo nel form del nostro sito che hai visto prima.
									</td>
									<td style="border:none;">
										<img src="${contextPath}/resources/img/howto/23/3.png" width=75%/>
									</td>
								</tr>
								<tr style="border: none;" class="tutorial23gedmatch">
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/6.png"
										width=100% /></td>
									<td style="border: none;">Registrati su <a
										href="https://genesis.gedmatch.com/login1.php"
										onclick="window.open(this.href);return false"><b>GEDmatch.</b></a><br>
									<br> Completata la registrazione, carichi i raw data
										andando nella sezione a destra <b>(Upload your DNA files)</b> e 
										cliccando su <b>Generic Uploads (23andme, FTDNA, AncestryDNA, most others).</b><br>
									<br> Dai il consenso e ti scegli un alias (soprannome).<br>
									Inserisci tutti i tuoi dati personali, aplogruppi compresi
										(inserisci i subcladi se presenti!).
									<br>Ultimato il caricamento dei raw
										data su GEDmatch, ti verrà dato un codice.<br> <b>Còpiatelo
											da qualche parte.</b><br>
									</td>
								</tr>
								<tr style="border: none;" class="tutorial23gedmatch">
									<td style="border: none;" colspan="2">
										<br>
										Ora devi aspettare che finiscano di processare il tuo kit. Potrebbero volerci 
										24 ore o più.<br>
										Quando l'elaborazione è finita, troverai nell'homepage di GEDmatch il tuo kit 
										number contrassegnato da una spunta blu di fianco.<br><br>
										Torna qui quando apparirà questa spunta blu.
									<br><br><b>.....</b><br><br><br>
									</td>
								</tr>
								<tr style="border: none;" class="tutorial23gedmatch">
									<td style="border: none;">
										Ora puoi finalmente usufruire dei vari calcolatori
										gratuiti di GEDmatch.<br>
									<br>Sotto la sezione a destra <b>DNA Applications</b>, clicca su
										<b>Admixture (heritage).</b>
									</td>
									<td style="border: none;">
										<img
										src="${contextPath}/resources/img/howto/gedmatch/5.png"
										width=100% />
									</td>
								</tr>
								<tr style="border: none;" class="tutorial23gedmatch">
									<td style="border: none;" colspan="2">Seleziona dalla
										lista il progetto <b>Eurogenes,</b> lasci selezionato il primo
										pallino e clicca <b>Continue.</b><br>
									<br> Incolli il tuo <b>codice</b> che ti eri salvato
										prima, scegli il calcolatore <b>EUtest</b> (l'ultimo nella
										lista) e inserisci <b>Italian</b> su ethnicity.<br>
									<br> Finito! Ora aspetta che ti esca una nuova schermata
										con altri dati interessanti.<br>
									<br> Tieni aperta la scheda, <a
										href="http://www.ethnopedia.info/account/">torna nel tuo
											profilo di Ethnopedia</a> e inserisci quei risultati.
									</td>
								</tr>
							</table>
						</div>
						<div style="display: none;" id="geno" class="tab_content">
							<table style="border: none;">
								<tr style="border: none;">
									<td style="border: none;" colspan="2">A differenza di
										Living DNA e 23andMe, Geno 2.0 purtroppo <b>non offre il
											download dei raw data relativi al DNA autosomico nel loro
											sito.</b><br> Cosa sono? I raw data sono i tuoi dati
										genetici privi di qualsiasi interpretazione.<br> Li
										scarichi e successivamente puoi inserirli in altri siti che
										offrono altri servizi (anche informazioni salutari) o
										calcolatori (spesso gratuiti).<br>
									<br> Geno 2.0 è ottimo per l'analisi degli aplogruppi
										(paterni e materni), ma la sua analisi autosomica lascia a
										desiderare (è piuttosto generica ed imprecisa) e soprattutto
										non consente di scaricare i raw data che è possibile
										utilizzare in altri siti e servizi, quindi per quanto riguarda
										il DNA autosomico è come se avessi acquistato qualcosa di
										incompleto, di "monco".<br>
									<br> L'aplogruppo paterno ad esempio si riferisce solo al
										cromosoma Y, mentre l'analisi autosomica è relativa a <b>tutti
											gli altri 45 cromosomi.</b><br> Il DNA autosomico ti dà più
										informazioni <b>su quello che sei tu,</b> non sul tuo lontano
										antenato paterno vissuto migliaia di anni fa.<br>
									<br>
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;">Per ottenere i propri raw data
										con Geno 2.0 occorre trasferire i propri dati su FTDna e
										acquistare <b>Family Finder</b> (al prezzo scontato di <b>35
											euro</b> per gli utenti di Geno).<br> Accedi su <a
										href="https://www.familytreedna.com/login.aspx"
										onclick="window.open(this.href);return false"><b>FTDna</b></a>
										e acquista Family Finder se non l'hai già fatto.<br>
									<br> Non dovrai spedire un altro campione di saliva: sarà
										analizzato quello che hai già mandato a Geno e che ora si
										trova nei laboratori di FTDna.<br> I risultati saranno
										quindi istantanei.
									</td>
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/1.png"
										width=100% /></td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/2.png"
										width=100% /></td>
									<td style="border: none;">Una volta acquistato Family
										Finder, puoi già ottenere altri risultati e servizi di FTDna
										come <b>myOrigins, ancientOrigins</b> e <b>Matches.</b><br>
									<br> Per poter scaricare i raw data però <b>devi
											aspettare 1 o 2 giorni,</b> quando saranno disponibili.<br>
										Li potrai scaricare cliccando su <b>Download Raw Data,</b>
										sotto ancientOrigins.
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;">Apparirà una nuova schermata
										dove dovrai scegliere <b>Build 37 Raw Data Concatenated.</b>
									</td>
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/3.PNG"
										width=100% /></td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/6.png"
										width=100% /></td>
									<td style="border: none;">Finito di scaricare i raw data,
										potrai ora registrarti su <a
										href="https://genesis.gedmatch.com/login1.php"
										onclick="window.open(this.href);return false"><b>GEDmatch.</b></a><br>
									<br>Completata la registrazione, carichi i raw data
										andando nella sezione a destra <b>(Upload your DNA files)</b> e 
										cliccando su <b>Generic Uploads (23andme, FTDNA, AncestryDNA, most others).</b><br>
									<br> Dai il consenso e ti scegli un alias (soprannome).<br>
									Inserisci tutti i tuoi dati personali, aplogruppi compresi
										(inserisci i subcladi se presenti!).
									<br>Ultimato il caricamento dei raw
										data su GEDmatch, ti verrà dato un codice.<br> <b>Còpiatelo
											da qualche parte.</b><br>
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;" colspan="2">
										<br>
										Ora devi aspettare che finiscano di processare il tuo kit. Potrebbero volerci 
										24 ore o più.<br>
										Quando l'elaborazione è finita, troverai nell'homepage di GEDmatch il tuo kit 
										number contrassegnato da una spunta blu di fianco.<br><br>
										Torna qui quando apparirà questa spunta blu.
									<br><br><b>.....</b><br><br><br>
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;">
										Ora puoi finalmente usufruire dei vari calcolatori
										gratuiti di GEDmatch.<br>
									<br>Sotto la sezione a destra <b>DNA Applications</b>, clicca su
										<b>Admixture (heritage).</b>
									</td>
									<td style="border: none;">
										<img
										src="${contextPath}/resources/img/howto/gedmatch/5.png"
										width=100% />
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;" colspan="2">Seleziona dalla
										lista il progetto <b>Eurogenes,</b> lasci selezionato il primo
										pallino e clicca <b>Continue.</b><br>
									<br> Incolli il tuo <b>codice</b> che ti eri salvato
										prima, scegli il calcolatore <b>EUtest</b> (l'ultimo nella
										lista) e inserisci <b>Italian</b> su ethnicity.<br>
									<br> Finito! Ora aspetta che ti esca una nuova schermata
										con altri dati interessanti.<br>
									<br> Tieni aperta la scheda, <a
										href="http://www.ethnopedia.info/account/">torna nel tuo
											profilo di Ethnopedia</a> e inserisci quei risultati.
									</td>
								</tr>
							</table>
						</div>
						<div style="display: none;" id="living" class="tab_content">
							<table>
								<tr style="border: none;">
									<td style="border: none;">Accedi su <a
										href="https://my.livingdna.com/login"
										onclick="window.open(this.href);return false"><b>Living
												DNA.</b></a><br>
									<br> Una volta entrato nel tuo profilo, clicca a sinistra
										su <b>Download Raw Data,</b> clicca sulla casella per dare il
										consenso e infine su <b>Download autosomal (family
											ancestry) raw marker data.</b>
									</td>
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/7.png"
										width=100% /></td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;"><img
										src="${contextPath}/resources/img/howto/gedmatch/6.png"
										width=100% /></td>
									<td style="border: none;">Finito di scaricare i raw data,
										potrai ora registrarti su <a
										href="https://genesis.gedmatch.com/login1.php"
										onclick="window.open(this.href);return false"><b>GEDmatch.</b></a><br>
									<br>Completata la registrazione, carichi i raw data
										andando nella sezione a destra <b>(Upload your DNA files)</b> e 
										cliccando su <b>Generic Uploads (23andme, FTDNA, AncestryDNA, most others).</b><br>
									<br> Dai il consenso e ti scegli un alias (soprannome).<br>
									Inserisci tutti i tuoi dati personali, aplogruppi compresi
										(inserisci i subcladi se presenti!).
									<br>Ultimato il caricamento dei raw
										data su GEDmatch, ti verrà dato un codice.<br> <b>Còpiatelo
											da qualche parte.</b><br>
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;" colspan="2">
										<br>
										Ora devi aspettare che finiscano di processare il tuo kit. Potrebbero volerci 
										24 ore o più.<br>
										Quando l'elaborazione è finita, troverai nell'homepage di GEDmatch il tuo kit 
										number contrassegnato da una spunta blu di fianco.<br><br>
										Torna qui quando apparirà questa spunta blu.
									<br><br><b>.....</b><br><br><br>
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;">
										Ora puoi finalmente usufruire dei vari calcolatori
										gratuiti di GEDmatch.<br>
									<br>Sotto la sezione a destra <b>DNA Applications</b>, clicca su
										<b>Admixture (heritage).</b>
									</td>
									<td style="border: none;">
										<img
										src="${contextPath}/resources/img/howto/gedmatch/5.png"
										width=100% />
									</td>
								</tr>
								<tr style="border: none;">
									<td style="border: none;" colspan="2">Seleziona dalla
										lista il progetto <b>Eurogenes,</b> lasci selezionato il primo
										pallino e clicca <b>Continue.</b><br>
									<br> Incolli il tuo <b>codice</b> che ti eri salvato
										prima, scegli il calcolatore <b>EUtest</b> (l'ultimo nella
										lista) e inserisci <b>Italian</b> su ethnicity.<br>
									<br> Finito! Ora aspetta che ti esca una nuova schermata
										con altri dati interessanti.<br>
									<br> Tieni aperta la scheda, <a
										href="http://www.ethnopedia.info/account/">torna nel tuo
											profilo di Ethnopedia</a> e inserisci quei risultati.
									</td>
								</tr>
							</table>
						</div>
					</div>
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
								src="${contextPath}/resources/style/images/icon-facebook.png"
								alt="" /></a>
						</p>
					</div>
					<!-- End Copyright -->

				</div>
			</div>
		</div>
		<!-- End Footer -->
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>