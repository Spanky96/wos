<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String bashPath = request.getContextPath(); %>
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
  <script type="text/javascript" src="<%=bashPath%>/static/js/login.js"></script>
  <body onkeydown="keyLogin()">
    <!-- warpper START -->
    <div id="warpper">
      <!-- main START -->
      <div id="loginMain">

        <!-- main-left START -->
        <div id="mainLeft" class="lf">
          <div class="logo-pic"></div>
          <div class="title-text">Online Exam Web System</div>
        </div>
        <!-- main-left END -->

        <!-- main-right START -->
        <div id="mainRight" class="rf">

          <!-- form title START -->
          <div class="form-title"><h2>Welcome to login!</h2></div>
          <!-- form title END -->

          <!-- form warpper START -->
          <div class="login-form">

            <!-- tip message START -->
            <div id="tipMessage">
              <c:if test="${not empty requestScope.TIP_MESSAGE}">${requestScope.TIP_MESSAGE}</c:if>
              <c:if test="${not empty requestScope.ERROR_FIELDS.username}">${requestScope.ERROR_FIELDS.username}</c:if>
              <c:if test="${not empty requestScope.ERROR_FIELDS.password}">${requestScope.ERROR_FIELDS.password}</c:if>
            </div>
            <!-- tip message END -->

            <!-- form START -->
            <form action="<%=bashPath %>/page/login" method="POST" id="loginForm">
              <input type="hidden" name="go" value="${requestScope.go }"/>
              <input type="hidden" name="queryString" id="queryString"/>
              <input type="text" autocomplete="off" name="username" id="username"
              class="username text-field" placeholder="Username" onfocus="clearErrorTips()"
              value="${cookie.saveUsername.value}" />
              <div class="error-logo username-error-logo" id="usernameErrorLogo" onclick="clearUsername()"></div>
              <br />
              <input type="password" autocomplete="off" name="password" id="password"
              class="password text-field" placeholder="Password" onfocus="clearErrorTips()"
              value="${cookie.savePassword.value}" />
              <div class="error-logo password-error-logo" id="passwordErrorLogo" onclick="clearPassword()"></div>
              <br />
              <input type="button" value="Login" onclick="login()" id="loginButton" class="login-button" />
              <br />
              <div class="lf">
                <input type="checkbox" id="isRemember" name="isRemember" value="yes" style="display: none" />
                <div id="checkboxControl" class="checkbox-control unchecked" onclick="doRemember()"></div>
                <font class="expanding-text" onclick="doRemember()">Remember me</font>
              </div>
              <a href="#" class="rf"><font class="expanding-text">Forget password?</font></a>
            </form>
            <!-- form END -->

          </div>
          <!-- form warpper END -->

        </div>
        <!-- main-right END -->
        
      </div>
      <!-- main end-->

      <!-- footer START -->
      <div id="footer">
        <div class="copyright-text">Copyright &copy; 2014 Augmentum, Inc. All Rights Reserved.</div>
      </div>
      <!-- footer END -->

    </div>
    <!-- warpper END -->
  </body>
</html>
