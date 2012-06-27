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
<table bottom:100 right:10 border="1" class="contact">
    <%--<c:if test="${not empty addressList}">--%>
    <c:forEach var="entry" items="${addressList}">
        <tr>
            <td class="contact">
                <a href="contact-details.html?addressId=${entry.adrId}">${entry.name}</a>
            </td>
            <td class="contact">
                    ${entry.name}
            </td>
            <td class="contact">
                    ${entry.formattedName}
            </td>
            <td class="contact">
                    ${entry.organization}
            </td>
            <td class="contact">
                    ${entry.title}
            </td>
            <td class="contact">
                    ${entry.photo}
            </td>
            <td class="contact">
                    ${entry.phone}
            </td>
            <td class="contact">
                    ${entry.address}
            </td>
            <td class="contact">
                    ${entry.revision}
            </td>
        </tr>
    </c:forEach>
    <%--</c:if>--%>
</table>
</body>

</html>