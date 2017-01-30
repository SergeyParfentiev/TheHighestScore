<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
    <s:head/>
</head>
<body>
    <h1 align="center">Login</h1>
    <s:div>
        <s:fielderror name="invalid"/>
        <s:form action="loginAction" validate="true" method="POST" namespace="/">
            <s:textfield name="login" required="true" label="Login: "/>
            <s:password name="passwordHash" required="true" label="Password: "/>
            <s:submit/>
        </s:form>
    </s:div>
</body>
</html>
