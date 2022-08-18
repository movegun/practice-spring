<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Title</title>
		<style>
			table, th, td {
			   border: 1px solid black;
			   border-collapse: collapse;
			}
			th, td {
			   padding: 5px;
			}
			a { text-decoration:none }
		</style>
	</head>

	<body style="text-align:center">
		<center>
			<h1>
				Address List with Spring5
			</h1>
			<a href="/address/write.do">입력</a><br/>
			<table border='1' cellpadding='7' cellspacing='2' width='50%'>

			<tr>			
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>날짜</th>
			<th>삭제</th>
			</tr>
			
			
			<c:forEach var="item" items="${ addresses }" varStatus="status">
			
			<tr>
			
			<td align='center'>${ item.seq }</td>
			
			<td>${ item.name }</td>
			
			<td>${ item.addr }</td>
			
			<td>${ item.rdate }</td>
			
			<td align='center'><a href="/address/delete.do?seq=${ item.seq }">삭제</a></td>			
			
			</tr>
						
			</c:forEach>			

			
			
			</table>
		</center>
	</body>
</html>