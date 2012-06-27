<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
<table bottom:100 right:10>
    <tr>
        <td>
            <b><big>Hi! ${loginName} </big></b>
        </td>
    </tr>
    <tr>
        <td>
            <a href="contacts.html">my contacts</a>
        </td>
    </tr>
    <tr>
        <td>
            <form:form method="POST" commandName="searchCmd">
                <table width="100%" align="right">
                    <tr>
                        <td width="250px">Search Contact:</td>
                        <td width="250px"><form:input path="findName"/></td>
                        <td width="250px" class="error">
                                ${noMatch}
                        </td>
                    </tr>
                </table>
                <br>
                <input type="submit" align="right" value="Search">
            </form:form>
        </td>
    </tr>
    <c:forEach var="entry" items="${addressList}">
        <tr>
            <td class="contact">
                <a href="contact-details.html?addressId=${entry.adrId}">${entry.name}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>