<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
</head>

<body>
<table>
    <tr>
        <td height="50px">&nbsp;</td>
    </tr>
    <tr>
        <td class="msgText">
            ${msg}
        </td>
    </tr>
    <tr>
        <td>
            <form:form method="POST" commandName="loginForm">
                <fieldset>
                    <legend>LogIn</legend>
                    <table width="100%" align="right">
                        <tr>
                            <td>Login Name:</td>
                            <td><form:input path="loginName"/></td>
                            <td><form:errors path="loginName" cssClass="error"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><form:password path="password"/></td>
                            <td><form:errors path="password" cssClass="error"/></td>
                        </tr>
                    </table>
                </fieldset>
                <br>
                <input type="submit" align="right" value="Submit">
            </form:form>
        </td>
    </tr>
    <tr>
        <td height="110px">&nbsp;</td>
    </tr>
</table>
</body>

</html>