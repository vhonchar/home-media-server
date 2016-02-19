<ul ng-repeat="user in users">
     <li>
         {{user.login}}
         <div ng-repeat="role in user.roles">
             <div>{{role}}</div>
         </div>
     </li>
 </ul>