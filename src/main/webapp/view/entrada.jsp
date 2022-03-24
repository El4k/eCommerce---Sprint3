<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,pear.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrada</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id"
	content="323562547940-gn2im3vv9f8hdmfkrr78sf16s6533v8r.apps.googleusercontent.com">
<script>
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
</script>
</head>
<body>
	<c:if test="${not empty produtos}"><label for="html"><b>Lista de Produtos: </b></label><br><br> ${produtos}</c:if>
	<br><br><br>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
</body>
</html>