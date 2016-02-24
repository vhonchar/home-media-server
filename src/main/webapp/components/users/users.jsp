<div class="users-component">
    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Granted roles</th>
        </tr>
        </thead>
        <tbody ng-repeat="user in users">
        <tr>
            <td>
                <span ng-hide="user.inEditMode">{{user.login}}</span>
                <span ng-show="user.inEditMode"><input placeholder="Login" ng-model="user.login"/></span>
            </td>
            <td>
                    <span ng-repeat="role in user.roles track by $index">
                        <span ng-hide="user.inEditMode">{{role}}</span>
                        <input ng-show="user.inEditMode" placeholder="Role" ng-model="user.roles[$index]"/>
                    </span>
            </td>
            <td>
                <span ng-hide="user.inEditMode" class="button yellow" ng-click="user.inEditMode = true">Update</span>
                <span ng-show="user.inEditMode" class="button yellow" ng-click="updateUser(user)">Save</span>
            </td>
            >
        </tr>
        </tbody>
    </table>

    <!--<div class="button add-user" ng-click="addRowForNewUser()">+</div>-->
</div>