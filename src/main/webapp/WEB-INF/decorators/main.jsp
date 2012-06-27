<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<%@include file="header.jsp" %>

<body bgcolor="#999966">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="15" nowrap="nowrap"><img src="/images/mm_spacer.gif" alt="" width="15" height="1"
                                            border="0"/></td>
        <td height="60" colspan="3" class="logo" nowrap="nowrap"><br/>
            Online Address Book
        </td>
        <td width="40">&nbsp;</td>
        <td width="100%">&nbsp;</td>
    </tr>

    <tr bgcolor="#ffffff">
        <td colspan="6"><img src='<c:url value="/images/mm_spacer.gif"/>' alt="" width="1" height="1" border="0"/></td>
    </tr>

    <tr bgcolor="#a4c2c2">
        <td width="15" nowrap="nowrap">&nbsp;</td>
        <td height="36" colspan="3" id="navigation" class="navText">
            <a href="home.html">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="profile.html">PROFILE</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="contacts.html">CONTACTS</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="add-contact.html">ADD CONTACT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="sign-up.html">SIGN UP</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="logout.html">LOG OUT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </td>
        <td width="40">&nbsp;</td>
        <td width="100%">&nbsp;</td>
    </tr>

    <tr bgcolor="#ffffff">
        <td colspan="6"><img src='<c:url value="/images/mm_spacer.gif"/>' alt="" width="1" height="1" border="0"/></td>
    </tr>

    <tr bgcolor="#ffffff">
        <td width="230" colspan="2" valign="top" bgcolor="#a4c2c2"><img
                src='<c:url value="/images/mm_lodging_image.jpg"/>'
                alt="Home Page Image"
                width="230" height="240" border="0"/>
            <table border="0" cellspacing="0" cellpadding="0" width="230">
                <tr>
                    <td width="15">&nbsp;</td>
                    <td width="200" class="sidebarText" id="padding">This is a online site to keep safe your
                        contacts<br/>
                        &nbsp;<br/>
                    </td>
                    <td width="15">&nbsp;</td>
                </tr>
            </table>
        </td>
        <td width="50" valign="top"><img src='<c:url value="/images/mm_spacer.gif"/>' alt="" width="50" height="1"
                                         border="0"/>
        </td>
        <td width="100%" valign="top"><br/>    <%--width="440"--%>
            <br/>
            <table border="0" cellspacing="0" cellpadding="0" width="440">
                <tr>
                    <td class="pageName"><p>Welcome</p></td>
                </tr>
                <%--<tr>
                    <td class="bodyText">
                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor
                            invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam
                            et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est
                            Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed
                            diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
                            voluptua. </p>

                        <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel
                            illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui
                            blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. </p>

                        <br/></td>
                </tr>--%>
                <tr>
                    <td>
                        <decorator:body/>
                    </td>
                </tr>

            </table>
        </td>
        <td width="40">&nbsp;</td>
        <td width="100%">&nbsp;</td>
    </tr>

    <tr bgcolor="#ffffff">
        <td colspan="6"><img src='<c:url value="/images/mm_spacer.gif"/>' alt="" width="1" height="1" border="0"/></td>
    </tr>

    <tr>
        <td width="15">&nbsp;</td>
        <td width="215">&nbsp;</td>
        <td width="50">&nbsp;</td>
        <td width="440">&nbsp;</td>
        <td width="40">&nbsp;</td>
        <td width="100%">&nbsp;</td>
    </tr>
    <tr>
        <td>
            <%@ include file="footer.jsp" %>
        </td>
    </tr>
</table>
</body>
</html>