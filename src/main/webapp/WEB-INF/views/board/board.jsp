<%--
  Created by IntelliJ IDEA.
  User: sujeong
  Date: 2023/06/27
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="/board" method="post">
        <input type="text" name="title" placeholder="title을 입력해주세요">
        <input type="text" name="category" placeholder="category를 입력해주세요">
        <input type="text" name="content" placeholder="content을 입력해주세요">
        <input type="text" name="username" placeholder="username을 입력해주세요">
        <input type="submit">
    </form>
</div>
