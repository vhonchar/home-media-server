$(document).ready(function(){

    if($(".login-form")){
        initLoginFormComponent($(".login-form"));
    }
});

function initLoginFormComponent($self){
    $self.submit(function(event){
        event.preventDefault();

        var login = $self.find("#login").val(),
            password = $self.find("#password").val();

        $.ajax({
            url: "/media-server/api/token",
            method: "POST",
            data: {login: login, password: password},
            dataType: "json",
            success: redirectToIndex,
            error: function(jqXhr, status){
                alert("error" + status);
            }
        });
    });
}

function redirectToIndex(token){
    $.ajax({
        url: "/media-server/index.html",
        method: "GET",
        headers: {
            token: JSON.stringify(token)
        },
        success: function(result, status){
            alert("I'm HOME");
        },
        error: function(jqXhr, status){
            alert("error" + status);
        }
    });
}