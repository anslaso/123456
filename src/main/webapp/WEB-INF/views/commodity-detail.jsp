<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>商品详情</title>
</head>
<body>
  <h2>商品详情</h2>
  <div>
    <a href="${pageContext.request.contextPath}/commodity/list">返回列表</a>
    <a href="${pageContext.request.contextPath}/order/list">我的订单</a>
  </div>

  <c:if test="${not empty error}">
    <div style="color:red">${error}</div>
  </c:if>

  <div>
    <p>编号：${commodity.id}</p>
    <p>名称：${commodity.name}</p>
    <p>价格：${commodity.price}</p>
    <p>库存：${commodity.stock}</p>
    <p>描述：${commodity.description}</p>
  </div>

  <form action="${pageContext.request.contextPath}/order/create" method="post">
    <input type="hidden" name="commodityId" value="${commodity.id}" />
    <label>数量：
      <input type="number" name="quantity" value="1" min="1" max="${commodity.stock}" required/>
    </label>
    <button type="submit">下单</button>
  </form>
</body>
</html>
