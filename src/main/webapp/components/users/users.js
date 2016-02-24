ngModule.directive("usersList", [function() {
    return {
        templateUrl : '/components/users/users.jsp',
        scope: {
            users: '='
        },
        bindToController: true,
        controllerAs: "$cntr",
        controller: [ '$scope', '$http', function($scope, $http){

            $http.get(MS.API.GET_ALL_USERS, {
                data: "application/json"
            }).then(function(response){
                $scope.users = response.data;
            }, function(response){
                if(response.status == MS.HTTP_STATUS.FORBIDDEN){
                    alert("U should log in first");
                    $scope.$parent.container.currentComponent = "logInForm";
                } else {
                    console.error(response);
                }
            });

            $scope.addRowForNewUser = function(){
                $scope.users.push({
                    inEditMode: true,
                    roles: ["ROLE_USER"]
                });
            };

            $scope.updateUser = function(user){
                $http.put(MS.API.GET_ALL_USERS, {
                    // crutch
                    login: user.login,
                    roles: user.roles,
                    id: user.id
                }).then(
                    function(response){
                        user.inEditMode = false;
                    }, function(response){
                        alert(response);
                    }
                );
            };
        }]
    }
}]);