<%--
  Created by IntelliJ IDEA.
  User: sujeong
  Date: 2023/06/27
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.board.domain.dto.BoardDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.id}</td>
            <td>${board.title}</td>
            <td>${board.category}</td>
            <td>${board.content}</td>
            <td>${board.username}</td>
            <td>${board.createAt}</td>
        </tr>
    </c:forEach>
</table>
