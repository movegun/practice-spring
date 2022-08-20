<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring Board - List</title>
<meta charset="utf-8">
<style>
a {
	text-decoration: none
}
</style>
</head>
<body onload="wantId.focus()">
	<center>
		<font color='gray' size='4' face='휴먼편지체'>
			<hr width='600' size='2' color='gray' noshade>
			<h3>Spring Board - List</h3> <font color='gray' size='4' face='휴먼편지체'>
				<a href='/'>인덱스</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href='/board/write.do'>글쓰기</a>
				<form name="input" method="input" action="/board/list.do?">
					<input	type="text" onKeyDown="if (event.keyCode==13) {check(); return false; }" id="wantId" name="wantName" placeholder="subject로 검색" /> 
					<input	type="button"  value="검색" onclick="check()">
				</form>
				<script language="javascript">
					function check() {
						if (document.getElementById("wantId").value == ""){
							alert("키워드를 입력해주세요!");
							wantId.focus();
						}else{
							wantSearch();
						}
					}
					function wantSearch() {
						//var el = document.getElementById("psId");
						var keyword = document.getElementById("wantId").value;
						console.log(keyword);
						alert("keyword : " + keyword);
						location.href = "/board/list.do?cp=1&ps=5"+"&keyword="+keyword;
					}
				</script>


		</font>
			<hr width='600' size='2' color='gray' noshade>

			<TABLE border='2' width='600' align='center' noshade>
				<TR size='2' align='center' noshade bgcolor='AliceBlue'>
					<th bgcolor='AliceBlue'>no</th>
					<th color='gray'>writer</th>
					<th color='gray'>e-mail</th>
					<th color='gray'>subject</th>
					<th color='gray'>date</th>

				</TR>


				<c:forEach var="item" items="${ pagingList }" varStatus="status">

					<TR align='center' noshade>
						<TD>${ item.seq }</TD>
						<TD>${ item.writer }</TD>
						<TD>${ item.email }</TD>
						<TD><a href="content.do?seq=${ item.seq }"> ${ item.subject }
						</a></TD>
						<TD>${ item.rdate }</TD>
					</TR>

				</c:forEach>


			</TABLE>

			<hr width='600' size='2' color='gray' noshade> <font
			color='gray' size='3' face='휴먼편지체'> <span> (총페이지수 :
					${boardNums.lastPage})( 총 게시글 : ${boardNums.total} ) </span>
				&nbsp;&nbsp;&nbsp; <c:if test="${boardNums.startPage != 1}">
					<a
						href="/board/list.do?cp=1&ps=${boardNums.cntPerPage}&orderBy=${orderBy}&keyword=${keyword}"}>&lt;&lt;</a>
				</c:if> &nbsp; <c:if test="${boardNums.startPage != 1 }">
					<a
						href="/board/list.do?cp=${boardNums.startPage - 1 }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}&keyword=${keyword}">&lt;</a>
				</c:if> &nbsp; <c:forEach begin="${boardNums.startPage }"
					end="${boardNums.endPage }" var="p">
					<c:choose>
						<c:when test="${p == boardNums.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != boardNums.nowPage }">
							<a
								href="/board/list.do?cp=${ p }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}&keyword=${keyword}">${ p }</a>
						</c:when>
					</c:choose>
				</c:forEach> &nbsp; <c:if test="${boardNums.endPage != boardNums.lastPage}">
					<a
						href="/board/list.do?cp=${boardNums.endPage+1 }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}&keyword=${keyword}">&gt;</a>
				</c:if> &nbsp; <c:if test="${boardNums.endPage != boardNums.lastPage}">
					<a
						href="/board/list.do?cp=${boardNums.lastPage }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}&keyword=${keyword}">&gt;&gt;</a>
				</c:if> <!-- 
        <a href="list.do?cp=1">  
                	<strong>1</strong>
    	</a>&nbsp;
    
        <a href="list.do?cp=2">
			2
    	</a>&nbsp;
    
        <a href="list.do?cp=3">
            3
    	</a>&nbsp;
    	 --> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="psId"
				name="psName" onchange="f(this)">
					<option value="3"
						<c:if test="${boardNums.cntPerPage == 3}">selected</c:if>>3</option>
					<option value="5"
						<c:if test="${boardNums.cntPerPage == 5}">selected</c:if>>5</option>
					<option value="10"
						<c:if test="${boardNums.cntPerPage == 10 }">selected</c:if>>10</option>

			</select> 개씩 보기 <select id="psOrderId" name="psOrder"
				onchange="changeOrderBy(this)">
					<option value="desc"
						<c:if test="${orderBy eq 'desc'}">selected</c:if>>최신순</option>
					<option value="asc"
						<c:if test="${orderBy eq 'asc'}">selected</c:if>>오래된순</option>
			</select> <script language="javascript">
				function changeOrderBy(select) {
					var ps = document.getElementById("psId").value;
					console.log("ps:" + ps);
					orderBy = select.value;
					location.href = "/board/list.do?ps=" + ps + "&orderBy="	+ orderBy+"&keyword="+"${keyword}" ;

				}
				function f(select) {
					//var el = document.getElementById("psId");
					var orderBy = document.getElementById("psOrderId").value;
					ps = select.value;
					//alert("ps : " + ps);
					location.href = "/board/list.do?ps=" + ps + "&orderBy="+ orderBy+"&keyword="+"${keyword}" ;
				}
			</script>

		</font>
			<hr width='600' size='2' color='gray' noshade>
	</center>
</body>
</html>