<%@ page import="pear.model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div align=right>
		<c:if test="${not empty usuarioLogado}">
			<a href="/ecommerce/pear?acao=TelaSaida"><input type="image"
				src="https://thumbs.dreamstime.com/b/bot%C3%A3o-redondo-azul-ciano-especial-da-sa%C3%ADda-103957079.jpg"
				width="70" height="70"></a>
		</c:if>
		<a href="/ecommerce/pear?acao=TelaCarrinho"><input type="image"
			src="http://www.agenciaeplus.com.br/wp-content/uploads/2017/09/carrinho.jpg"
			width="70" height="70"></a><a
			href="/ecommerce/pear?acao=TelaIndex"><input type="image"
			src="https://www.seekpng.com/png/full/138-1387775_login-to-do-whatever-you-want-login-icon.png"
			width="70" height="70"></a>
	</div>
</header>