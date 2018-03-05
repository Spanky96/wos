<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String bashPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
  </head>
  <link href="<%=bashPath%>/static/style/reset.css" rel="stylesheet">
  <link href="<%=bashPath%>/static/style/style.css" rel="stylesheet">
  <link href="<%=bashPath%>/static/style/login.css" rel="stylesheet">
  <script type="text/javascript" src="<%=bashPath%>/static/js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="<%=bashPath%>/static/js/jweixin-1.2.0.js"></script>
  <script type="text/javascript" src="<%=bashPath%>/static/js/login.js"></script>
  <body onkeydown="keyLogin()">
    <!-- warpper START -->
    <div id="warpper">
    		<h1>登录</h1>
 		<button>点击1</button>
 		<button>点击2</button>
    </div>
    <!-- warpper END -->
  </body>
</html>
