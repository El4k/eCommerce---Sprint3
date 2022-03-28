<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="pear.model.Usuario"%>
<c:url value="/pear" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="view/entrada.css">
<meta charset="ISO-8859-1">
<title>Formulário</title>
<style>
label {
	display: block;
	float: left;
}

label, input {
	width: 100px;
	margin: 3px 0;
}

input {
	width: 150px;
}
</style>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="card">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<h1>Formulário de Dados</h1>
		<div class="container-form">
			<form action="${linkEntradaServlet}" method="post">
				<fieldset>
					<div class="label-container">
						<label for='client-login'>Login: </label> <input id='client-login'
							placeholder="Login" name="login" value="${usuarioLogado.login }">
					</div>
					<div class="label-container">
						<label for='client-password'>Senha: </label> <input
							id='client-password' placeholder="Senha" name="senha"
							type="password" value="${usuarioLogado.senha }">
					</div>
					<div class="label-container">
						<label for='destiny'>CEP: </label> <input id='destiny'
							placeholder="CEP" name="CEP" type="text"
							pattern=[0-9]{8} value="${usuarioLogado.endereco.CEP }">
					</div>
					<div class="label-container">
						<label for='client-street'>Rua: </label> <input id='client-street'
							placeholder="Rua" name="rua" value="${usuarioLogado.endereco.rua }">
					</div>
					<div class="label-container">
						<label for='client-housenumber'>Número: </label> <input
							id='client-housenumber' placeholder="Numero" name="numero"
							type="number" value="${usuarioLogado.endereco.numero }">
					</div>
					<div class="label-container">
						<label for='client-district'>Bairro: </label> <input id='client-district'
							placeholder="Bairro" name="bairro" value="${usuarioLogado.endereco.bairro }" required>
					</div>
					<div class="label-container">
						<label for='client-city'>Cidade: </label> <input id='client-city'
							placeholder="Cidade" name="cidade" value="${usuarioLogado.endereco.cidade }">
					</div>
					<div class="label-container">
						<label for='client-state'>Estado: </label> <input
							id='client-state' placeholder="Estado" name="estado" value="${usuarioLogado.endereco.estado }">
					</div>
					<div class="label-container">
						<input type="hidden" name=acao value=Atualizar> <input
							type="submit" value="Atualizar">
					</div>
					<div class="label-container">
						<a href="${linkEntradaServlet}?acao=TelaLogin"> Voltar </a>
					</div>
				</fieldset>
			</form>
			<script type="text/javascript">
		$("#destiny").focusout(function(){
		
			$.ajax({
			
				url: 'https://viacep.com.br/ws/'+$(this).val()+'/json/unicode/',
				
				dataType: 'json',
				
				success: function(resposta){
				
					if (("erro" in resposta)) {
						alert("Digite um CEP valido!")
						$("#destiny").val(resposta.destiny);
					}
					$("#client-street").val(resposta.logradouro);
					$("#complemento").val(resposta.complemento);
					$("#client-district").val(resposta.bairro);
					$("#client-city").val(resposta.localidade);
					$("#client-state").val(resposta.uf);
					
					$("#numero").focus();
				}

				
			});
		});
		</script>
		</div>
	</div>
</body>
</html>