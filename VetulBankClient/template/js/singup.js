$(document).ready(function() {
    $('#signup').validate({


        rules: {
            password: {
                required: true,
                rangelength:[4,12]
            },
            confirmPassword: {equalTo:'#password'}
        },


        messages:  {
            password: {
                required: 'Please type a password',
                rangelength: 'Password must be between 4 and 12 characters long.'
            },
            confirmPassword: {
                equalTo: 'The passwords do not match.'
            }
        }

    });

    $("#submit").click(function () {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        if ((confirmPassword != password)) {
            $("#message").html("<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>Passwords aren't identical.</div>");
        }
        else {
            $.ajax({
                url: 'http://localhost:8080/accounts/create/password/' + password,
                type: 'PUT',

                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");


                    $("#message").html("<p class='text-center'><img src='template/images/ajax-loader.gif'></p>")
                },

                success: function(result){
                    alert(result);
                    $json = jQuery.parseJSON(result);
                    if ($json != null) {
                        $("#signup").hide();
                        $("#message").html('<div class="panel panel-primary"><div class="panel-heading"><h3 class="panel-title">Your account number</h3></div><div class="panel-body">'+$json.accountId+'</div></div></div>');
                    }
                    else {
                        $("#message").html($json);
                    }
                }
            });
        }
        return false;
    });
});