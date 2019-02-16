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
		.form-signin {
	    	max-width: 750px;
	    }
		.form-control {
		    width: 50%;
	    }
	    .btn-block {
		    width: 50%;
		}
		ul {
			margin-left: 120px;
		}
	</style>
	<script>
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
		function checkEmail() {
			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
			var goodColor = "#66cc66";
			var badColor = "#ff6666";		
			var email = document.getElementById('email');
			var message = document.getElementById('emailMessage');
			if(!email.value.match(re)) {
				email.style.backgroundColor = badColor;
				message.style.color = badColor;
				message.innerHTML = "E-mail non valida!"
			} else {
				email.style.backgroundColor = goodColor;
				message.style.color = goodColor;
				message.innerHTML = "OK!"
			}
		};
	</script>
</head>

<body>
	<div class="main">
		<div class="wrapper">
			
			<div class="signin">
				<form:form method="POST" modelAttribute="userForm" class="form-signin">
					<h2 class="form-signin-heading" align=center>Crea il tuo account</h2>
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
					<br>
					<spring:bind path="username">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="text" path="username" class="form-control"
								placeholder="Username" autofocus="true"></form:input>
							<form:errors path="username"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="nome">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="text" path="nome" class="form-control"
								placeholder="Nome / First name"></form:input>
							<form:errors path="nome"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="cognome">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="text" path="cognome" class="form-control"
								placeholder="Cognome / Last name"></form:input>
							<form:errors path="cognome"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="text" path="email" class="form-control"
								placeholder="Email" id="email" onkeyup="checkEmail();"></form:input>
							<form:errors path="email"></form:errors>
							<span id="emailMessage" class="emailMessage"></span>
						</div>
					</spring:bind>
		
					<spring:bind path="password">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="password" path="password" class="form-control"
								placeholder="Password" id="pass1"></form:input>
							<form:errors path="password"></form:errors>
						</div>
					</spring:bind>
		
					<spring:bind path="passwordConfirm">
						<div class="form-group ${status.error ? 'has-error' : ''}" align=center>
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Confirm password" id="pass2"
								onkeyup="checkPass(); return false;"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
							<span id="confirmMessage" class="confirmMessage"></span>
						</div>
					</spring:bind>
					
					<spring:bind path="gdpr">
						
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<table>
								<tr>
									<td width="5%">
										<form:checkbox path="gdpr" class="form-control" id="gdpr" />
									</td>
									<td>
										<small>Acconsento al trattamento dei miei dati secondo le disposizioni ai sensi degli artt. 6, 7, 8 e 9 
										del Regolamento Generale per la Protezione dei Dati personali (GDPR UE n. 679/2016), 
										presa visione dell'<a href="${contextPath}/gdpr">informativa sul trattamento</a> 
										che dichiaro aver letto</small>
									</td>
								</tr>
							</table>
							<form:errors path="gdpr"></form:errors>
						</div>
					</spring:bind>
					
					<div align=center>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
