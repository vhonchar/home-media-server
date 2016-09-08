<div class="container" ng-init="container = {currentComponent: 'users'}">

    <div class="top-bar">
        <!-- Left Nav Section -->
        <div class="top-bar-left">
            <ul class="vertical medium-horizontal menu">
                <li><a ng-click="container.currentComponent='logInForm'"
                       ng-class="{active: container.currentComponent=='logInForm'}" href="#">Log In</a></li>
                <li><a ng-click="container.currentComponent='users'"
                       ng-class="{active: container.currentComponent=='users'}" href="#">Users</a></li>
            </ul>
        </div>

        <!-- Logo -->
        <div class="logo-wrapper hide-for-small-only">
            <div class="logo">
                <!-- <img src="http://placehold.it/350x150?text=LOGO"> -->
            </div>
        </div>
    </div>

    <div class="components-holder" ng-switch="container.currentComponent">
        <div ng-switch-when="logInForm" login-form></div>
        <div ng-switch-when="users" users-list></div>
    </div>
</div>