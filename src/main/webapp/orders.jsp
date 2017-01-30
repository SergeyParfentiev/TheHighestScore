<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="admin_overflow">
    <table class="list">
        <tr>
            <th>Сотрудник</th>
            <th>Регион</th>
            <th>Цена</th>
        </tr>
        <s:iterator value="orders">
            <tr>
                <td><s:property value="fullName"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="cost"/></td>
            </tr>
        </s:iterator>
    </table>
</div>

