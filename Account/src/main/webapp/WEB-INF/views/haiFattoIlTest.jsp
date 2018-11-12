<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
	<title>Crea il tuo account</title>
	<link href="${contextPath}/resources/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	
	<style>
		html, body {
			height: 100%;
		}
		table td, table th {
		  padding: 5px;
		}	
		.main {
			height: 100%;
			width: 100%;
			display: table;
			text-align: center;
		}
		.wrapper {
			display: table-cell;
			height: 100%;
			vertical-align: middle;
		}
	</style>
	<script>
		$(document).ready(function() {
			$('#yes').click(function() {
				location.href='${contextPath}/registration';
			});
			$('#no').click(function() {
				$('.didYouTakeTest').hide();
				$('.banner').show();
			});
		});
		
	</script>

</head>

<body>

	<div class="main">
		<div class="wrapper">
			
			<c:if test="${!erroreValidazione}">
				<div class="didYouTakeTest">
					<h2 class="form-signin-heading" align=center>
						Hai già fatto un test genetico?<br> <small>Have you
							already taken a DNA test?</small> <br> <br>
						<button type="button" class="btn btn-success btn-lg" id="yes">Yes</button>
						<button type="button" class="btn btn-danger btn-lg" id="no">No</button>
					</h2>
				</div>
			</c:if>
	
			<div class="banner" style="display:none;">
				
				<h2>
					Possono iscriversi <u>solo</u> gli utenti<br>che hanno fatto il
					test genetico<br> <small><u>Only</u> people who
						purchased DNA test can register</small>
				</h2>
				
				<br>
				
				<br>
				<table align=center width="70%">
					<tr>
						<td style="text-align:left">
							<div class="preview">
								<a href="${contextPath}/../blog/testDNA.html" style="text-decoration: none; color : #000;">
								
									<table>
										<tr>
											<td>
												<img src="https://www.ethnopedia.info/blog/testdna/1.jpg" width="100%">
											</td>
											<td>
												<h4>
													<b>Il test genetico</b><br> perché farlo, a cosa serve, cosa ci offre, quali scegliere
												</h4> 
												Il nostro DNA è strettamente personale, unico, ci accompagna dalla
												nascita alla morte, non possiamo modificarlo a piacimento e anzi
												rimane immutato nel temp... &nbsp&nbsp&nbsp 
												<p style="color:blue;text-align:right;"><em> Continua</em></p>
											</td>
										</tr>
									</table>
								</a>
							</div>
							
						</td>
						<td>
							<h2>Ordina il kit Living DNA</h2>
							<a href="http://www.anrdoezrs.net/links/8289828/type/dlg/https://www.livingdna.com/" target="_top">
								<img src="https://www.awltovhc.com/image-8289828-12899160"
								width="50%" alt="" border="0" />
							</a>
							<h2>Order Living DNA kit</h2>
						</td>
					</tr>
				</table>
							
			</div>
			
		</div>
	</div>


</body>
</html>
