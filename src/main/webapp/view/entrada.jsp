<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="pear.model.Produto"%>
<%@ page import="pear.model.Pedido"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrada</title>
</head>
<body>
	<c:import url="header.jsp"/>
	<c:if test="${not empty produtos}">
		<label for="html"><b>Lista de Produtos: </b></label>
		<br>
		<hr>
		<c:forEach items="${produtos}" var="produto">
			<div>
				<b>Produto:</b> ${ produto.nomeProduto} &nbsp ${produto.descricao }
				<br> <b>Valor: R$</b> ${produto.valorProduto}
			</div>
			<br>
			<div>
				<img src="${produto.imagem }" width=200 height=100>
			</div>
			<br>
			<input type="hidden" name="ProdutoId" value="${produto.id}">
			<a
				href="/ecommerce/pear?acao=AddProduto&PedidoId=${pedido.id}&produto=${produto.id}"><input
				type="submit" value="Adicionar"></a>
			<hr>
			<br>
		</c:forEach>
		<br>
	</c:if>
	<br>
	<br>
	<br>

	<input type="hidden" name="PedidoId" value="${pedido.id}">

</body>
</html>