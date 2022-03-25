<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/pear" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de novo usuário</title>
<style> label {display: block; 	float: left; } label, input { 	width:100px; 	margin: 3px 0; } input { 	width:150px; } 	width:200px; }</style>
</head>
<body>
	<div class="card">
	    	<h1>Formulário de Cadastro</h1>
	    <div class="container-form">
			<form action="${linkEntradaServlet}" method="post">
				<fieldset>
			        <div class="label-container">
			    		<label for='client-login'>Login: </label>
			       		<input id='client-login' placeholder="Login" name="login" >
			        </div>
			        <div class="label-container">
			        	<label for='client-password'>Senha: </label>
			        	<input id='client-password' placeholder="Senha" name="senha" type="password" >
			        </div>
			        <div class="label-container">
				        <label for='client-street'>Rua: </label>
				        <input id='client-street' placeholder="Rua" name="rua" >
			        </div>
			        <div class="label-container">
				        <label for='client-housenumber'>Número: </label>
				        <input id='client-housenumber' placeholder="Numero" name="numero" type="number">
			        </div>
			        <div class="label-container">
				        <label for='client-city'>Cidade: </label>
				        <input id='client-city' placeholder="Cidade" name="cidade" >
			        </div>
			        <div class="label-container">
				        <label for='client-state'>Estado: </label>
				        <input id='client-state' placeholder="Estado"  name="estado" >
				    </div>  
			        <div class="label-container">
				        <label for='destiny'>CEP de destino: </label>
				        <input id='destiny' placeholder="CEP de destino" name="CEP" type="text" pattern=[0-9]{8}>
				    </div> 
			        <div class="label-container">
				        <input type="hidden" name=acao value=Cadastro>
				        <input type="submit" value="Cadastrar">
			        </div>
			        <div class="label-container">
				        <a href="${linkEntradaServlet}?acao=TelaIndex"> Voltar </a>
			        </div>
			    </fieldset>
			</form>
		</div>
	</div>
</body>
</html>