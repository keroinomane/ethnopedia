<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Crea il tuo account</title>
	<script type="text/javascript" src="${contextPath}/resources/style/js/jquery-1.5.min.js"></script>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script  type="text/javascript"> 
			    
            function checkPass()
            {
                var pass1 = document.getElementById('pass1');
                var pass2 = document.getElementById('pass2');
                var message = document.getElementById('confirmMessage');
                var goodColor = "#66cc66";
                var badColor = "#ff6666";
                if(pass1.value == pass2.value){
                    pass2.style.backgroundColor = goodColor;
                    message.style.color = goodColor;
                    message.innerHTML = "OK!"
                }else{
                    pass2.style.backgroundColor = badColor;
                    message.style.color = badColor;
                    message.innerHTML = "Password errata!"
                }
            }
	</script>   
	<style>
		table, tr, td {
			border:0;
		}
		.form-signin {
	    	margin: 0;
	    	max-width: 400px;
		}
		h1 {
			font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		}
	</style>
</head>

<body>

<div class="container">
	<table style="border-left:0;
		border-top:0;border-right:0;width:100%;">
		<tr style="border-left:0;
			border-top:0;">
			<td style="border-right:0;vertical-align:middle;" align="right">
				<form:form method="POST" modelAttribute="userForm" class="form-signin">
			        <h2 class="form-signin-heading" align=center>Crea il tuo account</h2>
			        <br>
			        <spring:bind path="username">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="username" class="form-control" placeholder="Username"
			                            autofocus="true"></form:input>
			                <form:errors path="username"></form:errors>
			            </div>
			        </spring:bind>
			        
			        <spring:bind path="nome">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="nome" class="form-control" placeholder="Nome / First name"></form:input>
			                <form:errors path="nome"></form:errors>
			            </div>
			        </spring:bind>
			        
			        <spring:bind path="cognome">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="cognome" class="form-control" placeholder="Cognome / Last name"></form:input>
			                <form:errors path="cognome"></form:errors>
			            </div>
			        </spring:bind>
			        
			        <spring:bind path="email">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="email" class="form-control" placeholder="Email"></form:input>
			                <form:errors path="email"></form:errors>
			            </div>
			        </spring:bind>
			
			        <spring:bind path="password">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="password" path="password" class="form-control" placeholder="Password" id="pass1"></form:input>
			                <form:errors path="password"></form:errors>
			            </div>
			        </spring:bind>
			
			        <spring:bind path="passwordConfirm">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="password" path="passwordConfirm" class="form-control"
			                            placeholder="Conferma password" id="pass2" onkeyup="checkPass(); return false;"></form:input>
			                <form:errors path="passwordConfirm"></form:errors>
			                <span id="confirmMessage" class="confirmMessage"></span>
			            </div>
			        </spring:bind>
			
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
			        <br>
			        <div align=center>
				        Il nome e il cognome devono essere veri.<br> Non verranno visualizzati pubblicamente.<br>
				        <small>For American people:</small>
				    </div>
				    <div align=left>
				    	<small>
					    	<ul>
					    	<li>please insert your maiden name</li>
					    	<li>please insert your original italian last name, if it has been changed in Ellis Island</li>
					    	</ul>
				    	</small>
			    	</div>
			
			    </form:form>
			</td>   
			<td width=60% style="border-right:0;" align=center>
				<div align=center>
					<br>
					<a href="http://www.dpbolvw.net/click-8289828-12899160" target="_top">
						<img src="http://www.awltovhc.com/image-8289828-12899160" width="25%" alt="" border="0"/>
					</a>
					<br><br>
					<h1>
					Possono iscriversi solo gli utenti<br>che hanno fatto il test genetico<br>
			        <small>Only people who purchased DNA test can register</small>
			        </h1>
			        <br><br>
			        <a href="http://www.anrdoezrs.net/click-8289828-12899164" target="_top">
								<img src="http://www.lduhtrp.net/image-8289828-12899164" height="90" alt="" border="0"/>
							</a>
			        </div>
			</td>
		</tr>	
	</table>
    

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
