<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Telefono Encontrado</title>
</head>
<body>
	<c:set var="p" scope="request" value="${telefono}" />
	<h1>Telefono encontrada</h1>		
		
	<p>Codigo: ${t.codigo}</p>
	<p>Numero: ${t.numero}</p>
	<p>Tipo: ${t.tipo}</p>
	<p>Operadora: ${t.operadora}</p>
	<p>Usuario: ${t.usuario}</p>
	
	<a href="/AgendaTelefonicaJEE/HTMLs/index.html">Regresar al index</a>
	
</body>
</html>

