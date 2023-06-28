<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 작성</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">게시판 프로그램</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">회원가입</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">로그인</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/board/list">게시물 목록</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/board/new">게시물 작성</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <div class="card">
        <div class="card-body">
            <h2 class="card-title">게시물 작성</h2>
            <form action="/board/create" method="post">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요">
                </div>
                <div class="form-group">
                    <label for="category">카테고리</label>
                    <input type="text" class="form-control" id="category" name="category" placeholder="카테고리를 입력해주세요">
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" id="content" name="content" rows="5"
                              placeholder="내용을 입력해주세요"></textarea>
                </div>
                <div class="form-group">
                    <label for="username">사용자명</label>
                    <input type="text" class="form-control" id="username" name="username" placeholder="사용자명을 입력해주세요">
                </div>
                <button type="submit" class="btn btn-primary">등록</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
