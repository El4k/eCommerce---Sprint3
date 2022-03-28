<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="pear.model.Produto"%>
<%@ page import="pear.model.Pedido"%>
<%@ page import="pear.acao.AddProduto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="view/entrada.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<title>Entrada</title>
</head>
<body>
	<c:import url="header.jsp" />
	<c:if test="${not empty produtos}">
		<label for="html"><span>Lista de Produtos: </span></label>
		<br>
		<hr>
		<c:forEach items="${produtos}" var="produto">
			<div>
				<p>Produto: ${ produto.nomeProduto} &nbsp ${produto.descricao }</p>
				<p>Valor: R$ ${produto.valorProduto}</p>
        <p>QuantidadeEstoque: ${produto.quantidadeEstoque}</p>
			</div>
			<div>
				<img src="${produto.imagem}" width=200 height=100>
			</div>
			<input type="hidden" name="ProdutoId" value="${produto.id}">
			<a href="/ecommerce/pear?acao=AddProduto&PedidoId=${pedido.id}&produto=${produto.id}" id="botao">
        <input type="submit" value="Adicionar">
      </a>
      		<hr>
			<br>
		</c:forEach>
		<br>
	</c:if>
  <hr>
	<br>
	<br>
	<br>

	<input type="hidden" name="PedidoId" value="${pedido.id}">

</body>
</html>