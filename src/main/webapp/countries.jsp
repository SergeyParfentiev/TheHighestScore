<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Country Orders</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.0/animate.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/spin.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/content.js"></script>
    <link rel="stylesheet" href="css/content.css">
</head>
<body>
    <s:select label="Select Country" id="countryId" name="countryId"
              list="countries" listKey="id" listValue="name"/>
    <div id="contentBody"></div>
    <div id="loading">
        <div id="menuSpinner"></div>
        <script>createSpinner('menuSpinner')</script>
    </div>
    <a href="ajaxdemo">Ajaxdemo</a><br/>
    <a href="logout">Logout</a>
</body>
<script type="text/javascript">
    $(document).ready(showOrders(), $('#countryId').trigger("change"));
</script>
</html>
