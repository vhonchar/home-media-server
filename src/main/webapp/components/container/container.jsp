<div class="container" ng-init="container = {currentComponent: 'users'}">

    <div class="tabs">
        <button class="button" ng-click="container.currentComponent='logInForm'">Log In</button>
        <button class="button" ng-click="container.currentComponent='users'">Users</button>
    </div>
    <div class="components-holder" ng-switch="container.currentComponent">
        <div ng-switch-when="logInForm" login-form></div>
        <div ng-switch-when="users" users-list></div>
    </div>
</div