<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
<table bottom:100 right:10>
    <tr>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>
            <b><big>Hi! ${loginName} </big></b>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>
            <form:form method="POST" commandName="searchCmd">
                <table width="100%" align="right">
                    <tr>
                        <td width="250px">Search Contact:</td>
                        <td width="250px"><form:input path="findName"/></td>
                        <td>
                            <input type="submit" align="right" value="Search">
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td class="error">
                                ${noMatch}
                                ${emptyStr}
                        </td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>
    <tr>
        <td>
            &nbsp;
        </td>
    </tr>

    <c:if test="${not empty addressList}">
        <tr>
            <td>
                <big> Matched contacts:</big>
            </td>
        </tr>
        <c:forEach var="entry" items="${addressList}">

            <tr>
                <td class="contact">
                    <a href="contact-details.html?addressId=${entry.adrId}">${entry.name}</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<table>
    <tr height="100px">
        <td>&nbsp</td>
    </tr>
</table>
</body>

</html>