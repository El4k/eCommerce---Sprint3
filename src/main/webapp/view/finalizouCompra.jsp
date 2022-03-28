<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="view/entrada.css">
<meta charset="ISO-8859-1">
<title>Finalizando Compra</title>
<style>
h2 {
	text-align: center;
}
</style>
<style>
label {
	display: block;
	float: left;
}

label, input {
	width: 80px;
	margin: 0px 0;
}

input {
	width: 200px;
}
</style>
</head>
<body>
	<c:import url="header.jsp" />
	<h2>Dados do Usuario ${usuarioLogado.login}</h2>
	<hr>
	<br>
	<c:if test="${not empty usuarioLogado}">
		<c:if test="${not empty pedido}">
			<fieldset>
				<label for="html"><b>Rua: </b></label>${usuarioLogado.endereco.rua}<br>
				<label for="html"><b>Numero: </b></label>${usuarioLogado.endereco.numero}<br>
				<label for="html"><b>CEP: </b></label>${usuarioLogado.endereco.CEP}<br>
				<label for="html"><b>Cidade: </b></label>${usuarioLogado.endereco.cidade}<br>
				<label for="html"><b>Estado: </b></label>${usuarioLogado.endereco.estado}<br>
				<label for="html"><b>Frete: </b></label>${pedido.valorFrete}<br>
				<label for="html"><b>Prazo: </b></label>${pedido.prazoEntrega}<br>
				<label for="html"><b>ValorTotal: </b></label>${pedido.valorTotal}<br>
			</fieldset>
			<a
				href="/ecommerce/pear?acao=TelaEntrada"><input
				type="submit" value="Voltar"></a>
		</c:if>
	</c:if>
</body>
</html>