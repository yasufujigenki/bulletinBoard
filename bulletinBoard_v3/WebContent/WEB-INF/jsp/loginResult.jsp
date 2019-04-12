<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>サンプルBBS</title>
	</head>
	<body>
		<h2>サンプル掲示板：ログイン後の掲示板「選択」画面 WebContent/loginResult.jsp</h2>
		<c:choose>
			<c:when test="${loginUser != null}">
				<p>ログインに成功しました。</p>
				<P>ようこそ、<c:out value="${loginUser.name}" />さん</P>
				<form action="/bulletinBoard_v3/Main" method="get">
					<input type="submit" value="つぶやき投稿・閲覧へ">
				</form>
			</c:when>
			<c:otherwise>
				<p>ログインに失敗しました</p>
				<a href="/bulletinBoard_v3/">TOPへ</a>
			</c:otherwise>
		</c:choose>
		<p>※閲覧へ押下で、 Main.java(servlet) の doGetメソッド へ。</p>
		<p>Main.java(servlet) の doGetメソッド で判定してloginUserが</p>
		<p>nullでなければ、 main.jsp へ。</p>
	</body>
</html>


