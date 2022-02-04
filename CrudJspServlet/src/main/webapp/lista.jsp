<%@page import="java.util.List"%>
<%@page import="br.edu.senai.persistencia.FuncionarioDao"%>
<%@page import="br.edu.senai.persistencia.Dao"%>
<%@page import="br.edu.senai.entidade.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="br.edu.senai.controle.Controle"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Funcionarios</title>
</head>
<body>
<h1>Lista de Funcionarios</h1>
<% 
	
	FuncionarioDao fd = new FuncionarioDao();
	List<Funcionario> lf = fd.findAll();
	for(Funcionario funcionario: lf){
%>
<ul>
	<li><%=funcionario.getNome() %>, <%=funcionario.getIdFuncionario() %>, <%=funcionario.getSalario() %>
	</li>
</ul>
<% } %>
</body>
</html>