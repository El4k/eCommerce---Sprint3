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
<title>Carrinho de Compras</title>
</head>
<body>
	<c:import url="header.jsp" />
	<hr>
	<c:if test="${not empty pedido}">
		<c:forEach items="${pedido.listaProdutos}" var="produto">
			<div>
				<b>Produto:</b> ${ produto.nomeProduto} &nbsp ${produto.descricao }
				<br> <b>Valor: R$</b> ${produto.valorProduto}
			</div>
			<br>
			<div>
				<img src="${produto.imagem }" width=200 height=100>
			</div>
			<br>
			<a href="/ecommerce/pear?acao=RemoveProduto&produto=${produto.id}"><input
				type="submit" value="Remover Produto"></a>
			<hr>
		</c:forEach>
	</c:if>
	<br>
	<br>
	<hr>
	<a href="/ecommerce/pear?acao=TelaFinalizar"><input type="submit"
		value="Finalizar compra"></a>
	<a
		href="/ecommerce/pear?acao=TelaEntradaComAtributo&PedidoId=${pedido.id}"><input
		type="submit" value="Voltar"></a>
</body>
</html>