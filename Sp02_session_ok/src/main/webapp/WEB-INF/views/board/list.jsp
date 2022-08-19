<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<body>
	<center>
		<font color='gray' size='4' face='휴먼편지체'>
			<hr width='600' size='2' color='gray' noshade>
			<h3>Spring Board - List</h3> <font color='gray' size='4' face='휴먼편지체'> <a href='/'>인덱스</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='/board/write.do'>글쓰기</a><br />
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
						<TD><a href="content.do?seq=${ item.seq }"> ${ item.subject } </a></TD>
						<TD>${ item.rdate }</TD>
					</TR>

				</c:forEach>


			</TABLE>

			<hr width='600' size='2' color='gray' noshade> <font color='gray' size='3' face='휴먼편지체'> <span> (총페이지수 : ${boardNums.lastPage})( 총 게시글 : ${boardNums.total} ) </span> &nbsp;&nbsp;&nbsp; <c:if test="${boardNums.startPage != 1}">
					<a href="/board/list.do?cp=1&ps=${boardNums.cntPerPage}&orderBy=${orderBy}"}>&lt;&lt;</a>
				</c:if> &nbsp; <c:if test="${boardNums.startPage != 1 }">
					<a href="/board/list.do?cp=${boardNums.startPage - 1 }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}">&lt;</a>
				</c:if> &nbsp; <c:forEach begin="${boardNums.startPage }" end="${boardNums.endPage }" var="p">
					<c:choose>
						<c:when test="${p == boardNums.nowPage }">
							<b>${p }</b>
						</c:when>
						<c:when test="${p != boardNums.nowPage }">
							<a href="/board/list.do?cp=${ p }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}">${ p }</a>
						</c:when>
					</c:choose>
				</c:forEach> &nbsp; <c:if test="${boardNums.endPage != boardNums.lastPage}">
					<a href="/board/list.do?cp=${boardNums.endPage+1 }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}">&gt;</a>
				</c:if> &nbsp; <c:if test="${boardNums.endPage != boardNums.lastPage}">
					<a href="/board/list.do?cp=${boardNums.lastPage }&ps=${boardNums.cntPerPage}&orderBy=${orderBy}">&gt;&gt;</a>
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
    	 --> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="psId" name="psName" onchange="f(this)">
					<option value="3" <c:if test="${boardNums.cntPerPage == 3}">selected</c:if>>3</option>
					<option value="5" <c:if test="${boardNums.cntPerPage == 5}">selected</c:if>>5</option>
					<option value="10" <c:if test="${boardNums.cntPerPage == 10 }">selected</c:if>>10</option>

			</select> 개씩 보기 <select id="psOrderId" name="psOrder" onchange="changeOrderBy(this)">
					<option value="desc" <c:if test="${orderBy eq 'desc'}">selected</c:if>>desc</option>
					<option value="asc" <c:if test="${orderBy eq 'asc'}">selected</c:if>>asc</option>
			</select>
			
			
			 <script language="javascript">
				function changeOrderBy(select) {
					var ps = document.getElementById("psId").value;
					console.log("ps:" + ps);
					orderBy = select.value;
					location.href = "/board/list.do?ps=" + ps + "&orderBy=" + orderBy;

				}
				function f(select) {
					//var el = document.getElementById("psId");
					var orderBy = document.getElementById("psOrderId").value;
					ps = select.value;
					//alert("ps : " + ps);
					location.href = "/board/list.do?ps=" + ps + "&orderBy=" + orderBy;
				}
			</script>

		</font>
			<hr width='600' size='2' color='gray' noshade>
	</center>
</body>
</html>