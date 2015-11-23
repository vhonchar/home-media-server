<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <sec:csrfMetaTags/>
        <script src="/media-server/js/jquery-2.1.4.min.js"></script>
        <script src="/media-server/js/app.js"></script>
    </head>
    <body>
        <h1>Hello</h1>

        <form class="login-form" method="POST" action="/media-server/api/token">
            <div class="login-form_row">
                <label for="login">Login</label><input id="login" name="login" type="text"/>
            </div>
            <div class="login-form_row">
                <label for="password">Password</label><input id="password" name="password" type="password"/>
            </div>
            <input type="submit"/>
        </form>
    </body>
</html>