<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
<%--<table>--%>
<table bottom:100 right:10>
    <tr>
        <td>
            <b><big>Hi! ${loginName} </big></b>
        </td>
    </tr>
    <tr>
        <td>
            <a href="delete.html?addressId=${address.adrId}">delete this contact</a>
        </td>
    </tr>
</table>


    <fieldset>
        <legend>Contact Details:</legend>
        <table bottom:100 right:10>
            <table width="100%" align="right">
                <form:form method="POST" commandName="address">
                    <tr>
                        <td>Name:</td>
                        <td><form:input path="name"/></td>
                        <td><form:errors path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Formatted Name:</td>
                        <td><form:input path="formattedName"/></td>
                        <td><form:errors path="formattedName" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Organization:</td>
                        <td><form:input path="organization"/></td>
                    </tr>
                    <tr>
                        <td>Title:</td>
                        <td><form:input path="title"/></td>
                    </tr>
                    <tr>
                        <td>Photo:</td>
                        <td><form:input path="photo"/></td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><form:input path="phone"/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><form:input path="address"/></td>
                        <td><form:errors path="address" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Revision:</td>
                        <td><form:input path="revision"/></td>
                    </tr>
                    <br>
                    <br>
                    <tr>
                        <td width="80px">&nbsp</td>
                        <td><input type="submit" align="right" value="Save"></td>
                    </tr>
                </form:form>
            </table>
        </table>
    </fieldset>

    <tr width="80px">
        <td>&nbsp</td>
    </tr>

</table>
</body>

</html>