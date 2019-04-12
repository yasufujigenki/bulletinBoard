<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="main.css">
		<title>サンプルBBS</title>
	</head>
	<body>
		<h2>サンプル掲示板：メイン画面 WebContent/main.jsp</h2>
		<p>ログインユーザー：<c:out value="${loginUser.name}" /></p>
		<p><a href="/bulletinBoard_v3/Logout">ログアウト</a></p>
		<p><a href="/bulletinBoard_v3/Main">更新</a></p>
		<form action="/bulletinBoard_v3/Main" method="post">
			<input type="text" name="text">
			<input type="submit" value="投稿！">
		</form>
			<c:if test="${not empty errorMsg}">
				<p>${errorMsg}</p>
			</c:if>
		<!-- 掲示板の内容表示 -->
		<c:forEach var="bulletin" items="${bulletinList}">
			<p><c:out value="${bulletin.userName}" />：<c:out value="${bulletin.created_at}" /><c:out value="${bulletin.text}" /></p>
		</c:forEach>
		<!-- ページネーション -->
		<c:if test="${indexList.size() > 0}">
			<ul>
				<!-- 戻るの処理 -->
				<c:if test="${nowPage > 0}">
					<li><a href="/bulletinBoard_v3/Main?page=${nowPage - 1}">prev</a></li>
				</c:if>
				<!-- ページ数の表示と処理 -->
				<c:forEach var="i" begin="0" end="${indexList.size()}" step="1">
					<li><a href="/bulletinBoard_v3/Main?page=${i}"><c:out value="${i + 1}"/></a></li>
				</c:forEach>
				<!-- 次への処理 -->
				<li><a href="/bulletinBoard_v3/Main?page=${nowPage + 1}">next</a></li>
			</ul>
		</c:if>
	</body>
</html>



