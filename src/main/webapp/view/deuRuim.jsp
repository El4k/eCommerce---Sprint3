<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Erro Finalizacao Compra</title>
<script type="text/javascript">
	alert("Compra nao realizada com sucesso!\n ESTOQUE INSUFICIENTE\n Seu pedido foi atualizado para que a compra ocorra!");
	window.location = "http://localhost:8080/ecommerce/pear?acao=TelaEntradaComAtributo&PedidoId=${pedido.id}";
</script>
</head>
<body>

</body>
</html>