<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            overflow: hidden;
            word-break: normal;
            border: 1px solid #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>

<body>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<h1>Todo List</h1>

<c:if test="${!empty listTasks}">
    <table class="tg">
        <tr>
            <th width="20">ID</th>
            <th width="300">Описание</th>
            <th width="180">Статус выполнения</th>
            <th width="80">Изменить</th>
            <th width="80">Удалить</th>
        </tr>
        <c:forEach items="${listTasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.executionStatus}</td>
                <td><a href="<c:url value="/edit/${task.id}"/>">Изменить</a></td>
                <td><a href="<c:url value="/remove/${task.id}"/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<table>
    <tr>
        <td>
            <form action="<c:url value="/previousPage"/>" method="get">
                <input type="submit" value="<spring:message text="Туда"/>">
            </form>
        </td>
        <td>
            ${pageNumber}
        </td>
        <td>
            <form action="<c:url value="/nextPage"/>" method="get">
                <input type="submit" value="<spring:message text="Сюда"/>">
            </form>
        </td>
    </tr>
</table>

</body>
</html>
