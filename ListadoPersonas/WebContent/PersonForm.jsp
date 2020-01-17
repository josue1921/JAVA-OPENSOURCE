<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person BD</title>
</head>
<body>
    <center>
        <h2>
            <a href="new">Registrar</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">Listado</a>
            &nbsp;&nbsp;&nbsp;
            <a href="busqueda">Busqueda</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${person != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${person == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${person != null}">
                        Editar
                    </c:if>
                    <c:if test="${person == null}">
                        Aregar nuevo
                    </c:if>
                </h2>
            </caption>
                <c:if test="${person != null}">
                    <input type="hidden" name="id" value="<c:out value='${person.id}' />" />
                </c:if>           
            <tr>
                <th>Nombre: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${person.nombre}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Apellido paterno: </th>
                <td>
                    <input type="text" name="apat" size="45"
                            value="<c:out value='${person.apellidoP}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Apellido materno: </th>
                <td>
                    <input type="text" name="amat" size="45"
                            value="<c:out value='${person.apellidoM}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Telefono: </th>
                <td>
                    <input type="text" name="tel" size="20"
                            value="<c:out value='${person.telefono}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Correo: </th>
                <td>
                    <input type="text" name="mail" size="20"
                            value="<c:out value='${person.correo}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Genero: </th>
                <td>
                    <input type="text" name="gender" size="20"
                            value="<c:out value='${person.genero}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>RFC: </th>
                <td>
                    <input type="text" name="rfc" size="20"
                            value="<c:out value='${person.rfc}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Guardar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>