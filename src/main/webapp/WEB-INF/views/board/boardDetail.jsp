<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.board.domain.dto.BoardDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<div class="container mt-4">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${board.title}</h5>
            <p class="card-text">작성자: ${board.username}</p>
            <p class="card-text">작성일: ${board.createAt}</p>
            <hr>
            <p class="card-text">${board.content}</p>
        </div>
    </div>

    <div class="mt-4">
        <button class="btn btn-primary" onclick="editBoard(${board.id})">수정</button>
        <button class="btn btn-danger" onclick="deleteBoard(${board.id})">삭제</button>
        <button class="btn btn-primary" onclick="main(${board.id})">메인 페이지</button>
    </div>
</div>
    <div>
        <form action="/board/${board.id}" method="post">
            <input type="text" name="content" placeholder="content을 입력해주세요">
            <input type="text" name="username" placeholder="usernam을 입력해주세요">
            <input type="submit">
            <div>
                <table>
                    <tr>
                        <td>닉네임</td>
                        <td>내용</td>
                    </tr>

                    <c:forEach items="${commentlist}" var = "commentlist"></c:forEach>
                </table>
            </div>
        </form>
    </div>
<script>
    // 게시물 수정 함수
    function editBoard(boardId) {
        // 게시물 수정 페이지로 이동
        location.href = "/board/edit/" + boardId;
    }

    // 게시물 삭제 함수
    function deleteBoard(boardId) {
        // 삭제 확인 메시지 출력
        if (confirm("게시물을 삭제하시겠습니까?")) {
            // AJAX 요청 생성
            var xhr = new XMLHttpRequest();

            // POST 요청 설정
            xhr.open("POST", "/board/delete/" + boardId, true);

            // 요청 완료 시 콜백 함수 처리
            xhr.onload = function () {
                if (xhr.status === 200) {
                    // 요청이 성공적으로 처리됐을 경우, 리다이렉트 등 필요한 작업 수행
                    location.href = "/board";
                } else {
                    // 요청이 실패했을 경우, 오류 처리
                    console.error("게시물 삭제 요청 실패");
                }
            };

            // 요청 전송
            xhr.send();
        }
    }

    function main(boardId) {
        location.href = "/board";
    }
</script>
