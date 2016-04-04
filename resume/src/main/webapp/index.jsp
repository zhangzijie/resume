<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
    <s:form action="addAdmin" method="post">
        <s:textfield name="id" label="ID" />
        <s:textfield name="username" label="用户名" />
        <s:password name="password" label="密码" />
        <s:submit value="submit"></s:submit>
    </s:form>
</body>
</html>