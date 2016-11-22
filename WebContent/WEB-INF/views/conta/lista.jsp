<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando Contas</title>
</head>
<body>


	<table>
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Paga?</th>
			<th>Data de Pagamento</th>
			<th>Ações</th>
		</tr>

		<c:forEach items="${todasContas}" var="conta">
			<!-- JSTL -->
			<tr>
				<td>${conta.id}</td>
				<!-- Aqui o mvs entende que precisa pegar o getID -->
				<td>${conta.descricao}</td>
				<td>${conta.valor}</td>
				<td>${conta.tipo}</td>
				<td><c:if test="${conta.paga eq false}">
				Não paga
				</c:if> 
				<c:if test="${conta.paga eq true}">
				Conta Paga!
				</c:if></td>
				<td><fmt:formatDate value="${conta.dataPagamento.time}"
						pattern="dd/MM/yyyy" /></td>	
				<td><a href="removeConta?id=${conta.id }"> Deletar </a></td>
				<td><a href="mostraConta?id=${conta.id}">Alterar</a></td>
			</tr>
		</c:forEach>



	</table>

</body>
</html>