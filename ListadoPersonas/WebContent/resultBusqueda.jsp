<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Busqueda de personas.</title>
</head>
<body>
	<center>
		<h2>
			<a href="new">Registrar</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">Listado</a>
            &nbsp;&nbsp;&nbsp;
			<a href="busqueda">Busqueda</a>
			&nbsp;&nbsp;&nbsp;
		</h2>
	</center>
	<div align="center">
		<table>
			<form action="searchBy" method="post">
				<thead>
					<tr>
						<th>
							Busqueda por identificador: <input type="text" id="searchId" />
							Busqueda por nombre: <input type="text" id="searchName" />
							Busqueda por rfc: <input type="text" id="searchRfc" />
						<th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<center>
								<input type="submit" value="search" />
							</center>
						</td>
					</tr>
				</tbody>
			</form>
		</table>
	</div>
	<div align="center">
		<c:if test="${person != null}">
	        <table border="1" cellpadding="5">
	            <caption><h2>Busqueda</h2></caption>
	            <tr>
	                <th>ID</th>
	                <th>Nombre</th>
	                <th>Apellido Paterno</th>
	                <th>Apellido Materno</th>
	                <th>Email</th>
	                <th>Telefono</th>
	                <th>Acciones</th>
	            </tr>
	            <c:forEach var="persona" items="${listPerson}">
	                <tr>
	                    <td><c:out value="${persona.id}" /></td>
	                    <td><c:out value="${persona.nombre}" /></td>
	                    <td><c:out value="${persona.apellidoP}" /></td>
	                    <td><c:out value="${persona.apellidoM}" /></td>
	                    <td><c:out value="${persona.correo}" /></td>
	                    <td><c:out value="${persona.telefono}" /></td>
	                    <td>
	                        <a href="edit?id=<c:out value='${persona.id}' />">Editar</a>
	                        &nbsp;&nbsp;&nbsp;&nbsp;
	                        <a href="delete?id=<c:out value='${persona.id}' />">Eliminar</a>                     
	                    </td>
	                </tr>
	            </c:forEach>
	        </table>
        </c:if>
    </div>
</body>
</html>