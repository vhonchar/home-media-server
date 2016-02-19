ngModule.directive("usersList", [function() {
    return {
        templateUrl : '/components/users/users.jsp',
        scope: {
            users: '='
        },
        bindToController: true,
        controllerAs: "$cntr",
        controller: [ '$scope', '$http', function($scope, $http){
            $http
            .get(MS.API.GET_ALL_USERS, {data: "application/json"})
            .then(function(response){
                $scope.users = response.data;
            }, function(response){
                if(response.status == MS.HTTP_STATUS.FORBIDDEN){
                    alert("U should log in first");
                    $scope.$parent.container.currentComponent = "logInForm";
                } else {
                    console.error(response);
                }
            });
        }]
    }
}]);