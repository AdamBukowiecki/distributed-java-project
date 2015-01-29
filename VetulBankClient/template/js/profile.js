$(document).ready(function() {
    $("#delete").click(function () {
        if (confirm('Are you sure?')) {
            alert($("#accountId").html());
            $.ajax({
                type: "delete",
                contentType: 'application/json',
                url: "http://localhost:8080/accounts/" + $("#accountId").html(),
                success: function (response) {
                    window.location = "logout.php";
                },
                beforeSend: function () {
                    $("#message").html("<p class='text-center'><img src='template/images/ajax-loader.gif'></p>")
                }
            });
        }
        return false;
    });
});