<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <script language="javascript">
        function exportContact() {
            document.location.href = "export-contact.html?addressId=${address.adrId}"
        }
    </script>
</head>

<body>
<%--<table>--%>
<table width="100%" bottom:100 right:10>
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


</table>


<fieldset>
    <legend>Contact Details of ${address.name}:</legend>
    <br>
    <table width="100%" bottom:100 right:10>
        <table width="100%" align="right">
            <form:form method="POST" commandName="address">
                <tr>
                    <td width="300px">Name:</td>
                    <td width="300px"><form:input path="name" maxlength="255"/></td>
                    <td width="100px"><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Formatted Name:</td>
                    <td><form:input path="formattedName" maxlength="255"/></td>
                    <td><form:errors path="formattedName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Organization:</td>
                    <td><form:input path="organization" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><form:input path="title" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Photo:</td>
                    <td><form:input path="photo" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><form:input path="phone" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><form:input path="address" maxlength="255"/></td>
                    <td><form:errors path="address" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>Revision:</td>
                    <td><form:input path="revision" maxlength="255"/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>
                        <big><a href="delete.html?addressId=${address.adrId}">Delete</a></big>
                    </td>
                    <td>&nbsp;</td>
                    <td><input type="submit" align="right" value="Save"></td>
                    <td><input type="button" align="right" value="Export" onClick="exportContact()"></td>
                </tr>
            </form:form>
        </table>
    </table>
</fieldset>

<table>
    <tr height="100px">
        <td>&nbsp</td>
    </tr>
</table>
</body>

</html>