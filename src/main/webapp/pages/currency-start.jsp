<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zewius
  Date: 19.04.22
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Конвертер валют</title>
</head>

<body>

<div class="title">
    <h2>Онлайн конвертер валют</h2>
</div>

<div class="description">
    <p>Курсовая работа, ИВТ-20-1, Красилов Сергей</p>
</div>

<br>

<h3>Конвертировать:</h3>
<form action="" method="post">
    <label>
        <p>Из:</p>
        <select name="from">
            <c:forEach var="currency" items="${currencies}">
                <option value="${currency.key}">${currency.key} - ${currency.value}</option>
            </c:forEach>
        </select>

        <p>Значение:</p>
        <input name="value" type="text"
               placeholder="Введите значение"/>

        <p>В:</p>
        <select name="to">
            <c:forEach var="currency" items="${currencies}">
                <option value="${currency.key}">${currency.key} - ${currency.value}</option>
            </c:forEach>
        </select>
    </label>
    <br><br>
    <input type="submit" value="Конвертировать">
</form>
</body>
</html>
