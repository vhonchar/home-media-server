<div class="login-form-component" ng-init="passwordType = 'password'">
    <div class="row">
        <div class="medium-6 medium-centered large-4 large-centered columns">
            <form method="POST" action="/login">
                <div class="row column log-in-form">
                    <h4 class="text-center">Log in with your username</h4>
                    <label>Email
                        <input type="text" placeholder="Username" name="login"/>
                    </label>
                    <label>Password
                        <input type="{{passwordType}}" placeholder="Password" name="password"/>
                    </label>
                    <input id="show-password" type="checkbox"
                           ng-click="passwordType = (passwordType == 'password' ? 'text' : 'password')"/>
                    <label for="show-password">Show password</label>

                    <p>
                        <input type="submit" class="button expanded"/>
                    </p>

                </div>
            </form>
        </div>
    </div>
</div>