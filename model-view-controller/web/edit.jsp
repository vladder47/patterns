<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 03.12.2019
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование фильма</title>
</head>
<body>
<h2>Редактирование информации о фильме</h2>
<form method="post">
    <label>Название фильма</label><br>
    <input name="title" value="${film.getTitle()}"/><br><br>
    <label>Жанр фильма</label><br>
    <input name="genre" value="${film.getGenre()}"/><br><br>
    <label>Режиссер фильма</label><br>
    <input name="director" value="${film.getDirector()}"/><br><br>
    <label>Год выхода фильма</label><br>
    <input name="year" type="number" value="${film.getYear()}"/><br><br>
    <label>Рейтинг фильма</label><br>
    <input name="rating" type="number" value="${film.getRating()}"/><br><br>
    <input type="submit" value="Сохранить"/>
</form>
</body>
</html>
