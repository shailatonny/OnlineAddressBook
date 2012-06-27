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
            <b><big>Your Contact List: </big></b>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
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


<table bottom:100 right:10>
    <tr>
        <td height="200px">
            &nbsp;
        </td>
    </tr>
</table>


</body>

</html>