<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 4/16/17
  Time: 2:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        String baseWebPath = basePath + "/user";
    %>
    <link rel="stylesheet" href="<%=basePath %>/css/bootstrap.min.css"/>
    <script src="<%=basePath %>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form action="<%=baseWebPath%>/active" method="post"  role="form" data-toggle="validator" >
        <c:if test ="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}"/>
        <%--<input type="hidden" id="userId" name="userId" value="${user.id}"/>--%>
        <h2>User</h2>
        <div class="form-group col-xs-4">

            <label for="name" class="control-label col-xs-4">姓名:</label>
            <input type="text" name="name" id="name" class="form-control" value="${user.name}"
                   required="true"/>

            <label for="age" class="control-label col-xs-4">年龄:</label>
            <input type="text" name="age" id="age" class="form-control" value="${user.age}"
                   required="true"/>

            <label for="sex" class="control-label col-xs-4">性别:</label>
            <input type="text" name="sex" id="sex" pattern="F|M" class="form-control" value="${user.gender}"
                   placeholder="F|M" required="true"/>

            <label for="contact" class="control-label col-xs-4">联系方式:</label>
            <input type="text" name="contact" id="contact" class="form-control" value="${user.contact}"
                   placeholder="jason@qima-inc.com" required="true"/>

            <br></br>
            <button type="submit" class="btn btn-primary  btn-md">增加</button>
        </div>
    </form>
</div>
</body>
</html>
