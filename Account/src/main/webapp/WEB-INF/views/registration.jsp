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
				$('.didYouTakeTest').hide();
				$('.signin').show();
			});
			$('#no').click(function() {
				$('.didYouTakeTest').hide();
				$('.banner').show();
			});
		});
		function checkPass() {
			var pass1 = document.getElementById('pass1');
			var pass2 = document.getElementById('pass2');
			var message = document.getElementById('confirmMessage');
			var goodColor = "#66cc66";
			var badColor = "#ff6666";
			if (pass1.value == pass2.value) {
				pass2.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "OK!"
			} else {
				pass2.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "Password errata!"
			}
		};
		
	</script>

</head>

<body>

	<div class="main">
		<div class="wrapper">
		
			<div class="didYouTakeTest">
				<h2 class="form-signin-heading" align=center>
					Hai già fatto un test genetico?<br> <small>Have you
						already taken a DNA test?</small> <br> <br>
					<button type="button" class="btn btn-success btn-lg" id="yes">Yes</button>
					<button type="button" class="btn btn-danger btn-lg" id="no">No</button>
				</h2>
			</div>
			
			<div class="signin" style="display:none;">
				<form:form method="POST" modelAttribute="userForm" class="form-signin">
					<h2 class="form-signin-heading" align=center>Crea il tuo account</h2>
					<br>
					<spring:bind path="username">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="username" class="form-control"
								placeholder="Username" autofocus="true"></form:input>
							<form:errors path="username"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="nome">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="nome" class="form-control"
								placeholder="Nome / First name"></form:input>
							<form:errors path="nome"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="cognome">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="cognome" class="form-control"
								placeholder="Cognome / Last name"></form:input>
							<form:errors path="cognome"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="email" class="form-control"
								placeholder="Email"></form:input>
							<form:errors path="email"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="password">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="password" class="form-control"
								placeholder="Password" id="pass1"></form:input>
							<form:errors path="password"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="passwordConfirm">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Confirm password" id="pass2"
								onkeyup="checkPass(); return false;"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
					</spring:bind>
		
					<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
					<br>
					<div align=center>
						Il nome e il cognome devono essere veri.<br> Non verranno
						visualizzati pubblicamente.
						<br><br>
						<small>For American people:</small>
					</div>
					<div align=left>
						<ul>
							<li><small>please insert your maiden name</small></li>
							<li><small>please insert your original italian last
									name, if it has been changed in Ellis Island</small></li>
						</ul>
					</div>
				</form:form>
			</div>
	
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
