<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Order List</title>
</head>
<body>
<h1>
	有赞黄龙体育中心卡消费订单
</h1>


<table border="1">
    <tbody>
    <tr>
        <th style="width: 80px;">订单id</th>
        <th style="width: 80px;">日期</th>
        <th style="width: 80px;">消费金额</th>
        <th style="width: 120px;">消费项目</th>
        <th style="width: 40px;">操作</th>
    </tr>
  <c:forEach items="${orderList}" var="order">
    <tr>
      <td><c:out value="${order.id}" /></td>
      <td><c:out value="${order.date}" /></td>
      <td><c:out value="${order.payment}" /></td>
      <td><c:out value="${order.purpose}" /></td>
      <td><a href="updateOrder?id=${order.id}">修改</a></td>
    </tr>
  </c:forEach>
    </tbody>
</table>

</body>
</html>