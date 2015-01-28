$(document).ready(function() {
    $("#delete").click(function () {
        if (confirm('Are you sure?')) {
            $.ajax({
                type: "POST",
                method: "DELETE",
                url: "http://localhost:8080/accounts/" + $("#accountId").html(),
                success: function (json) {
                    $json = jQuery.parseJSON(json);
                    if ($json.accountId != null) {
                        $("#signup").hide();
                        $("#message").html('<div class="panel panel-primary"><div class="panel-heading"><h3 class="panel-title">Your account number</h3></div><div class="panel-body">'+$json.accountId+'</div></div></div>');
                    }
                    else {
                        window.location = "logout.php";
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