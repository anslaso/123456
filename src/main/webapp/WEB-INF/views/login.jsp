<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>登录 - SSM 商城</title>
</head>
<body>
  <h2>登录</h2>
  <c:if test="${not empty loginError}">
    <div style="color:red">${loginError}</div>
  </c:if>
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    <div>
      <label>用户名：<input type="text" name="username" required/></label>
    </div>
    <div>
      <label>密码：<input type="password" name="password" required/></label>
    </div>
    <div>
      <button type="submit">登录</button>
    </div>
  </form>
  <p>测试账户：alice/pass1 或 bob/pass2</p>
</body>
</html>
