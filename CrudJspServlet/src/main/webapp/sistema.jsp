<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Cadastro de Funcionario </h2>

<form method="post" action="Controle?cmd=gravar">

	Nome <p/>
	<input type="text" name="nome" size="35">
	<br/>
	Salario <p/>
	<input type="text" name="salario" size="35">
	<br/>
	<input type="submit" value="Cadastrar"/>

</form>

${msg}
<br/>
<a href="lista.jsp">Listagem dos Funcionarios</a> 

</body>
</html>
