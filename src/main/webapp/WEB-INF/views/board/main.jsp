<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인 페이지</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        // 게시물 클릭 시 상세 페이지로 이동하는 함수
        function viewBoard(boardId) {
            location.href = "/board/" + boardId;
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/main">게시판 프로그램</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <%-- 로그인 상태에 따라 회원가입 링크 표시 여부 결정 --%>
            <% if (session.getAttribute("id") == null) { %>
            <li class="nav-item">
                <a class="nav-link" href="/user/signup">회원가입</a>
            </li>
            <% } %>
            <li class="nav-item">
                <a class="nav-link" href="/user/login">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/board/create">게시물 작성</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <div class="jumbotron">
        <h1 class="display-4">환영합니다!</h1>
        <p class="lead">게시판 프로그램을 사용해보세요.</p>
    </div>
</div>
<%@ include file="boardList.jsp" %>

</body>
</html>
