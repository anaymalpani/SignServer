<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="publicweb.css" type="text/css"/>
        <link rel="shortcut icon" href="favicon.png"/>
        <title>SignServer</title>
    </head>
    <body>
        <div id="container1">
            <%@include file="WEB-INF/jspf/header.jspf" %>
            <jsp:useBean class="org.signserver.web.SettingsBean" id="settings"/>

            <p>&nbsp;</p>
            
            <h4>Local Resources</h4>
            <ul class="resourcesList">
                <li><a href="clientweb/">Client Web</a></li>
                <li><a href="healthcheck/signserverhealth">Health Check</a></li>
                <c:if test="${settings.webDocEnabled}">
                    <li><a href="doc/">Documentation</a></li>
                </c:if>
                <c:if test="${settings.webClientCLIDistEnabled}">
                    <li><a href="clientcli-dist/">Client CLI Download</a></li>
                </c:if>
                <c:if test="${settings.webAdminGUIDistEnabled}">
                    <li><a href="admingui-dist/">Administration GUI Download</a></li>
                </c:if>
                <c:if test="${settings.adminWebEnabledAndAvailable}">
                    
                    <%-- XXX: Duplicated in LoginBean of AdminWeb. Use that implementation instead when switching to JSF. --%>
                    <c:set var="req" value="${pageContext.request}" />
                    <c:set var="url">${req.requestURL}</c:set>
                    <c:set var="uri" value="${req.requestURI}" />                    
                    <c:set var="adminWeb" value="https://${settings.getHostName(req)}:${settings.externalPrivateHttpsPort}${req.contextPath}/adminweb/"/>

                    <%--
                    <c:out value="req: ${req}"/><br/>
                    <c:out value="url: ${url}"/><br/>
                    <c:out value="uri: ${uri}"/><br/>
                    <c:out value="contextPath: ${req.contextPath}"/><br/>                    
                    <c:out value="adminWeb: ${adminWeb}"/><br/>
                    --%>
                    
                    <li><a href="<c:out value='${adminWeb}'/>">Administration Web</a></li>
                </c:if>
            </ul>

            <h4>Online Resources</h4>
            <ul class="resourcesList">
                <li><a href="https://www.signserver.org">SignServer Web Site</a></li>
                <li><a href="https://doc.primekey.com">PrimeKey Documentation</a></li>
            </ul>

            <%@include file="WEB-INF/jspf/footer.jspf" %>
        </div>
    </body>
</html>
