<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.fiap.lojaclasses.Categoria" %>
<%
	List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Categorias</title>
</head>
<body>
<h2>Categorias</h2>
<a href="CategoriaServlet?acao=novo">Nova Categoria</a>
<table border="1">
	<tr><th>ID</th><th>Descrição</th><th>Ações</th></tr>
	<%
		for(Categoria cat: categorias) {
	%>
	<tr>
		<td><%= cat.getIdCategoria() %></td>
		<td><%= cat.getDescricao() %></td>
		<td>
			<a href="CategoriaServlet?acao=alterar&id=<%= cat.getIdCategoria() %>">Editar</a>
			<a href="CategoriaServlet?acao=excluir&id=<%= cat.getIdCategoria() %>">Excluir</a>			
		</td>
	</tr>
	<%} %>
</table>

</body>
</html>