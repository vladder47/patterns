<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 03.12.2019
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление нового фильма</title>
</head>
<body>
<h2>Добавление нового фильма</h2>
<form method="post">
    <label>Название фильма</label><br>
    <input name="title"/><br><br>
    <label>Жанр фильма</label><br>
    <input name="genre"/><br><br>
    <label>Режиссер фильма</label><br>
    <input name="director"/><br><br>
    <label>Год выхода фильма</label><br>
    <input name="year" type="number"/><br><br>
    <label>Рейтинг фильма</label><br>
    <input name="rating" type="number"/><br><br>
    <input type="submit" value="Сохранить"/>
</form>

</body>
</html>
