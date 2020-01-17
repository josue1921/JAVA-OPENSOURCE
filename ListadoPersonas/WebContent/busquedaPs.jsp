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
							Busqueda por identificador: <input type="text" name="searchId" />
							Busqueda por nombre: <input type="text" name="searchName" />
							Busqueda por rfc: <input type="text" name="searchRfc" />
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
</body>
</html>