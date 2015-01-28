$(document).ready(function() {
    $("#submit").click(function () {
        var accountId = $("#accountId").val();
        var password = $("#password").val();
        if ((accountId == "") || (password == "")) {
            $("#message").html("<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>Please enter an account id and a password</div>");
        }
        else {
            $.ajax({
                type: "POST",
                url: "checklogin.php",
                data: "accountId=" + accountId + "&password=" + password,
                success: function (html) {
                    if (html == 'true') {
                        window.location = "index.php";
                    }
                    else {
                        $("#message").html(html);
                    }
                },
                beforeSend: function () {
                    $("#message").html("<p class='text-center'><img src='template/images/ajax-loader.gif'></p>")
                }
            });
        }
        return false;
    });
});