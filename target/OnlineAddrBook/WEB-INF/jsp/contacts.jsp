<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
<table bottom:100 right:10>
    <%--<tr>
        <td>
            <a href="add-contact.html">add contact</a>
        </td>
    </tr>--%>
    <tr>
        <td>
            <b><big>${loginName}, Your Contact List: </big></b>
        </td>
    </tr>
</table>
<table bottom:100 right:10 border="1">
    <%--<c:if test="${not empty addressList}">--%>
    <c:forEach var="entry" items="${addressList}">
        <tr>
            <td>
                <a href="contact-details.html?addressId=${entry.adrId}">${entry.name}</a>
            </td>
            <td>
                    ${entry.name}
            </td>
            <td>
                    ${entry.formattedName}
            </td>
            <td>
                    ${entry.organization}
            </td>
            <td>
                    ${entry.title}
            </td>
            <td>
                    ${entry.photo}
            </td>
            <td>
                    ${entry.phone}
            </td>
            <td>
                    ${entry.address}
            </td>
            <td>
                    ${entry.revision}
            </td>
        </tr>
    </c:forEach>
    <%--</c:if>--%>
</table>
</body>

</html>