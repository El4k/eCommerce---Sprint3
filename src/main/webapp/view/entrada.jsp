<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,pear.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<header>
<div align=right><a href="/ecommerce/pear?acao=TelaCorreios"><input type="image" img src="http://www.agenciaeplus.com.br/wp-content/uploads/2017/09/carrinho.jpg" widht="70" height="70"></a><a href="/ecommerce/pear?acao=TelaIndex"><input type="image" img src="https://www.seekpng.com/png/full/138-1387775_login-to-do-whatever-you-want-login-icon.png" widht="70" height="70"></a><div>
</header>
<meta charset="ISO-8859-1">
<title>Entrada</title>
</head>
<body>
	<c:if test="${not empty produtos}"><label for="html"><b>Lista de Produtos: </b></label></div><br><hr> ${produtos} </c:if>
	<br><br><br>
</body>
</html>