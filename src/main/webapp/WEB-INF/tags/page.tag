<!DOCTYPE html>
<%@tag description="General Page template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="jwr" uri="http://jawr.net/tags" %>

<%@attribute name="title" required="true" %>
<%@attribute name="ngMuduleName" required="true" %>
<%@attribute name="top" required="false" fragment="true" %>
<%@attribute name="footer" required="false" fragment="true" %>

<html ng-app="${ngMuduleName}">
    <head>
        <title>${title}</title>
    </head>
    <body>
        <div class="page-header">
            <c:choose>
                <c:when test="${not empty top}">
                    <jsp:invoke fragment="top"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="/components/header.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="page-body">
          <jsp:doBody/>
        </div>

        <div class="page-footer">
            <c:choose>
                <c:when test="${not empty footer}">
                    <jsp:invoke fragment="footer"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="/components/footer.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>

        <script type="text/javascript" src="/js/bundles/libs.js"/></script>
        <script type="text/javascript" src="/js/bundles/components.js"/></script>
    </body>
</html>