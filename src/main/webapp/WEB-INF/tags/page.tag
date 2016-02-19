<!DOCTYPE html>
<%@tag description="General Page template" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="title" required="true" %>
<%@attribute name="ngMuduleName" required="true" %>
<%@attribute name="top" required="false" fragment="true" %>
<%@attribute name="footer" required="false" fragment="true" %>

<html ng-app="${ngMuduleName}">
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="/clientlibs/bundles/common.css">
        <link rel="stylesheet" href="/clientlibs/bundles/components.css">
    </head>
    <body>
        <div class="page-header">
            <c:choose>
                <c:when test="${not empty top}">
                    <jsp:invoke fragment="top"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="/components/header/header.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="page-body">
          <jsp:doBody/>
        </div>

        <c:if test="${not empty footer}">
            <div class="page-footer">
                <jsp:invoke fragment="footer"/>
            </div>
        </c:if>

        <script type="text/javascript" src="/clientlibs/bundles/libs.js"/></script>

        <!-- TODO: this is a crutch -->
        <script type="text/javascript">
            var ngModule = angular.module('MediaServer', [])
        </script>

        <script type="text/javascript" src="/clientlibs/bundles/components.js"/></script>
    </body>
</html>