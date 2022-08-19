<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring Board - Content</title>
</head>
<style>
a {
	text-decoration: none
}
</style>
<meta charset="utf-8">
<center>
	<font color='gray' size='4' face='휴먼편지체'>
		<hr width='600' size='2' color='gray' noshade>
		<h3>Spring Board - Content</h3> <font color='gray' size='4' face='휴먼편지체'> <a href='write.do'>글쓰기</a>
	</font>
		<hr width='600' size='2' color='gray' noshade>
	</font>

	<table border='2' width='600' align='center' noshade>
		<tr>
			<td width='20%' align='center'>No</td>
			<td>${ foundBoard.seq }</td>
		</tr>
		<tr>
			<td width='20%' align='center'>Writer</td>
			<td>${ foundBoard.writer }</td>
		</tr>
		<tr>
			<td align='center'>E-mail</td>
			<td>${ foundBoard.email }</td>
		</tr>
		<tr>
			<td align='center'>Subject</td>
			<td>${ foundBoard.subject }</td>
		</tr>
		<tr>
			<td align='center'>Contents</td>
			<td>${ foundBoard.content }</td>
		</tr>
	</table>

	<hr width='600' size='2' color='gray' noshade>
	<font color='gray' size='4' face='휴먼편지체'> <a href='update.do?seq=${ foundBoard.seq }'>수정</a> &nbsp;&nbsp;| <a href='del.do?seq=${ foundBoard.seq }'>삭제</a> &nbsp;&nbsp;| <a href='list.do'>목록</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
</center>
</html>