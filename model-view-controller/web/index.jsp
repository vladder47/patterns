<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 01.12.2019
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Список фильмов</title>
  </head>
  <body>
  <h2>Список фильмов</h2>
  <table id="film-table">
    <tr><th>Название</th>
        <th>Жанр</th>
        <th>Режиссер</th>
        <th>Год</th>
        <th>Оценка</th></tr>
    <c:forEach var="film" items="${films}">
      <tr><td>${film.getTitle()}</td>
        <td>${film.getGenre()}</td>
        <td>${film.getDirector()}</td>
        <td>${film.getYear()}</td>
        <td>${film.getRating()}</td>
        <td><a href="<c:url value='/edit?id=${film.getId()}'/>">Изменить</a>
            <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                <input type="hidden" name="id" value="${film.getId()}">
                <input type="submit" value="Удалить">
            </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  <p><a href='<c:url value="/create"/>'>Добавить новый фильм</a></p>
  <script type="text/javascript">
      var socket = new WebSocket("ws://localhost:8080/push");

      socket.onopen = function(event) {
        console.log("Соединение установлено");
      };

      socket.onmessage = function(event) {
        if (event.data == "updateTable") {
            location.reload();
        };
      };

  </script>
  </body>
</html>
