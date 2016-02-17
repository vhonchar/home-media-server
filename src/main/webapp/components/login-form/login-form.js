var ngModule = angular.module('MediaServer', [])

ngModule.directive('loginForm', [function() {
    return {
        templateUrl : '/components/login-form/login-form.jsp',
    }
}]);