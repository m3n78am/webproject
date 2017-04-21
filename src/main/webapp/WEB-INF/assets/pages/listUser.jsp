<%--
  Created by IntelliJ IDEA.
  User: Jason
  Date: 4/14/17
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <h2>Users</h2>
    <!--Search Form -->
    <form action="<%=baseWebPath%>/active" method="post" id="seachUserForm" role="form">
        <input type="hidden" id="search" name="action" value="search">
        <input type="hidden" id="searchType" name="searchType" value="searchByName">
        <div class="form-group col-xs-5">
            <input type="text" name="userName" id="userName" class="form-control" required="true" placeholder="Type the Name of the user"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
        <br></br>
        <br></br>
    </form>

    <!--User List-->
    <form action="<%=baseWebPath%>/active" method="post" id="userForm" role="form" >
        <input type="hidden" id="userId" name="userId">
        <input type="hidden" id="action" name="action">
        <c:choose>
            <c:when test="${not empty userList}">
                <table  class="table table-striped" border="1">
                    <thead>
                    <tr>
                        <td>用户id</td>
                        <td>姓名</td>
                        <td>年龄</td>
                        <td>性别</td>
                        <td>联系方式</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${userList}">
                        <c:set var="classSucess" value=""/>
                        <c:if test ="${userId == user.id}">
                            <c:set var="classSucess" value="info"/>
                        </c:if>
                        <tr class="${classSucess}">
                            <td>
                                <a href="<%=basePath %>/user/userInfo?userId=${user.id}&searchAction=searchById">${user.id}</a>
                            </td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.sex}</td>
                            <td>${user.contact}</td>
                            <td><a href="#" id="remove"
                                   onclick="document.getElementById('action').value = 'remove';
                                   document.getElementById('userId').value = '${user.id}';
                                   document.getElementById('userForm').submit();">
                                <span class="glyphicon glyphicon-trash"/>
                            </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    No people found matching your search criteria
                </div>
            </c:otherwise>
        </c:choose>
    </form>

    <form action ="<%=baseWebPath%>/addUser">
        <br></br>
        <button type="submit" class="btn btn-primary  btn-md">New User</button>
    </form>

</div>
</body>
</html>
