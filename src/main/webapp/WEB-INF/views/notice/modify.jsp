<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <style>
<style type="text/css">
.input_wrap{
	padding: 5px 20px;
}
label{
    display: block;
    margin: 10px 0;
    font-size: 20px;	
}
input{
	padding: 5px;
    font-size: 17px;
}
textarea{
	width: 800px;
    height: 200px;
    font-size: 15px;
    padding: 10px;
}
.btn{
  	display: inline-block;
    font-size: 22px;
    padding: 6px 12px;
    background-color: #fff;
    border: 1px solid #ddd;
    font-weight: 600;
    width: 140px;
    height: 41px;
    line-height: 39px;
    text-align : center;
    margin-left : 30px;
    cursor : pointer;
}
.btn_wrap{
	padding-left : 80px;
	margin-top : 50px;
}	
	#delete_btn{
    background-color: #f3e3e7;
	
}
</style>
</head>
<body>
<h1>조회 페이지</h1>
	<form id="modifyForm" action="/notice/modify" method="post">
	<div class="input_wrap">
		<label>게시판 번호</label>
		<input name="notice_num" readonly="readonly" value='<c:out value="${pageInfo.notice_num}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 제목</label>
		<input name="notice_sub" value='<c:out value="${pageInfo.notice_sub}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 내용</label>
		<textarea rows="3" name="notice_con"><c:out value="${pageInfo.notice_con}"/></textarea>
	</div>
	<div class="input wrap">
		<label>게시판 등록일</label>
		<input name="notice_date" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.notice_date}"/>' >
	</div>
	<div class="input_wrap">
		<label>게시판 조회수</label>
		<input name="notice_view" value='<c:out value="${pageInfo.notice_view}"/>' >
	</div>
	<div class="btn_wrap">
		<a class="btn" id="list_btn">목록 페이지</a> 
        <a class="btn" id="modify_btn">수정 완료</a>
        <a class="btn" id="delete_btn">삭제</a>
        <a class="btn" id="cancel_btn">수정 취소</a>
	</div>
	</form>
	<form id="infoForm" action="/notice/modify" method="get">
		<input type="hidden" id="notice_num" name="notice_num" value='<c:out value="${pageInfo.notice_num}"/>'>
		<input type="hidden" name="pageNum" value='<c:out value="${str.pageNum}"/>'>
		<input type="hidden" name="amount" value='<c:out value="${str.amount}"/>'>
		<input type="hidden" name="type" value="${str.type }">
		<input type="hidden" name="keyword" value="${str.keyword }">
	</form>
	
<script>
	let form = $("#infoForm");        // 페이지 이동 form(리스트 페이지 이동, 조회 페이지 이동)
	let mForm = $("#modifyForm");    // 페이지 데이터 수정 form

	/* 목록 페이지 이동 버튼 */
	$("#list_btn").on("click", function(e){
    form.find("#notice_num").remove();
    form.attr("action", "/notice/list");
    form.submit();
});

	/* 수정 하기 버튼 */
	$("#modify_btn").on("click", function(e){
    	mForm.submit();
});

	/* 취소 버튼 */
	$("#cancel_btn").on("click", function(e){
    	form.attr("action", "/notice/get");
   		form.submit();
});   		
   	/* 삭제 버튼 */
   	$("#delete_btn").on("click", function(e){
   	 	form.attr("action", "/notice/delete");
   	    form.attr("method", "post");
   	    form.submit();
   	    
});
</script>	
</body>
</html>