<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html ng-app="MediaServer">
    <head>
        <title>Media Server</title>
        <link rel="stylesheet" href="/clientlibs/bundles/common.css">
        <link rel="stylesheet" href="/clientlibs/bundles/components.css">
    </head>
    <body>
        <div class="page-header">
            <jsp:include page="/components/header/header.jsp"/>
        </div>

        <div class="page-body">
            <container></container>
        </div>


        <!-- JavaScript -->
        <script type="text/javascript" src="/clientlibs/bundles/libs.js"/></script>

        <!-- TODO: this is a crutch -->
        <script type="text/javascript">
            var ngModule = angular.module('MediaServer', [])
        </script>
        <script type="text/javascript" src="/clientlibs/bundles/components.js"/></script>
    </body>
</html>