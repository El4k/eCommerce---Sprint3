<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="pear.model.Produto" %>
<%@ page import="pear.model.Pedido"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrinho de Compras</title>
</head>
<body>
Usuario: ${user.nome} <input type="hidden" name="idUser" value="${ user.id}">
<br>
<hr>
<c:if test="${not empty pedido.listaProdutos }">
${pedido.listaProdutos}
</c:if>
<a href="/ecommerce/pear?acao=FinalizarPedido"><input type="submit" value="Finalizar compra"></a>
</body>
</html>