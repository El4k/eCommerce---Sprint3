<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="pear.model.Pedido"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro Estoque</title>
<script type="text/javascript">
	alert("Unidades fora do estoque!");
	window.location = "http://localhost:8080/ecommerce/pear?acao=TelaEntradaComAtributo&PedidoId=${pedido.id}";
</script>

</head>
<body>
</body>
</html>