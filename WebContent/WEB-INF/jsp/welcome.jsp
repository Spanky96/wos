<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="top.spanky.wos.model.User"%>
<html>
<% String bashPath = request.getContextPath(); %>
<head>
<meta charset="UTF-8">
<meta name="viewport"
  content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>welcome</title>
<style>
body {
  background: #F5F5F5;
}
</style>
</head>

<body>
    <p>{$requestScope.user.username}</p><br>
    <p>{$requestScope.user.name}</p><br>
    <p>{$requestScope.user.gender}</p><br>
    <p>{$requestScope.user.phone}</p><br>
</body>
</html>
