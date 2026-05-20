<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>商品列表</title>
</head>
<body>
  <h2>商品列表</h2>
  <div>
    <a href="${pageContext.request.contextPath}/user/login">登录</a>
    <a href="${pageContext.request.contextPath}/order/list">我的订单</a>
  </div>

  <table border="1" cellpadding="6">
    <tr><th>编号</th><th>名称</th><th>价格</th><th>库存</th><th>操作</th></tr>
    <c:forEach var="c" items="${items}">
      <tr>
        <td>${c.id}</td>
        <td>${c.name}</td>
        <td>${c.price}</td>
        <td>${c.stock}</td>
        <td><a href="${pageContext.request.contextPath}/commodity/detail/${c.id}">查看</a></td>
      </tr>
    </c:forEach>
  </table>

  <div>
    <c:if test="${currentPage > 1}">
      <a href="?page=${currentPage-1}&pageSize=${pageSize}">上一页</a>
    </c:if>
    <span>第 ${currentPage} / ${totalPages} 页</span>
    <c:if test="${currentPage < totalPages}">
      <a href="?page=${currentPage+1}&pageSize=${pageSize}">下一页</a>
    </c:if>
  </div>
</body>
</html>
