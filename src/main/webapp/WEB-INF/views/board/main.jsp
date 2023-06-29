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
            <% if (session.getAttribute("username") == null) { %>
            <li class="nav-item">
                <a class="nav-link" href="/user/signup">회원가입</a>
            </li>
            <li>
                <a class="nav-link" href="/user/login">로그인</a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <a class="nav-link" href="/user/logout">로그아웃</a>
            </li>
            <% } %>
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
<%--검색 조건을 선택하고 해당하는 조건 키워드와 일치하는게 있으면 가져오도록 설정함--%>
<% String condition = request.getParameter("condition"); %>
<form method="get" action="/main">
    <select name="condition">
        <option value="title"<% if(condition != null && condition.equals("title")) { %>selected<% } %>>제목</option>
        <option value="content"<% if(condition != null && condition.equals("content")) { %>selected<% } %>>내용</option>
        <option value="u.username"<% if(condition != null && condition.equals("u.username")) { %>selected<% } %>>아이디</option>
        <option value="create_at"<% if(condition != null && condition.equals("create_at")) { %>selected<% } %>>작성날짜</option>
    </select>
    <%--  selected if문은 검색 조건 저장하려고 만듬    --%>
    <%-- null인 상태에서 equals() 메서드를 호출하면 오류가 발생하기 떄문에 condition != null 을 condition.equals("content") 보다
    코드를 먼저 실행해서 null이 아닐떄만 equals()메서드를 호출하도록 함--%>
    <%--searchDao select 구문에서 board와 user를 inner join하는데 username이 두군데 다 존재하기 때문에--%>
    <%--컬럼을 공통되게 사용하는건 어떤 테이블에서 조회할지 지정을 하려고 u나 b를 넣어준것 (u = user table,b = board table)--%>
    <input type="text" name="keyword" placeholder="검색할 내용을 입력하세요" value="${param.keyword}" style="width:300px;height:40px;">
    <%--  value="${param.keyword}" 으로 검색한 값을 보여줌      --%>
    <input type="submit" value="검색">
</form>
<p>※작성날짜로 검색 예시 -> 0000-00-00 ※</p>
<%@ include file="boardList.jsp" %>

</body>
</html>
