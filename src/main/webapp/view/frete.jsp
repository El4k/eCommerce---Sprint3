<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
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
width
:
200px
;
 
}
</style>
</head>
<body>
	<h2>Dados da Compra</h2>
	<hr>
	<br>
	<c:if test="${not empty usuarioLogado}">
		<fieldset>
			<label for="html"><b>Rua: </b></label>${usuarioLogado.endereco.rua}<br>
			<label for="html"><b>Numero: </b></label>${usuarioLogado.endereco.numero}<br>
			<label for="html"><b>CEP: </b></label>${usuarioLogado.endereco.CEP}<br>
			<label for="html"><b>Cidade: </b></label>${usuarioLogado.endereco.cidade}<br>
			<label for="html"><b>Estado: </b></label>${usuarioLogado.endereco.estado}<br>
		</fieldset>
	</c:if>

</body>
</html>