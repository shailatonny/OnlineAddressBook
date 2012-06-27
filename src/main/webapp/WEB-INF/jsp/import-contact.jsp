<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <script language="JavaScript">
        function Validate() {
            var vcard = document.getElementById("vcard").value;
            if (vcard == '') {
                alert("Please select a vCard file.");
                document.getElementById("vcard").focus();
                return false;
            }
            var checking = vcard.toLowerCase();
            if (!checking.match(/(\.vcf|\.vcard)$/)) {
                alert("Please enter vcard File Extensions .vcf, .vcard");
                document.getElementById("vcard").focus();
                return false;
            }
            return true;
        }
    </script>
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
            <form:form method="POST" commandName="importCommand" enctype="multipart/form-data"
                       onsubmit="return Validate();">
                <table width="100%" align="right">
                    <tr>
                        <td width="250px"><input path="vcard" type="file" name="file" id="vcard"/></td>
                    </tr>
                    <tr>
                        <td width="250px"></td>
                        <td>
                            <input type="submit" align="right" value="Save">
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
</table>

<table>
    <tr height="100px">
        <td>&nbsp</td>
    </tr>
</table>
</body>

</html>