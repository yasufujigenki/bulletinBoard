<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>サンプルBBS</title>
	</head>
	<body>
		<h2>サンプル掲示板：ログイン画面 WebContent/index.jsp</h2>
		<form action="/bulletinBoard_v3/Login" method="post">
			<table style="border-style: none;">
				<tr>
					<td>ユーザー名：</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード：</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン"></td>
				</tr>
			</table>
		</form>
		<p>※ログイン押下で Login.java(servlet) へ。</p>
		<p>LoginLogic.java(model) で判定してtrueなら /WEB-INF/jsp/loginResult.jsp へ。</p>
		<p>falseならこのページにエラー表示</p>
	</body>
</html>