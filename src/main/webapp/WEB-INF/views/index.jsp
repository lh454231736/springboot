<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>测试jsp的使用</title>
</head>
<body>
    Date:${time}
    message:${message}
    <hr/>
    <c:if test="${user!=null}">
             用户名:<p>${user.userName}</p><br/>
             密码:    <p>${user.password}</p><br/>
            年龄:   <p>${user.age}</p><br/>
    </c:if>
</body>
</html>