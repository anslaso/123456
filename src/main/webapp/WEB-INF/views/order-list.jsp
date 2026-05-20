<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>我的订单</title>
</head>
<body>
  <h2>我的订单</h2>
  <div>
    <a href="${pageContext.request.contextPath}/commodity/list">继续购物</a>
    <a href="${pageContext.request.contextPath}/user/logout">退出</a>
  </div>
  <table border="1" cellpadding="6">
    <tr><th>订单ID</th><th>商品ID</th><th>数量</th><th>下单时间</th><th>操作</th></tr>
    <c:forEach var="o" items="${orders}">
      <tr>
        <td>${o.id}</td>
        <td>${o.commodityId}</td>
        <td>${o.quantity}</td>
        <td>${o.createTime}</td>
        <td><a href="${pageContext.request.contextPath}/order/delete/${o.id}">删除</a></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
