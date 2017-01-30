<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
    <title>Welcome</title>
    <sx:head/>
</head>
<body>
    <h2>Struts 2 Autocomplete (Drop down) Example!</h2>
    <s:form action="ajaxdemo" validate="true" method="POST" namespace="/">
        Country:
        <sx:autocompleter size="1" list="countries" name="country"/>
        <s:submit/>
    </s:form>
    <a href="showCountryList">Show Order List</a>
</body>
</html>